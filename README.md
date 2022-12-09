# The Drone Factory API 
- This is the API for the drone question submitted as part of the Musala interview process. 
## Configurations 
In order to run the solution you need to follow through these steps :

### 1. Initialize Spring Boot :

- Spring Web
- Lombok 
- Spring Data JPA 
- PostgreSQL Driver 

### 2. Setup Docker Container 

- Dockerfile 
- docker-compose.yml 

### 3. Git 

- Initialize the git repository 
- Setup Remote 
- Push all changes 

## If you already have Java running in your machine and docker, you can just clone my repositories.  

# Running The Project 


## 1. Drones 

- Send a json POST request to {server_ip}:8080/drones 
- This is where you can register a drone. 
- Register drone takes in serial number , weight limit, and model

Once drones are registered you can load medication

## 2. Medication 
You can load medication to a drone provided these conditions are met : 
1. Drone is charged more than 25% 
2. Drone weight limit is more than the medication weight. 
3. Drone state is IDLE or LOADING

To load drone you first have to check the list of available drones by sending a GET request to 
- {server_ip}:8080/drones
- When available drones are returned please note down the drone id (drone_id)
- The to load medication send a POST request to {server_ip}:8080/drones/{drone_id}/medication
- To check the list of loaded items you can set a GET request to {server_ip}:8080/drones/{drone_id}/medication

