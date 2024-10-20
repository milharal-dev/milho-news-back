# Etapa de construção
FROM eclipse-temurin:21-jdk AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

# Etapa de execução
FROM eclipse-temurin:21-jre
ARG PORT=8080
ENV PORT=${PORT}
COPY --from=build /app/target/*.jar app.jar
RUN useradd -r -s /bin/false runtime
USER runtime

EXPOSE ${PORT}

ENTRYPOINT [ "java", "-Dserver.port=${PORT}", "-jar", "app.jar" ]