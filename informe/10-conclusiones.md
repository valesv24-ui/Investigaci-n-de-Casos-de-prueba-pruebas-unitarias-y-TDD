# Conclusiones

> Tarea 12 · Responsable: Valery Salas Vargas · Revisa: Maykel Meoño González

## Qué logró la investigación

La investigación siguió un requisito desde su redacción hasta sus pruebas. El requisito «el sistema aplicará descuentos correctos a los clientes frecuentes» no se puede verificar tal como está escrito. Al identificar sus diez ambigüedades y reconstruir la cadena requisito → criterio → caso → resultado esperado, se obtuvieron doce casos trazables. La única prueba del desarrollador equivale a uno de ellos. Con ese análisis, el material de las fuentes y una demostración pequeña del ciclo rojo–verde–refactor, el equipo formuló una respuesta a la pregunta central.

## Respuesta a la pregunta central

**¿Es razonable defender TDD en todos los proyectos o su utilidad depende del problema, el equipo y los requisitos? Su utilidad depende de los tres.** La evidencia revisada sostiene que TDD es valiosa en ciertas condiciones, pero no justifica imponerla como regla universal.

1. **Antes de discutir TDD hay que tener un requisito verificable.** En el caso de la guía, la prueba del 10 % no se puede juzgar como suficiente porque no existe un criterio de aceptación contra el cual medirla. Mientras no se defina qué es un «cliente frecuente» y un «descuento correcto», ninguna prueba, escrita antes o después del código, demuestra que el requisito se cumplió. Escribir la prueba primero tiene un efecto útil: obliga a hacer esas preguntas antes de programar.

2. **Una suite es suficiente por lo que cubre, no por cuántas pruebas tiene.** Una suite se considera suficiente cuando cubre cada criterio, cada partición y cada frontera (ISTQB, 2024). La demostración lo confirmó: al cambiar a propósito `>=` por `>`, la prueba de 99,99 siguió pasando y solo la del valor exacto 100 falló.

3. **El ciclo rojo–verde–refactor da seguridad para cambiar el código, siempre que las pruebas verifiquen comportamiento.** Si dependen de la estructura interna se vuelven frágiles y encarecen el refactor (Vocke, 2018). Si tienen aserciones débiles o les faltan casos límite, dan una falsa sensación de seguridad.

4. **El beneficio de TDD podría estar en el ritmo y no en el orden.** En el estudio de Fucci et al. (2017), el orden en que se escriben prueba y código no tuvo una influencia importante. Los ciclos más cortos se asociaron con mejor calidad, aunque con un efecto débil. Eso no prueba que los pasos pequeños sean la causa, pero sí debilita el argumento de que escribir la prueba primero es indispensable.

**Postura.** TDD conviene cuando:
- hay reglas de negocio con entradas y salidas definidas;
- el código se va a mantener y refactorizar;
- el equipo puede sostener la disciplina de pasos pequeños.

Conviene menos, o conviene otra práctica, cuando:
- el requisito todavía se explora y va a cambiar;
- el código es un prototipo desechable;
- lo que hay que validar es la integración, la interfaz o el rendimiento.

## Qué cambia en el razonamiento del equipo

TDD cambia la pregunta con la que el equipo empieza. En lugar de «¿cómo programo esto?», la pregunta pasa a ser «¿cómo sabré que esto está bien?». En el caso de la guía, el desarrollador razonó al revés: programó, confirmó lo que ya creía y declaró terminado. La persona que propuso aclarar las reglas razonó como pide TDD: sin un resultado esperado definido no hay prueba que escribir.

Ese cambio tiene tres efectos:
- las ambigüedades aparecen antes de escribir código;
- el criterio de «terminado» deja de ser una opinión y pasa a ser un conjunto de casos que pasan;
- cada prueba queda trazada a una regla del negocio.

Ese cambio de razonamiento es lo más valioso de TDD, y también se puede aplicar sin escribir las pruebas antes del código.

## Por qué más pruebas no equivale automáticamente a mejor calidad

- **Más pruebas sobre un requisito ambiguo solo multiplican la suposición inicial.** Diez pruebas del 10 % no dicen más que una si nadie confirmó que el 10 % es lo correcto.
- **Más pruebas en la misma partición casi no encuentran defectos nuevos.** Una prueba bien elegida en la frontera detecta lo que muchas en el centro dejan pasar.
- **Cada prueba tiene costo.** Vocke (2018) advierte que «every single test in your test suite is additional baggage and doesn't come for free». Las pruebas frágiles o duplicadas consumen tiempo de mantenimiento sin proteger más.
- **Una suite en verde demuestra que pasan los casos escritos, no que no haya defectos.** La calidad la determinan la pertinencia de los casos y su trazabilidad a los criterios, no su número.

## Límites de la evidencia

- **Predomina la evidencia normativa y de experiencia profesional.** Seis de las ocho fuentes (ISTQB, ISO/IEC/IEEE 29119-1, Pressman, JUnit 5, Agile Alliance y Vocke) describen o recomiendan, pero no miden resultados. Fowler aporta solo la descripción del ciclo.
- **Hay una sola fuente empírica.** Fucci et al. (2017) es un estudio observacional, sin grupo de control, con 39 profesionales de dos empresas y tres tareas cortas. Sirve para matizar la postura, no para generalizar.
- **El caso es pequeño y sus reglas son supuestas.** Las reglas de frecuencia, monto y redondeo las supuso el equipo, porque no hubo un cliente real a quien preguntar. Con otras respuestas cambian los casos, aunque no el método.
- **El ciclo no se observó con JUnit.** Las fases se observaron con un arnés mínimo en Java. La suite final sí se ejecutó con JUnit 5.9.2 (`mvn test`, 9 pruebas en verde), pero eso no repite las fases en rojo. Además, solo cubre la regla de monto, no la clasificación por frecuencia (CP-11 y CP-12).

## Pendientes y qué podría mejorarse

1. Automatizar CP-11 y CP-12, la clasificación de cliente frecuente, con una segunda unidad que cuente las compras.
2. Repetir el ciclo completo con JUnit, para observar también las fases en rojo con la herramienta (la suite final ya se ejecutó con `mvn test`).
3. Verificar las citas de Fucci et al. (2017) en la versión publicada por IEEE.
4. Dejar fuera del análisis A7, A8 y A10 (promociones combinadas, exclusiones y momento de evaluación) fue una simplificación. Un análisis más completo las incluiría.
5. Para investigaciones futuras, buscar estudios controlados de larga duración que comparen test-first y test-last con la misma granularidad. Esa evidencia permitiría confirmar o cambiar esta conclusión.
