FROM jboss/keycloak:latest

EXPOSE 8080

ENV KEYCLOAK_USER=admin
ENV KEYCLOAK_PASSWORD=admin
#ENV KEYCLOAK_LOGLEVEL=DEBUG

COPY ear/target/keycloak-patreon-ear-0.0.1-SNAPSHOT.ear /opt/jboss/keycloak/standalone/deployments
