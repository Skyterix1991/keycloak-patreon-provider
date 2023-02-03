# keycloak-patreon

Keycloak Patreon Identity Provider plugin.

## Install

Download `keycloak-patreon-provider-<version>.jar` (or `.ear` for older versions) from [Releases page](https://github.com/Skyterix1991/keycloak-patreon-provider/releases).
Then deploy it into `$KEYCLOAK_HOME/providers` directory (or `$KEYCLOAK_HOME/standalone/deployments/` for older versions).

Or use provided Dockerfile.

### Patreon

Register your application [Patreon Developer Portal](https://www.patreon.com/portal/registration/register-clients).
You will get Client ID and Client Secret from the created application.

## Source Build

Clone this repository and run `mvn package`.
You can see `keycloak-patreon-provider-<version>.jar` under `target` directory.

## Licence

[Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0)
