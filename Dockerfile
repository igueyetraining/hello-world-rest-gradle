FROM eclipse-temurin:21.0.6_7-jre
VOLUME /tmp
COPY build/libs/hello-world-rest-gradle-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS="-Xmx64m"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar" ]