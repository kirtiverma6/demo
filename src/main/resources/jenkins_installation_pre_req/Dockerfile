FROM jenkins/jenkins:lts

USER root

# Install dependencies
RUN apt-get update \
    && apt-get install -y apt-transport-https ca-certificates curl gnupg lsb-release

# Install Docker CLI
RUN curl -fsSL https://get.docker.com/ | sh

USER jenkins
