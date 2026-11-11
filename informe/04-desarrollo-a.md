# Desarrollo A · Del requisito al caso de prueba

> Tarea 7 · Responsable: Valery Salas Vargas · Revisa: Maykel Meoño González

Esta sección explica cómo un requisito se convierte en casos de prueba verificables y cómo se mantiene la trazabilidad entre ellos. Se aplica al requisito del descuento del 10 %. Los casos que se diseñan aquí (CP-01 a CP-09) son los que el Desarrollo B automatiza con JUnit 5.

## 1. La cadena requisito → criterio → caso → resultado esperado

| Elemento | Qué es | Pregunta que responde |
|---|---|---|
| **Requisito** | Lo que el sistema debe hacer, expresado por el cliente o el analista | ¿Qué se necesita? |
| **Criterio de aceptación** | Condición concreta y verificable que el requisito debe cumplir para darse por aceptado | ¿Cómo sabremos que está bien hecho? |
| **Caso de prueba** | Conjunto de precondiciones, datos de entrada y pasos que ejercitan un criterio | ¿Con qué datos lo comprobamos? |
| **Resultado esperado** | Salida o comportamiento que debe producirse con esos datos, definido *antes* de ejecutar | ¿Qué debería pasar? |

Los criterios de aceptación cumplen dos funciones: sirven para «Define the scope of the user story» y para «Serve as a basis for the user story acceptance testing» (ISTQB, 2024, p. 45–46). Un caso de prueba surge cuando una condición de prueba se concreta con datos. El ISTQB describe esta actividad como «elaborating the test conditions into test cases» (2024, p. 19). El resultado esperado tiene que definirse antes de ejecutar la prueba. Si no, cualquier salida parece correcta.

### Trazabilidad

La **trazabilidad** es la relación documentada entre cada elemento de la cadena. Según el ISTQB (2024, p. 20), «it is important to establish and maintain traceability throughout the test process between the test basis elements» y los productos de la prueba. En la práctica permite responder tres preguntas:

1. **Cobertura:** ¿todo criterio de aceptación tiene al menos un caso?
2. **Impacto:** si el requisito cambia, ¿qué casos hay que actualizar?
3. **Justificación:** ¿cada caso existe por una razón, o hay casos huérfanos que no verifican nada pedido?

El instrumento es la **matriz de trazabilidad** de la sección 4.

## 2. El requisito y sus ambigüedades

> ⚠ **Requisito de trabajo.** Mientras se confirma el texto exacto de la guía, se usa esta redacción, que coincide con la demostración del Desarrollo B:
>
> **R-01.** *El sistema aplica un descuento del 10 % a las compras de 100 o más.*

El requisito parece simple, pero al intentar escribir casos con resultado esperado aparecen preguntas sin respuesta. Cada ambigüedad es un riesgo: si el equipo la resuelve suponiendo, las pruebas pueden quedar en verde y aun así verificar algo que el cliente no pidió.

| # | Ambigüedad | Por qué importa | Pregunta al cliente |
|---|---|---|---|
| A1 | ¿«100 o más» incluye exactamente 100? | Define la frontera: `>=` frente a `>` | «Una compra de exactamente 100, ¿recibe el descuento?» |
| A2 | ¿El 10 % se calcula sobre el subtotal o sobre el total con impuestos? | Cambia el monto que se compara con 100 y el monto descontado | «¿El monto de 100 es antes o después de impuestos?» |
| A3 | ¿Cómo se redondea? | 100,01 × 0,9 = 90,009. ¿Se cobra 90,01 o 90,00? | «¿A cuántos decimales y con qué regla se redondea el total?» |
| A4 | ¿Qué moneda y qué precisión? | «100» puede ser ₡100 o $100; determina los valores límite (99,99 o 99) | «¿En qué moneda está el umbral y cuál es la unidad mínima de cobro?» |
| A5 | ¿Se combina con otras promociones? | Dos descuentos pueden aplicarse en cadena o excluirse | «Si hay otra promoción, ¿se suman, se aplica la mayor o ninguna?» |
| A6 | ¿Aplica a todos los clientes y productos? | Puede haber excepciones (productos en oferta, clientes mayoristas) | «¿Hay productos o clientes excluidos?» |
| A7 | ¿Qué pasa con montos no válidos (negativos, cero, vacíos)? | El requisito solo describe el caso feliz | «¿Qué debe hacer el sistema si el monto es 0 o negativo, por ejemplo en una devolución?» |

