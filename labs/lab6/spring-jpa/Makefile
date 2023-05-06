clean:
	mvn clean

compile:
	mvn compile

run:
	mvn spring-boot:run


run-mysql:
	docker run -d --name mysql -td -p 3306:3306 -e MYSQL_ROOT_PASSWORD=cmpe172 mysql:8.0

# firstly, make run-mysql -> for creating mysql in the docker
# then, make run -> application will create data in tables at SQL