# Diapositivas de Maykel · 8–11, 14–15 y 16–17 (más la actividad práctica)

> Responsable: Maykel · Tiempo estimado: 7 minutos de exposición, más 10 minutos de actividad.
> Regla: poco texto en pantalla; el desarrollo va en las **notas del orador**.
> La numeración corresponde al reparto: Valery expone 1–7 y 12–13; Maykel expone 8–11 y 14–15; ambos conducen la actividad y cierran con 16–17.
> Contenido sincronizado con `Presentacion_Tema2_TDD_actualizada_main.pptx` y el caso de la guía incorporado después del PR #14.

---

## Bloque 1 · Diapositivas 8–11 · 4 minutos

### Diapositiva 8 · Pruebas unitarias (≈ 1 min)
**En pantalla**
> Una prueba unitaria revisa una unidad pequeña, **en aislamiento**
- **Aislada:** el resultado depende solo de la unidad; las dependencias se reemplazan por dobles de prueba.
- **Automática:** pasa o falla sin que alguien tenga que revisar manualmente el resultado.
- **Base de la suite:** rápida, barata y ayuda a localizar el defecto con precisión.
- Stub: devuelve respuestas fijas · Mock: además permite comprobar que se le hizo una llamada.

**Notas:** El ISTQB (2024, p. 29) llama prueba de componente —también conocida como prueba unitaria— a la que prueba un componente en aislamiento. Vocke (2018) las ubica como la base de la suite y advierte que suele confundirse *mock* con *stub*. En nuestro caso, la calculadora del descuento no tiene dependencias externas y no necesita dobles; si el porcentaje se leyera de una base de datos, se podría usar un *stub* del repositorio.

### Diapositiva 9 · Arrange–Act–Assert (≈ 1 min)
**En pantalla:** tres cajas con una línea de código cada una.
- **Arrange** (preparar): `new CalculadoraDescuento()`.
- **Act** (ejecutar): `calcularTotal(100.0)`.
- **Assert** (comprobar): `assertEquals(90.0, total, 0.0001)`.
- Ejemplo: **CP-02**, el monto exacto en el umbral recibe 10 % bajo el supuesto de cálculo adoptado por el equipo.

**Notas:** Vocke (2018) propone la estructura fija y la resume con el mnemónico «Arrange, Act, Assert». En JUnit 5 el objeto nuevo se crea con `@BeforeEach`, así cada prueba empieza limpia y son independientes (Bechtold et al., s. f., secc. 2.1). Usamos `assertEquals` con tolerancia para decimales y `assertThrows` para los casos de error (secc. 2.5). El ejemplo verifica únicamente el cálculo del descuento para un cliente que ya está clasificado como frecuente. El 10 % a partir de 100 es un supuesto del equipo, no una regla escrita en el requisito original de la guía. Los casos CP-01 a CP-09 usan este molde.

### Diapositiva 10 · Rojo, verde, refactor (≈ 1 min)
**En pantalla:** tres columnas con los colores del ciclo.
- 🔴 **Rojo:** se escribe CP-02 (100 → 90) y falla: obtuvo 100,0, esperaba 90,0.
- 🟢 **Verde:** código mínimo para que pase; CP-01 y CP-02 pasan.
- 🔵 **Refactor:** `100` y `0,10` pasan a constantes; las 9 pruebas siguen en verde.
- **CP-03 pasó sin fase roja.** Al cambiar `>=` por `>` a propósito, solo CP-02 falló.
- Pie: observado con un arnés mínimo en Java, no con JUnit.

**Notas:** El ISTQB (2024, p. 26) describe TDD como una práctica que dirige la codificación mediante casos de prueba, y Fowler (2023) resume el ciclo en tres pasos. Una prueba que nunca estuvo en rojo no demuestra que detecte el error, por eso rompimos el código a propósito: CP-03 pasa con ambos operadores y la frontera la protege CP-02. El ciclo se observó con un arnés mínimo en Java, no con JUnit. El ejemplo trabaja solo el cálculo para un cliente previamente clasificado como frecuente, bajo el supuesto del equipo de 10 % desde 100; no prueba la clasificación por frecuencia.

### Diapositiva 11 · Pruebas frágiles (≈ 1 min)
**En pantalla:** dos columnas, frágil contra robusta.
- **Frágil:** verifica que se llamó a `aplicarTasa()`; se rompe al refactorizar.
- **Robusta:** comprueba que `calcularTotal(100.0)` devuelve 90; sobrevive al refactor.
- «Test for observable behaviour instead.» (Vocke, 2018).
- Una suite en verde solo dice que **los casos escritos pasan**.

**Notas:** Una prueba es frágil cuando falla por cambios que no alteran el comportamiento observable. El ejemplo se explica, no se ejecutó. Cada prueba tiene un costo de mantenimiento (Vocke, 2018), y las frágiles lo multiplican. Cierre del bloque: pueden faltar casos, las aserciones pueden ser débiles o el requisito puede estar mal entendido. Ninguna prueba unitaria detecta por sí sola que entendimos mal el requisito. Dar paso a Valery para el caso de clientes frecuentes y las preguntas al cliente (diapositivas 12–13).

---

## Bloque 2 · Diapositivas 14–15 · 2 minutos

