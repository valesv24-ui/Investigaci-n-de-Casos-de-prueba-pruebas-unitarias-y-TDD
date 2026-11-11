# Bitácora del ciclo rojo–verde–refactor

> Instrumento del paso 5. Proyecto: `demo-tdd/` (Maven, JUnit 5.9.2; código en `src/main/java/cr/utn/descuento/`, pruebas en `src/test/java/cr/utn/descuento/`). Casos: CP-01 a CP-09 de la matriz de trazabilidad del Desarrollo A.

## Cómo se observó cada resultado

**Los resultados reales de abajo se obtuvieron el 11-nov-2026 con un arnés mínimo en Java (sin JUnit).** En el entorno de preparación no se pudo descargar JUnit (Maven Central bloqueado), así que cada paso se ejecutó con las mismas entradas y los mismos valores esperados de las pruebas, y con la misma tolerancia (0,0001). El paso 1 es la salida real del compilador (`javac`); los pasos 2 a 9 usan una versión del código de producción por paso; el paso 10 usa la clase final del proyecto.

**Pendiente (Maykel):** correr `mvn test` en `demo-tdd/` con JUnit y anotar abajo que las 9 pruebas pasan en el reporte de Surefire. El arnés comprueba la lógica, pero no demuestra que las anotaciones de JUnit funcionen.

## Ciclo

| # | Prueba | Fase | Cambio hecho | Resultado esperado | Resultado real (arnés) | Observación |
|---|---|---|---|---|---|---|
| 1 | CP-01 (50 → 50) | Rojo | Escribir la prueba sin la clase | No compila | `error: cannot find symbol … class CalculadoraDescuento` | En un lenguaje compilado, que no compile cuenta como rojo |
| 2 | CP-01 | Verde | `return monto;` | Pasa | CP-01 pasa | Implementación mínima |
| 3 | CP-02 (100 → 90) | Rojo | Escribir la prueba | Falla: se obtiene 100, se esperaba 90 | CP-02 falla: «obtuvo 100.0, esperaba 90.0» | CP-01 sigue pasando |
| 4 | CP-02 | Verde | `return monto >= 100 ? monto * 0.9 : monto;` | Pasa; CP-01 sigue pasando | CP-01 y CP-02 pasan | |
| 5 | CP-03 (99,99 → 99,99) | Verde sin rojo | Solo escribir la prueba | Pasa de inmediato | CP-03 pasa sin cambiar el código | No hubo fase roja |
| 5b | CP-02 (mutante) | Comprobación | Cambiar `>=` por `>` | CP-02 falla | CP-02 falla: «obtuvo 100.0, esperaba 90.0» | Muestra que CP-02 detecta el error de frontera. CP-03 no lo detecta |
| 6 | CP-04 (−1 → excepción) | Rojo | Escribir la prueba | Falla: no lanza excepción | CP-04 falla: «no lanzó excepción; devolvió -1.0» | |
| 7 | CP-04 | Verde | Agregar `if (monto < 0) throw …` | Pasa | CP-01 a CP-04 pasan | |
| 8 | CP-07 (100,01 → 90,01) | Rojo | Escribir la prueba (criterio CA-04: redondeo a 2 decimales) | Falla: se obtiene 90,009 | CP-07 falla: «obtuvo 90.009, esperaba 90.01» | Supuesto A3 por confirmar con el cliente |
| 9 | CP-07 | Verde | `Math.round(total * 100.0) / 100.0` | Pasa | CP-01 a CP-04 y CP-07 pasan | |
| 10 | CP-01 a CP-09 | Refactor | `100` y `0.10` pasan a constantes `UMBRAL` y `TASA_DESCUENTO`; el redondeo pasa a un método privado | Las 9 pruebas siguen en verde | CP-01 a CP-09 pasan (CP-05, CP-06, CP-08 y CP-09 se agregan ya con la clase final y pasan de inmediato) | CP-05, CP-06, CP-08 y CP-09 tampoco pasaron por rojo |
| 11 | Prueba frágil (ejemplo) | — | Con Mockito, verificar que se llama `aplicarTasa()`; luego refactorizar | Se rompe sin cambiar el comportamiento | **No se ejecutó** | Opcional; requiere agregar Mockito. Se explica en el Desarrollo B, sección 3, sin resultado observado |

## Lo que la bitácora muestra y lo que no

- Se observó un ciclo completo de rojo, verde y refactor (pasos 3 a 4, 6 a 7 y 8 a 10), con dos pruebas que no pasaron por rojo (CP-03 y, al final, CP-05, CP-06, CP-08 y CP-09).
- El mutante del paso 5b muestra que la frontera de 100 solo la protege CP-02. CP-03 pasa tanto con `>=` como con `>`.
- No se midió tiempo ni productividad. Es una demostración ilustrativa, no evidencia sobre TDD.
