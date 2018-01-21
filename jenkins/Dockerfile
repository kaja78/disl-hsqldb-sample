FROM jenkins:latest

USER root
# Download and install Gradle
RUN \
     cd /var && \
     curl -L https://services.gradle.org/distributions/gradle-3.3-bin.zip -o gradle-3.3-bin.zip && \
     unzip gradle-3.3-bin.zip && \
     rm gradle-3.3-bin.zip


# Export some environment variables
ENV GRADLE_HOME=/var/gradle-3.3
ENV PATH=$PATH:$GRADLE_HOME/bin

RUN chown -R jenkins "$GRADLE_HOME"

USER jenkins
COPY jenkins_home /var/jenkins_home
