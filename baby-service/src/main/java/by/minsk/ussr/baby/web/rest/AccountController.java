package by.minsk.ussr.baby.web.rest;

import by.minsk.ussr.baby.model.Account;
import by.minsk.ussr.baby.web.facade.AccountFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {

    private final AccountFacade accountFacade;

    public AccountController(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @GetMapping
    public Account getAccount() {
        return accountFacade.getAccountOrCreateNew();
    }
}
