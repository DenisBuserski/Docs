For testing this tool I used this project - https://github.com/DenisBuserski/quarkus-grpc-demo

Run:
```bash
docker run --rm -i -v $(pwd):/scripts -v /home/db-user/Desktop/quarkus-grpc-demo/src/main/proto:/proto -w /scripts --network=host grafana/k6 run test-k6.js
```

| Command                                                            | Explanation                                                                                                           |
| ------------------------------------------------------------------ | --------------------------------------------------------------------------------------------------------------------- |
| `docker run`                                                       | Start new Docker container                                                                                            |
| `--rm`                                                             | Automatically removes the container after it exits                                                                    |
| `-i`                                                               | Interactive mode                                                                                                      |
| `-v $(pwd):/scripts`                                               | Mounts the current directory(Where you run the command) into the container at "/scripts"                              |
| `-v /home/db-user/Desktop/quarkus-grpc-demo/src/main/proto:/proto` | Mounts the proto files directory from the host into the container at "/proto"                                         |
| `-w /scripts`                                                      | Sets the working directory inside the container to "/scripts"                                                         |
| `--network host`                                                   | - The container shares the host machine’s network stack<br>- Inside the container, `localhost` is your actual machine |
| `grafana/k6`                                                       | The Docker image                                                                                                          |
| `run test-k6.js`                                                   | Run the script                                                                                                        |
