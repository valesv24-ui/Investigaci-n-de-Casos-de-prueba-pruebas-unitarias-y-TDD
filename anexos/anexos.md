# Anexos

> Tarea 15 · Responsable: Maykel Meoño González · Revisa: Valery Salas Vargas
> Valery agrega su fila en la bitácora de IA (regla 3). Maykel completa «Qué se aprovechó» con lo que realmente usó.

## Anexo A. Matriz de lectura crítica

Ver `fuentes/matriz-lectura-critica.md` (fuente 1, Valery; fuente 2, Maykel; fuente 3, ambos). Se pega completa en este anexo al armar el documento final.

## Anexo B. Registro de responsabilidades

Se copia aquí la tabla del apartado «Proceso de planificación» con el **estado final de cada tarea el día de la entrega** (regla 5).

## Anexo C. Bitácora de uso de IA

| Integrante | Herramienta y modelo | Fecha | Prompt (resumen) | Qué se aprovechó |
|---|---|---|---|---|
| Maykel Meoño González | Claude (Anthropic), modelo configurado `claude-sonnet-5-5` | 6-nov-2026 | «Analiza el zip y el docx y dime qué labores pendientes tiene Maykel» | Lista de tareas pendientes de Maykel, según el reparto y el estado del repositorio |
| Maykel Meoño González | Claude (Anthropic), modelo configurado `claude-sonnet-5-5` | 6-nov-2026 | «Haz las tareas correspondientes al informe» | Borradores de: fichas de las fuentes 2 y 3, planificación, Desarrollo B, postura sobre TDD, abstract, lecciones aprendidas, anexos, proyecto de demostración JUnit y plantilla Word. ⚠ **Maykel: indicá qué texto conservaste, cuál reescribiste y qué verificaste contra los originales.** |
| Valery Salas Vargas | Claude (Anthropic), modelo configurado `claude-opus-5-5` | 1-nov-2026 | «Buscar y verificar ISTQB CTFL v4.0, ISO/IEC/IEEE 29119 y Pressman (2012)» | Datos bibliográficos, referencias APA y mapeo de secciones de las tres fuentes (tarea 1) |
| Valery Salas Vargas | Claude (Anthropic), modelo configurado `claude-opus-5-5` | 6-nov-2026 | «Continúa con mi siguiente tarea» (metodología, matriz de la fuente 1, introducción, Desarrollo A) | Borradores de la metodología, la matriz de la fuente 1, la introducción, el Desarrollo A y las filas del Desarrollo A en la postura; revisión del aporte de Maykel. ⚠ **Valery: indicá qué texto conservaste, cuál reescribiste y qué verificaste contra los originales.** |
| Valery Salas Vargas | Claude (Anthropic), modelo configurado `claude-opus-5-5` | 11-nov-2026 | «Empieza a trabajar en lo mío» | Borradores del resumen ejecutivo, las conclusiones, las referencias APA, la declaración de uso de IA, las lecciones aprendidas (parte de Valery) y el contenido de las diapositivas 1–7 y 12–13. ⚠ **Valery: indicá qué conservaste y qué reescribiste.** |

**Verificación de lo generado por IA.** Las citas de las fuentes se extrajeron de los originales en línea. La herramienta no pudo abrir *TDD by Example* de Beck ni confirmar volumen, páginas y DOI de Fucci et al. (2017) en la versión publicada. Esos datos deben comprobarse a mano.

## Anexo D. Figuras y su fuente

| Figura | Descripción | Fuente |
|---|---|---|
| Figura 1 | Ciclo rojo–verde–refactor | Elaboración propia, con base en Fowler (2023) |

![Figura 1. Ciclo rojo–verde–refactor. Elaboración propia, con base en Fowler (2023).](figura-1-ciclo-rojo-verde-refactor.png){width=85%}

## Anexo E. Código de la demostración con JUnit 5

Proyecto Maven `demo-tdd/` (JUnit 5, Java 17). Clase probada:

```java
public class CalculadoraDescuento {
    static final double UMBRAL = 100.0;
    static final double TASA_DESCUENTO = 0.10;

    public double calcularTotal(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
        return monto >= UMBRAL ? monto * (1 - TASA_DESCUENTO) : monto;
    }
}
```

Las pruebas (CP-01 a CP-04 y una parametrizada) están en `CalculadoraDescuentoTest.java`. La bitácora del ciclo está en el archivo `bitacora-ciclo-tdd.md`.
