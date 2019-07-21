package by.minsk.ussr.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class AuthService {
    public static void main(String[] args) {
        SpringApplication.run(AuthService.class, args);
    }
}
