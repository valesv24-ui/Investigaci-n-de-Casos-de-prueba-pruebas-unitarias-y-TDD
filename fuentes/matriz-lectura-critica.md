# Matriz de lectura crítica

> Tarea 5 · Fuente 1: Valery · Fuente 2: Maykel · Fuente 3: ambos · Fecha límite: sáb 7 nov

**Tipo de evidencia:**
- **N**: normativa o consenso de un organismo
- **P**: experiencia profesional u opinión experta
- **E**: empírica (estudio con datos)

## Fuente 1 · ISTQB (2024), *Certified Tester Foundation Level syllabus* v4.0.1 · Responsable: Valery

**Ficha general**

| Campo | Contenido |
|---|---|
| Autor / organismo | International Software Testing Qualifications Board, organismo internacional sin fines de lucro que define la certificación de testers |
| Tipo de documento | Programa (*syllabus*) de certificación de nivel básico. El documento se describe así: «This syllabus forms the basis for the International Software Testing Qualification at the Foundation Level» (p. 10) |
| Tipo de evidencia | **N**: consenso de expertos del sector, revisado por los comités nacionales del ISTQB |
| Vigencia | v4.0 del 21-04-2023; v4.0.1 de mantenimiento del 15-09-2024 |
| Acceso | PDF gratuito y oficial en istqb.org |

**Afirmaciones que usa el informe**

| # | Sección (pág.) | Cita textual | Idea en nuestras palabras | Uso en el informe |
|---|---|---|---|---|
| 1 | 1.4.4 (p. 20) | «To implement effective test monitoring and test control, it is important to establish and maintain traceability throughout the test process between the test basis elements…» | La trazabilidad entre la base de prueba (requisitos, criterios) y los casos hace posible controlar las pruebas y saber qué está cubierto. | Desarrollo A: matriz requisito → criterio → caso → resultado |
| 2 | 2.1.3 (p. 26) | TDD: «Directs the coding through test cases (instead of extensive software design)» | En TDD, las pruebas guían la escritura del código, en lugar de un diseño previo extenso. | Introducción; puente con el Desarrollo B |
| 3 | 2.1.3 (p. 26) | «Each of these approaches implements the principle of early testing (see section 1.3) and follows shift left…» | TDD, ATDD y BDD llevan las pruebas a las primeras etapas del desarrollo. | Introducción (contexto); postura sobre TDD |
| 4 | 2.1.3 (p. 26) | ATDD: «Derives tests from acceptance criteria as part of the system design process» | Las pruebas de aceptación se derivan de los criterios de aceptación. | Desarrollo A: del criterio de aceptación al caso |
| 5 | 2.2.1 (p. 28–29) | «Component testing (also known as unit testing) focuses on testing components in isolation.» | La prueba unitaria es la prueba de un componente aislado. | Definición de prueba unitaria; Desarrollo B |
| 6 | 4.2.1 (p. 39) | «Therefore, one test for each partition is sufficient.» | Si los valores de una partición se comportan igual, basta con un caso por partición, válida o inválida. | Desarrollo A: casos normales y de error |
| 7 | 4.2.2 (p. 40) | 2 valores: «for each boundary value there are two coverage items: this boundary value and its closest neighbor»; 3 valores: «…three coverage items: this boundary value and both its neighbors.» | Los defectos se concentran en las fronteras. El análisis de 3 valores es más riguroso que el de 2. | Desarrollo A: casos límite del descuento del 10 % |
| 8 | 4.4.1 (p. 43) | «Error guessing is a test technique used to anticipate the occurrence of errors, defects, and failures…» | La experiencia del tester sirve para anticipar errores típicos, como entradas vacías, negativas o con un formato incorrecto. | Desarrollo A: casos de error |
| 9 | 4.5.2 (p. 45–46) | Los criterios de aceptación sirven para «Define the scope of the user story» y «Serve as a basis for the user story acceptance testing» | El criterio de aceptación delimita el requisito y es la base de sus pruebas. | Desarrollo A; preguntas de debate 1 y 2 (ambigüedades) |
| 10 | 4.5.3 (p. 46) | «ATDD is a test-first approach…» | ATDD también escribe las pruebas antes del código, pero en el nivel de aceptación. | Desarrollo A y B (relación entre ATDD y TDD) |

**Valoración crítica**

| | |
|---|---|
| **Fortalezas** | Lo produce un organismo internacional y lo revisan expertos de muchos países. Es el vocabulario estándar del sector, es gratuito y es reciente (2023–2024). Las definiciones son precisas y numeradas, así que se pueden citar con exactitud. |
| **Limitaciones** | Es un programa de certificación: describe y define, pero **no aporta evidencia empírica** sobre si TDD mejora la calidad o la productividad. Presenta TDD de forma neutral y no dice cuándo no conviene. Su objetivo es formar para un examen, por eso simplifica. |
| **Posibles sesgos** | Su interés es promover la certificación y la profesión del tester. Las técnicas que incluye se presentan como buenas prácticas generales, sin considerar el contexto del proyecto. |
| **Qué no puede responder** | Si TDD conviene en *todos* los proyectos. Para eso hacen falta las fuentes de Maykel (Beck o Agile Alliance, Fowler) y, de ser posible, un estudio empírico. |
| **Confiabilidad para el informe** | Alta para definiciones y técnicas de diseño de casos. Baja como argumento a favor o en contra de TDD. |

> Páginas tomadas del índice y de las marcas de página del PDF v4.0.1 (78 p.). **Valery: confirmar cada página con el PDF abierto antes de pasarlas al Word.**

## Fuente 2 · (por definir: JUnit 5 User Guide / Beck o Agile Alliance / Fowler) · Responsable: Maykel

_Pendiente: Maykel._

## Fuente 3 · (por definir entre los dos) · Responsables: ambos

_Pendiente: hay que elegirla juntos. Sugerencia: un estudio empírico sobre TDD, porque ninguna de las otras fuentes aporta evidencia de tipo E._
