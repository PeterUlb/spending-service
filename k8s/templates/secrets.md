# Secrets

The following secrets must be provided to run the application

## GCP PubSub Key

Name: **pubsub-key**

`kubectl create secret generic pubsub-key --from-file=key.json=PATH-TO-KEY-FILE.json`

## Secrets Configuration

Name: **spending-service**

*Includes all relevant secret properties. Template included in this directory (NOTE: BASE64)*

**!RIGHT NOW THE SERVICE DOES NOT NEED ANY SECRET CONFIGURATION!**

`kubectl create secret generic spending-service --from-literal=spring.datasource.user=user --from-literal=spring.datasource.password=p455w0rd`
