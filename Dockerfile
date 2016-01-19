#使用官方Maven镜像
FROM maven

#
EXPOSE 443 80

CMD mvn package

RUN  mvn spring-boot:run
