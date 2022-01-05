# keycloak-patreon

Keycloak Patreon Identity Provider plugin.

## Install

Download `keycloak-patreon-ear-<version>.ear` from [Releases page](https://github.com/Skyterix1991/keycloak-patreon-oidc/releases).
Then deploy it into `$KEYCLOAK_HOME/standalone/deployments/` directory.

Or use provided Dockerfile.

### Patreon

Register your application [Patreon Developer Portal](https://www.patreon.com/developers/).
You will get Client ID and Client Secret from the created application.

## Source Build

Clone this repository and run `mvn package`.
You can see `keycloak-patreon-ear-<version>.ear` under `ear/target` directory.

## Licence

[Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0)
