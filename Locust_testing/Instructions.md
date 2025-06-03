Run:
```
docker run --rm -p 8089:8089 -v $(pwd):/mnt/locust -w /mnt/locust locustio/locust -f locustfile.py --host=http://host.docker.internal:8082
```

`docker run` - Start new Docker container <br>
`--rm` - Automatically removes the container after it exits <br>
`-p 8089:8089` - Maps port 8089 on the local machine to port 8089 inside the docker container <br>
`-v ${pwd}:/mnt/locust` - Mounts the current directory into the container at "/mnt/locust" <br>
`locustio/locust` - The Docker image <br>
`-f locustfile.py` - The test script <br>
`--host=http://host.docker.internal:8082` - Set the target host URL where Locust will load 8082 is where the application is running <br>
