package by.minsk.ussr.auth.web.facade;

import by.minsk.ussr.auth.model.ERole;
import by.minsk.ussr.auth.model.Role;
import by.minsk.ussr.auth.model.User;
import by.minsk.ussr.auth.service.AccountService;
import by.minsk.ussr.auth.service.MailService;
import by.minsk.ussr.auth.service.RoleService;
import by.minsk.ussr.auth.service.util.RandomUtil;
import by.minsk.ussr.auth.api.dto.UserProfileDto;
import by.minsk.ussr.auth.web.error.EmailAlreadyUsedException;
import by.minsk.ussr.auth.web.error.LoginAlreadyUsedException;
import by.minsk.ussr.auth.web.mapper.AccountMapper;
import by.minsk.ussr.auth.web.vm.AccountViewModel;
import java.util.Collections;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountFacade {

    private final AccountService accountService;
    private final MailService mailService;
    private final RoleService roleService;
    private final AccountMapper mapper;

    public AccountFacade(AccountService accountService, MailService mailService, RoleService roleService, AccountMapper mapper) {
        this.accountService = accountService;
        this.mailService = mailService;
        this.roleService = roleService;
        this.mapper = mapper;
    }

    public void createAccount(AccountViewModel accountVM) {
        User user = mapper.toEntity(accountVM);

        accountService.findByUsername(user.getUsername())
                .ifPresent(u -> {
                    throw new LoginAlreadyUsedException();
                });
        accountService.findOneByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new EmailAlreadyUsedException();
                });

        user.setActivationKey(RandomUtil.generateActivationKey());
        Role userRole = roleService.getRoleByName(ERole.ROLE_USER.name());
        user.setRoles(Collections.singletonList(userRole));

        mailService.sendCreationEmail(user);

        accountService.save(user);
    }

    public void activateRegistration(String key) {
        User user = accountService.findByActivationKey(key)
                .orElseThrow(() -> new IllegalArgumentException("No user was found for this activation key"));

        accountService.activateRegistration(user);
    }

    public UserProfileDto currentUserProfile(String userName) {
        User user = accountService.findByUsername(userName).orElseThrow(IllegalArgumentException::new);
        UserProfileDto dto = new UserProfileDto();
        dto.setId(user.getId());
        dto.setUserName(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
