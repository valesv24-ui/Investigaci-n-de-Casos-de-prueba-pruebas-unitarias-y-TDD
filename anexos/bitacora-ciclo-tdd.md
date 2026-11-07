# Bitácora del ciclo rojo–verde–refactor

> Instrumento del paso 5. Proyecto: `demo-tdd/` (Maven, JUnit 5). **Maykel: la columna «Resultado real» está vacía a propósito.** Se completa al ejecutar cada paso; no la llenes con lo esperado.
>
> Cómo ejecutarla: crear el proyecto, y en cada paso correr `mvn test`. Para ver el ciclo, comenzar sin la clase `CalculadoraDescuento` y agregar las pruebas y el código en este orden.

| # | Prueba | Fase | Cambio hecho | Resultado esperado | Resultado real | Observación |
|---|---|---|---|---|---|---|
| 1 | CP-01 (50 → 50) | Rojo | Escribir la prueba sin la clase | No compila / falla | | |
| 2 | CP-01 | Verde | `return monto;` | Pasa | | |
| 3 | CP-02 (100 → 90) | Rojo | Escribir la prueba | Falla: se obtiene 100, se esperaba 90 | | |
| 4 | CP-02 | Verde | `return monto >= 100 ? monto * 0.9 : monto;` | Pasa; CP-01 sigue pasando | | |
| 5 | CP-03 (99,99 → 99,99) | Verde sin rojo | Solo escribir la prueba | Pasa de inmediato | | Probar a romperla: cambiar `>=` por `>` y ver que CP-02 falla |
| 6 | CP-04 (−1 → excepción) | Rojo | Escribir la prueba | Falla: no lanza excepción | | |
| 7 | CP-04 | Verde | Agregar `if (monto < 0) throw …` | Pasa | | |
| 8 | Todas | Refactor | Constantes `UMBRAL` y `TASA_DESCUENTO` | 4 pruebas en verde | | |
| 9 | Prueba frágil (ejemplo) | — | Con Mockito, verificar que se llama `aplicarTasa()`; luego refactorizar | Se rompe sin cambiar el comportamiento | | Opcional; requiere agregar Mockito |

**Verificación previa (hecha al preparar este documento).** La clase final `CalculadoraDescuento` se compiló y se comprobaron los valores esperados con un programa de verificación simple, sin JUnit (no se pudo descargar JUnit en el entorno de preparación). Resultados: 0→0, 50→50, 99,99→99,99, 100→90, 100,01→90,009, 200→180 y −1→excepción. **Las pruebas JUnit en sí no se ejecutaron.**
