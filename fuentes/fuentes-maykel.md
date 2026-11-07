# Fichas de fuentes · Maykel Meoño González

> Tarea 2 · Responsable: Maykel · Revisa: Valery
> Regla 2: cada fuente la verifica quien la cita. Las citas textuales de abajo se extrajeron de los originales en línea el 6-nov-2026. **Maykel: abrí cada original y confirmá cada cita y página antes de pasarla al Word** (las marcas ⚠ indican qué falta).

## Hallazgos que cambian el plan original

1. **«Fowler, *Practical Test Pyramid*» en realidad es de Ham Vocke.** El artículo está alojado en el sitio de Martin Fowler, pero el autor es Ham Vocke (26-feb-2018). En APA se cita a **Vocke (2018)**, no a Fowler. Hay que corregirlo en el reparto, en la metodología (paso 2) y en las referencias.
2. **La entrada de TDD de Agile Alliance es muy breve** y no menciona «rojo–verde–refactor». Sirve para la definición y el beneficio que declara, pero el ciclo se respalda con **Fowler (2023)**, entrada *Test Driven Development* de su *bliki* (fuente de apoyo, que sí es de Fowler).
3. **No pude abrir *TDD by Example* de Beck** (libro, sin acceso en línea). Por eso la fuente de TDD es Agile Alliance (la guía permite «Beck o Agile Alliance»). Si prefieren a Beck, hay que tener el libro físico o digital y verificar las páginas.
4. **JUnit ya tiene la versión 6** (guía 6.x en docs.junit.org). La guía que pide el reparto es la de la serie **5.x**. Verifiqué el texto con la versión 5.3.2; usá la misma versión que uses en la demostración (por ejemplo, 5.14.x) y confirmá que las secciones citadas coinciden.

---

## Fuente 2.1 · JUnit 5 User Guide

**Referencia APA 7**

Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., & Stein, C. (s. f.). *JUnit 5 user guide* (Versión 5.x) [Documentación técnica]. JUnit. https://docs.junit.org/

⚠ Ajustar el número exacto de versión y la URL de la versión usada (ejemplo verificado: https://docs.junit.org/5.3.2/user-guide/index.pdf, versión 5.3.2).

| Campo | Contenido |
|---|---|
| Tipo de evidencia | **N** (documentación oficial del *framework*) |
| Qué respalda | Qué es JUnit 5, cómo se marca una prueba y cómo se escriben aserciones |
| Limitación | Describe la herramienta, no si conviene usar TDD |

| # | Sección | Cita textual | Idea en nuestras palabras | Uso |
|---|---|---|---|---|
| 1 | 1.1 | «JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage» | JUnit 5 se compone de tres módulos: la plataforma que ejecuta, Jupiter (el modelo para escribir pruebas) y Vintage (compatibilidad con JUnit 3 y 4). | Desarrollo B: JUnit 5 como herramienta |
| 2 | 3.1 | @Test: «Denotes that a method is a test method.» | Una anotación marca qué método es una prueba. | Desarrollo B: estructura de la prueba unitaria |
| 3 | 3.1 | @BeforeEach: «Denotes that the annotated method should be executed before each @Test» | Sirve para preparar el estado antes de cada prueba (Arrange). | Desarrollo B: AAA y aislamiento |
| 4 | 3.4 | `assertThrows(IllegalArgumentException.class, () -> {…})` (ejemplo del apartado de aserciones) | Verifica que un bloque de código lance la excepción esperada: sirve para los casos de error. | Desarrollo B: aserciones y casos de error |
| 5 | 3.1 | @ParameterizedTest: «Denotes that a method is a parameterized test.» | Una misma prueba se ejecuta con varios datos, útil para valores límite. | Desarrollo B: casos límite |

---

## Fuente 2.2 · Agile Alliance, entrada «TDD» del glosario

**Referencia APA 7**

Agile Alliance. (s. f.). *TDD*. En *Agile glossary*. Recuperado el 6 de noviembre de 2026, de https://agilealliance.org/glossary/tdd/

| Campo | Contenido |
|---|---|
| Tipo de evidencia | **P** (comunidad profesional; sin autoría individual en la página) |
| Qué respalda | Definición de TDD y el beneficio que declara |
| Limitación | Entrada muy corta, sin datos ni ciclo detallado. Las afirmaciones de beneficio no traen evidencia en la propia página |

| # | Cita textual | Idea en nuestras palabras | Uso |
|---|---|---|---|
| 1 | «Test-driven development (TDD) is a style of programming where coding, testing, and design are tightly interwoven.» | TDD es un estilo de programar donde código, pruebas y diseño van entrelazados. | Desarrollo B; postura sobre TDD |
| 2 | «Benefits include reduction in defect rates.» | La comunidad declara que reduce defectos, aunque la entrada no cita estudios. | Postura sobre TDD (argumento a favor, con su límite) |

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
| 2 | Test structure | «A good structure for all your tests (this is not limited to unit tests) is this one:» | Propone una estructura fija de tres partes (preparar, ejecutar, comprobar), equivalente a AAA. ⚠ Confirmar los tres pasos tal como los nombra el artículo. | Desarrollo B: AAA |
| 3 | Mocking and Stubbing | «A lot of people use the terms Mock and Stub interchangeably.» | Los dobles de prueba se confunden entre sí; conviene distinguirlos al hablar de aislamiento. | Desarrollo B: aislamiento |
| 4 | What to test? | «Don't reflect your internal code structure within your unit tests.» y «Test for observable behaviour instead.» | Probar el comportamiento observable, no la estructura interna, evita pruebas que se rompen al refactorizar. | Desarrollo B: pruebas frágiles |
| 5 | What to test? | «Look into Test-Driven Development and let your unit tests guide your development» | Recomienda TDD para que las pruebas guíen el desarrollo. | Postura sobre TDD |
| 6 | Avoid test duplication | «Every single test in your test suite is additional baggage and doesn't come for free.» | Cada prueba cuesta mantenimiento; más pruebas no es siempre mejor. | Postura sobre TDD (costos) |

⚠ Las páginas no aplican (es un artículo web): se cita por sección.

---

## Fuente de apoyo (opcional) · Fowler, *Test Driven Development*

**Referencia APA 7**

Fowler, M. (2023, 11 de diciembre). *Test driven development*. martinfowler.com. https://martinfowler.com/bliki/TestDrivenDevelopment.html

Se usa solo para el ciclo: «Write a test for the next bit of functionality you want to add.» y «Refactor both new and old code to make it well structured.» Fowler señala que omitir el refactor es la forma más común de hacer mal TDD. Fecha de publicación original: 5-mar-2005; actualizada 11-dic-2023. ⚠ Si la usan, hay que agregarla a la lista de fuentes y a la metodología (pasarían de 6 a 7).

---

## Propuesta de fuente 3 (se acuerda con Valery) · Fucci et al. (2017)

**Referencia APA 7**

Fucci, D., Erdogmus, H., Turhan, B., Oivo, M., & Juristo, N. (2017). A dissection of the test-driven development process: Does it really matter to test-first or to test-last? *IEEE Transactions on Software Engineering, 43*(7), 597–614. https://doi.org/10.1109/TSE.2016.2616877

⚠ Verifiqué el contenido en el preprint de arXiv (1611.05994); **volumen, páginas y DOI hay que confirmarlos en la versión publicada** (IEEE o repositorio de Brunel).

Es la única fuente de **evidencia empírica (E)** y resuelve el hueco que señala la matriz de Valery. Detalle en `fuentes/matriz-lectura-critica.md`.
