# Proceso de planificación

> Tarea 4 · Responsable: Maykel Meoño González · Revisa: Valery Salas Vargas

## División del trabajo

El informe y la exposición del Tema 2, «Casos de prueba, pruebas unitarias y TDD», se dividieron por mitades entre Valery Salas Vargas (A) y Maykel Meoño González (B). Valery llevó las secciones que plantean el problema: resumen, introducción, metodología, requisitos y casos de prueba. Maykel llevó las que lo resuelven técnicamente (pruebas unitarias y TDD) y el formato Word. La postura final sobre TDD y las lecciones aprendidas se escribieron entre los dos. Cada sección tiene un responsable y la otra persona la revisa.

El reparto se acordó el 1 de noviembre de 2026 y la entrega es el 14 de noviembre de 2026.

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

> Rellenar la columna «Estado final» el día de la entrega (regla 5). Los estados de abajo corresponden al **11 de noviembre de 2026**, según lo que consta en el repositorio (`main`) y en el trabajo local pendiente de *pull request*.

| # | Tarea | Responsable | Revisa | Fecha límite | Estado |
|---|---|---|---|---|---|
| 1 | Buscar y verificar 3 fuentes: ISTQB CTFL v4.0, ISO/IEC/IEEE 29119, Pressman | Valery | Maykel | mar 3 nov | Hecha. Fusionada en `main` |
| 2 | Buscar y verificar 3 fuentes: JUnit 5 User Guide, TDD (Agile Alliance), Vocke *Practical Test Pyramid* | Maykel | Valery | mar 3 nov | Citas contrastadas con los originales en línea el 11-nov. Falta que Maykel abra cada original y confirme Fucci en IEEE Xplore |
| 3 | Metodología (7 pasos, con instrumentos y criterios) | Valery | Maykel | mié 4 nov | Hecha. Fusionada en `main` (PR #1) |
| 4 | Proceso de planificación | Maykel | Valery | mié 4 nov | Hecha (actualizada el 11-nov). Revisión de Valery pendiente |
| 5 | Matriz de lectura crítica | Ambos | Ambos | sáb 7 nov | Hecha. Citas contrastadas el 11-nov. Falta confirmar Fucci en la versión de IEEE |
| 6 | Introducción | Valery | Maykel | sáb 7 nov | Hecha. Fusionada en `main` (PR #2) |
| 7 | Desarrollo A | Valery | Maykel | lun 9 nov | Hecha. Fusionada en `main` (PR #9). Revisión de Maykel pendiente |
| 8 | Desarrollo B | Maykel | Valery | lun 9 nov | Hecha. Alineada con CP-01 a CP-09; ciclo observado con arnés sin JUnit. Falta correr `mvn test` y la revisión de Valery |
| 9 | Postura condicionada sobre TDD | Ambos | Ambos | mar 10 nov | Versión del 11-nov integrada (argumentos de A y B). Falta que ambos confirmen el peso de cada fila |
| 10 | Resumen ejecutivo | Valery | Maykel | mar 10 nov | Hecha. Fusionada en `main` (PR #10) |
| 11 | Abstract | Maykel | Valery | mar 10 nov | Hecha. Alineada con el resumen y las conclusiones. Revisión de Valery pendiente |
| 12 | Conclusiones | Valery | Maykel | mar 10 nov | Hecha. Fusionada en `main` (PR #6) |
| 13 | Lecciones aprendidas | Ambos | Ambos | mié 11 nov | Partes de ambos escritas (`13-lecciones-aprendidas-valery.md` y `-maykel.md`). Falta que Maykel la reescriba con sus palabras |
| 14 | Referencias APA y declaración de uso de IA | Valery | Maykel | mié 11 nov | Hecha. Fusionada en `main` (PR #11). Faltan cambios a las referencias de JUnit y Agile Alliance |
| 15 | Anexos | Maykel | Valery | mié 11 nov | Hecha. Anexos A a E completos; falta la ejecución con JUnit y la revisión de Valery |
| 16 | Formato Word | Maykel | Valery | jue 12 nov | Pendiente (vence jue 12 nov) |
| 17 | Tabla de correspondencia y PDF | Ambos | Ambos | jue 12 nov | Pendiente |

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
| La demostración con JUnit no se ejecuta con JUnit | El ciclo se observó con un arnés mínimo sin JUnit y así se declara en el Desarrollo B. Falta correr `mvn test` y anotar el resultado en la bitácora antes del jueves 12 |
| Citas verificadas solo en versiones resumidas de las páginas | Maykel abre cada original antes de pasar el texto al Word (regla 2) |
| Nombre del archivo final (`.docx` en el patrón, pero se pide PDF) | Confirmar con el profesor |
