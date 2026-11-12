# Diapositivas de Maykel · 8–11, 14–15 y 16 (más la actividad práctica)

> Responsable: Maykel · Fecha límite: mié 11 nov · Tiempo total: 7 de los 15 minutos, más 10 de actividad
> Solo texto, igual que `diapositivas-valery.md`. Todavía no se arma en ninguna herramienta (Gamma.App **no** está permitido). Hay que usar la misma herramienta y el mismo diseño que las diapositivas de Valery.
> Regla: poco texto en pantalla; lo demás va en las **notas del orador**, que se dicen sin leer.
> La numeración es la del reparto. Valery expone 1–7 y 12–13, así que en la sala el orden real es 1–7, 8–11, 12–13, 14–15, la actividad y 16.

---

## Bloque 1 · Diapositivas 8–11 · 4 minutos

### Diapositiva 8 · Pruebas unitarias (≈ 1 min)
**En pantalla**
> Una prueba unitaria revisa una unidad pequeña, **en aislamiento**
- **Aislada:** el resultado depende solo de la unidad; las dependencias se reemplazan por dobles de prueba
- **Automática:** pasa o falla sin que nadie la revise
- **Base de la suite:** rápida, barata y localiza el defecto con precisión
- Stub: devuelve respuestas fijas · Mock: además permite comprobar que se le hizo una llamada

**Notas:** El ISTQB (2024, p. 29) llama a esto prueba de componente, también conocida como prueba unitaria: prueba un componente en aislamiento. Vocke (2018) las ubica como la base de la suite («The foundation of your test suite will be made up of unit tests») y advierte que mucha gente confunde *mock* y *stub*, por eso fijamos esta distinción. En nuestro caso, la calculadora del descuento no tiene dependencias externas y no necesita dobles; si el porcentaje se leyera de una base de datos, se usaría un *stub* de ese repositorio.

### Diapositiva 9 · Arrange–Act–Assert (≈ 1 min)
**En pantalla:** tres cajas con una línea de código cada una
- **Arrange** (preparar): `new CalculadoraDescuento()`
- **Act** (ejecutar): `calcularTotal(100.0)`
- **Assert** (comprobar): `assertEquals(90.0, total, 0.0001)`
- Ejemplo: **CP-02**, el monto exacto en el umbral recibe 10 %. El ID del caso va en el nombre de la prueba

**Notas:** Vocke (2018) propone esta estructura fija y la resume con el mnemónico «Arrange, Act, Assert». En JUnit 5 el objeto nuevo se crea con `@BeforeEach`, así cada prueba empieza limpia y son independientes (Bechtold et al., s. f., secc. 2.1). Usamos `assertEquals` con tolerancia para decimales y `assertThrows` para los casos de error (secc. 2.5). Con una sola fase *Act* y pocas aserciones, cuando falla se sabe qué se rompió. Cada caso de la matriz de Valery, CP-01 a CP-09, es una prueba con este molde, con su ID en el nombre y en `@DisplayName`.

### Diapositiva 10 · Rojo, verde, refactor (≈ 1 min)
**En pantalla:** tres columnas con los colores del ciclo
- 🔴 **Rojo:** se escribe CP-02 (100 → 90) y falla: obtuvo 100,0, esperaba 90,0
- 🟢 **Verde:** código mínimo para que pase; CP-01 y CP-02 pasan
- 🔵 **Refactor:** `100` y `0,10` pasan a constantes; las 9 pruebas siguen en verde
- **CP-03 pasó sin fase roja.** Al cambiar `>=` por `>` a propósito, solo CP-02 falló
- Pie: observado con un arnés mínimo en Java, no con JUnit

**Notas:** El ISTQB (2024, p. 26) describe TDD como una práctica que dirige la codificación mediante casos de prueba, y Fowler (2023) resume el ciclo en tres pasos; según él, omitir el refactor es la forma más común de hacer mal TDD. Una prueba que nunca estuvo en rojo no demuestra que detecte el error, por eso rompimos el código a propósito: CP-03 pasa con ambos operadores y la frontera la protege CP-02. Ser honestos: el ciclo se observó con un arnés mínimo porque no se pudo descargar JUnit. *[Actualizar esta nota cuando se corra `mvn test`.]*

### Diapositiva 11 · Pruebas frágiles (≈ 1 min)
**En pantalla:** dos columnas, frágil contra robusta
- **Frágil:** verifica que se llamó a `aplicarTasa()`; se rompe al refactorizar
- **Robusta:** comprueba que `calcularTotal(100.0)` devuelve 90; sobrevive al refactor
- «Test for observable behaviour instead.» (Vocke, 2018)
- Una suite en verde solo dice que **los casos escritos pasan**

