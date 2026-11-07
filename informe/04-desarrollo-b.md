# Desarrollo B · Pruebas unitarias y TDD

> Tarea 8 · Responsable: Maykel Meoño González · Revisa: Valery Salas Vargas

Esta sección explica qué es una prueba unitaria, cómo se escribe y cómo se usa en el ciclo de TDD. Los ejemplos usan el requisito del descuento del 10 % del Desarrollo A y los casos de prueba CP-01 a CP-04 (normal, límite y error). La regla de los ejemplos es ilustrativa: descuento del 10 % cuando el total es de 100 o más. Debe ajustarse al requisito real de la guía.

## 1. La prueba unitaria

El ISTQB (2024, p. 28) define la prueba de componente, también llamada prueba unitaria, como la que «focuses on testing components in isolation». Una prueba unitaria revisa una unidad pequeña de código (un método o una clase) sin depender del resto del sistema, y su resultado es automático: pasa o falla.

Vocke (2018) las ubica como la base de la estrategia de pruebas: «The foundation of your test suite will be made up of unit tests». Son rápidas, baratas de ejecutar y localizan el defecto con precisión. Por eso se ejecutan cientos de veces al día.

### 1.1 Aislamiento

Aislar significa que el resultado de la prueba depende solo de la unidad probada. Para lograrlo se reemplazan sus dependencias (base de datos, red, reloj, otras clases) por **dobles de prueba**. Vocke (2018) advierte que mucha gente usa *mock* y *stub* como sinónimos. Para este informe se usa esta distinción: un *stub* devuelve respuestas fijas y un *mock* además permite comprobar que se le hizo una llamada.

En el caso del descuento, la calculadora no tiene dependencias externas, así que no necesita dobles. Eso la convierte en un buen primer ejemplo. Un caso con aislamiento real aparecería si el porcentaje se leyera de una base de datos: entonces se usaría un *stub* de ese repositorio.

### 1.2 Aserciones

Una **aserción** compara el resultado real con el esperado. Si no coinciden, la prueba falla. JUnit 5 reúne las aserciones en la clase `Assertions` de Jupiter. Las dos que usa la demostración son `assertEquals` (valor esperado frente a valor real, con tolerancia para números decimales) y `assertThrows`, que verifica que un bloque de código lance una excepción concreta y sirve para los casos de error (Bechtold et al., s. f., secc. 3.4).

JUnit 5 se compone de tres módulos: «JUnit Platform + JUnit Jupiter + JUnit Vintage» (Bechtold et al., s. f., secc. 1.1). Para escribir pruebas nuevas se usa Jupiter. Se marca un método como prueba con `@Test` («Denotes that a method is a test method») y se repite la preparación con `@BeforeEach`, que se ejecuta antes de cada prueba y deja un estado nuevo para cada una. Eso es lo que mantiene a las pruebas independientes entre sí.

### 1.3 Estructura Arrange–Act–Assert (AAA)

Vocke (2018) propone una estructura fija de tres partes para toda prueba, que corresponde a AAA:

| Fase | Qué hace | En el ejemplo |
|---|---|---|
| **Arrange** (preparar) | Crea los datos y el objeto bajo prueba | `double monto = 50.0;` |
| **Act** (ejecutar) | Llama una sola vez al método que se prueba | `calculadora.calcularTotal(monto)` |
| **Assert** (comprobar) | Compara el resultado con el esperado | `assertEquals(50.0, total, 0.001)` |

Una prueba con una sola fase *Act* y pocas aserciones indica con claridad qué se rompió cuando falla. Cada caso del Desarrollo A se convierte en una prueba con este molde, y el nombre del método y `@DisplayName` llevan el ID del caso para conservar la trazabilidad:

```java
@Test
@DisplayName("CP-02 límite: monto exacto en el umbral recibe 10 %")
void montoEnElUmbralRecibeDescuento() {
    double total = calculadora.calcularTotal(100.0);   // Act (Arrange es el objeto del @BeforeEach)
    assertEquals(90.0, total, 0.001);                  // Assert
}
```

Para varios valores de una misma partición o frontera, `@ParameterizedTest` («Denotes that a method is a parameterized test») ejecuta el mismo método con distintos datos y evita copiar pruebas (Bechtold et al., s. f., secc. 3.1).

## 2. El ciclo rojo–verde–refactor de TDD

