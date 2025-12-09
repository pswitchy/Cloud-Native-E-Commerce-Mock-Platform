# Cloud-Native E-Commerce Platform

A robust microservices application deployed on a custom Kubernetes cluster, featuring event-driven architecture using RabbitMQ and Redis.

## 🚀 Tech Stack
- **Language:** Java 17 (Spring Boot)
- **Containerization:** Docker & Helm
- **Orchestration:** Kubernetes (K3s) on Ubuntu 22.04
- **Data Layer:** Redis (Cache) & RabbitMQ (Messaging)
- **Infrastructure:** Multipass (Linux Virtualization)

## 🏗 Architecture
The application exposes a REST API that handles order processing:
1. **API Gateway:** Ingress/NodePort exposes endpoints.
2. **Caching:** Checks Redis for item availability.
3. **Async Processing:** Pushes successful orders to a RabbitMQ queue for decoupled processing.

## 🛠 Project Structure
- `/src`: Java Source code and Multi-stage Dockerfile.
- `/helm`: Custom Helm charts for deployment.
- `/infrastructure`: Kubernetes manifests for stateful services (Redis/RabbitMQ).

## 💻 How to Run
1. **Infrastructure Setup:**
   ```bash
   multipass launch jammy --name mediaocean-server --memory 4G
   # Install K3s...
   ```
2. **Deploy Data Layer:**
   ```bash
   kubectl apply -f infrastructure/redis.yaml
   kubectl apply -f infrastructure/rabbitmq.yaml
   ```
3. **Deploy Application:**
   ```bash
   helm install my-shop ./helm/shop-app
   ```


<img width="570" height="125" alt="Screenshot 2025-12-10 at 2 44 44 AM" src="https://github.com/user-attachments/assets/0e2626d4-f7a1-4d2b-b7bb-05fb5de2829f" />
<img width="603" height="326" alt="Screenshot 2025-12-10 at 2 39 55 AM" src="https://github.com/user-attachments/assets/d9cacf78-9e34-4227-9413-365fed32c02a" />
