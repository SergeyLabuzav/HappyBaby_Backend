package by.minsk.ussr.auth.service.impl;

import by.minsk.ussr.auth.service.TokenService;
import by.minsk.ussr.auth.service.context.UserContext;
import javax.transaction.Transactional;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TokenServiceImpl implements TokenService {
    private final TokenStore tokenStore;
    private final UserContext userContext;

    public TokenServiceImpl(TokenStore jdbcTokenStore, UserContext userContext) {
        this.tokenStore = jdbcTokenStore;
        this.userContext = userContext;
    }

    @Override
    public void revokeToken() {
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(userContext.getAccessToken());
        if (accessToken.getRefreshToken() != null) {
            tokenStore.removeRefreshToken(accessToken.getRefreshToken());
        }
        tokenStore.removeAccessToken(accessToken);
    }
}
