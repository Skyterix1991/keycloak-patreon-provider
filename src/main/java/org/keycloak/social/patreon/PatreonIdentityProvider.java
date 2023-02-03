package org.keycloak.social.patreon;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.SneakyThrows;
import org.jboss.logging.Logger;
import org.keycloak.broker.oidc.AbstractOAuth2IdentityProvider;
import org.keycloak.broker.oidc.mappers.AbstractJsonUserAttributeMapper;
import org.keycloak.broker.provider.BrokeredIdentityContext;
import org.keycloak.broker.provider.IdentityBrokerException;
import org.keycloak.broker.provider.util.SimpleHttp;
import org.keycloak.broker.social.SocialIdentityProvider;
import org.keycloak.events.EventBuilder;
import org.keycloak.models.KeycloakSession;

public class PatreonIdentityProvider extends AbstractOAuth2IdentityProvider<PatreonIdentityProviderConfig>
        implements SocialIdentityProvider<PatreonIdentityProviderConfig> {

    private static final Logger log = Logger.getLogger(PatreonIdentityProvider.class);

    public static final String AUTH_URL = "https://www.patreon.com/oauth2/authorize";
    public static final String TOKEN_URL = "https://www.patreon.com/api/oauth2/token";
    public static final String PROFILE_URL = "https://www.patreon.com/api/oauth2/v2/identity?fields%5Buser%5D=about,created,email,first_name,full_name,image_url,last_name,social_connections,thumb_url,url,vanity";
    public static final String DEFAULT_SCOPE = "identity";

    public PatreonIdentityProvider(KeycloakSession session, PatreonIdentityProviderConfig config) {
        super(session, config);
        config.setAuthorizationUrl(AUTH_URL);
        config.setTokenUrl(TOKEN_URL);
        config.setUserInfoUrl(PROFILE_URL);
    }

    @Override
    protected boolean supportsExternalExchange() {
        return true;
    }

    @Override
    protected String getProfileEndpointForValidation(EventBuilder event) {
        return PROFILE_URL;
    }

    @Override
    @SneakyThrows
    protected BrokeredIdentityContext extractIdentityFromProfile(EventBuilder event, JsonNode profile) {
        BrokeredIdentityContext user = new BrokeredIdentityContext(getJsonProperty(profile.path("data"), "id"));
        user.setUsername(getJsonProperty(profile.path("data").path("attributes"), "full_name"));
        user.setIdpConfig(getConfig());
        user.setIdp(this);

        AbstractJsonUserAttributeMapper.storeUserProfileForMapper(user, profile, getConfig().getAlias());

        return user;
    }

    @Override
    protected BrokeredIdentityContext doGetFederatedIdentity(String accessToken) {
        log.debug("doGetFederatedIdentity()");

        JsonNode profile;

        try {
            profile = SimpleHttp.doGet(PROFILE_URL, session).header("Authorization", "Bearer " + accessToken).asJson();
        } catch (Exception e) {
            throw new IdentityBrokerException("Could not obtain user profile from patreon.", e);
        }

        return extractIdentityFromProfile(null, profile);
    }

    @Override
    protected String getDefaultScopes() {
        return DEFAULT_SCOPE;
    }
}
