# About this project

The aim of this project is to create an API which is able to guarantee the communication with the Time-Series Database [InfluxDB](https://docs.influxdata.com/influxdb/v1.7/introduction/getting-started/) from client to server and vice versa.

## How are the data structured into InfluxDB

Name of measurement (similar to the concept of table in SQL): access_log
Below the are the measurement's columns, with the association of field_key -> field_value and the data type for each one:

| time      | user_id | anonymous_key | organization_id | place_id | inside  |
| --------- | ------- | ------------- | --------------- | -------- | ------- |
| TIMESTAMP | string  | string        | string          | string   | Boolean |
| ...       | ...     | ...           | ...             | ...      | ...     |

## Library in use

Added in build.gradle the dependency [influxdb-java](https://github.com/influxdata/influxdb-java).

Pay attention: the version of Gradle dependency is the latest, so 2.17. Getting in touch with the library's developer Stefan Mayer (stefan.majer@gmail.com), it has been confirmed that the version 2.17 is compatible with all influxdb version from 1.1 to 1.7.

So, there will not be problems with the last InfluxDB Docker Image, so 1.7.


## Alternative library

It would be possible to use [JFlux library](https://github.com/nickRm/jflux).

The original Maven dependency can be converted in Gradle dependency with this [web site](https://sagioto.github.io/maven2gradle/).

## How to start InfluxDB locally

Open a CLI and run **influxd**.

After open an other CLI and run **influx**: this call permits to enter in the InfluxDB console.

If the user must authenticate it, run **auth** and insert user and password.

To select **xxx** database, run **use xxx**.


The syntax of queries and commands is very similar to SQL sintax.
