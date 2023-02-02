FROM quay.io/keycloak/keycloak:20.0.3

EXPOSE 8080

COPY ear/target/keycloak-patreon-ear-0.0.1-SNAPSHOT.ear /opt/keycloak/standalone/deployments/
