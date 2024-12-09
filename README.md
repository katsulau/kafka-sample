```

# create connector
curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json"  http://localhost:8083/connectors -d @connector.json



# kafka list topics

docker-compose exec kafka kafka-topics.sh --list --bootstrap-server local-kafka:9092


# insert data to mysql table users

docker-compose exec mysql mysql -u root -ppassword test -e "INSERT INTO user(name) VALUES ('SampleName3');"




# subscriber (consumer)

docker-compose exec kafka kafka-console-consumer.sh --bootstrap-server local-kafka:9092 --from-beginning --topic debezium_cdc_topic.test.user

```
