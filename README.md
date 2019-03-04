# K8S Play

Multi microservice architecture to play with kubernetes

## front8s

Simple RestController service that also pushes messages to RebbitMQ,
and pushes objects to Redis

## consume8s

Simple RabbitMQ message consumer that also fetches objects from Redis

## red8s

Simple REST Service that pushes and fetches objects from Redis

# Running

`docker-compose up`

# Running in Kubernetes

Deploy each service separately from docker images and set proper env variables. All services can be scaled across multiple pods.
Exposed variables are visible in docker-compose.yml file.

