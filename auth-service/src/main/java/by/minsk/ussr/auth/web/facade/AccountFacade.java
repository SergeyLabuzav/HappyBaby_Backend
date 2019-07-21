package by.minsk.ussr.auth.web.facade;

import by.minsk.ussr.auth.model.User;
import by.minsk.ussr.auth.service.AccountService;
import by.minsk.ussr.auth.service.MailService;
import by.minsk.ussr.auth.web.error.EmailAlreadyUsedException;
import by.minsk.ussr.auth.web.error.LoginAlreadyUsedException;
import by.minsk.ussr.auth.web.mapper.AccountMapper;
import by.minsk.ussr.auth.web.vm.AccountViewModel;
import org.springframework.stereotype.Service;

@Service
public class AccountFacade {

    private final AccountService accountService;
    private final MailService mailService;
    private final AccountMapper mapper;

    public AccountFacade(AccountService accountService, MailService mailService, AccountMapper mapper) {
        this.accountService = accountService;
        this.mailService = mailService;
        this.mapper = mapper;
    }

    public void createAccount(AccountViewModel accountVM) {
        User user = mapper.toEntity(accountVM);

        accountService.findByUsername(user.getUsername()).ifPresent(this::throwLoginAlreadyUsedException);
        accountService.findOneByEmail(user.getEmail()).ifPresent(this::throwEmailAlreadyUsedException);

        accountService.save(user);

        mailService.sendCreationEmail(user);
    }

    private void throwLoginAlreadyUsedException(User user) {
        throw new LoginAlreadyUsedException();
    }

    private void throwEmailAlreadyUsedException(User user) {
        throw new EmailAlreadyUsedException();
    }
}
