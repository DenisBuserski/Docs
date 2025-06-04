from locust import HttpUser, task, between
import random

class ProductTestUser(HttpUser):
    wait_time = between(1, 3)  # Simulate think time between requests

    @task
    def hello(self):
        self.client.get("/hello")
        
    @task
    def get_product_by_id(self):
        product_id = random.randint(1, 30)  # simulate different product IDs
        with self.client.get(f"/product/get/{product_id}", name="/product/get/:id", catch_response=True) as response:
            if response.status_code != 200:
                response.failure(f"Failed to fetch product {product_id}: {response.status_code}")
            else:
                response.success()
