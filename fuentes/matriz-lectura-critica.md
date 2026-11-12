# Matriz de lectura crítica

> Tarea 5 · Fuente 1: Valery · Fuente 2: Maykel · Fuente 3: ambos · Fecha límite: sáb 7 nov

**Tipo de evidencia:**
- **N**: normativa o consenso de un organismo
- **P**: experiencia profesional u opinión experta
- **E**: empírica (estudio con datos)

## Matriz en el formato de la guía

Esta tabla es la que exige la guía (sección 4, «Anexo obligatorio»). Las secciones que siguen la detallan fuente por fuente, con las citas textuales y sus páginas.

| Fuente y tesis | Evidencia consultada | ¿Qué no demuestra / límite? | Interpretación de la pareja |
|---|---|---|---|
| **Fuente 1 · ISTQB (2024).** Las pruebas se diseñan a partir de una base de prueba trazable (requisitos y criterios de aceptación), con técnicas como la partición de equivalencia y los valores límite. TDD es un enfoque *test-first* que aplica el principio de probar temprano. | Programa oficial v4.0.1, consenso de expertos de los comités nacionales del ISTQB. Secciones 1.4.4 (trazabilidad), 2.1.3 (TDD, ATDD y BDD), 2.2.1 (prueba de componente), 4.2 (técnicas de caja negra) y 4.5 (criterios de aceptación). | No aporta datos sobre si TDD mejora la calidad o la productividad. Presenta TDD de forma neutral, sin decir cuándo no conviene. Es un programa de certificación, por eso simplifica. | Es la fuente más confiable para definir y diseñar casos: sostiene todo el Desarrollo A. No sirve para decidir si TDD conviene. Por eso hizo falta una fuente empírica. |
| **Fuente 2 · Vocke (2018).** Las pruebas unitarias deben ser la base de la estrategia de pruebas. Hay que probar el comportamiento observable y no la estructura interna, y cada prueba tiene un costo de mantenimiento. Recomienda TDD. | Artículo técnico basado en la experiencia profesional del autor, con ejemplos en Java (microservicios), publicado en martinfowler.com. Secciones *Unit tests*, *Test Structure*, *What to Test?* y *Avoid Test Duplication*. | Es opinión experta de un solo autor, sin datos ni método de investigación. Recomienda TDD sin discutir cuándo no conviene. | Respalda la estructura AAA y la explicación de las pruebas frágiles (Desarrollo B). Su advertencia de que cada prueba «doesn't come for free» sostiene que más pruebas no equivalen a más calidad. |
| **Fuente 3 · Fucci et al. (2017).** Escribir la prueba antes o después del código no explica, de forma importante, la calidad ni la productividad. Los beneficios atribuidos a TDD vendrían de trabajar en pasos pequeños y uniformes. | Estudio observacional con 39 profesionales de dos empresas y 82 datos, analizados con regresión múltiple. Mide granularidad, uniformidad, orden y esfuerzo de refactorización. Contrastado con el preprint de arXiv. | No prueba causalidad: no hay aleatorización ni grupo de control. Usa tareas cortas y requisitos fijos. Los modelos explican poco (R² ajustado de 0,10 a 0,12) y solo la granularidad frente a la calidad es significativa entre los factores de ritmo. | Matiza la postura: el valor de TDD podría estar en el ritmo de trabajo y en obligar a aclarar el requisito, no en el orden. No alcanza para afirmar que *test-first* sea inútil ni para generalizar. |

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
| 5 | 2.2.1 (p. 29) | «Component testing (also known as unit testing) focuses on testing components in isolation.» | La prueba unitaria es la prueba de un componente aislado. | Definición de prueba unitaria; Desarrollo B |
| 6 | 4.2.1 (p. 39) | «Therefore, one test for each partition is sufficient.» | Si los valores de una partición se comportan igual, basta con un caso por partición, válida o inválida. | Desarrollo A: casos normales y de error |
| 7 | 4.2.2 (p. 40–41) | 2 valores: «for each boundary value there are two coverage items: this boundary value and its closest neighbor»; 3 valores: «…three coverage items: this boundary value and both its neighbors.» | Se prueban los valores en cada frontera de las particiones y sus vecinos. El análisis de 3 valores es más riguroso que el de 2. | Desarrollo A: casos límite del descuento del 10 % |
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

## Fuente 2 · Vocke (2018), *The practical test pyramid* · Responsable: Maykel

**Ficha general**

| Campo | Contenido |
|---|---|
| Autor / organismo | Ham Vocke, ingeniero de software. Publicado en el sitio de Martin Fowler (ThoughtWorks) |
| Tipo de documento | Artículo técnico en línea, 26-feb-2018 |
| Tipo de evidencia | **P**: experiencia profesional, sin datos ni método de investigación |
| Vigencia | 2018. Los principios de las pruebas unitarias no han cambiado, pero los ejemplos de herramientas sí |
| Acceso | Gratuito, https://martinfowler.com/articles/practical-test-pyramid.html |

**Afirmaciones que usa el informe**

