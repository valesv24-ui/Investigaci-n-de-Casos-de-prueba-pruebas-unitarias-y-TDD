# Desarrollo A · Del requisito al caso de prueba

> Tarea 7 · Responsable: Valery Salas Vargas · Revisa: Maykel Meoño González

Esta sección responde los dos primeros aspectos de la ficha del Tema 2 y las preguntas de debate 1 y 2. Explica cómo un requisito se transforma en una comprobación útil y lo aplica al caso de los descuentos a clientes frecuentes. Los casos diseñados aquí (CP-01 a CP-12) se retoman en el Desarrollo B. Allí, los casos CP-01 a CP-09 se automatizan como pruebas unitarias.

## 1. Requisito, criterio de aceptación, caso de prueba y resultado esperado: relaciones y trazabilidad

| Elemento | Qué es | Pregunta que responde |
|---|---|---|
| **Requisito** | Lo que el sistema debe hacer, expresado por el cliente o el analista | ¿Qué se necesita? |
| **Criterio de aceptación** | Condición concreta y verificable que el requisito debe cumplir para darse por aceptado | ¿Cómo sabremos que está bien hecho? |
| **Caso de prueba** | Conjunto de precondiciones, datos de entrada y pasos que ejercitan un criterio | ¿Con qué datos lo comprobamos? |
| **Resultado esperado** | Salida o comportamiento que debe producirse con esos datos, definido *antes* de ejecutar | ¿Qué debería pasar? |

Los cuatro elementos forman una cadena: cada uno se deriva del anterior. El criterio de aceptación es el eslabón que vuelve verificable al requisito. Según el ISTQB, sirve para «Define the scope of the user story» y para «Serve as a basis for the user story acceptance testing» (2024, p. 45–46). Un caso de prueba aparece cuando una condición de prueba se concreta con datos, actividad que el ISTQB describe como «elaborating the test conditions into test cases» (2024, p. 19). El resultado esperado tiene que salir del criterio y fijarse antes de ejecutar. Si no, cualquier salida parece correcta.

**Trazabilidad.** Es la relación documentada entre los eslabones de la cadena. Según el ISTQB (2024, p. 20), «it is important to establish and maintain traceability throughout the test process between the test basis elements» y los productos de la prueba. En la práctica permite responder tres preguntas:

1. **Cobertura:** ¿todo criterio de aceptación tiene al menos un caso?
2. **Impacto:** si el requisito cambia, ¿qué casos hay que actualizar?
3. **Justificación:** ¿cada caso existe por una razón, o hay casos que no verifican nada pedido?

**Aplicado al caso.** Al requisito «el sistema aplicará descuentos correctos a los clientes frecuentes» le falta el eslabón del criterio de aceptación. Por eso la única prueba del desarrollador no se puede trazar a nada verificable: confirma un 10 % que nadie definió como el resultado esperado. La cadena se rompe en el segundo eslabón, y sin criterio no hay forma de decidir si una prueba, o cien, son suficientes. La sección 3 reconstruye la cadena completa.

## 2. Cobertura de casos normales, límites y errores; razones para evitar pruebas que solo confirman el caso feliz

### 2.1 Por qué una prueba del caso feliz no basta

La prueba del desarrollador comprueba un solo valor de una sola situación: un cliente frecuente que recibe el 10 %. Esa prueba seguiría pasando con implementaciones claramente incorrectas. Algunos ejemplos:

- el sistema da el 10 % a **todos** los clientes, frecuentes o no;
- el sistema nunca deja de considerar frecuente a un cliente;
- el sistema calcula mal el descuento en la frontera de la regla, por ejemplo con `>` en lugar de `>=`;
- el sistema acepta montos negativos.

Una prueba que no puede fallar ante esos errores no aporta evidencia de que el requisito se cumpla. Solo confirma lo que el desarrollador ya creía. Pressman describe ese sesgo: quien construye el software tiende a diseñar «pruebas que demostrarán que el programa funciona, en lugar de descubrir errores» (2010, p. 385). La demostración del Desarrollo B lo muestra: al cambiar a propósito `>=` por `>`, la prueba de 99,99 siguió pasando y solo la del valor exacto de la frontera detectó el error.

