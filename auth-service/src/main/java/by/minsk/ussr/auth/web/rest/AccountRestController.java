package by.minsk.ussr.auth.web.rest;

import by.minsk.ussr.api.auth.dto.UserProfileDto;
import by.minsk.ussr.auth.web.facade.AccountFacade;
import by.minsk.ussr.auth.web.vm.AccountViewModel;
import io.micrometer.core.annotation.Timed;
import java.security.Principal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/activate")
    @Timed
    public void activateAccount(@RequestParam(value = "key") String key) {
        accountFacade.activateRegistration(key);
    }

    @GetMapping("/me")
    public UserProfileDto get(final Principal principal) {
        return accountFacade.currentUserProfile(principal.getName());
    }
}
