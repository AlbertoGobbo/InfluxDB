# ABOUT THIS PROJECT

The aim of this project is to create an API which is able to guarantee the communication from client to server and vice versa.

## LIBRARY IN USE

Added in build.gradle the dependency [influxdb-java](https://github.com/influxdata/influxdb-java).

Pay attention: the version of Gradle dependency is the latest, so 2.17. Getting in touch with the library's developer Stefan Mayer, it has been confirmed that the version 2.17 is compatible with all influxdb version from 1.1 to 1.7.

So, there will not be problems with the last InfluxDB Docker Image, so 1.7.


## ALTERNATIVE LIBRARY

It has been decided to use [JFlux library](https://github.com/nickRm/jflux).

The original Maven dependency has been converted in Gradle dependency with this [web site](https://sagioto.github.io/maven2gradle/).
