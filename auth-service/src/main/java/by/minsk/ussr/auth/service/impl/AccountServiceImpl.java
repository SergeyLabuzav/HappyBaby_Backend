package by.minsk.ussr.auth.service.impl;

import by.minsk.ussr.auth.model.User;
import by.minsk.ussr.auth.repository.UserDetailRepository;
import by.minsk.ussr.auth.service.AccountService;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
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

    @Override
    public Optional<User> findByActivationKey(String activationKey) {
        return userDetailRepository.findOneByActivationKey(activationKey);
    }

    @Override
    public void activateRegistration(User user) {
        log.debug("Activate user: {}", user);
        user.setCredentialsNonExpired(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);

        user.setActivationKey(null);
    }

    @Override
    public void save(User user) {
        log.debug("Save user: {}", user);
        userDetailRepository.save(user);
    }
}
