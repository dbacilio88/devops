#/app /usr /lib
FROM ubuntu:20.04

RUN apt update
RUN apt install nginx -y
RUN echo 'hello world' > /var/www/html/index.html

EXPOSE 80

#command for image execution
CMD ["nginx", "-g", "daemon off;"]