| # | Sección | Cita textual | Idea en nuestras palabras | Uso en el informe |
|---|---|---|---|---|
| 1 | Unit tests | «The foundation of your test suite will be made up of unit tests.» | Las pruebas unitarias son la base de la suite. | Desarrollo B: lugar de la prueba unitaria |
| 2 | Unit tests › Test Structure | «A good structure for all your tests (this is not limited to unit tests) is this one:» con tres pasos: «Set up the test data», «Call your method under test» y «Assert that the expected results are returned». El artículo agrega: «There's a nice mnemonic to remember this structure: “Arrange, Act, Assert”.» | Una estructura fija de tres partes para toda prueba, que el propio artículo llama Arrange–Act–Assert. | Desarrollo B: AAA |
| 3 | Unit tests › Mocking and Stubbing | «A lot of people use the terms Mock and Stub interchangeably.» | Los dobles de prueba se confunden; hay que definirlos. | Desarrollo B: aislamiento |
| 4 | Unit tests › What to Test? | «Don't reflect your internal code structure within your unit tests.» · «Test for observable behaviour instead.» | Probar comportamiento observable evita pruebas frágiles. | Desarrollo B: pruebas frágiles |
| 5 | Unit tests › Mocking and Stubbing | «Look into Test-Driven Development and let your unit tests guide your development» | Recomienda TDD como guía del desarrollo. | Postura sobre TDD |
| 6 | Avoid Test Duplication | «Every single test in your test suite is additional baggage and doesn't come for free.» | Cada prueba tiene costo de mantenimiento. | Postura sobre TDD (contraargumento) |

**Valoración crítica**

| | |
|---|---|
| **Fortalezas** | Claro, práctico y bien estructurado. Está en un sitio de referencia del sector y es de acceso libre. Cubre justo los temas del Desarrollo B (aislamiento, estructura, fragilidad). |
| **Limitaciones** | Es opinión experta con un solo autor, sin estudios que respalden las recomendaciones. No define el ciclo rojo–verde–refactor ni trata la «falsa sensación de seguridad» con esos términos. Sus ejemplos están en un contexto concreto (microservicios en Java). |
| **Posibles sesgos** | Recomienda TDD sin discutir cuándo no conviene. Parte de la experiencia de un equipo de producto con prácticas ágiles maduras. |
| **Qué no puede responder** | Si TDD mejora la calidad o la productividad con datos. Tampoco dice en qué proyectos no conviene. |
| **Confiabilidad para el informe** | Media-alta para buenas prácticas de pruebas unitarias. Baja como prueba de que TDD «funciona». |

---

## Fuente 3 · Fucci et al. (2017) · Responsables: ambos

**Ficha general**

| Campo | Contenido |
|---|---|
| Autor / organismo | Davide Fucci, Hakan Erdogmus, Burak Turhan, Markku Oivo y Natalia Juristo (investigación académica) |
| Tipo de documento | Artículo científico, *IEEE Transactions on Software Engineering* (2017) |
| Tipo de evidencia | **E**: estudio observacional con datos y regresión múltiple |
| Diseño | 39 profesionales de dos empresas, 82 datos completos, tres tareas (Mars Rover, Bowling Scorekeeper y MusicPhone) |
| Acceso | Preprint gratuito en arXiv (1611.05994); versión publicada por IEEE |

**Afirmaciones que usa el informe** (citas contrastadas el 11-nov-2026 con el preprint de arXiv 1611.05994. ⚠ Falta confirmarlas en la versión publicada por IEEE y anotar página. Volumen 43(7) y páginas 597–614 confirmados en un índice bibliográfico)

| # | Cita textual | Idea en nuestras palabras | Uso en el informe |
|---|---|---|---|
| 1 | (Resumen, p. 597 en IEEE) «Sequencing, the order in which test and production code are written, had no important influence.» | En el estudio, escribir la prueba antes o después no explicó mejor la calidad ni la productividad. | Postura sobre TDD; contraargumento |
| 2 | (Resumen, p. 597 en IEEE) «The claimed benefits of TDD may not be due to its distinctive test-first dynamic» | Los beneficios atribuidos a TDD podrían venir de otra parte. | Postura sobre TDD |
| 3 | (Resumen, p. 597 en IEEE) «TDD-like processes encourage fine-grained, steady steps that improve focus and flow.» | TDD ayuda porque obliga a dar pasos pequeños y parejos. | Postura sobre TDD (cuándo sí) |
| 4 | (Secc. VIII, *Discussion*) «We thus recommend focusing on breaking down development tasks into as small and as uniform steps as possible.» | La recomendación práctica es trabajar en pasos pequeños y uniformes. | Conclusión |

**Valoración crítica**

| | |
|---|---|
| **Fortalezas** | Es la única fuente con datos. Usa profesionales y no solo estudiantes. Mide por separado cuatro factores del proceso (granularidad, uniformidad, orden y esfuerzo de refactor). |
| **Limitaciones** | Sin aleatorización ni grupo de control, así que no prueba causalidad. Muestra por conveniencia, solo dos empresas y tres tareas (dos artificiales) con requisitos fijos. Tareas cortas. Los modelos finales explican una parte pequeña de la variación (R² ajustado de 0,12 para calidad y 0,10 para productividad). De los factores de ritmo, solo la granularidad frente a la calidad es significativa al nivel de 0,05 (p = 0,04). La uniformidad frente a la calidad (p = 0,09) y la granularidad y la uniformidad frente a la productividad (p = 0,11 y 0,08) no lo son. El esfuerzo de refactorización sí es significativo en los dos modelos (calidad p = 0,03; productividad p = 0,02). El orden test-first no entra en ningún modelo final. Por eso la recomendación de pasos pequeños y uniformes es una señal y no una prueba. |
| **Posibles sesgos** | Participantes voluntarios o elegidos por sus empresas. Experiencia sesgada hacia perfiles medios y senior. |
| **Qué no puede responder** | El efecto de largo plazo en mantenibilidad, ni el efecto en proyectos grandes con requisitos cambiantes. |
| **Confiabilidad para el informe** | Media: sirve para matizar la postura (el orden test-first no sería lo decisivo), no para generalizar. |

> Nota técnica del propio preprint: el texto llama «positivas» a las asociaciones de granularidad y uniformidad, pero los coeficientes reportados son negativos (ciclos más cortos y parejos se asocian con mejores resultados). Conviene leerlo con cuidado al citar.
