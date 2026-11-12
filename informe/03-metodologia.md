# Metodología

> Tarea 3 · Responsable: Valery Salas Vargas · Revisa: Maykel Meoño González

## Enfoque

La investigación es documental, con enfoque cualitativo y alcance descriptivo-analítico. Parte de una revisión de fuentes normativas y académicas sobre pruebas de software. Lo que se obtiene de ellas se aplica a un caso concreto, el requisito del descuento del 10 %, para responder la pregunta central: **¿conviene aplicar TDD en todos los proyectos de software?**

El trabajo se hizo en siete pasos. Cada uno tiene un instrumento, un criterio que indica cuándo el paso está completo y una persona responsable. Así se puede rastrear qué hizo cada integrante, y las lecciones aprendidas se escriben por paso.

## Pasos

### Paso 1. Delimitación del problema y de la pregunta central
Se analizó la guía del Tema 2 para definir la pregunta central, los objetivos y el alcance del informe. El alcance quedó en tres temas: casos de prueba, pruebas unitarias y desarrollo guiado por pruebas (TDD). Quedan fuera las pruebas de integración, de sistema y de rendimiento, salvo para ubicar las unitarias dentro de los niveles de prueba.

- **Instrumento:** guía del Tema 2 y un mapa de conceptos (requisito, criterio de aceptación, caso de prueba, prueba unitaria, TDD).
- **Criterio de cumplimiento:** la pregunta se puede responder con evidencia de las fuentes y cada objetivo corresponde a una sección del informe.
- **Responsable:** Valery y Maykel.

### Paso 2. Búsqueda y selección de fuentes
Se seleccionaron ocho fuentes: tres a cargo de cada integrante, una fuente empírica acordada entre ambos y una fuente de apoyo. Se dio prioridad a organismos de estandarización y a autores de referencia en la disciplina.

- **Instrumento:** ficha bibliográfica por fuente, con la referencia APA 7, la versión o edición, el acceso al original y las secciones que respaldan cada parte del informe (carpeta `fuentes/` del repositorio).
- **Criterios de inclusión:**
  - autoridad: organismo de estandarización, autor o comunidad reconocida;
  - pertinencia directa con los tres temas;
  - vigencia: se usa la versión más reciente disponible;
  - acceso al documento original.
- **Criterios de exclusión:** Wikipedia, blogs sin autoría identificable y fuentes secundarias que solo resumen a otras.
- **Fuentes seleccionadas:**
  - Valery: ISTQB (2024), ISO/IEC/IEEE 29119-1 (2022) y Pressman (2010).
  - Maykel: JUnit 5 User Guide (Bechtold et al., s. f.), Agile Alliance (s. f.) sobre TDD y Vocke (2018), *The practical test pyramid*.
  - Acordada entre ambos (fuente 3 de la matriz): Fucci et al. (2017), la única con evidencia empírica sobre TDD.
  - De apoyo: Fowler (2023), usada solo para describir el ciclo rojo–verde–refactor.
- **Responsable:** cada fuente la busca y la verifica quien la cita.

### Paso 3. Verificación y lectura crítica
Cada fuente se leyó en su versión original. Para cada afirmación que se usa en el informe se comprobó que la fuente realmente la respalda y se anotó la cita y la página.

- **Instrumento:** matriz de lectura crítica, con estas columnas: fuente, tipo de evidencia (normativa, experiencia profesional o empírica), afirmación principal, cita y página, fortalezas, limitaciones o sesgos, y uso en el informe.
- **Criterio de cumplimiento:** ninguna afirmación del informe queda sin una fuente verificada, y se distingue lo que una fuente *establece* (norma) de lo que *recomienda* (opinión experta).
- **Responsable:** fuente 1, Valery; fuente 2, Maykel; fuente 3, ambos.

### Paso 4. Análisis del caso del descuento del 10 %
Los conceptos de las fuentes se aplicaron al requisito del descuento del 10 %. Primero se identificaron las ambigüedades del requisito y las preguntas que habría que hacerle al cliente. Después se derivó la cadena requisito → criterio de aceptación → caso de prueba → resultado esperado.

Los casos se diseñaron con dos técnicas de caja negra descritas en el programa ISTQB (2024, secc. 4.2.1 y 4.2.2):
- **Partición de equivalencia:** una prueba por partición válida e inválida.
- **Análisis de valores límite:** se evalúan los valores en cada frontera de las particiones.

