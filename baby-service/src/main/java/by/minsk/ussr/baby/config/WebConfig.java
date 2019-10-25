package by.minsk.ussr.baby.config;

import by.minsk.ussr.baby.security.extractor.UserPrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public PrincipalExtractor userPrincipalExtractor() {
        return new UserPrincipalExtractor();
    }
}
