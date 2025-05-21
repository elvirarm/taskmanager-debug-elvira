# TaskManager - Linting con Ktlint

1. Instalar la herramienta elegida (Detekt o Ktlint) e incluir capturas de pantalla del proceso.
    
Estoy usando Ktlint, para instalarlo he incluido en el fichero de build.gradle lo siguiente:
   
![Configuración de ktlint](./src/main/kotlin/images/add_ktlint.jpg)

2. Integrar el analizador en el proyecto que se está desarrollando y ejecutar el análisis.

Para ejecutar el diagnóstico abro la terminal que el mismo IDE proporciona y ejecuto el siguiente comando:

   ./gradlew ktlintCheck

3. Identificar al menos 5 tipos de errores detectados.

He obtenido los siguientes errores

![Diagnóstico 1](./src/main/kotlin/images/diagnostico1.png)

![Diagnóstico 2](./src/main/kotlin/images/diagnostico2.png)

4. Para cada tipo de error, documentar:

Los errores que me está indicando son:

- class UsuarioServiceTest should be declared in a file named UsuarioServiceTest.kt

   Solución: Debo cambiarle el nombre porque me equivoqué y le puse Actividad en vez de Usuario porque al principio iba a hacer la actividad anterior con actividad.

![Solucionado problema con el nombre del archivo de test](./src/main/kotlin/images/cambioNombre.png)


-  Wildcard import en ActividadServiceTest
   
   Solución: Esto quiere decir que he hecho un import *, para que sea más controlado se recomienda importar solo lo necesario.

    Imagen de los imports antes:

    ![Cómo estaban los imports antes](./src/main/kotlin/images/importsantes.png)

    Imagen de los imports arreglados:

    |[Imports actuales](./src/main/kotlin/images/importdespues.png)

    Commit de la solución: https://github.com/elvirarm/taskmanager-debug-elvira/commit/e2a53a7137ed2cb5843b2dba7f46314748ae66c9

- File must end with a newline en IUsuarioService, en UsuarioService y en Utilidades

   Solución: Los archivos tienen que terminar con un salto de línea. Así que para arreglarlo añadiré un salto de líneas a todos los archivos.

    Commit de la solución: https://github.com/elvirarm/taskmanager-debug-elvira/commit/a5aaca928b04ef099889b524e8e4de473b2c655b

- Unexpected blank line(s) before "}"

   Solución: He dejado un espacio antes de llave en la clase IUsuarioService, así que lo eliminaré.

    Commit de la solución: https://github.com/elvirarm/taskmanager-debug-elvira/commit/ea7c033df87a7720dfae4cda0b7c5f9393dff274

He vuelto a ejecutar el analizador de código y me ha dado un error:

- File must end with a newline (\n) (final-newline) en build.gradle.kts

    Solución: añadirle un espacio final

    Commit de la solución: https://github.com/elvirarm/taskmanager-debug-elvira/commit/9a6a05bec972a31a04a565f5f7eba6628c5ed713

5. Explorar y modificar al menos una opción de configuración del analizador distinta de la predeterminada; describir cómo afecta al código y por tanto al informe de errores.

He añadido esta linea en el archivo build.gradle.kts

    disabledRules.set(setOf("no-wildcard-imports"))

Commit del cambio: https://github.com/elvirarm/taskmanager-debug-elvira/commit/6aed829663cd4ab98478d40d44f9d533754e06ba

Esto lo que hace es que no me saltaría como error los wildcard import.

En mi caso me saltaba porque Kotlin prefiere imports más específicos como ya he explicado antes, después de la modificación el informe de error los obviaría.

# PREGUNTAS

Responde a las preguntas:

[1]
1.a ¿Qué herramienta has usado, y para qué sirve?

He utilizado Ktlint, es una herramienta de linting que sirve para analizar el código y detectar errores sintáctico o de estilo.

1.b ¿Cuáles son sus características principales?

- No requiere configuración compleja

- Te da una serie de reglas por defecto, pero te permite personalizarlas fácilmente.

- Se pueden deshabilitar las reglas que no nos convenzcan.

- klint tiene una herramienta que te permiten arreglar algunos problemas automáticamente, aunque hay algunos que no puede y te lo indica en el informe de errores.

- El output del informe de errores es personalizable.

- Está publicado como un jar que se ejecuta una sola vez en todas las dependencias. 

1.c ¿Qué beneficios obtengo al utilizar dicha herramienta?
[2]
2.a De los errores/problemas que la herramienta ha detectado y te ha ayudado a solucionar, ¿cual es el que te ha parecido que ha mejorado más tu código?

Me han parecido muy útil el de cambiarle el nombre al archivo ActividadService porque la verdad es que no me había dado ni cuenta de que no lo había modificado y también el de no dejarte importar todo de golpe porque a veces no se necesitan todos los imports y es una mala práctica.

2.b ¿La solución que se le ha dado al error/problema la has entendido y te ha parecido correcta?

Sí, la verdad que el informe de errores es muy claro y te da sugerencias de cómo solucionar el problema, quedando resuelto perfectamente.

2.c ¿Por qué se ha producido ese error/problema?

En el archivo ActividadService, al principio iba a hacer el ejercicio de debug con mi servicio de actividad, entonces al crear la clase se nombró así. Pero al final decidí hacerlo de usuario y cambié el nombre de la clase en el código, pero no lo renombré en el archivo.

Y en el caso de los wildcard se ha producido porque hago un import * y lo correcto es hacer los imports de forma individual.

[3]
3.a ¿Que posibilidades de configuración tiene la herramienta?

Tiene las siguientes posibilidades de configuración:

- verbose: muestra más información en la salida.

- outputToConsole: decide si muestra los resultados en consola.

- coloredOutput: colorea la salida para mejor lectura.

- reporters: definir formatos de reporte, por ejemplo: CHECKSTYLE, JSON, HTML.

- filter: incluir o excluir archivos o patrones de archivos.

- disabledRules: desactivar reglas específicas que no quieres aplicar.

- experimentalRules: habilitar reglas experimentales que aún no son estables.

- android: activa reglas específicas para proyectos Android.

3.b De esas posibilidades de configuración, ¿cuál has configurado para que sea distinta a la que viene por defecto?

He utilizado la de disabledRules para desactivar que me marque los wildcard.

3.c Pon un ejemplo de como ha impactado en tu código, enlazando al código anterior al cambio, y al posterior al cambio,

Antes me marcaba los wildcard y ahora no.

Enlace antes del cambio: https://github.com/elvirarm/taskmanager-debug-elvira/commit/aeec4eaa1e3647ada8f5c12fa05325c2c5f0c991

Enlace después del cambio: https://github.com/elvirarm/taskmanager-debug-elvira/commit/6aed829663cd4ab98478d40d44f9d533754e06ba

[4]
4 ¿Qué conclusiones sacas después del uso de estas herramientas?

La verdad que me ha parecido una herramienta muy interesante y útil para mejorar el código.

Antes conocía técnicas para depurar el código y buscar errores de compilación sobre todo, pero esta herramienta ayuda a seguir buenas prácticas y un mismo estilo.
