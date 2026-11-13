# Fichas de fuentes · Maykel Meoño González

> Tarea 2 · Responsable: Maykel · Revisa: Valery
> Regla 2: cada fuente la verifica quien la cita. **Las citas de abajo se contrastaron el 11-nov-2026 con la página original en línea** (la lectura la hizo la herramienta de IA que se declara en el Anexo C). **Maykel: abrí cada original vos mismo y confirmá cada cita antes de pasarla al Word.** Las marcas ⚠ indican lo que aún no se pudo confirmar.

## Hallazgos que cambian el plan original

1. **«Fowler, *Practical Test Pyramid*» en realidad es de Ham Vocke.** El artículo está alojado en el sitio de Martin Fowler, pero el autor es Ham Vocke (26-feb-2018). En APA se cita a **Vocke (2018)**. Ya está corregido en la metodología y en las referencias.
2. **La entrada de TDD de Agile Alliance es breve y no usa el término «rojo–verde–refactor»**, pero sí describe el ciclo en palabras (escribir una prueba que falla, escribir el código mínimo que la hace pasar, refactorizar y repetir). El ciclo con sus tres pasos se respalda además con **Fowler (2023)** (fuente de apoyo).
3. **La cita de Agile Alliance de la versión anterior de esta ficha no era textual.** «Test-driven development (TDD) is a style of programming where coding, testing, and design are tightly interwoven» y «Benefits include reduction in defect rates» no aparecen así en el cuerpo de la página. La página dice «refers to a style of programming in which three activities are tightly interwoven: coding, testing (in the form of writing unit tests), and design (in the form of refactoring)» y «many teams report significant reductions in defect rates». «Benefits include reduction in defect rates.» solo está en la meta descripción de la página. Ya se corrigió en el Desarrollo B.
4. **No pude abrir *TDD by Example* de Beck** (libro, sin acceso en línea). Por eso la fuente de TDD es Agile Alliance (la guía permite «Beck o Agile Alliance»).
5. **JUnit ya tiene la versión 6.** La guía que pide el reparto es de la serie **5.x**. Se verificó contra la **versión 5.9.2** (https://docs.junit.org/5.9.2/user-guide/) y es la que usa `demo-tdd/pom.xml`. **Los números de sección cambian entre versiones**: en 5.9.2 las anotaciones están en la sección 2.1 y las aserciones en la 2.5 (la ficha anterior citaba 3.1 y 3.4, que son de la versión 5.3.2).

---

## Fuente 2.1 · JUnit 5 User Guide

**Referencia APA 7**

Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., de Rancourt, J., & Stein, C. (s. f.). *JUnit 5 user guide* (Versión 5.9.2) [Documentación técnica]. JUnit. https://docs.junit.org/5.9.2/user-guide/

La página no muestra fecha de publicación, por eso va «s. f.». Autores confirmados por Maykel el 13-nov-2026 en la portada de la guía: son siete (se agregó a Juliette de Rancourt).

| Campo | Contenido |
|---|---|
| Tipo de evidencia | **N** (documentación oficial del *framework*) |
| Qué respalda | Qué es JUnit 5, cómo se marca una prueba y cómo se escriben aserciones |
| Limitación | Describe la herramienta, no si conviene usar TDD |

| # | Sección (v. 5.9.2) | Cita textual | Idea en nuestras palabras | Uso |
|---|---|---|---|---|
| 1 | 1.1 | «JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage» | JUnit 5 se compone de tres módulos: la plataforma que ejecuta, Jupiter (el modelo para escribir pruebas) y Vintage (compatibilidad con JUnit 3 y 4). | Desarrollo B: JUnit 5 como herramienta |
| 2 | 2.1 (anotaciones) | @Test: «Denotes that a method is a test method.» | Una anotación marca qué método es una prueba. | Desarrollo B: estructura de la prueba unitaria |
| 3 | 2.1 (anotaciones) | @BeforeEach: «Denotes that the annotated method should be executed before each @Test, @RepeatedTest…» (la frase sigue con @ParameterizedTest y @TestFactory) | Sirve para preparar el estado antes de cada prueba (Arrange compartido). | Desarrollo B: AAA y aislamiento |
| 4 | 2.5 (aserciones) | Ejemplo `exceptionTesting()`: `Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));` | `assertThrows` verifica que un bloque de código lance la excepción esperada: sirve para los casos de error. La guía usa `ArithmeticException`; la demostración usa `IllegalArgumentException`. | Desarrollo B: aserciones y casos de error |
| 5 | 2.1 (anotaciones) | @ParameterizedTest: «Denotes that a method is a parameterized test.» | Una misma prueba se ejecuta con varios datos, útil para valores límite. | Desarrollo B: casos límite |

---

## Fuente 2.2 · Agile Alliance, entrada «TDD» del glosario

**Referencia APA 7**

Agile Alliance. (s. f.). *TDD*. En *Agile glossary*. Recuperado el 11 de noviembre de 2026, de https://agilealliance.org/glossary/tdd/

La página no muestra autor individual. Los metadatos indican publicación el 6-dic-2015 y última modificación el 18-oct-2023; como el texto visible no trae fecha, se cita «s. f.».

| Campo | Contenido |
|---|---|
| Tipo de evidencia | **P** (comunidad profesional; sin autoría individual en la página) |
| Qué respalda | Definición de TDD, descripción breve del ciclo y el beneficio que declara |
| Limitación | Entrada corta, sin datos. El beneficio es un testimonio de equipos («many teams report…») y no cita estudios |

| # | Cita textual | Idea en nuestras palabras | Uso |
|---|---|---|---|
| 1 | «“Test-driven development” refers to a style of programming in which three activities are tightly interwoven: coding, testing (in the form of writing unit tests), and design (in the form of refactoring).» | TDD es un estilo de programar donde código, pruebas unitarias y diseño (refactor) van entrelazados. | Desarrollo B; postura sobre TDD |
| 2 | «many teams report significant reductions in defect rates» (la frase sigue con «at the cost of a moderate increase in an initial development effort») | Equipos reportan menos defectos, a cambio de más esfuerzo inicial. La entrada no cita estudios. | Postura sobre TDD (argumento a favor, con su límite) |

Las dos citas fueron confirmadas por Maykel el 13-nov-2026 en la página original.

---

## Fuente 2.3 · Vocke, *The Practical Test Pyramid* (alojado en martinfowler.com)

**Referencia APA 7**

Vocke, H. (2018, 26 de febrero). *The practical test pyramid*. martinfowler.com. https://martinfowler.com/articles/practical-test-pyramid.html

| Campo | Contenido |
|---|---|
| Tipo de evidencia | **P** (experiencia profesional de un ingeniero, publicada en un sitio de referencia) |
| Qué respalda | Rol de las pruebas unitarias, estructura de una prueba, qué conviene probar, fragilidad |
| Limitación | Es un artículo de opinión experta, no un estudio. No menciona «rojo–verde–refactor» ni «falsa sensación de seguridad» como tales |

| # | Sección | Cita textual | Idea en nuestras palabras | Uso |
|---|---|---|---|---|
| 1 | Unit tests | «The foundation of your test suite will be made up of unit tests.» | Las pruebas unitarias deben ser la base y la mayoría de la suite. | Desarrollo B |
| 2 | Unit tests › Test Structure | «A good structure for all your tests (this is not limited to unit tests) is this one:» seguida de tres pasos: «Set up the test data», «Call your method under test», «Assert that the expected results are returned». El texto agrega: «There's a nice mnemonic to remember this structure: “Arrange, Act, Assert”.» | Estructura fija de tres partes (preparar, ejecutar, comprobar); el propio artículo la llama Arrange–Act–Assert. | Desarrollo B: AAA |
| 3 | Unit tests › Mocking and Stubbing | «A lot of people use the terms Mock and Stub interchangeably.» | Los dobles de prueba se confunden entre sí; conviene distinguirlos al hablar de aislamiento. | Desarrollo B: aislamiento |
| 4 | Unit tests › What to Test? | «Don't reflect your internal code structure within your unit tests.» y «Test for observable behaviour instead.» | Probar el comportamiento observable, no la estructura interna, evita pruebas que se rompen al refactorizar. | Desarrollo B: pruebas frágiles |
| 5 | Unit tests › **Mocking and Stubbing** | «Look into Test-Driven Development and let your unit tests guide your development» (la oración continúa después de un punto y coma) | Recomienda TDD para que las pruebas guíen el desarrollo. | Postura sobre TDD |
| 6 | Avoid Test Duplication | «Every single test in your test suite is additional baggage and doesn't come for free.» | Cada prueba cuesta mantenimiento; más pruebas no es siempre mejor. | Postura sobre TDD (costos) |

Nota: la cita 5 estaba ubicada en «What to Test?» en la versión anterior de esta ficha y en la matriz de lectura crítica (fuente 2, fila 5). Está en **Mocking and Stubbing**. Hay que corregir la matriz (tarea 5).

Las páginas no aplican (es un artículo web): se cita por sección.

---

## Fuente de apoyo · Fowler, *Test Driven Development*

**Referencia APA 7**

Fowler, M. (2023, 11 de diciembre). *Test driven development*. martinfowler.com. https://martinfowler.com/bliki/TestDrivenDevelopment.html

Verificado el 11-nov-2026: «Write a test for the next bit of functionality you want to add.» y «Refactor both new and old code to make it well structured.» Sobre el refactor: «The most common way that I hear to screw up TDD is neglecting the third step.» Fecha de la página: 11-dic-2023 (publicación original 5-mar-2005). Se usa solo para el ciclo. Ya está en la metodología (paso 2) y en las referencias, así que el total es de ocho fuentes.

---

## Fuente 3 (acordada) · Fucci et al. (2017)

**Referencia APA 7**

Fucci, D., Erdogmus, H., Turhan, B., Oivo, M., & Juristo, N. (2017). A dissection of the test-driven development process: Does it really matter to test-first or to test-last? *IEEE Transactions on Software Engineering, 43*(7), 597–614. https://doi.org/10.1109/TSE.2016.2616877

Verificado el 11-nov-2026:
- **Volumen, número y páginas (43(7), 597–614) y DOI:** confirmados en un índice bibliográfico (BibBase). El repositorio de Brunel confirma el DOI y el título, pero su registro dice 2016 y no trae volumen. ⚠ **Falta contrastar con IEEE Xplore** (el sitio no se pudo abrir desde aquí).
- **Citas del preprint de arXiv (1611.05994):** «Sequencing, the order in which test and production code are written, had no important influence.» (resumen); «82 data points collected from 39 professionals» (resumen); «The participants implemented three tasks during each workshop run.» (secc. 4.5); «Two companies… participated in this study.» (secc. 3); «Granularity and uniformity are possibly the most important factors in TDD-like processes.» (secc. 8).

Es la única fuente de **evidencia empírica (E)**. Detalle en `fuentes/matriz-lectura-critica.md`.

---

## Qué le queda a Maykel en la tarea 2

1. Abrir cada original y confirmar las citas (regla 2). Especialmente Agile Alliance (puntuación) y Vocke (secciones).
2. Confirmar volumen y páginas de Fucci en IEEE Xplore o en el PDF publicado.
3. ~~Confirmar los autores de la guía de JUnit~~ Hecho el 13-nov-2026.
4. Avisar a Valery de dos cambios en la lista de referencias (tarea 14): JUnit con versión 5.9.2 y URL propia, y fecha de recuperación de Agile Alliance (11-nov-2026).
