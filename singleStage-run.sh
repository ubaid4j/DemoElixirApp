sudo chmod +x ./mvnw
./mvnw clean package -DskipTests
sudo docker build --tag elixir-app --file singleStep.Dockerfile .
sudo docker stop elixir-app
sudo docker rm elixir-app
sudo docker run -p 9090:9090 --name elixir-app elixir-app:latest