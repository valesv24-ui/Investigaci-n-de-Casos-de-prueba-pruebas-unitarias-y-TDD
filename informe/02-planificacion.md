# Proceso de planificación

> Tarea 4 · Responsable: Maykel Meoño González · Revisa: Valery Salas Vargas

## División del trabajo

El informe y la exposición del Tema 2, «Casos de prueba, pruebas unitarias y TDD», se dividieron por mitades entre Valery Salas Vargas (A) y Maykel Meoño González (B). Valery llevó las secciones que plantean el problema: resumen, introducción, metodología, requisitos y casos de prueba. Maykel llevó las que lo resuelven técnicamente (pruebas unitarias y TDD) y el formato Word. La postura final sobre TDD y las lecciones aprendidas se escribieron entre los dos. Cada sección tiene un responsable y la otra persona la revisa.

El reparto se acordó el 1 de noviembre de 2026 y la entrega es el 14 de noviembre de 2026.

## Levantamiento de requerimientos de la consigna

Antes de repartir el trabajo se leyó la guía (secciones 1 a 4 y la ficha del Tema 2) y se extrajeron los requerimientos que el informe y la exposición deben cumplir. La tabla los agrupa y dice en qué parte del trabajo se atiende cada uno. Al final se revisan de nuevo contra la guía con la tabla de correspondencia del equipo.

| Requerimiento de la guía | Cómo se atiende en el trabajo |
|---|---|
| Informe en PDF con los 13 componentes en el orden de la sección 3, sin sustituirlos, omitirlos ni unirlos (secc. 2 y 3). | Un apartado por componente, en el orden pedido. La postura sobre TDD va dentro del Desarrollo. |
| Portada, tabla de contenidos, encabezado y número de página generados con las funciones de Word; estilos Título 1, 2 y 3; portada sin encabezado ni número (secc. 2 y 3). | Formato Word a cargo de Maykel; revisa Valery. |
| Resumen ejecutivo y abstract en inglés de al menos 150 palabras; introducción más extensa que el resumen ejecutivo (secc. 3 y 4). | Resumen ejecutivo (Valery) y abstract (Maykel). Se cuentan las palabras en la revisión final. |
| Metodología con al menos cinco pasos y una lección aprendida por cada paso, con lo aprendido, la dificultad y la mejora (secc. 3 y 4). | Siete pasos, cada uno con instrumento, criterio y responsable. Las lecciones se escriben por paso. |
| Al menos seis fuentes, tres de ellas técnicas primarias u oficiales; citas y bibliografía en APA; sin Wikipedia; declaración del uso de IA (secc. 4). | Criterios para escoger las fuentes (más abajo), bibliografía APA y Anexo C (bitácora de uso de IA). |
| Matriz de lectura crítica de al menos tres fuentes, con cuatro columnas, dentro del informe o de los anexos (secc. 2 y 4). | Anexo A, con una fuente de Valery, una de Maykel y una trabajada entre ambos. |
| Resolver las tareas de la ficha del Tema 2, con la consigna como subtítulo antes de cada respuesta: los cinco aspectos, las tres preguntas de debate y la conclusión exigida. | Desarrollo A, Desarrollo B y postura condicionada sobre TDD. |
| Presentación de al menos 15 diapositivas sin Gamma.App, con 15 minutos de exposición y 10 de actividad práctica; ambos exponen y defienden; la pregunta final es «¿Qué conclusión cambiaríamos si apareciera nueva evidencia y por qué?» (secc. 1, 2 y 8). | Sección Presentación del registro de responsabilidades; la actividad práctica de cierre la diseña Maykel. |
| Los casos se investigan y se analizan documentalmente; no se exige construir software ni ejecutar laboratorios (secc. 1). | La demostración en Java es pequeña e ilustrativa y se declara como tal. |

## Consultas previstas

Estas son las consultas que se planearon antes de buscar. Cada una parte de un aspecto de la ficha del Tema 2 y dice dónde se buscaría. Son un plan, no resultados: lo que cada fuente respalda se presenta en el Desarrollo y en la matriz de lectura crítica.