### Diapositiva 14 · Postura condicionada (≈ 1 min)
**En pantalla**
> TDD conviene en ciertos proyectos, **no en todos**
- **Conviene cuando:** hay reglas de negocio claras · el código se mantendrá y refactorizará · el equipo puede sostener pasos pequeños.
- **Conviene menos cuando:** el requisito aún se explora · el código es desechable · se valida integración, interfaz o rendimiento.
- En todos los casos: aclarar el requisito y derivar casos trazables.

**Notas:** Es la respuesta corta a la pregunta central: «¿Es razonable defender TDD en todos los proyectos, o depende del problema, el equipo y los requisitos?». La postura sale de la tabla de argumentos del informe. Lo que aplica siempre es aclarar el requisito y derivar casos trazables. Mencionar que cada fila de la tabla tiene su fuente y un peso (alto, medio o bajo).

### Diapositiva 15 · Contraargumento y límites (≈ 1 min)
**En pantalla**
- **Contraargumento:** «Escribir la prueba primero es lo que hace valioso a TDD, así que debería aplicarse siempre».
- **Respuesta:** en Fucci et al. (2017) el orden no tuvo influencia importante; contaron los pasos pequeños y uniformes. Señal débil, no prueba.
- **Límites:** 6 de 8 fuentes son normativas o de experiencia · una sola fuente empírica, observacional · la demostración es pequeña y no usó JUnit.

**Notas:** El estudio tiene 39 profesionales de dos empresas y tres tareas cortas, sin grupo de control. De los factores de ritmo, solo la granularidad frente a calidad es significativa (p = 0,04) y los modelos explican poco (R² ajustado de 0,10 a 0,12). No permite concluir que el test-first sea inútil; por eso la postura es condicionada.

---

## Actividad práctica · 10 minutos · la diseñan Maykel y Valery

### Diapositiva 16 · Actividad: ¿qué prueba falta? (≈ 7 min)
**En pantalla**
> Caso de la guía: descuento correcto a clientes frecuentes. Para el ejercicio, el equipo supone 5 compras en 6 meses.
- Código: `esFrecuente = comprasUltimos6Meses > 5;`
- **En parejas · 2 min:** leer el requisito y el código.
- **5 min:** escribir en formato AAA la prueba que falta para la frontera de 5 compras.
- **3 min:** puesta en común: ¿qué debería pasar con 5 compras?

**Notas:** Dar la consigna sin la respuesta. El requisito real de la guía es «el sistema aplicará descuentos correctos a los clientes frecuentes»; no define qué significa frecuente. Para este ejercicio se declara el supuesto del equipo: frecuente significa cinco o más compras en seis meses. El código usa `> 5`, por lo que no clasifica como frecuente a quien tiene exactamente cinco compras. Los nueve casos CP-01 a CP-09 prueban el cálculo para alguien ya clasificado como frecuente y no detectan este defecto de clasificación. En parejas, escribir el caso de frontera que falta. No presentar el 10 % ni el umbral de monto como requisitos de la guía.

### Diapositiva 17 · Respuesta: CP-12 (≈ 3 min)
**En pantalla**
> Falta CP-12: la frontera de cinco compras
- Caso diseñado en la matriz del Desarrollo A; **no está automatizado**.
- Arrange: `compras = 5` en los últimos 6 meses · `monto = 200.00`.
- Act: `calcularDescuento(compras, monto)`.
- Assert: `assertEquals(180.00, total, 0.0001)` bajo el supuesto de descuento del equipo.
- Con `> 5`, el cliente queda fuera. Con `>= 5`, entra como frecuente.
- Una suite en verde no demuestra que el requisito esté completo: puede faltar la prueba de clasificación.

**Notas:** La respuesta es CP-12: exactamente cinco compras en seis meses. Bajo el supuesto del equipo, el cliente ya cuenta como frecuente y, si además se supone 10 % de descuento desde 100, el total de una compra de 200 sería 180. Con `> 5` queda fuera; con `>= 5` pasa. Aclarar que CP-12 está diseñado en la matriz, pero no automatizado ni ejecutado. Los CP-01 a CP-09 sí prueban el cálculo para clientes previamente clasificados como frecuentes. Una suite en verde solo demuestra que pasan los casos escritos.

---

## Bloque 3 · Cierre · 1 minuto (ambos)

### Diapositiva 18 · Conclusión y pregunta final (≈ 1 min)
**En pantalla**
> **No en todos.**
- Conviene con reglas claras, código que cambia y pasos pequeños; aclarar el requisito y derivar casos trazables aplica a todos.
- **¿Qué evidencia cambiaría esta conclusión?** Estudios controlados en proyectos reales y de larga duración, o datos del propio equipo sobre defectos y costo de mantener las pruebas.

**Notas:** Cierran ambos. Tres cosas cambiarían la conclusión: estudios controlados de larga duración que midan mantenibilidad y costo; réplicas de Fucci et al. que contradigan que el orden no importa; datos del propio equipo que mostraran que TDD no compensa (entonces se usaría solo en las partes críticas). Cerrar agradeciendo y abrir preguntas.

---

**Pendientes**
- Mantener este guion sincronizado con `Presentacion_Tema2_TDD_actualizada_main.pptx`.
- Actualizar la nota de la diapositiva 10 cuando se corra `mvn test`, si se llega a ejecutar con JUnit.
- Practicar el bloque completo sin leer y respetar los tiempos de exposición y actividad.
