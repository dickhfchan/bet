FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.mountbet.betservice.BetserviceApplication"]

#Run on VM: docker run -i  -p 8020:8020 -e "SPRING_PROFILES_ACTIVE=vm" mountbet/betservice