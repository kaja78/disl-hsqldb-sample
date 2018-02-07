FROM jenkins/jenkins:2.89.1-alpine

ENV HUGO_VERSION 0.34

USER root

# Install HUGO
RUN set -x && \
  apk add --update wget ca-certificates && \
  cd /var && \
  mkdir hugo_${HUGO_VERSION}_Linux-64bit && \
  cd hugo_${HUGO_VERSION}_Linux-64bit && \
  wget https://github.com/gohugoio/hugo/releases/download/v${HUGO_VERSION}/hugo_${HUGO_VERSION}_Linux-64bit.tar.gz && \
  tar xzf hugo_${HUGO_VERSION}_Linux-64bit.tar.gz && \
  rm -r hugo_${HUGO_VERSION}_Linux-64bit.tar.gz && \
  mv hugo /usr/bin/hugo && \
  cd .. && \
  rm -r hugo_${HUGO_VERSION}_Linux-64bit && \
  apk del wget ca-certificates && \
  rm /var/cache/apk/*
RUN chown -R jenkins /usr/bin/hugo

# Install Gradle
RUN \
     cd /var && \
     curl -L https://services.gradle.org/distributions/gradle-3.3-bin.zip -o gradle-3.3-bin.zip && \
     unzip gradle-3.3-bin.zip && \
     rm gradle-3.3-bin.zip
ENV GRADLE_HOME=/var/gradle-3.3
ENV PATH=$PATH:$GRADLE_HOME/bin
RUN chown -R jenkins "$GRADLE_HOME"

USER jenkins

#Install jenkins plugins
RUN /usr/local/bin/install-plugins.sh junit:1.23 gradle:1.28

COPY jenkins_home /var/jenkins_home
