# Conclusiones

> Tarea 12 · Responsable: Valery Salas Vargas · Revisa: Maykel Meoño González · Incluye la respuesta a la pregunta central, los pendientes y los límites de la evidencia

## Respuesta a la pregunta central

**¿Conviene aplicar TDD en todos los proyectos de software? No en todos.** La evidencia revisada sostiene que TDD es una práctica valiosa en ciertas condiciones, pero no justifica imponerla como regla universal.

1. **Antes de discutir TDD hay que tener casos de prueba bien diseñados.** El Desarrollo A muestra que un requisito tan corto como «10 % de descuento a compras de 100 o más» contiene al menos siete ambigüedades. Tres de ellas (si 100 está incluido, sobre qué monto se calcula y cómo se redondea) cambian directamente el resultado esperado. Mientras no se respondan, ninguna prueba unitaria, escrita antes o después del código, verifica lo que el cliente necesita. Escribir la prueba primero tiene un efecto positivo: obliga a hacer esas preguntas temprano, cuando corregir es barato.

2. **La trazabilidad y las técnicas de diseño determinan la calidad de una suite.** Con partición de equivalencia bastarían tres casos. Al probar las fronteras con valores límite, el conjunto razonable sube a nueve casos unitarios más uno de otro nivel. Una suite se considera suficiente cuando cubre cada criterio de aceptación, cada partición y cada frontera, no por la cantidad de pruebas (ISTQB, 2024).

3. **El ciclo rojo–verde–refactor aporta seguridad para cambiar el código, siempre que las pruebas verifiquen comportamiento.** Si las pruebas dependen de la estructura interna, se vuelven frágiles y encarecen el refactor (Vocke, 2018). Si tienen aserciones débiles o faltan casos límite, dan una falsa sensación de seguridad.

4. **El beneficio de TDD podría estar en el ritmo y no en el orden.** En el estudio de Fucci et al. (2017), el orden en que se escriben prueba y código no tuvo una influencia importante, y los mejores resultados se asociaron con pasos pequeños y uniformes. Eso debilita el argumento de que escribir la prueba primero es indispensable.

**Postura.** TDD conviene cuando se cumplen estas condiciones:
- hay reglas de negocio con entradas y salidas definidas;
- el código se va a mantener y refactorizar;
- el equipo puede sostener la disciplina de pasos pequeños.

Conviene menos, o conviene otra práctica, en estos casos:
- el requisito todavía se explora y va a cambiar;
- el código es un prototipo desechable;
- lo que hay que validar es la integración, la interfaz o el rendimiento.

En todos los casos, el primer paso es aclarar el requisito y derivar casos de prueba trazables. Esa parte sí aplica a todos los proyectos.

## Límites de la evidencia

- **Predomina la evidencia normativa y de experiencia profesional.** Seis de las ocho fuentes (ISTQB, ISO/IEC/IEEE 29119-1, Pressman, JUnit 5, Agile Alliance y Vocke) describen o recomiendan, pero no miden resultados. Fowler aporta solo la descripción del ciclo.
- **Hay una sola fuente empírica.** Fucci et al. (2017) es un estudio observacional, sin grupo de control, con 39 profesionales de dos empresas y tres tareas cortas. Sus modelos explican una parte pequeña de la variación, así que sirve para matizar la postura, no para generalizar.
- **El caso de estudio es pequeño.** El requisito del descuento tiene una sola regla, sin dependencias externas. No representa la complejidad de un sistema real con integración, datos persistentes o requisitos cambiantes.
- **Algunos supuestos no están confirmados.** Los resultados esperados de los casos límite dependen de supuestos sobre la frontera, el redondeo y la moneda que no fueron confirmados por un cliente real.

## Pendientes

1. Confirmar con el profesor la redacción exacta del requisito del descuento y de las preguntas de debate, y ajustar los casos si cambian las fronteras.
2. Resolver el redondeo de los montos con decimales (caso CP-07: 90,009 o 90,01).
3. Verificar las páginas de todas las citas contra los documentos originales y el volumen y las páginas de Fucci et al. (2017) en la versión publicada por IEEE.
4. Ejecutar las pruebas automatizadas de los casos CP-01 a CP-09 para pasar del resultado esperado al resultado observado.
5. Para investigaciones futuras, buscar estudios controlados de larga duración en proyectos reales que comparen test-first y test-last con la misma granularidad. Esa evidencia permitiría confirmar o cambiar esta conclusión.

---

**Notas para la revisión (se borran antes de pasar al Word):**
- Esta sección debe ser coherente con la postura de la tarea 9. Cuando la cierren juntos, revisar que la lista de cuándo sí y cuándo no coincida.
- El pendiente 4 depende de lo que se decida con la demostración de JUnit que se borró del repositorio.