**Notas:** Una prueba es frágil cuando falla por cambios que no alteran el comportamiento observable. El ejemplo se explica, no se ejecutó. Cada prueba tiene un costo de mantenimiento («additional baggage», Vocke, 2018), y las frágiles lo multiplican. Cierre del bloque: faltan casos, aserciones débiles o un requisito mal entendido dan falsa sensación de seguridad; ninguna prueba unitaria detecta que entendimos mal el requisito. Dar paso a Valery para el caso del descuento y las preguntas al cliente (diapositivas 12–13).

---

## Bloque 2 · Diapositivas 14–15 · 2 minutos

### Diapositiva 14 · Postura condicionada (≈ 1 min)
**En pantalla**
> TDD conviene en ciertos proyectos, **no en todos**
- **Conviene cuando:** hay reglas de negocio claras · el código se va a mantener y refactorizar · el equipo puede sostener pasos pequeños
- **Conviene menos cuando:** el requisito aún se explora · el código es desechable · se valida integración, interfaz o rendimiento
- En todos los casos: aclarar el requisito y derivar casos trazables

**Notas:** Es la respuesta corta a la pregunta central, y sale de la tabla de argumentos del informe. Lo que aplica siempre es el primer paso que mostró Valery. Mencionar que cada fila de la tabla tiene su fuente y un peso (alto, medio o bajo).

### Diapositiva 15 · Contraargumento y límites (≈ 1 min)
**En pantalla**
- **Contraargumento:** «Escribir la prueba primero es lo que hace valioso a TDD, así que debería aplicarse siempre»
- **Respuesta:** en Fucci et al. (2017) el orden no tuvo influencia importante; contaron los pasos pequeños y uniformes. Señal débil, no prueba
- **Límites:** 6 de 8 fuentes son normativas o de experiencia · una sola fuente empírica, observacional · la demostración es pequeña y no usó JUnit

**Notas:** El estudio tiene 39 profesionales de dos empresas y tres tareas cortas, sin grupo de control. De los factores de ritmo, solo la granularidad frente a calidad es significativa (p = 0,04) y los modelos explican poco (R² ajustado de 0,10 a 0,12). No permite concluir que el test-first sea inútil; por eso la postura es condicionada.

---

## Actividad práctica · 10 minutos · la diseña Maykel y la conducen ambos

### Actividad 1 · ¿Qué prueba falta? (≈ 7 min)
**En pantalla**
> Todas las pruebas pasan. ¿Qué prueba falta?
- Código: `total = monto > 100 ? monto * 0.9 : monto;`
- Requisito: 10 % de descuento a compras de **100 o más**
- Pruebas en verde: CP-01 (50), CP-03 (99,99), CP-05 (200), CP-06 (0)
- En parejas: 2 min leer · 5 min escribir en formato AAA la prueba que falta y decir qué resultado da

**Notas:** Dar la consigna sin la respuesta. Circular durante los 5 minutos; pista si hace falta: «¿qué dice el requisito exactamente en 100?». Si el grupo va lento, acortar la puesta en común, no el trabajo en parejas.

### Actividad 2 · Respuesta (≈ 3 min)
**En pantalla**
> Falta CP-02: el valor exacto de la frontera
- Arrange: `new CalculadoraDescuento()` · Act: `calcularTotal(100.0)` · Assert: `assertEquals(90.0, total)`
- Con `>` falla: obtuvo 100,0 y esperaba 90,0. Con `>=` pasa
- Una suite en verde no demuestra que el software sea correcto

**Notas:** Es lo mismo que pasó en nuestra demostración: CP-03 pasaba con ambos operadores. El ISTQB (2024, secc. 4.2.2) dice que en las fronteras los desarrolladores tienen más probabilidad de equivocarse. Preguntar al grupo cuántos habrían confiado en la suite en verde. Escribir la prueba desde el requisito, antes del código, habría hecho aparecer este caso.

---

## Bloque 3 · Diapositiva 16 · 1 minuto (ambos)

### Diapositiva 16 · Conclusión y pregunta final (≈ 1 min)
**En pantalla**
> **No en todos.**
- Conviene con reglas claras, código que cambia y pasos pequeños; aclarar el requisito y derivar casos trazables aplica a todos
- **¿Qué evidencia cambiaría esta conclusión?** Estudios controlados en proyectos reales y de larga duración, o datos del propio equipo sobre defectos y costo de mantener las pruebas

**Notas:** Cierran ambos. Tres cosas cambiarían la conclusión: estudios controlados de larga duración que midan mantenibilidad y costo; réplicas de Fucci et al. que contradigan que el orden no importa; datos del propio equipo que mostraran que TDD no compensa (entonces se usaría solo en las partes críticas). Cerrar agradeciendo y abrir preguntas.

---

**Pendientes**
- Pasar esto a la herramienta que usen los dos, con el mismo diseño que Valery (por ahora hay un borrador visual publicado como artefacto, que se puede descartar).
- Actualizar la nota de la diapositiva 10 cuando se corra `mvn test`.
- Practicar el bloque completo (7 min) sin leer, en el ensayo del vie 13, y preparar 1 minuto para explicar el bloque de Valery (regla 4).
