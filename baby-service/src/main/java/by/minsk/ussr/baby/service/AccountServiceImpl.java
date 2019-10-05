package by.minsk.ussr.baby.service;

import by.minsk.ussr.baby.model.Account;
import by.minsk.ussr.baby.repository.AccountRepository;
import by.minsk.ussr.baby.service.context.UserContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final UserContext userContext;
    private final AccountRepository accountRepository;

    public AccountServiceImpl(UserContext userContext, AccountRepository accountRepository) {
        this.userContext = userContext;
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Account getAccount() {
        return accountRepository.findByUserProfileId(userContext.userProfileId());
    }

    @Override
    public Account createAccount() {
        Account newAccount = new Account();
        newAccount.setUserProfileId(userContext.userProfileId());
        return accountRepository.save(newAccount);
    }
}
