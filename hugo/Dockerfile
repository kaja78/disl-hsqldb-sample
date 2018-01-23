FROM alpine:3.1

ENV HUGO_VERSION 0.34

EXPOSE 1313

# Install HUGO
RUN set -x && \
  apk add --update wget ca-certificates && \
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

ENTRYPOINT ["/usr/bin/hugo"]