Para evitarlo, el ISTQB propone técnicas que derivan los casos del requisito y no de la intuición:

- **Partición de equivalencia:** divide las entradas en grupos que el sistema debe tratar igual; con un caso por grupo basta, porque «one test for each partition is sufficient» (2024, p. 39).
- **Análisis de valores límite:** prueba cada frontera entre grupos y sus vecinos, ya que en las fronteras «developers are more likely to make errors» (ISTQB, 2024, p. 40–41). Pressman coincide: «un mayor número de errores ocurre en las fronteras del dominio de entrada y no en el “centro”» (2010, p. 425).
- **Conjetura de errores:** anticipa fallos típicos a partir de la experiencia (ISTQB, 2024, p. 43).

Con estas técnicas, la cobertura se mide contra los criterios, las particiones y las fronteras, no por la cantidad de pruebas.

### 2.2 Casos diseñados para la regla aclarada

Los casos solo se pueden diseñar después de responder las preguntas de la sección 3. Para continuar el análisis, el equipo **supone** las respuestas que aparecen en la sección 3.3. Son supuestos propios, no datos de la guía, y su único fin es mostrar cómo se completa la cadena.

**Particiones y fronteras**

| Variable | Particiones | Fronteras probadas |
|---|---|---|
| Compras del cliente en los últimos 6 meses | < 5: no frecuente · ≥ 5: frecuente | 4 y 5 |
| Monto de la compra (cliente frecuente) | < 0: inválido · 0 a 99,99: sin descuento · ≥ 100: 10 % | −0,01 · 0 · 0,01 · 99,99 · 100 · 100,01 |

En la frontera de 100 se usa el análisis de 3 valores (100 y sus dos vecinos), porque ahí está el error más probable. En las demás se usan 2 valores.

**Matriz de trazabilidad**

| Criterio | Caso | Tipo | Técnica | Precondición | Entrada | Resultado esperado |
|---|---|---|---|---|---|---|
| CA-01 | **CP-01** | Normal | Partición | Cliente frecuente | 50,00 | 50,00 |
| CA-02 | **CP-02** | Límite | Valor límite (100) | Cliente frecuente | 100,00 | 90,00 |
| CA-01 | **CP-03** | Límite | Valor límite (100) | Cliente frecuente | 99,99 | 99,99 |
| CA-03 | **CP-04** | Error | Partición | Cliente frecuente | −1,00 | Error: «El monto no puede ser negativo» |
| CA-02 | **CP-05** | Normal | Partición | Cliente frecuente | 200,00 | 180,00 |
| CA-01 | **CP-06** | Límite | Valor límite (0) | Cliente frecuente | 0,00 | 0,00 |
| CA-02, CA-04 | **CP-07** | Límite | Valor límite (100, 3 valores) | Cliente frecuente | 100,01 | 90,01 |
| CA-03 | **CP-08** | Límite y error | Valor límite (0) | Cliente frecuente | −0,01 | Error |
| CA-01 | **CP-09** | Límite | Valor límite (0) | Cliente frecuente | 0,01 | 0,01 |
| — | CP-10 | Error | Conjetura de errores | — | vacío / «abc» | Mensaje de validación (nivel de interfaz) |
| CA-05 | **CP-11** | Límite | Valor límite (frecuencia) | 4 compras en 6 meses | 200,00 | 200,00 (sin descuento) |
| CA-06 | **CP-12** | Límite | Valor límite (frecuencia) | 5 compras en 6 meses | 200,00 | 180,00 |

**Comprobación de cobertura**

| Criterio | Casos | ¿Cubierto? |
|---|---|---|
| CA-01 | CP-01, CP-03, CP-06, CP-09 | Sí |
| CA-02 | CP-02, CP-05, CP-07 | Sí |
| CA-03 | CP-04, CP-08 | Sí |
| CA-04 | CP-07 | Sí, con el supuesto de redondeo |
| CA-05 | CP-11 | Sí |
| CA-06 | CP-12 | Sí |

| Tipo | Cantidad | Casos |
|---|---|---|
| Normales | 2 | CP-01, CP-05 |
| Límites | 7 | CP-02, CP-03, CP-06, CP-07, CP-09, CP-11, CP-12 |
| Límite y error a la vez | 1 | CP-08 |
| Errores | 2 | CP-04 · CP-10 (otro nivel) |
| **Total** | **12** | 11 unitarios + 1 de interfaz |

