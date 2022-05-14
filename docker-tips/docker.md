# Basics for Docker

- `docker run`
- `docker rm`
- `docker run -rm ubuntu echo "hello from docker"`: run the `echo` command and delete the container (no need to manually delete the container with -rm)
- `docker ps -a`: a Docker command to list the running containers by default
- `docker exec`: run the same container with different shells
- `docker --name mycontainer`: name the container to mycontainer
- `docker -it bash`: open an interactive terminal 
- `docker exec -it pintos bash`
- `make grade`

## Initialize Docker for Projects

`docker run --rm --name pintos -it -v $(pwd):/pintos thierrysans/pintos bash`

## GDB Debugging

- `--gdb`: start debugging
- `pintos-gdb kernel.o` in build directory:
