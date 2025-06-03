For testing this tool I used this project - https://github.com/DenisBuserski/quarkus-grpc-demo

Run:
```bash
docker run --rm -i -v $(pwd):/scripts -v /home/db-user/Desktop/quarkus-grpc-demo/src/main/proto:/proto -w /scripts --network=host grafana/k6 run test-k6.js
```
