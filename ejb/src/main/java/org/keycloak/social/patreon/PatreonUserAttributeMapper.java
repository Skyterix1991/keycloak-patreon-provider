package org.keycloak.social.patreon;

import org.keycloak.broker.oidc.mappers.AbstractJsonUserAttributeMapper;

public class PatreonUserAttributeMapper extends AbstractJsonUserAttributeMapper {

	private static final String[] COMPATIBLE_PROVIDERS = new String[] { PatreonIdentityProviderFactory.PROVIDER_ID };

	@Override
	public String[] getCompatibleProviders() {
		return COMPATIBLE_PROVIDERS;
	}

	@Override
	public String getId() {
		return "patreon-user-attribute-mapper";
	}

}
