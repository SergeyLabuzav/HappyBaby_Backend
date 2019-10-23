package by.minsk.ussr.baby.service.context;

import by.minsk.ussr.baby.error.NoUserLoggedInException;
import by.minsk.ussr.baby.web.dto.UserInfo;
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
        return ((UserInfo) authentication.getUserAuthentication().getPrincipal()).getId();
    }
}
