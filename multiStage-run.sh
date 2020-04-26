sudo chmod +x ./mvnw
sudo docker build --tag elixir-app --file multiStage.Dockerfile .
sudo docker stop elixir-app
sudo docker rm elixir-app
sudo docker run -p 9090:9090 --name elixir-app elixir-app:latest