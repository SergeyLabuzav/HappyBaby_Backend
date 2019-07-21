package by.minsk.ussr.auth.web.facade;

import by.minsk.ussr.auth.model.User;
import by.minsk.ussr.auth.service.AccountService;
import by.minsk.ussr.auth.web.error.EmailAlreadyUsedException;
import by.minsk.ussr.auth.web.error.LoginAlreadyUsedException;
import by.minsk.ussr.auth.web.mapper.AccountMapper;
import by.minsk.ussr.auth.web.vm.AccountViewModel;
import org.springframework.stereotype.Service;

@Service
public class AccountFacade {

    private final AccountService accountService;
    private final AccountMapper mapper;

    public AccountFacade(AccountService accountService, AccountMapper mapper) {
        this.accountService = accountService;
        this.mapper = mapper;
    }

    public void createAccount(AccountViewModel accountVM) {
        User user = mapper.toEntity(accountVM);

        accountService.findByUsername(user.getUsername()).ifPresent(u -> {throw new LoginAlreadyUsedException();});
        accountService.findOneByEmail(user.getEmail()).ifPresent(u -> {throw new EmailAlreadyUsedException();});

        System.out.println(user);
    }
}
