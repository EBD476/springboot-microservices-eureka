FROM adoptopenjdk/openjdk11:alpine-jre
ENV APP_HOME=/app
COPY . /app
ARG JAR_FILE=build/lib/eureka-discovery-service-1.0.jar
#WORKDIR /app
WORKDIR /app
#COPY ${JAR_FILE} ./app/app.jar
#COPY build/lib/eureka-discovery-service-1.0.jar ./app/app.jar
#RUN cp $APP_HOME/build/lib/eureka-discovery-service-1.0.jar /app/app.jar

#ARG BUILD_HOME
#ENV APP_HOME=$BUILD_HOME
#COPY  $APP_HOME/build/lib/eureka-discovery-service-1.0.jar /app/app.jar
#ADD ./build/lib/eureka-discovery-service-1.0.jar app.jar
COPY /build/libs/eureka-discovery-service-1.0.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
