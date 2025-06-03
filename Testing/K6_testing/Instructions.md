For testing this tool I used this project - https://github.com/DenisBuserski/quarkus-grpc-demo

Run:
```bash
docker run --rm -i -v $(pwd):/scripts -v /home/db-user/Desktop/quarkus-grpc-demo/src/main/proto:/proto -w /scripts --network=host grafana/k6 run test-k6.js
```

| Command                        | Explanation                                                                                                           |
| ------------------------------ | --------------------------------------------------------------------------------------------------------------------- |
| `docker run`                   | Start new Docker container                                                                                            |
| `--rm`                         | Automatically removes the container after it exits                                                                    |
| `--network host`               | - The container shares the host machine’s network stack<br>- Inside the container, `localhost` is your actual machine |
| `-v ${pwd}:/mnt/locust`        | Mounts the current directory into the container at "/mnt/locust"                                                      |
| `locustio/locust`              | The Docker image                                                                                                      |
| `-f locustfile.py`             | The test script                                                                                                       |
| `--host=http://localhost:8082` | Set the target host URL where Locust will load 8082 is where the application is running                               |
