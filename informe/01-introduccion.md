# Introducción

> Tarea 6 · Responsable: Valery Salas Vargas · Revisa: Maykel Meoño González

## Contexto

Un defecto de software se vuelve más caro de corregir cuanto más tarde se detecta. Por eso la ingeniería del software considera las pruebas parte del proceso de desarrollo y no solo una revisión al final (Pressman, 2010). Hay un estándar internacional, la serie ISO/IEC/IEEE 29119, cuya primera parte «specifies general concepts in software testing» (ISO et al., 2022). El ISTQB, por su parte, define el vocabulario y las técnicas que usa la industria para diseñar pruebas (ISTQB, 2024).

Este informe trabaja con tres conceptos. El primero es el **caso de prueba**, que traduce un requisito y su criterio de aceptación en entradas concretas con un resultado esperado verificable. El segundo es la **prueba unitaria**, que el ISTQB define como la prueba que «focuses on testing components in isolation» (2024, p. 28). El tercero es el **desarrollo guiado por pruebas (TDD)**, que lleva la idea más lejos: la prueba se escribe antes que el código y «directs the coding through test cases» (ISTQB, 2024, p. 26). TDD aplica el principio de probar temprano, o *shift left* (ISTQB, 2024, p. 26).

En la práctica, adoptar TDD tiene costos. Hay que escribir y mantener las pruebas, el equipo necesita disciplina y, si las pruebas están mal diseñadas, pueden romperse con cada cambio o dar una falsa sensación de seguridad. Por eso, en un equipo de desarrollo no se discute si probar o no, sino **cuánto y cuándo** conviene probar primero.

## Pregunta central

> **¿Conviene aplicar TDD en todos los proyectos de software?**

## Objetivos

**Objetivo general:** determinar en qué condiciones conviene aplicar TDD en un proyecto de software. Para eso se analiza la relación entre requisitos, casos de prueba y pruebas unitarias con base en fuentes normativas y académicas.

**Objetivos específicos:**
1. Explicar la cadena requisito → criterio de aceptación → caso de prueba → resultado esperado y la trazabilidad entre sus elementos. *(Desarrollo A)*
2. Diseñar casos de prueba normales, límite y de error para el requisito del descuento del 10 %, e identificar las ambigüedades del requisito y las preguntas que habría que hacerle al cliente. *(Desarrollo A)*
3. Describir la prueba unitaria (aislamiento, aserciones y la estructura Arrange–Act–Assert), el ciclo rojo–verde–refactor y los riesgos de las pruebas frágiles. *(Desarrollo B)*
4. Formular una postura condicionada sobre TDD que diga cuándo sí y cuándo no conviene, con su contraargumento y los límites de la evidencia. *(Conclusión)*

## Alcance

**Incluye:**
- casos de prueba y técnicas de caja negra para diseñarlos (partición de equivalencia, valores límite y conjetura de errores);
- pruebas unitarias, ilustradas con JUnit 5;
- TDD y su relación con ATDD.

Se toma como caso de estudio el requisito del descuento del 10 % de la guía del tema.

**No incluye:**
- pruebas de integración, de sistema, de rendimiento y de seguridad, que solo se mencionan para ubicar las pruebas unitarias dentro de los niveles de prueba;
- la medición de la cobertura de código con herramientas;
- la comparación de *frameworks* de pruebas.

**Límites de la evidencia:** la investigación es documental. Las fuentes principales son normativas y de experiencia profesional; solo una aporta evidencia empírica (Fucci et al., 2017), y la demostración práctica es pequeña e ilustrativa. Por eso las conclusiones sobre TDD se presentan como condicionadas, no como generalizables a todos los proyectos.

## Organización del informe

1. La **metodología** describe los siete pasos de la investigación.
2. El **Desarrollo A** trata los casos de prueba y su trazabilidad, aplicados al caso del descuento.
3. El **Desarrollo B** trata las pruebas unitarias y el ciclo de TDD.
4. Al final están la postura sobre TDD, las conclusiones y las lecciones aprendidas.

---

**Notas para la revisión (se borran antes de pasar al Word):**
- Pressman (2010): falta la página de la idea «las pruebas son parte del proceso». Valery la agrega con el libro abierto (cap. de estrategias de prueba).
- Si la guía define la pregunta central con otra redacción, se usa la de la guía.
- Maykel: revisá que el objetivo 3 refleje lo que vas a cubrir en el Desarrollo B.
