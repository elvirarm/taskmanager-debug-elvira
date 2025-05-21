# TaskManager -Documentación

1. Documentar mi código

Para documentar mi código lo hice con el formato multilinea o comentario en bloque (/*), aunque también hemos documentado en otras ocasiones con docstring(""")

En ella incluía una breve descripción de la función, parámetros recibidos, retornos que hacía. A continuación adjunto capturas de mi código comentado:

Capturas del servicio Usuario comentado:

![Captura del servicio usuario comentado](./src/main/kotlin/images/documentacionUsuario1.png)

![Captura del servicio usuario comentado](./src/main/kotlin/images/documentacionUsuario2.png)

Capturas del servicio Actividad comentado:

![Captura del servicio_actividad comentado](./src/main/kotlin/images/documentacionActividad1.png)

![Captura del servicio actividad comentado](./src/main/kotlin/images/documentacionActividad2.png)

![Captura del servicio actividad comentado](./src/main/kotlin/images/documentacionActividad3.png)

Capturas del servicio Gestor Actividades comentado:

![Captura del servicio_gestor_actividades comentado](./src/main/kotlin/images/documentacionGestorActividades1.png)

![Captura del servicio_gestor_actividades comentado](./src/main/kotlin/images/documentacionGestorActividades2.png)

![Captura del servicio_gestor_actividades comentado](./src/main/kotlin/images/documentacionGestorActividades3.png)

![Captura del servicio_gestor_actividades comentado](./src/main/kotlin/images/documentacionGestorActividades4.png)

1. Configuración de Dokka

![Configuración Dokka](./src/main/kotlin/images/configuracionDokka.png)


Para configurar Dokka incluí en el archivo build.gradle.kts lo siguiente:

plugins {
id("org.jetbrains.dokka") version "1.6.10"
}

repositories {
mavenCentral()
}

Sin embargo en mi versión de Gradle daba problemas y al ejecutar me daba error, entonces la versión la sustituí por "1.9.20" que es una versión más actual.

2. Ejecución de Dokka

![Ejecución Dokka](./src/main/kotlin/images/ejecutadoDokka.png)


Después ejecuté Dokka a través del comando "gradle dokkaHtml" para generar un html con la documentación-

3. Ruta de Dokka

Al ejecutarlo se me creó en el build una carpeta de dokka con el html y todo lo necesario:

Esta es la ruta generada: build/dokka/html/index.html

Ejemplos de cómo se ve Dokka en el navegador:

![Ejemplo Dokka en el navegador con servicio Actividad](./src/main/kotlin/images/navegadorActividad.png)

![Ejemplo Dokka en el navegador con servicio Usuario](./src/main/kotlin/images/navegadorService.png)
