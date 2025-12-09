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
