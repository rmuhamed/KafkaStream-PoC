# My Kafka stream poof of concept
Trying random things with Apache Kafka Stream 

## Introduction
In this repository you can the following components, 
+ Producer application
+ Consumer application
+ Stream application

In order to simulate a topology with three nodes,
+ Source node (i.e Producer application)
+ Stream node (i.e Stream application)
+ Sink node (i.e Consumer application)

## Setup before run a demo
First you have present, in your system, a _kafka_ distribution (if you don't have one, check and download it from [here](https://apache.brunneis.com/kafka/)). In this sample, we're using v2.4.1 (the latest one at the moment of development)

### Starting ,both, zookeeper and kakfa servers
Staying in /bin inside kafka directory, run the following

First, zookeeper server
```shell
bin $ ./zookeeper-server-start.sh ../config/zookeeper.properties
```
In another shell, we launch the kakfa server
```shell
bin $ ./kafka-server-start.sh ../config/server.properties
```

### Creating topics
We have to create two topics, one will be _produced_ as an **input**, and another one will be _consumed_  as an **output**
```shell
bin $ ./kafka-topics.sh --create --topic sensor_input --bootstrap-server localhost:9092 partition 1 --replication-factor 1
bin $ ./kafka-topics.sh --create --topic sensor_output --bootstrap-server localhost:9092 partition 1 --replication-factor 1
```

You can check if both were created, by the following command,
```shell
bin $ ./kafka-topics.sh --list --bootstrap-server localhost:9092
# The output should be the following
sensor_input
sensor_output
```

### Run each of the components

#### How to launch the Stream application
```shell script
SensorMeasurementsStream $ ./gradlew clean run
# The output should be the following
> Task :run
Topologies:
   Sub-topology: 0
    Source: KSTREAM-SOURCE-0000000000 (topics: [sensor_input])
      --> KSTREAM-SINK-0000000001
    Sink: KSTREAM-SINK-0000000001 (topic: sensor_output)
```

#### How to launch the Consumer application
```shell script
   SensorMeasurementConsumer $ ./gradlew clean run
   
   > Task :compileJava
   > Task :run
```
#### How to launch the Producer application
```shell script
SensorMeasurementProducer $ ./gradlew clean run

> Task :run
```