La prueba original del desarrollador equivale a CP-05: es uno de doce casos. Los casos de límite y de error son la mayoría, y son los que detectan los errores que el caso feliz deja pasar.

> **Relación con el Desarrollo B.** CP-01 a CP-09 están automatizados en `demo-tdd/` para un cliente ya clasificado como frecuente, cada prueba con el ID de su caso. CP-11 y CP-12, la clasificación por frecuencia, están diseñados pero no automatizados: necesitarían una segunda unidad que cuente las compras del cliente. CP-10 corresponde al nivel de interfaz.

## 3. Situación para el análisis crítico

> *Un equipo recibe el requisito «el sistema aplicará descuentos correctos a los clientes frecuentes». Un desarrollador crea una sola prueba que confirma un descuento del 10 % y declara finalizada la funcionalidad. Otra persona propone aclarar las reglas antes de escribir más pruebas.*

### 3.1 Pregunta de debate 1: ¿Qué ambigüedades impiden juzgar si la prueba es suficiente?

Para juzgar si una prueba es suficiente hace falta saber contra qué se compara. El requisito no lo dice: tiene dos términos sin definir, «clientes frecuentes» y «descuentos correctos», y varias condiciones implícitas.

| # | Ambigüedad | Por qué impide juzgar la prueba |
|---|---|---|
| A1 | **¿Quién es «cliente frecuente»?** ¿Cantidad de compras, monto acumulado, antigüedad o membresía? ¿En qué período? | Sin esta definición no se sabe a quién debe aplicarse el descuento, ni a quién no. La prueba no verifica a ningún cliente no frecuente |
| A2 | **¿Dónde está la frontera de la frecuencia?** Si son 5 compras, ¿5 exactas cuentan? | Es el error de frontera más probable y la prueba no lo toca |
| A3 | **¿Qué es un descuento «correcto»?** ¿10 % fijo, escalonado por nivel de cliente o dependiente del monto? | El 10 % que confirma la prueba es una suposición del desarrollador, no un criterio del cliente |
| A4 | **¿Hay un monto mínimo de compra?** | Si existe, el descuento no aplica siempre y faltan casos por debajo del mínimo |
| A5 | **¿Sobre qué monto se calcula?** ¿Subtotal, con impuestos o con envío? | Cambia el resultado esperado de todos los casos |
| A6 | **¿Cómo se redondea?** | 100,01 × 0,9 = 90,009. Puede cobrarse 90,01 o 90,00 |
| A7 | **¿Se combina con otras promociones? ¿Hay un tope?** | Un cliente frecuente con otra promoción puede recibir un descuento doble o uno incorrecto |
| A8 | **¿Hay productos o categorías excluidos?** | La prueba usa un solo producto o monto |
| A9 | **¿Qué pasa con entradas inválidas o devoluciones?** | El requisito solo describe el caso feliz |
| A10 | **¿Cuándo se evalúa si el cliente es frecuente?** ¿Al momento de la compra? ¿Qué pasa si pierde la condición? | Afecta el resultado de compras hechas cerca del cambio de condición |

**Respuesta.** Con esas ambigüedades, la prueba no se puede juzgar como suficiente ni como insuficiente, porque no existe un criterio contra el cual medirla. Lo único que se puede afirmar es que comprueba **un** comportamiento supuesto, un 10 % para un cliente que el desarrollador consideró frecuente. No cubre a ningún cliente no frecuente, ninguna frontera y ningún error. Declarar terminada la funcionalidad es una conclusión que la evidencia no sostiene. La propuesta de aclarar las reglas antes de escribir más pruebas es la correcta: escribir más pruebas sobre un requisito ambiguo solo multiplica la suposición inicial.

### 3.2 Pregunta de debate 2: ¿Qué información tendría que deducirse o preguntarse antes de decidir que el requisito se cumplió?

Parte de la información se puede **deducir** del contexto del sistema y otra parte solo la puede dar quien pidió el requisito. Lo importante es no confundir las dos: lo que se deduce también debe confirmarse antes de darlo por cierto.

