# Diapositivas de Valery · 1–7 y 12–13

> Responsable: Valery · Tiempo total: 8 de los 15 minutos
> Formato: PowerPoint u otro que se pueda entregar en el Campus Virtual. Al menos 15 diapositivas en total. **Gamma.App está prohibido.**
> Sigue la secuencia recomendada por la guía (p. 6–7):
> 1. problema y pregunta central;
> 2. hallazgos de fuentes y conceptos;
> 3. comparación crítica y análisis del caso;
> 4. decisión, limitaciones y contraargumento;
> 5. conclusión y pregunta al público.
>
> Regla: poco texto en pantalla. Lo demás va en las **notas del orador**, que se dicen sin leer.

---

## Bloque 1 · Problema y pregunta central · Diapositivas 1–3 · 2 minutos

### Diapositiva 1 · Portada (≈ 20 s)
**En pantalla**
- Casos de prueba, pruebas unitarias y TDD: ¿probar antes cambia el resultado?
- ISW-622 Pruebas de Software · Grupo 02 · UTN Sede San Carlos
- Valery Salas Vargas · Maykel Meoño González
- Profesor Andrés Joseph Jiménez Leandro · sábado 14 de noviembre de 2026

**Notas:** «Buenos días. Somos el grupo 02 y nuestro tema es casos de prueba, pruebas unitarias y TDD.»

### Diapositiva 2 · El problema (≈ 50 s)
**En pantalla**
- Requisito: «el sistema aplicará descuentos **correctos** a los clientes **frecuentes**»
- Una sola prueba: confirma un 10 % → «terminado»
- Otra persona: «aclaremos las reglas antes de escribir más pruebas»
- ¿Quién tiene razón?

**Notas:** Este es el caso de la guía. Plantea el problema de fondo: una prueba solo es útil si se deriva de un requisito claro. Las pruebas son parte del desarrollo, no una revisión al final, y TDD lleva esa idea al extremo: la prueba guía el código (ISTQB, 2024).

### Diapositiva 3 · Pregunta central (≈ 50 s)
**En pantalla**
> ¿Es razonable defender TDD en **todos** los proyectos, o su utilidad depende del problema, el equipo y los requisitos?
- Investigación documental · 8 fuentes (ISTQB, ISO 29119, JUnit, Fucci et al., entre otras)
- Spoiler: depende, y les vamos a decir de qué

**Notas:** Explicar el método en una oración: revisamos normas, documentación técnica, artículos profesionales y un estudio empírico, y lo aplicamos al caso.

---

## Bloque 2 · Hallazgos y conceptos · Diapositivas 4–7 · 4 minutos

### Diapositiva 4 · Del requisito al resultado esperado (≈ 1 min)
**En pantalla:** cuatro cajas con flechas
`Requisito → Criterio de aceptación → Caso de prueba → Resultado esperado`
- Debajo, en rojo, sobre la segunda caja: **«falta en el caso de la guía»**

**Notas:**
- El criterio de aceptación hace verificable al requisito. Sirve para delimitar el alcance y como base de las pruebas (ISTQB, 2024).
- En el caso de la guía ese eslabón no existe: el 10 % que confirma la prueba lo decidió el desarrollador, no el cliente.
- Sin criterio, no hay forma de decir si una prueba, o cien, son suficientes.

### Diapositiva 5 · Trazabilidad (≈ 1 min)
**En pantalla:** extracto de la matriz

| Criterio | Caso | Tipo | Precondición | Entrada | Esperado |
|---|---|---|---|---|---|
| CA-02 | CP-02 | Límite | Frecuente | 100 | 90 |
| CA-01 | CP-03 | Límite | Frecuente | 99,99 | 99,99 |
| CA-05 | CP-11 | Límite | 4 compras | 200 | 200 |
| CA-06 | CP-12 | Límite | 5 compras | 200 | 180 |

**Notas:** La trazabilidad responde tres preguntas: ¿está todo cubierto?, si cambia el requisito, ¿qué casos se tocan?, y ¿algún caso sobra? (ISTQB, 2024). Aclarar que las reglas, «frecuente = 5 compras en 6 meses» y «10 % desde 100», son **supuestos del equipo**, porque no hay un cliente real a quien preguntar.

### Diapositiva 6 · Normales, límites y errores (≈ 1 min)
**En pantalla:** una recta numérica del monto
`—— < 0 (error) ——|0|—— 0 a 99,99 (sin descuento) ——|100|—— ≥ 100 (10 %) ——`
- Puntos marcados: −0,01 · 0 · 0,01 · 99,99 · 100 · 100,01
- Debajo, una segunda recta de frecuencia: `4 compras | 5 compras`

**Notas:** Partición de equivalencia: un caso por partición basta (ISTQB, 2024). Pero los errores se concentran en las fronteras. Dato de la demostración: al cambiar `>=` por `>`, la prueba de 99,99 siguió pasando y solo la de 100 falló.

### Diapositiva 7 · Por qué el caso feliz no basta (≈ 1 min)
**En pantalla**
- La prueba original = **1 de 12 casos**
- Seguiría pasando si el sistema:
  - da 10 % a **todos** los clientes;
  - falla en la frontera (`>` en vez de `>=`);
  - acepta montos negativos.
- La cobertura se mide por criterios, particiones y fronteras, no por cantidad

**Notas:** Una prueba que no puede fallar ante esos errores no aporta evidencia, solo confirma lo que el desarrollador ya creía. Dar paso a Maykel: «Ahora Maykel les cuenta cómo estos casos se convierten en pruebas unitarias y qué pasa con TDD.»

---

## Bloque 3 · Análisis del caso · Diapositivas 12–13 · 2 minutos

### Diapositiva 12 · Pregunta 1: ¿qué ambigüedades impiden juzgar si la prueba es suficiente? (≈ 1 min)
**En pantalla:** el requisito al centro, con flechas a:
- ¿Quién es «cliente frecuente»? ¿5 compras exactas cuentan?
- ¿Qué es un descuento «correcto»? ¿10 % fijo o escalonado?
- ¿Sobre qué monto? ¿Cómo se redondea?
- ¿Se combina con otras promociones?
- Al pie: «10 ambigüedades en total»

**Notas:** Sin estas respuestas, la prueba no se puede juzgar como suficiente ni como insuficiente, porque no hay criterio contra el cual medirla. Lo único seguro es que no cubre a ningún cliente no frecuente, ninguna frontera y ningún error. Declarar «terminado» es una conclusión que la evidencia no sostiene.

### Diapositiva 13 · Pregunta 2: ¿qué deducir y qué preguntar antes de decir «se cumplió»? (≈ 1 min)
**En pantalla:** dos columnas

| Se puede deducir (y confirmar) | Hay que preguntar |
|---|---|
| Redondeo y moneda (facturas existentes) | Definición de cliente frecuente |
| Validación de montos (reglas del sistema) | Porcentaje o escala de descuento |
| Productos excluidos (catálogo) | Combinación con promociones |

- **«Cumplido» = todos los casos trazados pasan, no una prueba**

**Notas:** La persona que propuso aclarar las reglas tenía razón. Conectar con TDD: escribir la prueba primero obliga a hacer estas preguntas antes de programar. Dar paso a Maykel para la pregunta 3 y la postura (diapositivas 14–15).

---

**Pendientes**
- Pasar esto a la herramienta que usen los dos, con el mismo diseño que las diapositivas de Maykel.
- Practicar el bloque completo en 8 minutos sin leer (ensayo del vie 13).
- Preparar 1 minuto para explicar el bloque de Maykel (regla 4).
