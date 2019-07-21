package by.minsk.ussr.auth.web.mapper;

import by.minsk.ussr.auth.model.User;
import by.minsk.ussr.auth.web.vm.AccountViewModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountMapperImpl implements AccountMapper {

    private final PasswordEncoder passwordEncoder;

    public AccountMapperImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User toEntity(AccountViewModel accountViewModel) {
        User user = new User();
        user.setEmail(accountViewModel.getEmail());
        user.setUsername(accountViewModel.getLogin());
        user.setPassword(passwordEncoder.encode(accountViewModel.getPassword()));

        return user;
    }

    @Override
    public AccountViewModel toDto(User entity) {
        return null;
    }
}
