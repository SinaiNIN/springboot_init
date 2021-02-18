## Getting Started

### Prerequisites

Before working with the project you should have some basic software installed.

The *required* software components are:

* **JDK 11+** - you will need to have the Java 11+ SDK installed on your system. You can download the SDK from here: https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html
* **Docker** - for development, you may use Docker to host a containerized MySQL instance. This makes it easy to create and destroy databases as needed. You can download Docker from here: https://www.docker.com/

The *recommended* software components to install are:

* **IntelliJ** - you may use whatever development environment you prefer, but for starting we recommend IntelliJ. You can download it here: https://www.jetbrains.com/idea/
* **MySQL Workbench** - from time-to-time you'll need to access the database.

### Configure your environment

Assuming you've *installed the JDK version 11+*, you'll need to make sure that it is configured properly.

From the command-line of your operating system, type `java -version`. The output should show version the JDK vresion. Any version of 11+ will do. So if you see something like the following, then you are in good shape:

    java version "11.0.1" 2018-10-16 LTS
    Java(TM) SE Runtime Environment 18.9 (build 11.0.1+13-LTS)
    Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.1+13-LTS, mixed mode)

Finally, it's possible the `java` application may not be configured in your **PATH**, or your **PATH** might be referencing an older or newer version. If you don't know how to setup your system properly, please **ask for help**.


### Start your Database

If using MySQL:
* The following command will start a new MySQL docker instance in the background: `docker run --rm -p 3306:3306 -h 0.0.0.0 --name mysql -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7`
* You can stop the MySQL instance at any time by typing: ```docker stop mysql```.

Note: when stopping the docker instance, all databases will be lost.


### Running the project

You can start thee Project by running `./gradlew bootRun`.
The first time you run the core, it will download dependencies, build from source, and start-up the application.

The server will listen on port 443 by default.
If you wish to start the server on a different by passing a SERVER_PORT parameter in.
For example, to start the server on port 8443, call `./gradlew bootRun -DSERVER_PORT=8443`.