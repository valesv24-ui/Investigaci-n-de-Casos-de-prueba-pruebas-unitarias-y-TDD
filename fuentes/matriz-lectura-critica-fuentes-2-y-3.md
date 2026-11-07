# Matriz de lectura crítica · aporte de Maykel (fuente 2) y propuesta de fuente 3

> Tarea 5. Pegar debajo de la fuente 1 de Valery en `fuentes/matriz-lectura-critica.md`, reemplazando los marcadores «Pendiente».
> Tipos de evidencia: **N** normativa · **P** experiencia profesional · **E** empírica.

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
| 2 | Test structure | «A good structure for all your tests (this is not limited to unit tests) is this one:» | Una estructura fija de tres partes para toda prueba (⚠ confirmar los nombres de los pasos). | Desarrollo B: AAA |
| 3 | Mocking and Stubbing | «A lot of people use the terms Mock and Stub interchangeably.» | Los dobles de prueba se confunden; hay que definirlos. | Desarrollo B: aislamiento |
| 4 | What to test? | «Don't reflect your internal code structure within your unit tests.» · «Test for observable behaviour instead.» | Probar comportamiento observable evita pruebas frágiles. | Desarrollo B: pruebas frágiles |
| 5 | What to test? | «Look into Test-Driven Development and let your unit tests guide your development» | Recomienda TDD como guía del desarrollo. | Postura sobre TDD |
| 6 | Avoid test duplication | «Every single test in your test suite is additional baggage and doesn't come for free.» | Cada prueba tiene costo de mantenimiento. | Postura sobre TDD (contraargumento) |

**Valoración crítica**

| | |
|---|---|
| **Fortalezas** | Claro, práctico y bien estructurado. Está en un sitio de referencia del sector y es de acceso libre. Cubre justo los temas del Desarrollo B (aislamiento, estructura, fragilidad). |
| **Limitaciones** | Es opinión experta con un solo autor, sin estudios que respalden las recomendaciones. No define el ciclo rojo–verde–refactor ni trata la «falsa sensación de seguridad» con esos términos. Sus ejemplos están en un contexto concreto (microservicios en Java). |
| **Posibles sesgos** | Recomienda TDD sin discutir cuándo no conviene. Parte de la experiencia de un equipo de producto con prácticas ágiles maduras. |
| **Qué no puede responder** | Si TDD mejora la calidad o la productividad con datos. Tampoco dice en qué proyectos no conviene. |
| **Confiabilidad para el informe** | Media-alta para buenas prácticas de pruebas unitarias. Baja como prueba de que TDD «funciona». |

---

## Fuente 3 (propuesta, a acordar con Valery) · Fucci et al. (2017) · Responsables: ambos

**Ficha general**

| Campo | Contenido |
|---|---|
| Autor / organismo | Davide Fucci, Hakan Erdogmus, Burak Turhan, Markku Oivo y Natalia Juristo (investigación académica) |
| Tipo de documento | Artículo científico, *IEEE Transactions on Software Engineering* (2017) |
| Tipo de evidencia | **E**: estudio observacional con datos y regresión múltiple |
| Diseño | 39 profesionales de dos empresas, 82 datos completos, tres tareas (Mars Rover, Bowling Scorekeeper y MusicPhone) |
| Acceso | Preprint gratuito en arXiv (1611.05994); versión publicada por IEEE |

**Afirmaciones que usa el informe** (⚠ las citas salen del preprint de arXiv: confirmar en la versión publicada y anotar página)

| # | Cita textual | Idea en nuestras palabras | Uso en el informe |
|---|---|---|---|
| 1 | «Sequencing, the order in which test and production code are written, had no important influence.» | En el estudio, escribir la prueba antes o después no explicó mejor la calidad ni la productividad. | Postura sobre TDD; contraargumento |
| 2 | «The claimed benefits of TDD may not be due to its distinctive test-first dynamic» | Los beneficios atribuidos a TDD podrían venir de otra parte. | Postura sobre TDD |
| 3 | «TDD-like processes encourage fine-grained, steady steps that improve focus and flow.» | TDD ayuda porque obliga a dar pasos pequeños y parejos. | Postura sobre TDD (cuándo sí) |
| 4 | «we recommend focusing on breaking down development tasks into as small and as uniform steps as possible.» | La recomendación práctica es trabajar en pasos pequeños y uniformes. | Conclusión |

**Valoración crítica**

| | |
|---|---|
| **Fortalezas** | Es la única fuente con datos. Usa profesionales y no solo estudiantes. Mide por separado cuatro factores del proceso (granularidad, uniformidad, orden y esfuerzo de refactor). |
| **Limitaciones** | Sin aleatorización ni grupo de control, así que no prueba causalidad. Muestra por conveniencia, solo dos empresas y tres tareas (dos artificiales) con requisitos fijos. Tareas cortas. Los modelos explican una parte pequeña de la variación (R² ajustado de 0,09 a 0,12). |
| **Posibles sesgos** | Participantes voluntarios o elegidos por sus empresas. Experiencia sesgada hacia perfiles medios y senior. |
| **Qué no puede responder** | El efecto de largo plazo en mantenibilidad, ni el efecto en proyectos grandes con requisitos cambiantes. |
| **Confiabilidad para el informe** | Media: sirve para matizar la postura (el orden test-first no sería lo decisivo), no para generalizar. |

> Nota técnica del propio preprint: el texto llama «positivas» a las asociaciones de granularidad y uniformidad, pero los coeficientes reportados son negativos (ciclos más cortos y parejos se asocian con mejores resultados). Conviene leerlo con cuidado al citar.