El ISTQB (2024, p. 26) describe TDD como una práctica que «directs the coding through test cases» y que aplica el principio de probar temprano. Fowler (2023) resume el ciclo en tres pasos que se repiten: escribir una prueba para la siguiente funcionalidad, escribir el código que la hace pasar y refactorizar «both new and old code». Para la comunidad ágil, TDD es un estilo de programar donde «coding, testing, and design are tightly interwoven» (Agile Alliance, s. f.).

| Fase | Qué se hace | Estado de las pruebas |
|---|---|---|
| 🔴 **Rojo** | Se escribe una prueba para algo que aún no existe y se ejecuta. Debe fallar | Falla (si no falla, la prueba no aporta información) |
| 🟢 **Verde** | Se escribe el código mínimo para que pase | Pasa |
| 🔵 **Refactor** | Se mejora la estructura sin cambiar el comportamiento | Siguen pasando |

Fowler (2023) señala que omitir el refactor es la forma más común de hacer mal TDD: sin él se acumula código que funciona pero está mal estructurado.

### 2.1 Un ciclo completo con el caso del descuento

La siguiente secuencia usa los casos de la matriz de trazabilidad. La columna de resultado se completa con la ejecución real de la demostración (ver la bitácora en `anexos/bitacora-ciclo-tdd.md`).

| Paso | Prueba | Fase | Código de producción | Resultado esperado |
|---|---|---|---|---|
| 1 | CP-01 (50 → 50) | Rojo | La clase y el método no existen (no compila) o devuelven 0 | Falla |
| 2 | CP-01 | Verde | `return monto;` | Pasa |
| 3 | CP-02 (100 → 90) | Rojo | Sigue `return monto;` | Falla (se obtiene 100, no 90) |
| 4 | CP-02 | Verde | `return monto >= 100 ? monto * 0.9 : monto;` | Pasa, y CP-01 sigue pasando |
| 5 | CP-03 (99,99 → 99,99) | Rojo o verde | Sin cambios | **Pasa de inmediato**: sirve de red de seguridad en la frontera. Se anota que no hubo fase roja |
| 6 | CP-04 (−1 → excepción) | Rojo | No valida negativos | Falla |
| 7 | CP-04 | Verde | Se agrega `if (monto < 0) throw …` | Pasa |
| 8 | Todas | Refactor | `100` y `0.10` pasan a constantes `UMBRAL` y `TASA_DESCUENTO` | Las 4 pruebas siguen en verde |

El paso 5 ilustra un punto importante: una prueba que nunca estuvo en rojo no demuestra que detecte el error que debería detectar. En TDD estricto, para comprobarlo se rompe el código a propósito (por ejemplo, cambiando `>=` por `>`) y se verifica que la prueba falle.

### 2.2 Qué aporta el ciclo y qué no

Según la comunidad ágil, uno de los beneficios es la «reduction in defect rates» (Agile Alliance, s. f.), aunque esa entrada no cita estudios. Fucci et al. (2017) analizaron datos de 39 profesionales y encontraron que el orden de escritura (prueba antes o después del código) «had no important influence»; lo que se asociaba con mejores resultados eran los pasos pequeños y uniformes. Esto sugiere que el valor de TDD está más en el ritmo de trabajo que en el orden. Es una evidencia limitada (sin grupo de control, solo tres tareas, dos de ellas artificiales), por lo que se trata como una señal y no como una prueba. Se retoma en la postura final.

## 3. Pruebas frágiles

Una prueba es **frágil** cuando falla por cambios que no alteran el comportamiento observable. El síntoma es que al refactorizar se rompen pruebas aunque el sistema siga funcionando. Vocke (2018) da la regla para evitarlo: «Don't reflect your internal code structure within your unit tests» y «Test for observable behaviour instead».

**Ejemplo.** Suponga que el cálculo se separa en un método privado `aplicarTasa()`. Una prueba frágil verificaría con un *mock* que `aplicarTasa()` fue llamado una vez. Si en el refactor se elimina ese método y el cálculo se escribe en una sola línea, la prueba falla aunque `calcularTotal(100)` siga devolviendo 90. Una prueba robusta solo comprueba la entrada y la salida:

| | Prueba frágil | Prueba robusta |
|---|---|---|
| Qué verifica | Que se llamó a `aplicarTasa()` | Que `calcularTotal(100.0)` devuelve 90 |
| Se rompe al refactorizar | Sí | No |
| Se rompe cuando el cálculo es incorrecto | No necesariamente | Sí |

Otras causas habituales son depender del orden de ejecución, de la hora del sistema o de datos compartidos entre pruebas. `@BeforeEach` ayuda a evitarlas porque cada prueba empieza con un objeto nuevo (Bechtold et al., s. f., secc. 3.1).