- **Instrumento:** matriz de trazabilidad (ID del requisito, criterio de aceptación, ID del caso, tipo de caso, datos de entrada, resultado esperado) y una lista de ambigüedades con su pregunta al cliente.
- **Criterio de cumplimiento:**
  - cada criterio de aceptación tiene al menos un caso;
  - cada caso se puede trazar a un criterio (ISTQB, 2024, secc. 1.4.4);
  - el conjunto cubre casos normales, límites y de error.
- **Responsable:** Valery.

### Paso 5. Demostración del ciclo de TDD
Para observar el ciclo rojo–verde–refactor, los casos del paso 4 se automatizaron como pruebas unitarias con JUnit 5. No se pudo descargar JUnit en el entorno de preparación. Por eso cada fase se ejecutó con un arnés mínimo en Java, con las mismas entradas, valores esperados y tolerancia que las pruebas. Las pruebas siguen la estructura Arrange–Act–Assert. Se registró qué pasó en cada fase: la prueba falla antes de existir el código, pasa con la implementación mínima y se mantiene en verde al refactorizar. También se anotaron las pruebas que se rompieron por cambios internos que no alteraban el comportamiento, es decir, las pruebas frágiles.

- **Instrumento:** proyecto de ejemplo con JUnit 5, un arnés mínimo en Java y una bitácora del ciclo (prueba, fase, resultado, observación) en el Anexo E.
- **Criterio de cumplimiento:** se ve al menos un ciclo completo rojo–verde–refactor y cada prueba se puede relacionar con un caso de la matriz de trazabilidad.
- **Responsable:** Maykel.

### Paso 6. Síntesis y postura condicionada sobre TDD
Se compararon los argumentos de las fuentes y lo observado en los pasos 4 y 5. Con eso se formuló una postura condicionada: en qué contextos TDD conviene y en cuáles no. La postura incluye su contraargumento principal y los límites de la evidencia.

- **Instrumento:** tabla de argumentos, con las columnas condición del proyecto, argumento a favor, argumento en contra, fuente o evidencia y peso.
- **Criterio de cumplimiento:**
  - la postura se apoya en al menos dos fuentes independientes;
  - presenta y responde un contraargumento;
  - dice qué evidencia nueva haría cambiar la conclusión, que es la pregunta final de la exposición.
- **Responsable:** Valery y Maykel.

### Paso 7. Revisión cruzada y control de calidad
Cada sección la revisó el integrante que no la escribió. Las revisiones se hicieron por *pull request* en el repositorio compartido, y los comentarios quedaron registrados como constancia de que ambos conocen todo el informe. Antes de exportar el PDF se verificó el informe contra la tabla de control de correspondencia de la guía.

- **Instrumento:** *pull requests* en GitHub con revisor asignado, la tabla de control de correspondencia y la bitácora de uso de IA en los anexos.
- **Criterio de cumplimiento:**
  - toda sección tiene una revisión aprobada;
  - cada requisito de la guía aparece en el informe;
  - las referencias están en APA 7;
  - el uso de IA de cada integrante está declarado.
- **Responsable:** Valery y Maykel.

## Resumen

| Paso | Instrumento | Criterio de cumplimiento | Responsable |
|---|---|---|---|
| 1. Delimitación | Guía y mapa de conceptos | Pregunta respondible con evidencia | Ambos |
| 2. Búsqueda y selección | Ficha bibliográfica | Inclusión y exclusión aplicadas; 8 fuentes | Cada quien las suyas |
| 3. Lectura crítica | Matriz de lectura crítica | Toda afirmación verificada con cita y página | V: fuente 1 · M: fuente 2 · ambos: fuente 3 |
| 4. Análisis del caso | Matriz de trazabilidad | Cobertura de casos normales, límites y errores | Valery |
| 5. Demostración TDD | JUnit 5 y bitácora del ciclo | Ciclo rojo–verde–refactor completo | Maykel |
| 6. Síntesis | Tabla de argumentos | Postura con 2 o más fuentes y contraargumento | Ambos |
| 7. Revisión y control | PR, tabla de correspondencia y bitácora de IA | Todo revisado y correspondido | Ambos |

## Referencias citadas en esta sección

International Software Testing Qualifications Board. (2024). *Certified Tester Foundation Level syllabus* (Versión 4.0.1). https://www.istqb.org/wp-content/uploads/2024/11/ISTQB_CTFL_Syllabus_v4.0.1.pdf

---

**Notas para la revisión (se borran antes de pasar al Word):**
- Hay que ajustar los nombres de las columnas de la matriz de lectura crítica a lo que pida la guía, si la guía define un formato.
