# Diapositivas de Valery · 1–7 y 12–13

> Responsable: Valery · Fecha límite: mié 11 nov · Tiempo total: 8 de los 15 minutos
> Gamma.App **no** está permitido. Hay que pasar esto a la herramienta que usen los dos, con el mismo diseño que las diapositivas de Maykel.
> Regla: poco texto en pantalla; lo demás va en las **notas del orador**, que se dicen sin leer.

---

## Bloque 1 · Diapositivas 1–3 · 2 minutos

### Diapositiva 1 · Portada (≈ 20 s)
**En pantalla**
- Casos de prueba, pruebas unitarias y TDD
- ISW-622 Pruebas de Software · Grupo 02 · UTN Sede San Carlos
- Valery Salas Vargas · Maykel Meoño González
- Profesor Andrés Joseph Jiménez Leandro · 14 de noviembre de 2026

**Notas:** «Buenos días. Somos el grupo 02 y nuestro tema es casos de prueba, pruebas unitarias y TDD.»

### Diapositiva 2 · El problema (≈ 50 s)
**En pantalla**
- Un defecto cuesta más cuanto más tarde se encuentra
- TDD propone escribir la prueba **antes** del código
- Pero escribir y mantener pruebas tiene un costo

**Notas:** Las pruebas son parte del proceso de desarrollo, no algo que se hace al final (Pressman, 2010). TDD lleva esa idea más lejos: la prueba guía el código (ISTQB, 2024). La duda no es si probar, sino cuánto y cuándo conviene probar primero.

### Diapositiva 3 · Pregunta central (≈ 50 s)
**En pantalla**
> ¿Conviene aplicar TDD en **todos** los proyectos?
- Investigación documental · 8 fuentes · 1 caso: descuento del 10 %
- Spoiler: la respuesta es «depende», y les vamos a decir de qué

**Notas:** Explicar el método en una oración: revisamos normas (ISTQB, ISO 29119), libros, documentación profesional y un estudio empírico, y lo aplicamos a un requisito pequeño. Mencionar que vamos a terminar con una postura condicionada.

---

## Bloque 2 · Diapositivas 4–7 · 4 minutos

### Diapositiva 4 · Del requisito al resultado esperado (≈ 1 min)
**En pantalla:** diagrama de cuatro cajas con flechas
`Requisito → Criterio de aceptación → Caso de prueba → Resultado esperado`
- Ejemplo debajo de cada caja:
  - «10 % a compras ≥ 100»
  - «Dado 100, el total es 90»
  - «Entrada: 100,00»
  - «90,00»

**Notas:** Un criterio de aceptación delimita el requisito y es la base de sus pruebas (ISTQB, 2024). El resultado esperado se define **antes** de ejecutar; si no, cualquier salida parece correcta.

### Diapositiva 5 · Trazabilidad (≈ 1 min)
**En pantalla:** extracto de la matriz (4 o 5 filas)

| Criterio | Caso | Tipo | Entrada | Esperado |
|---|---|---|---|---|
| CA-01 | CP-01 | Normal | 50 | 50 |
| CA-02 | CP-02 | Límite | 100 | 90 |
| CA-01 | CP-03 | Límite | 99,99 | 99,99 |
| CA-03 | CP-04 | Error | −1 | Error |

**Notas:** La trazabilidad responde tres preguntas: ¿está todo cubierto?, si cambia el requisito, ¿qué casos se tocan?, y ¿algún caso sobra? (ISTQB, 2024, secc. 1.4.4). Los mismos IDs CP-xx aparecen en las pruebas de Maykel, así que la cadena llega hasta el código.

### Diapositiva 6 · Partición y valores límite (≈ 1 min)
**En pantalla:** una recta numérica
`—— P1: < 0 (error) ——|0|—— P2: 0 a 99,99 (sin descuento) ——|100|—— P3: ≥ 100 (10 %) ——`
- Puntos marcados: −0,01 · 0 · 0,01 · 99,99 · 100 · 100,01

**Notas:** Partición de equivalencia: un caso por partición basta (ISTQB, 2024, secc. 4.2.1). Pero el error típico aquí es escribir `>` en vez de `>=`, y está en la frontera. Por eso se usan valores límite de 3 valores en 100 (secc. 4.2.2). Dato de la demostración: al cambiar `>=` por `>`, CP-03 (99,99) siguió pasando y solo CP-02 (100) falló.

### Diapositiva 7 · Cobertura (≈ 1 min)
**En pantalla**
- Solo particiones: **3 casos**
- Con valores límite: **9 casos unitarios + 1 de interfaz**
- 2 normales · 5 límites · 1 error · 1 límite y error
- La suficiencia se mide por criterios, particiones y fronteras, no por cantidad

**Notas:** Más casos dentro de la misma partición casi no encuentran defectos nuevos y sí cuestan mantenimiento. El caso de entrada vacía o «abc» no se puede probar en el método unitario: le toca a otro nivel. Dar paso a Maykel: «Ahora Maykel les cuenta cómo estos casos se convierten en pruebas unitarias.»

---

## Bloque 3 · Diapositivas 12–13 · 2 minutos

### Diapositiva 12 · ¿Qué no dice el requisito? (≈ 1 min)
**En pantalla:** «10 % de descuento a compras de 100 o más», con tres preguntas alrededor:
- ¿100 exacto recibe descuento?
- ¿Antes o después de impuestos?
- ¿Cómo se redondea 90,009?
- Al pie: «+ 4 ambigüedades más: moneda, promociones, exclusiones, montos inválidos»

**Notas:** Responde la pregunta de debate 1. Las tres primeras cambian el resultado esperado de los casos límite. Si el equipo supone en lugar de preguntar, las pruebas quedan en verde y confirman un error.

### Diapositiva 13 · Qué preguntarle al cliente (≈ 1 min)
**En pantalla**
- «Una compra de exactamente 100, ¿recibe el descuento?»
- «¿El monto de 100 es antes o después de impuestos?»
- «¿A cuántos decimales se redondea?»
- **Lección:** escribir la prueba primero obliga a hacer estas preguntas temprano

**Notas:** Responde la pregunta de debate 2: no hay un número fijo de casos, la cobertura se mide por criterios y fronteras. Conectar con la postura: este es un argumento *a favor* de escribir las pruebas antes, aunque el estudio de Fucci et al. (2017) indica que el orden por sí solo no explica la mejora. Dar paso a Maykel para la postura (diapositivas 14–15).

---

**Pendientes**
- ⚠ Ajustar el requisito, las fronteras y las preguntas de debate al texto exacto de la guía.
- Practicar el bloque completo en 8 minutos sin leer (ensayo del vie 13).
- Preparar 1 minuto para explicar el bloque de Maykel (regla 4).
