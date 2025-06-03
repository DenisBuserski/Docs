import http from 'k6/http';
import grpc from 'k6/net/grpc';
import { check } from 'k6';

export let options = {
  vus: 10,
  duration: '30s',
};

// Create and setup gRPC client once (init context)
// const client = new grpc.Client();
// client.load(['/proto'], 'hello.proto');
// client.connect('http://host.docker.internal:8081', { plaintext: true });


export default function () {
  // REST requests

  let restRes = http.get('http://localhost:8082/hello');
  check(restRes,
          { 'REST status is 200': (r) => r.status === 200 });

  // Generate a random product ID between 1 and 1000
  const randomId = Math.floor(Math.random() * 1000) + 1;
  let restGetRes = http.get(`http://localhost:8082/get/${randomId}`);
  check(restGetRes,
          {'REST /get/{id} status is 200 or 404': (r) => r.status === 200 || r.status === 404,});

  // let grpcRes = client.invoke('com.demo.controller.grpc.HelloGrpcService/GetProductById', { id: '1' });
  // check(grpcRes, { 'gRPC status is OK': (r) => r && r.status === grpc.StatusOK });
}

export function teardown() {
  client.close();
}
