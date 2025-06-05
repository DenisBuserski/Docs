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

<br>

Number of users (peak concurrency)
- Total number of simulated users(Virtual users) that will run the test
- Will repeatedly execute tasks(`@task`-decorated functions)
- Think of each as a concurrent client/user session
- "Number of users = 100" - Locust will simulate 100 concurrent users executing the tasks
Ramp up (users started/second)
- spawn-rate = 10 means 10 users are started per second.
- ramp-up time = total users / spawn rate = 100 / 10 = 10 seconds

Run time (optional)
- How long the test should run after ramp-up is complete
- If this is not set:
  - In UI mode - The test uns until "Stop" is clicked
  - In headless mode - Locust runs indefinitely unless stopped manually
Profile



Spawn rate (users started per second)
- How quickly users are started
