# account-service

Create image docker
docker build -t account-service:1.0.0 .
Create container with environment variables
docker create -p8080:8080 --name account-service --network (red name) account-service:1.0.0 -e HOST_POSTGRESQL=(host bdd) -e USERNAME_POSTGRESQL=(username bdd) -e PASSWORD_POSTGRESQL=(password bdd)
