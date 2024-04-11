FROM amazoncorretto:17

# Crear the dir where the code will go
RUN mkdir -p /home/app
# Create a directory for the app
WORKDIR /home/app

# Copy everything from the current directory to the app directory
COPY . /home/app

# Build the app
RUN ./gradlew clean build -x test

# Expose the port
EXPOSE 8080

# Run the app
CMD [ "java", "-jar", "./build/libs/account-service-0.0.1-SNAPSHOT.jar" ]