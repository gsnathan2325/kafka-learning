#help Documents

docker run -d \
    --name zookeeper \
    -p 2181:2181 \
    -e ZOOKEEPER_CLIENT_PORT=2181 \
    -e ZOOKEEPER_TICK_TIME=2000 \
    confluentinc/cp-zookeeper:7.5.0



docker run -d \
    --name kafka-broker \
    -p 9092:9092 \
    -e KAFKA_BROKER_ID=1 \
    -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
    -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
    -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
    --link zookeeper \
    confluentinc/cp-kafka:7.5.0

    #creat topic
    $ bin/kafka-topics.sh --create --topic my-quick-topic --bootstrap-server localhost:9092 

kafka-topics --create --topic my-new-topic --bootstrap-server localhost:9092 --partitions 2 --replication-factor 1

kafka-topics --list --bootstrap-server localhost:9092

kafka-topics --describe --topic my-new-topic --bootstrap-server localhost:9092

KafkaProducer
-------------
kafka-console-producer --topic my-new-topic --bootstrap-server localhost:9092

KafkaConsumer
kafka-console-consumer --topic my-new-topic --bootstrap-server localhost:9092 --group my-consumer-group --from-beginning



kafka-consumer-groups --bootstrap-server localhost:9092 --describe --group my-consumer-group