| Información | ¿Deducir o preguntar? | Dónde buscarla o a quién preguntar | Qué decide |
|---|---|---|---|
| Definición de cliente frecuente (A1) y su frontera (A2) | **Preguntar** | Dueño del producto o área comercial | Particiones y fronteras de frecuencia (CA-05, CA-06) |
| Porcentaje o escala de descuento (A3) | **Preguntar** | Área comercial | Resultado esperado de todos los casos con descuento |
| Monto mínimo (A4) y base de cálculo (A5) | Deducir de las políticas de precios existentes, **y confirmar** | Documentación del negocio y dueño del producto | Fronteras de monto (CA-01, CA-02) |
| Redondeo y moneda (A6) | Deducir de cómo el sistema ya maneja montos y de la normativa de facturación, **y confirmar** | Código y facturas existentes; contabilidad | CA-04 |
| Combinación con promociones y topes (A7) | **Preguntar** | Área comercial | Casos de interacción entre descuentos |
| Exclusiones (A8) | Deducir del catálogo, **y confirmar** | Catálogo de productos | Casos por categoría |
| Entradas inválidas y devoluciones (A9) | Deducir de las reglas de validación del sistema | Código y requisitos de validación | CA-03 y casos de error |
| Momento de evaluación de la frecuencia (A10) | **Preguntar** | Dueño del producto | Casos de cambio de condición |

**Respuesta.** Antes de decidir que el requisito se cumplió hace falta, como mínimo:

- la definición verificable de «cliente frecuente» y de «descuento correcto», que solo el cliente puede dar;
- los criterios de aceptación escritos a partir de esas definiciones y aceptados por el cliente;
- un conjunto de casos trazado a esos criterios que cubra las particiones, las fronteras y los errores.

El requisito se considera cumplido cuando todos los casos trazados pasan, no cuando pasa una prueba. Si una respuesta del cliente cambia, la trazabilidad indica qué casos hay que rehacer.

### 3.3 Respuestas supuestas para continuar el análisis

Como no hay un cliente real a quien preguntar, el equipo supone estas respuestas para completar la cadena. Con cualquier otra respuesta cambian los criterios y los casos, pero el método es el mismo.

| Ambigüedad | Supuesto del equipo |
|---|---|
| A1, A2 | Cliente frecuente: 5 o más compras en los últimos 6 meses (5 exactas cuentan) |
| A3, A4 | Un cliente frecuente recibe 10 % en compras de 100 o más. Debajo de 100, sin descuento |
| A5 | Se calcula sobre el subtotal |
| A6 | El total se redondea a dos decimales |
| A9 | Los montos negativos son inválidos y se rechazan |
| A7, A8, A10 | Fuera del alcance de este análisis: quedan como preguntas abiertas |

**Criterios de aceptación resultantes**

| ID | Criterio (*Dado / Cuando / Entonces*) |
|---|---|
| CA-01 | **Dado** un cliente frecuente y un monto entre 0 y 99,99, **cuando** se calcula el total, **entonces** no se aplica descuento. |
| CA-02 | **Dado** un cliente frecuente y un monto de 100 o más, **cuando** se calcula el total, **entonces** se descuenta el 10 %. |
| CA-03 | **Dado** un monto negativo, **cuando** se calcula el total, **entonces** el sistema rechaza la operación. |
| CA-04 | **Dado** cualquier total calculado, **entonces** se presenta redondeado a dos decimales. |
| CA-05 | **Dado** un cliente con menos de 5 compras en los últimos 6 meses, **cuando** compra 100 o más, **entonces** no recibe descuento. |
| CA-06 | **Dado** un cliente con 5 o más compras en los últimos 6 meses, **cuando** compra 100 o más, **entonces** recibe el 10 %. |

## Referencias citadas en esta sección

International Software Testing Qualifications Board. (2024). *Certified Tester Foundation Level syllabus* (Versión 4.0.1). https://www.istqb.org/wp-content/uploads/2024/11/ISTQB_CTFL_Syllabus_v4.0.1.pdf

Pressman, R. S. (2010). *Ingeniería del software: Un enfoque práctico* (V. Campos Olguín & J. Enríquez Brito, Trads.; 7.ª ed.). McGraw-Hill.