## 3. Criterios de aceptación

Con supuestos explícitos para A1, A3 y A7 (A2, A4, A5 y A6 quedan fuera de esta demostración), el requisito se puede escribir en criterios verificables con el formato *Dado / Cuando / Entonces*:

| ID | Criterio de aceptación | Supuesto que lo sostiene |
|---|---|---|
| CA-01 | **Dado** un monto entre 0 y menos de 100, **cuando** se calcula el total, **entonces** el total es igual al monto (sin descuento). | — |
| CA-02 | **Dado** un monto de 100 o más, **cuando** se calcula el total, **entonces** el total es el monto menos el 10 %. | A1: 100 sí recibe descuento |
| CA-03 | **Dado** un monto negativo, **cuando** se calcula el total, **entonces** el sistema rechaza la operación con un error. | A7: los negativos no son válidos |
| CA-04 | **Dado** cualquier total calculado, **entonces** se presenta redondeado a dos decimales. | A3: redondeo a 2 decimales (⚠ por confirmar) |

## 4. Diseño de los casos

### 4.1 Partición de equivalencia

La entrada (el monto) se divide en particiones cuyos valores el sistema debería tratar igual. El ISTQB indica que las particiones no deben solaparse y que «one test for each partition is sufficient» (2024, p. 39).

| Partición | Rango | Tipo | Comportamiento esperado | Caso representativo |
|---|---|---|---|---|
| P1 | monto < 0 | Inválida | Error | CP-04 (−1) |
| P2 | 0 ≤ monto < 100 | Válida | Sin descuento | CP-01 (50) |
| P3 | monto ≥ 100 | Válida | 10 % de descuento | CP-05 (200) |

### 4.2 Análisis de valores límite

Las particiones tienen dos fronteras: **0** (entre P1 y P2) y **100** (entre P2 y P3). Con unidad mínima de 0,01 (supuesto de A4), el análisis de **2 valores** prueba cada frontera y su vecino más cercano. El de **3 valores** prueba la frontera y sus dos vecinos (ISTQB, 2024, p. 40). Como el error típico en este requisito es escribir `>` en lugar de `>=`, se usa el de 3 valores en la frontera de 100:

| Frontera | Valores (2 valores) | Valores agregados (3 valores) |
|---|---|---|
| 0 | −0,01 · 0 | 0,01 |
| 100 | 99,99 · 100 | 100,01 |

### 4.3 Conjetura de errores

Por experiencia se anticipan errores que las particiones no cubren de forma explícita (ISTQB, 2024, p. 43): entrada vacía o no numérica, montos muy grandes y un redondeo acumulado. La entrada vacía o no numérica no se puede representar en el método `calcularTotal(double)`. Por eso se prueba en otro nivel, la interfaz o la validación de entrada, y se registra como caso pendiente de ese nivel.

## 5. Matriz de trazabilidad

| Requisito | Criterio | Caso | Tipo | Técnica | Entrada | Resultado esperado |
|---|---|---|---|---|---|---|
| R-01 | CA-01 | **CP-01** | Normal | Partición P2 | 50,00 | 50,00 |
| R-01 | CA-02 | **CP-02** | Límite | Valor límite (100) | 100,00 | 90,00 |
| R-01 | CA-01 | **CP-03** | Límite | Valor límite (100) | 99,99 | 99,99 |
| R-01 | CA-03 | **CP-04** | Error | Partición P1 | −1,00 | Error: «El monto no puede ser negativo» |
| R-01 | CA-02 | **CP-05** | Normal | Partición P3 | 200,00 | 180,00 |
| R-01 | CA-01 | **CP-06** | Límite | Valor límite (0) | 0,00 | 0,00 |
| R-01 | CA-02, CA-04 | **CP-07** | Límite | Valor límite (100, 3 valores) | 100,01 | 90,01 ⚠ depende de A3 |
| R-01 | CA-03 | **CP-08** | Límite / error | Valor límite (0) | −0,01 | Error |
| R-01 | CA-01 | **CP-09** | Límite | Valor límite (0, 3 valores) | 0,01 | 0,01 |
| R-01 | — | CP-10 | Error | Conjetura de errores | vacío / «abc» | Mensaje de validación. *Pendiente: nivel de interfaz, fuera del alcance unitario* |

