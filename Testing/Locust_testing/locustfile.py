from locust import HttpUser, task, between
import random
import string

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

    @task
    def post_fee_data(self):
        # Random values for currency
        currencies = ["USD", "EUR", "GBP", "JPY", "INR"]

        # Generate random description
        def random_description(length=10):
            return ''.join(random.choices(string.ascii_letters + string.digits, k=length))

        payload = {
            "totalFee": round(random.uniform(10.0, 1000.0), 2),
            "scaleFactor": round(random.uniform(0.5, 2.0), 2),
            "currency": random.choice(currencies),
            "feeBreakdown": {
                "feeAmount": round(random.uniform(1.0, 500.0), 2),
                "scaleFactor": round(random.uniform(0.5, 2.0), 2),
                "currency": random.choice(currencies),
                "description": random_description()
            }
        }

        with self.client.post("/fee/submit", json=payload, name="/fee/submit", catch_response=True) as response:
            if response.status_code != 200:
                response.failure(f"Failed to submit fee data: {response.status_code}, {response.text}")
            else:
                response.success()