El costo es real: «Every single test in your test suite is additional baggage and doesn't come for free» (Vocke, 2018). Las pruebas frágiles multiplican ese costo, porque se pasa más tiempo arreglándolas que protegiendo el código.

## 4. Falsa sensación de seguridad

Una suite en verde solo indica que **los casos escritos pasan**. No garantiza que el programa sea correcto, y puede dar confianza que no corresponde. Algunos ejemplos con el caso del descuento:

- **Casos que faltan.** Si no existe el caso de 100 exacto, el error `>` en lugar de `>=` pasa sin ser detectado. El ISTQB (2024, secc. 4.2.2) explica que los defectos se concentran en las fronteras, y por eso hay que probarlas.
- **Aserciones débiles.** Una prueba que solo comprueba `assertNotNull(total)` pasa aunque el cálculo esté mal. Ejecutar el código sin verificar su resultado sube la cobertura, pero no aumenta la protección.
- **Prueba escrita después, a la medida del código.** Si se escribe mirando la implementación, tiende a repetir sus errores. En el ciclo rojo–verde la prueba se escribe antes, desde el requisito.
- **Requisito mal entendido.** Las pruebas pueden verificar con total precisión algo equivocado. Si «10 % de descuento» significaba otra cosa, las pruebas en verde confirman un error (ver ambigüedades del Desarrollo A).

Para reducir este riesgo se combinan tres prácticas: derivar los casos del requisito con técnicas como partición y valores límite (ISTQB, 2024, secc. 4.2), verificar que cada prueba falle al menos una vez cuando el código está mal y mantener las pruebas pequeñas y legibles.

## 5. Pregunta de debate 3

> ⚠ La redacción exacta de la pregunta 3 debe tomarse de la guía. Esta respuesta asume que trata de la confianza que da una suite de pruebas en verde y de las pruebas que se rompen al refactorizar.

**¿Puede un equipo confiar en que su software está correcto si todas las pruebas unitarias pasan?**

No del todo. Una suite en verde demuestra que los casos escritos pasan, no que no haya defectos. Su valor depende de tres cosas: que los casos cubran normales, límites y errores; que las aserciones verifiquen resultados concretos y no solo que el código se ejecute; y que las pruebas comprueben comportamiento y no detalles internos, para que sigan siendo útiles tras refactorizar. Además, ninguna prueba unitaria detecta un requisito mal entendido, por lo que debe acompañarse de preguntas al cliente y de pruebas de otros niveles. El ISTQB (2024) pone las pruebas de componente en el primer nivel de una serie, no como sustituto de las demás.

## Referencias citadas en esta sección

Agile Alliance. (s. f.). *TDD*. En *Agile glossary*. Recuperado el 6 de noviembre de 2026, de https://agilealliance.org/glossary/tdd/

Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M., & Stein, C. (s. f.). *JUnit 5 user guide* (Versión 5.x) [Documentación técnica]. JUnit. https://docs.junit.org/

Fowler, M. (2023, 11 de diciembre). *Test driven development*. martinfowler.com. https://martinfowler.com/bliki/TestDrivenDevelopment.html

Fucci, D., Erdogmus, H., Turhan, B., Oivo, M., & Juristo, N. (2017). A dissection of the test-driven development process: Does it really matter to test-first or to test-last? *IEEE Transactions on Software Engineering, 43*(7), 597–614. https://doi.org/10.1109/TSE.2016.2616877

International Software Testing Qualifications Board. (2024). *Certified Tester Foundation Level syllabus* (Versión 4.0.1). https://www.istqb.org/wp-content/uploads/2024/11/ISTQB_CTFL_Syllabus_v4.0.1.pdf

Vocke, H. (2018, 26 de febrero). *The practical test pyramid*. martinfowler.com. https://martinfowler.com/articles/practical-test-pyramid.html

---

**Notas para la revisión (se borran antes de pasar al Word):**
- Valery: revisá que los casos CP-01 a CP-04 y el umbral coincidan con tu matriz de trazabilidad. Si cambiás los IDs, hay que cambiarlos aquí y en las pruebas.
- Maykel: ejecutá la demostración (`demo-tdd/`) y completá la bitácora con los resultados reales antes de dejar la sección 2.1 como definitiva. La tabla de arriba es el resultado esperado, no uno observado.
- Maykel: verificá cada cita y página contra el original (regla 2). El ISTQB p. 26 y p. 28 salen de la matriz de Valery.
