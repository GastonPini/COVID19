# secret-service-shared

Este es un proyecto gradle que representa a una librería / biblioteca JAR con código que necesita ser compartida entre diferentes proyectos.

Debido a que este proyecto configura el plugin maven-publish, podemos publicarlo en un repositorio maven para poder compartirlo.
Para publicarlo en el repositorio local:
```bash
gradlew publishToMavenLocal
```

