package by.minsk.ussr.auth.service.impl;

import by.minsk.ussr.auth.model.AuthUserDetail;
import by.minsk.ussr.auth.model.User;
import by.minsk.ussr.auth.repository.UserDetailRepository;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserDetailRepository userDetailRepository;
    private final AccountStatusUserDetailsChecker accountStatusUserDetailsChecker;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;

        accountStatusUserDetailsChecker = new AccountStatusUserDetailsChecker();
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userDetailRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));

        UserDetails userDetails = new AuthUserDetail(user);
        accountStatusUserDetailsChecker.check(userDetails);
        return userDetails;
    }
}
