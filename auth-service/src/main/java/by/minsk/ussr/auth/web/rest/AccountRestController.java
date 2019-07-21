package by.minsk.ussr.auth.web.rest;

import by.minsk.ussr.auth.web.facade.AccountFacade;
import by.minsk.ussr.auth.web.vm.AccountViewModel;
import io.micrometer.core.annotation.Timed;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("oauth/account")
public class AccountRestController {

    private final AccountFacade accountFacade;

    public AccountRestController(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @PostMapping("/create")
    @Timed
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody AccountViewModel accountVM) {
        accountFacade.createAccount(accountVM);
    }
}
