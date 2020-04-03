# About this project

The aim of this project is to create an API which is able to guarantee the communication with the Time-Series Database [InfluxDB](https://docs.influxdata.com/influxdb/v1.7/introduction/getting-started/) from client to server and vice versa.

## How are the data structured into InfluxDB

Name of measurement (similar to the concept of table in SQL): accessLog
Below the are the measurement's columns, with the association of field_key -> field_value and the data type for each one:

| time      | timestampMs (via locationInfo) | userId       | anonymous | placeId      | inside  |
| --------- | ------------------------------ | ------------ | --------- | ------------ | ------- |
| TIMESTAMP | TIMESTAMP                      | unsigned int | Boolean   | unsigned int | Boolean |
| <!--      | TIMESTAMP                      | TIMESTAMP    | string    | Boolean      | string  | Boolean | --> |
| ...       | ...                            | ...          | ...       | ...          | ...     |

Example of JSON received:

{
  "timestampMs": 1585906080346,
  "userId": 34753543,
  "placeId": [
    453785436,
    71984147938
  ],
  "anonymous":false,
  "inside": true
}

## Library in use

Added in build.gradle the dependency [influxdb-java](https://github.com/influxdata/influxdb-java).

For an accurate reading of all methods, examine [Javadoc Documentation](https://javadoc.io/doc/org.influxdb/influxdb-java/latest/index.html).

Pay attention: the version of Gradle dependency is the latest, so 2.17. Getting in touch with the library's developer Stefan Mayer (stefan.majer@gmail.com), it has been confirmed the version 2.17 is compatible with all influxdb version from 1.1 to 1.7.

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

## Possible errors with Spring (only for developers)

* To solve [error 405](https://www.baeldung.com/spring-request-method-not-supported-405)

* Pay attention to the **error 500**! According to [this site](https://www.yawintutor.com/there-was-an-unexpected-error-type-internal-server-error-status-500/) : "*The controller class is responsible for processing the request from the client. In controller class, the request is processed and the response is sent back to the user. The Json request is processed in RestController class in the restful web service and sends Json response to the so called application. In some cases the controller class will not process the request because of some code bug or data issue. Instead, a Runtime Exception is thrown. The request to the calling application can not be servered. The internal server error created with http error code is 500, in this case.*".
So follow this [link](https://www.baeldung.com/spring-request-response-body), to discover and solve the typical error is in the definition of @ResponseBody and @RequestBody.
