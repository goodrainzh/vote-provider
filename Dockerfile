FROM goodrainapps/maven:jdk7-alpine

COPY demo.vote.provider-0.0.1-SNAPSHOT.jar /vote-provider.jar

ENTRYPOINT exec java -jar /vote-provider.jar