:: Start database
docker run --rm --name mariadb -p 3308:3306/tcp -v %cd%/database:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=12345 -d mariadb:10.5.5

:: Start maven-cache
docker volume create --name maven-repo

:: Start payara
docker run --rm --name payara -p 8080:8080 -p 4848:4848 -d nosp/web-app-skeleton

::Build with maven
docker run --rm -it --name mavenbuild -v maven-repo:/root/.m2 -v %cd%:/usr/src/mymaven -w /usr/src/mymaven maven mvn clean install

:: Copy .war to payara:
docker cp target/Skeleton-1.0.war payara:/opt/payara/deployments
docker cp src/config.properties payara:/opt/payara/

:: Redeploy war
docker exec -it payara asadmin --user=admin --passwordFile /opt/payara/passwordFile undeploy Skeleton-1.0
docker exec -it payara asadmin --user=admin --passwordFile /opt/payara/passwordFile deploy deployments/Skeleton-1.0.war