**Comprobación de cobertura**

| Criterio | Casos que lo cubren | ¿Cubierto? |
|---|---|---|
| CA-01 | CP-01, CP-03, CP-06, CP-09 | Sí |
| CA-02 | CP-02, CP-05, CP-07 | Sí |
| CA-03 | CP-04, CP-08 | Sí |
| CA-04 | CP-07 | Parcial: depende de la respuesta a A3 |

| Tipo de caso | Cantidad | Casos |
|---|---|---|
| Normales | 2 | CP-01, CP-05 |
| Límites | 5 | CP-02, CP-03, CP-06, CP-07, CP-09 |
| Límite y error a la vez | 1 | CP-08 |
| Errores | 1 (+1 de otro nivel) | CP-04 · CP-10 |
| **Total** | **10** | 9 unitarios + 1 de otro nivel |

Las particiones solas darían tres casos (uno por partición). Las fronteras agregan seis más. Esa diferencia muestra por qué los límites son la parte más costosa, y la más valiosa, del diseño.

> **Relación con el Desarrollo B.** Los casos CP-01 a CP-09 están automatizados en `demo-tdd/`, cada prueba con el ID de su caso. CP-10 queda para el nivel de interfaz. La demostración aplica el supuesto de redondeo a dos decimales (CP-07 = 90,01). Al cambiar a propósito `>=` por `>`, solo CP-02 falló y CP-03 siguió pasando: la frontera de 100 necesita el caso exacto.

## 6. Preguntas de debate 1 y 2

> ⚠ La redacción exacta de las preguntas debe tomarse de la guía. Estas respuestas suponen que la 1 trata de las ambigüedades del requisito y la 2 de cuántos casos se necesitan para cubrirlo.

**Pregunta 1. ¿Qué ambigüedades tiene el requisito del descuento y qué se le debe preguntar al cliente antes de escribir las pruebas?**

El requisito tiene al menos siete ambigüedades (tabla de la sección 2). Las más críticas son tres: si el valor 100 recibe el descuento (A1), sobre qué monto se calcula (A2) y cómo se redondea (A3). Cambian directamente el resultado esperado de los casos límite. No se deben resolver suponiendo. Una prueba escrita sobre un supuesto equivocado pasa en verde y confirma el error, que es la «falsa sensación de seguridad» del Desarrollo B. Por eso, en un proceso con TDD o ATDD, escribir los casos antes del código tiene un beneficio adicional: obliga a hacer estas preguntas temprano, cuando corregir es barato.

**Pregunta 2. ¿Cuántos casos de prueba hacen falta para considerar cubierto el requisito?**

No existe un número fijo. La cobertura se mide contra los criterios de aceptación y las técnicas aplicadas, no por cantidad. Con partición de equivalencia bastan tres casos, uno por partición. Al aplicar valores límite de 3 valores en la frontera crítica y de 2 en la otra, el conjunto razonable sube a nueve casos unitarios más uno de validación en otro nivel. El criterio de suficiencia tiene tres partes:
- cada criterio de aceptación tiene al menos un caso;
- cada partición tiene un representante;
- cada frontera se prueba con sus vecinos.

Agregar más casos dentro de una misma partición casi no encuentra defectos nuevos y sí aumenta el costo de mantenimiento.

## Referencias citadas en esta sección

International Software Testing Qualifications Board. (2024). *Certified Tester Foundation Level syllabus* (Versión 4.0.1). https://www.istqb.org/wp-content/uploads/2024/11/ISTQB_CTFL_Syllabus_v4.0.1.pdf

---

**Notas para la revisión (se borran antes de pasar al Word):**
- Valery: reemplazar el «requisito de trabajo» por el texto exacto de la guía y revisar si cambian las fronteras, la moneda o los IDs.
- Valery: confirmar las páginas del ISTQB (p. 19, 20, 39, 40, 43, 45–46) con el PDF abierto.
- Pendiente: agregar una cita de Pressman (2010) sobre pruebas de caja negra o de ISO/IEC/IEEE 29119-1 (vocabulario) con página, para que el Desarrollo A no dependa de una sola fuente.
