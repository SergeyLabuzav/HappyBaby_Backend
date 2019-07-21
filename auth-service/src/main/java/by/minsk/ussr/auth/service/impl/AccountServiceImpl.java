package by.minsk.ussr.auth.service.impl;

import by.minsk.ussr.auth.model.User;
import by.minsk.ussr.auth.repository.UserDetailRepository;
import by.minsk.ussr.auth.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final UserDetailRepository userDetailRepository;

    public AccountServiceImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userDetailRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findOneByEmail(String email) {
        return userDetailRepository.findOneByEmailIgnoreCase(email);
    }
}
