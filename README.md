# springbootapp

# create Docker Image
docker build --tag=springbootapp:latest .

# run the image
docker run -p 8000:8000 springbootapp-dev:latest

or 

docker run -p "port of your choice":8000 springbootapp-dev:latest
