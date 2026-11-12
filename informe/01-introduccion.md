# Introducción

> Tarea 6 · Responsable: Valery Salas Vargas · Revisa: Maykel Meoño González

## Contexto

Un defecto de software se vuelve más caro de corregir cuanto más tarde se detecta. Por eso la ingeniería del software considera las pruebas parte del proceso de desarrollo y no solo una revisión al final (Pressman, 2010). Hay un estándar internacional, la serie ISO/IEC/IEEE 29119, cuya primera parte «specifies general concepts in software testing» (ISO et al., 2022). El ISTQB, por su parte, define el vocabulario y las técnicas que usa la industria para diseñar pruebas (ISTQB, 2024).

Este informe trabaja con tres conceptos. El primero es el **caso de prueba**, que traduce un requisito y su criterio de aceptación en entradas concretas con un resultado esperado verificable. El segundo es la **prueba unitaria**, que el ISTQB define como la prueba que «focuses on testing components in isolation» (2024, p. 29). El tercero es el **desarrollo guiado por pruebas (TDD)**, que lleva la idea más lejos: la prueba se escribe antes que el código y «directs the coding through test cases» (ISTQB, 2024, p. 26). TDD aplica el principio de probar temprano, o *shift left* (ISTQB, 2024, p. 26).

En la práctica, adoptar TDD tiene costos. Hay que escribir y mantener las pruebas, el equipo necesita disciplina y, si las pruebas están mal diseñadas, pueden romperse con cada cambio o dar una falsa sensación de seguridad. Por eso, en un equipo de desarrollo no se discute si probar o no, sino **cuánto y cuándo** conviene probar primero.

El tema es relevante para la calidad porque una prueba solo aporta evidencia si se deriva de un requisito claro. El caso que plantea la guía lo muestra: un equipo recibe el requisito «el sistema aplicará descuentos correctos a los clientes frecuentes», un desarrollador escribe una sola prueba que confirma un 10 % y da la funcionalidad por terminada, y otra persona propone aclarar las reglas antes de escribir más pruebas. La investigación usa ese caso para analizar qué hace útil a una prueba y cuándo conviene escribirla primero.

## Pregunta central

> **¿Es razonable defender TDD en todos los proyectos o su utilidad depende del problema, el equipo y los requisitos?**

## Objetivos

**Objetivo general:** determinar si TDD puede defenderse en todos los proyectos o en qué condiciones de problema, equipo y requisitos resulta útil. Para eso se analiza cómo un requisito se transforma en una comprobación útil, con base en fuentes normativas, técnicas y académicas.

**Objetivos específicos:**
1. Explicar la cadena requisito → criterio de aceptación → caso de prueba → resultado esperado y la trazabilidad entre sus elementos. *(Desarrollo A)*
2. Identificar las ambigüedades del requisito de descuentos a clientes frecuentes, la información que debe deducirse o preguntarse y los casos normales, límite y de error necesarios para juzgar si se cumplió. *(Desarrollo A)*
3. Describir la prueba unitaria (aislamiento, aserciones y la estructura Arrange–Act–Assert), el ciclo rojo–verde–refactor, qué pretende prevenir y qué no garantiza, y los riesgos de las pruebas frágiles. *(Desarrollo B)*
4. Formular una postura condicionada sobre TDD que diga cuándo sí y cuándo no conviene, qué cambia en el razonamiento del equipo y por qué más pruebas no equivale automáticamente a mejor calidad. *(Conclusión)*

## Alcance

**Incluye:**
- casos de prueba y técnicas de caja negra para diseñarlos (partición de equivalencia, valores límite y conjetura de errores);
- pruebas unitarias, ilustradas con JUnit 5;
- TDD y su relación con ATDD.

Se toma como caso de estudio la situación de la ficha del Tema 2: el requisito de descuentos a clientes frecuentes.

**No incluye:**
- pruebas de integración, de sistema, de rendimiento y de seguridad, que solo se mencionan para ubicar las pruebas unitarias dentro de los niveles de prueba;
- la medición de la cobertura de código con herramientas;
- la comparación de *frameworks* de pruebas.

**Límites de la evidencia:** la investigación es documental. Las fuentes principales son normativas y de experiencia profesional; solo una aporta evidencia empírica (Fucci et al., 2017), y la demostración práctica es pequeña e ilustrativa. Por eso las conclusiones sobre TDD se presentan como condicionadas, no como generalizables a todos los proyectos.

## Organización del informe

1. La **metodología** describe los siete pasos de la investigación.
2. El **Desarrollo A** trata los casos de prueba y su trazabilidad, y responde las preguntas de debate 1 y 2 sobre el caso de los clientes frecuentes.
3. El **Desarrollo B** trata las pruebas unitarias y el ciclo de TDD, y responde la pregunta de debate 3.
4. Al final están la postura sobre TDD, las conclusiones y las lecciones aprendidas.

---

**Notas para la revisión (se borran antes de pasar al Word):**
- Pressman (2010): falta la página de la idea «las pruebas son parte del proceso». Valery la agrega con el libro abierto (cap. de estrategias de prueba).
