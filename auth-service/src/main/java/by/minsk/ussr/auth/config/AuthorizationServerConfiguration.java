package by.minsk.ussr.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
public class AuthorizationServerConfiguration implements AuthorizationServerConfigurer {

    private final DataSource dataSource;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthorizationServerConfiguration(PasswordEncoder passwordEncoder, DataSource dataSource, AuthenticationManager authenticationManager) {
        this.dataSource = dataSource;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Bean
    TokenStore jdbcTokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .checkTokenAccess("isAuthenticated()")
                .tokenKeyAccess("permitAll()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .jdbc(dataSource)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(jdbcTokenStore())
                .authenticationManager(authenticationManager);
    }
}
