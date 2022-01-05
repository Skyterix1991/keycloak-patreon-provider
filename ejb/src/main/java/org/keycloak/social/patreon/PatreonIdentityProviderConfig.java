package org.keycloak.social.patreon;

import org.keycloak.broker.oidc.OAuth2IdentityProviderConfig;
import org.keycloak.models.IdentityProviderModel;

public class PatreonIdentityProviderConfig extends OAuth2IdentityProviderConfig {

    public PatreonIdentityProviderConfig(IdentityProviderModel model) {
        super(model);
    }

    public PatreonIdentityProviderConfig() {
    }
}
