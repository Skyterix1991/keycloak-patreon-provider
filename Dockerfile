FROM quay.io/keycloak/keycloak:20.0.3

EXPOSE 8080

COPY target/keycloak-patreon-provider-0.0.1-SNAPSHOT.jar /opt/keycloak/providers
