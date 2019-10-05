package by.minsk.ussr.baby.web.facade;

import by.minsk.ussr.baby.model.Account;
import by.minsk.ussr.baby.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountFacade {

    private final AccountService accountService;

    public AccountFacade(AccountService accountService) {
        this.accountService = accountService;
    }

    public Account getAccountOrCreateNew() {
        Account account = accountService.getAccount();
        if (account == null) {
            account = accountService.createAccount();
        }
        return account;
    }
}