| Aspecto de la ficha por responder | Consulta prevista y dónde se buscaría |
|---|---|
| Requisito, criterio de aceptación, caso de prueba y resultado esperado: relaciones y trazabilidad. | Términos: «test basis», «traceability», «acceptance criteria», «test case». Dónde: programa ISTQB CTFL v4.0.1 (actividades de prueba, trazabilidad y criterios de aceptación) y Pressman (2010) para el contexto de calidad. |
| Cobertura de casos normales, límites y errores; razones para evitar pruebas que solo confirman el caso feliz. | Términos: «equivalence partitioning», «boundary value analysis», «error guessing». Dónde: ISTQB (técnicas de prueba de caja negra). |
| Prueba unitaria, aislamiento, aserciones y estructura AAA (Preparar–Actuar–Afirmar). | Términos: «component testing», «test in isolation», «assertions», «Arrange Act Assert». Dónde: ISTQB (niveles de prueba), guía de usuario de JUnit 5 (anotaciones, aserciones y ciclo de vida) y Vocke (2018). |
| Ciclo de TDD: rojo, verde y refactorización; qué pretende prevenir y qué no garantiza. | Términos: «test-driven development», «red green refactor», «ATDD». Dónde: Agile Alliance (s. f.), Fowler (2023) e ISTQB (pruebas como impulsoras del desarrollo). |
| Pruebas mantenibles, pruebas frágiles y el riesgo de una falsa sensación de seguridad. | Términos: «brittle tests», «test maintenance», «test pyramid». Dónde: Vocke (2018), Fowler (2023) y la guía de JUnit 5. |
| ¿Cambia el resultado si se escribe primero la prueba? (pregunta central y contraargumento). | Términos: «test-first», «test-last», «TDD empirical study». Dónde: estudio empírico de Fucci et al. (2017), para contrastar la postura con evidencia. |
| Marco normativo general de las pruebas de software. | Términos: «ISO/IEC/IEEE 29119-1», «software testing general concepts». Dónde: ficha oficial de la norma; es de pago, por lo que solo se prevé consultar su alcance. |

## Criterios para escoger las fuentes

Las fuentes se escogen con los criterios de la guía (sección 4) y con los criterios de inclusión y exclusión del Paso 2 de la metodología:

- **Cantidad y tipo:** al menos seis fuentes, y al menos tres técnicas primarias u oficiales (normas, organismos especializados, documentación de herramientas). Se recomienda incluir bibliografía académica o libros especializados.
- **Autoridad:** organismo de estandarización, autor de referencia o comunidad reconocida.
- **Pertinencia:** relación directa con los tres temas (casos de prueba, pruebas unitarias y TDD).
- **Vigencia:** se usa la versión o edición más reciente disponible.
- **Acceso y verificación:** se prefiere la fuente que se pueda abrir en su original, para comprobar cada dato y cada cita. Si no se puede abrir, se declara y se busca una alternativa.
- **Contraste:** se busca al menos una fuente con evidencia empírica, para no apoyar la postura solo en fuentes normativas o de experiencia profesional.
- **Exclusión:** Wikipedia, blogs sin autoría identificable y fuentes secundarias que solo resumen a otras. Las diapositivas del curso sirven de guía, pero no sustituyen a las fuentes.
- **Uso de IA:** ninguna fuente que la IA proponga entra a la bibliografía sin abrir el original; lo no verificado se declara en la bitácora (Anexo C).

## Productos del análisis previo

Estos son los productos que se planearon construir antes y durante el análisis. Cada uno corresponde a un paso de la metodología y alimenta una parte del informe.

| Producto (paso y responsable) | Para qué sirve |
|---|---|
| Mapa de conceptos (paso 1; ambos) | Relacionar requisito, criterio de aceptación, caso de prueba, prueba unitaria y TDD, y delimitar el alcance. |
| Ficha bibliográfica por fuente (paso 2; cada integrante, las suyas) | Reunir la referencia APA, la versión, el acceso al original y las secciones que respaldan cada parte del informe. |
| Matriz de lectura crítica (paso 3; Valery, fuente 1; Maykel, fuente 2; ambos, fuente 3) | Separar qué afirma cada fuente, en qué evidencia se apoya, qué no demuestra y qué interpreta la pareja. Va en el Anexo A. |
| Matriz de trazabilidad (paso 4; Valery) | Enlazar requisito, criterio de aceptación, caso de prueba y resultado esperado, con casos normales, límites y errores. |
| Bitácora del ciclo rojo–verde–refactor y esquema del ciclo (paso 5; Maykel) | Registrar la demostración en Java y qué se observó en cada fase. Van en los Anexos D y E. |
| Tabla de argumentos (paso 6; ambos) | Ordenar cuándo sí y cuándo no conviene TDD, con la fuente de cada argumento y el contraargumento. |
| Tabla de correspondencia con la guía y bitácora de IA (paso 7; ambos) | Comprobar que cada requerimiento de la guía se cumple y declarar el uso de IA (Anexo C). |

## Forma de trabajo

