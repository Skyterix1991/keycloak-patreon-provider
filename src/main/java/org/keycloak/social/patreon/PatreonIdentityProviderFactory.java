package org.keycloak.social.patreon;

import org.keycloak.broker.provider.AbstractIdentityProviderFactory;
import org.keycloak.broker.social.SocialIdentityProviderFactory;
import org.keycloak.models.IdentityProviderModel;
import org.keycloak.models.KeycloakSession;

public class PatreonIdentityProviderFactory extends AbstractIdentityProviderFactory<PatreonIdentityProvider>
        implements SocialIdentityProviderFactory<PatreonIdentityProvider> {

    public static final String PROVIDER_ID = "patreon";

    @Override
    public String getName() {
        return "Patreon";
    }

    @Override
    public PatreonIdentityProvider create(KeycloakSession session, IdentityProviderModel model) {
        return new PatreonIdentityProvider(session, new PatreonIdentityProviderConfig(model));
    }

    @Override
    public PatreonIdentityProviderConfig createConfig() {
        return new PatreonIdentityProviderConfig();
    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }
}