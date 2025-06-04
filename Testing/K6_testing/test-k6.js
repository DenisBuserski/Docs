import http from 'k6/http';
import grpc from 'k6/net/grpc';
import {check, sleep} from 'k6';

export let options = {
    vus: 10,
    duration: '30s',
};

// Create and setup gRPC client once
const client = new grpc.Client();
client.load(['/proto'], 'hello.proto');

// The default function runs once per Virtual User(VU) iteration.
// This function is executed repeatedly by each VU during the test duration.
export default function () {
    client.connect('localhost:8081', { plaintext: true });
    const randomId = Math.floor(Math.random() * 20) + 1;

    // REST
    let restHelloResponse = http.get('http://localhost:8082/hello');
    check(restHelloResponse,
        { 'REST status is 200': (r) => r.status === 200 });
    console.log(JSON.stringify(restHelloResponse.message));

    let getRestResponse = http.get(`http://localhost:8082/product/get/${randomId}`);
    check(getRestResponse,
        { 'REST /get/{id} status is 200 or 404': (response) => response.status === 200 || response.status === 404,});
    console.log(JSON.stringify(getRestResponse.message));

    // gPRC
    const data = {id: String(randomId)};
    let getGrpcResponse = client.invoke('hello.HelloGrpc/GetProductById', data);
    check(getGrpcResponse,
        { 'gRPC status is OK': (r) => r && r.status === grpc.StatusOK});
    console.log(JSON.stringify(getGrpcResponse.message));

    client.close(); // Each iteration opens and closes a connection immediately
    sleep(1);
}

// The client connection is kept open for all iterations and only closed once after the entire test finishes.
// Difference in CPU usage comes down a lot to when and how you close the client connection.
// export function teardown() {
//     client.close();
// }

