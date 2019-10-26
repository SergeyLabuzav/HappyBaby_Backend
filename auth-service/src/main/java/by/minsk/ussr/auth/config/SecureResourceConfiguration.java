package by.minsk.ussr.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class SecureResourceConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/oauth/account/create").permitAll()
                .antMatchers(HttpMethod.GET, "/oauth/account/activate").permitAll()
                .antMatchers(HttpMethod.DELETE, "/oauth/token/revoke").permitAll()
                .anyRequest().authenticated();
    }
}