- Cada tarea se hace en una rama propia del repositorio compartido (por ejemplo `valery/tarea-3-metodologia`).
- Se abre un *pull request* hacia `main` con la otra persona como revisora. Los comentarios del PR son la constancia de la revisión cruzada. En los primeros PR hubo fusiones antes de la aprobación de la otra persona; una ronda de correcciones (PR #3) arregló los errores que la revisión encontró después.
- Cada persona verifica las fuentes que cita y declara su uso de IA en la bitácora de anexos (Anexo C).
- Antes de la entrega, cada integrante practicará explicar el bloque del otro (ensayo del viernes 13 de noviembre), porque el profesor puede preguntar a cualquiera.

## Cronograma

| Fecha | Hito |
|---|---|
| Mar 3 nov | Fuentes verificadas (tareas 1 y 2) |
| Mié 4 nov | Metodología y proceso de planificación (tareas 3 y 4) |
| Sáb 7 nov | Matriz de lectura crítica e introducción (tareas 5 y 6) |
| Lun 9 nov | Desarrollo A y Desarrollo B (tareas 7 y 8) |
| Mar 10 nov | Postura sobre TDD, resumen, abstract y conclusiones (tareas 9 a 12) |
| Mié 11 nov | Lecciones aprendidas, referencias, anexos y diapositivas (tareas 13 a 15) |
| Jue 12 nov | Formato Word, tabla de correspondencia y PDF (tareas 16 y 17) |
| Vie 13 nov | Ensayo cronometrado de 15 + 10 minutos |
| Sáb 14 nov | Entrega y exposición (grupo 02, segundo en exponer) |

## Registro de responsabilidades

Los estados corresponden al **13 de noviembre de 2026**, según lo que consta en el repositorio.

| # | Tarea | Responsable | Revisa | Fecha límite | Estado |
|---|---|---|---|---|---|
| 1 | Buscar y verificar 3 fuentes: ISTQB CTFL v4.0, ISO/IEC/IEEE 29119, Pressman | Valery | Maykel | mar 3 nov | Hecha |
| 2 | Buscar y verificar 3 fuentes: JUnit 5 User Guide, TDD (Agile Alliance), Vocke *Practical Test Pyramid* | Maykel | Valery | mar 3 nov | Hecha. Citas contrastadas con los originales en línea el 11-nov. Fucci et al. se contrastó con el preprint de arXiv, no con IEEE Xplore |
| 3 | Metodología (7 pasos, con instrumentos y criterios) | Valery | Maykel | mié 4 nov | Hecha |
| 4 | Proceso de planificación | Maykel | Valery | mié 4 nov | Hecha (estados actualizados el 13-nov) |
| 5 | Matriz de lectura crítica | Ambos | Ambos | sáb 7 nov | Hecha. Incluye la tabla en el formato de la guía |
| 6 | Introducción | Valery | Maykel | sáb 7 nov | Hecha |
| 7 | Desarrollo A | Valery | Maykel | lun 9 nov | Hecha |
| 8 | Desarrollo B | Maykel | Valery | lun 9 nov | Hecha (ajustada al caso de clientes frecuentes el 13-nov). El ciclo se observó con un arnés mínimo en Java; el 13-nov `mvn test` pasó las 9 pruebas con JUnit 5.9.2 |
| 9 | Postura condicionada sobre TDD | Ambos | Ambos | mar 10 nov | Hecha. Está en el informe con los argumentos de ambos |
| 10 | Resumen ejecutivo | Valery | Maykel | mar 10 nov | Hecha |
| 11 | Abstract | Maykel | Valery | mar 10 nov | Hecha (cifras alineadas con el resumen el 13-nov) |
| 12 | Conclusiones | Valery | Maykel | mar 10 nov | Hecha |
| 13 | Lecciones aprendidas | Ambos | Ambos | mié 11 nov | Hecha. Cada integrante escribió las de los pasos que ejecutó |
| 14 | Referencias APA y declaración de uso de IA | Valery | Maykel | mié 11 nov | Hecha |
| 15 | Anexos | Maykel | Valery | mié 11 nov | Hecha. Anexos A a E |
| 16 | Formato Word | Maykel | Valery | jue 12 nov | Hecha el 13-nov: portada, índice automático, encabezado y número de página sin numerar la portada |
| 17 | Tabla de correspondencia y PDF | Ambos | Ambos | jue 12 nov | En curso: falta la revisión conjunta del PDF final |

### Presentación

| Diapositivas | Contenido | Expone | Arma | Minutos |
|---|---|---|---|---|
| 1–3 | Portada, problema y pregunta central | Valery | Valery | 2 |
| 4–7 | Requisito, criterio, caso de prueba y trazabilidad; cobertura | Valery | Valery | 4 |
| 8–11 | Unitarias, AAA, rojo–verde–refactor, pruebas frágiles | Maykel | Maykel | 4 |
| 12–13 | Caso del descuento del 10 %: ambigüedades y preguntas | Valery | Valery | 2 |
| 14–15 | Postura condicionada sobre TDD, límites y contraargumento | Maykel | Maykel | 2 |
| 16 | Conclusión y pregunta final | Ambos | Ambos | 1 |

La actividad práctica de 10 minutos la diseña Maykel y la conducen ambos. La lista de preguntas posibles del profesor la preparan ambos, la mitad cada uno.

## Riesgos identificados

| Riesgo | Medida |
|---|---|
| Tareas vencidas antes de la revisión cruzada (fuentes y planificación) | Hacer las revisiones en el mismo día en que se abre el PR |
| Fuente citada con autor incorrecto (*Practical Test Pyramid* es de Vocke, no de Fowler) | Verificar autor, fecha y versión contra el original antes de citar |
| El ciclo de la demostración no se observó con JUnit | Las fases en rojo se observaron con un arnés mínimo y así se declara en el Desarrollo B. La suite final se ejecutó con `mvn test` el 13-nov y pasó las 9 pruebas |
| Citas verificadas solo en versiones resumidas de las páginas | Maykel abre cada original antes de pasar el texto al Word (regla 2) |
| Nombre del archivo final (`.docx` en el patrón, pero se pide PDF) | Confirmar con el profesor |
