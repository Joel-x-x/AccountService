FROM amazoncorretto:21-alpine-jdk

# Copy everything else
COPY /build/libs/AppGym-0.0.1-SNAPSHOT.jar app.jar

# Run the app
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
