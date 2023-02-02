FROM bitnami/keycloak:20.0.3

EXPOSE 8080

ENV KEYCLOAK_ADMIN_USER=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin

COPY ear/target/keycloak-patreon-ear-0.0.1-SNAPSHOT.ear /opt/jboss/keycloak/standalone/deployments
