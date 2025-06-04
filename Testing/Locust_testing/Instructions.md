For testing this tool I used this project - https://github.com/DenisBuserski/quarkus-grpc-demo

Run:
```bash
docker run --rm --network host -v $(pwd):/mnt/locust -w /mnt/locust locustio/locust -f locustfile.py --host=http://localhost:8082
```

| Command                        | Explanation                                                                                                           |
| ------------------------------ | --------------------------------------------------------------------------------------------------------------------- |
| `docker run`                   | Start new Docker container                                                                                            |
| `--rm`                         | Automatically removes the container after it exits                                                                    |
| `--network host`               | - The container shares the host machine’s network stack<br>- Inside the container, `localhost` is your actual machine |
| `-v ${pwd}:/mnt/locust`        | Mounts the current directory(Where you run the command) into the container at "/mnt/locust"                                                      |
| `locustio/locust`              | The Docker image                                                                                                      |
| `-f locustfile.py`             | The test script                                                                                                       |
| `--host=http://localhost:8082` | Set the target host URL where Locust will load 8082 is where the application is running                               |
