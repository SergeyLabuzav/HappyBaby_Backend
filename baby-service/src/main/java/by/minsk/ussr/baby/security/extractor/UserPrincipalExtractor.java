package by.minsk.ussr.baby.security.extractor;

import by.minsk.ussr.api.auth.dto.UserProfileDto;
import java.util.Map;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;

public class UserPrincipalExtractor implements PrincipalExtractor {
    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        UserProfileDto userInfo = new UserProfileDto();
        userInfo.setId((int)(map.get("id")));
        userInfo.setEmail((String) (map.get("email")));
        userInfo.setUserName((String) (map.get("userName")));
        return userInfo;
    }
}
