package by.minsk.ussr.auth.service.context;

import by.minsk.ussr.api.auth.dto.UserProfileDto;
import by.minsk.ussr.api.auth.error.NoUserLoggedInException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserContext {

    public Integer userProfileId() {
        OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new NoUserLoggedInException();
        }
        return getPrincipal(authentication).getId();
    }

    private UserProfileDto getPrincipal(OAuth2Authentication authentication) {
        return (UserProfileDto) authentication.getUserAuthentication().getPrincipal();
    }

    public String getAccessToken() {
        return null;
    }
}