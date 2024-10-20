# Etapa de construção
FROM eclipse-temurin:21-jdk AS build

# Instala Maven
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

COPY . /app
WORKDIR /app

# Comando para compilar o projeto usando Maven
RUN mvn clean package -DskipTests

# Etapa de execução
FROM eclipse-temurin:21-jre
ARG PORT=8080
ENV PORT=${PORT}
COPY --from=build /app/target/*.jar app.jar
RUN useradd -r -s /bin/false runtime
USER runtime

# Expõe a porta configurada
EXPOSE ${PORT}

ENTRYPOINT [ "java", "-Dserver.port=${PORT}", "-jar", "app.jar" ]