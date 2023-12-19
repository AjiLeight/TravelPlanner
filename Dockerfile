FROM maven:latest as build

WORKDIR /app

COPY . /app/

ENV MONGODB_URL=mongodb+srv://root:root@product.ly6bzfk.mongodb.net/?retryWrites=true&w=majority
ENV MONGODB_DATABASE=travelplanner
ENV SECRET=404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970
ENV JWT_TOKEN_EXPIRY=86400000
ENV JWT_REFRESH_TOKEN_EXPIRY=604800000

RUN mvn clean package

FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

ENV MONGODB_URL=mongodb+srv://root:root@product.ly6bzfk.mongodb.net/?retryWrites=true&w=majority
ENV MONGODB_DATABASE=travelplanner
ENV SECRET=404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970
ENV JWT_TOKEN_EXPIRY=86400000
ENV JWT_REFRESH_TOKEN_EXPIRY=604800000

COPY --from=build /app/target/*.jar app.jar
CMD ["java","-jar","/app.jar"]