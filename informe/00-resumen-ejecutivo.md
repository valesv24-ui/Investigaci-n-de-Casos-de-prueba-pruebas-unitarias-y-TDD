# Resumen ejecutivo

> Tarea 10 · Responsable: Valery Salas Vargas · Revisa: Maykel Meoño González · Mínimo 150 palabras · Debe coincidir con el *abstract* (tarea 11)

Este informe analiza los casos de prueba, las pruebas unitarias y el desarrollo guiado por pruebas (TDD) para responder la pregunta central del Tema 2: **¿es razonable defender TDD en todos los proyectos o su utilidad depende del problema, el equipo y los requisitos?** Se pretende entender cómo un requisito se transforma en una comprobación útil y evaluar críticamente el valor y los límites de las pruebas unitarias y de TDD.

La investigación es documental y cualitativa. Se basa en ocho fuentes:
- normas y documentos de organismos internacionales: el programa ISTQB de nivel básico y la norma ISO/IEC/IEEE 29119-1;
- un libro de texto de ingeniería del software: Pressman;
- documentación técnica y artículos de referencia profesional: JUnit 5, Agile Alliance, Vocke y Fowler;
- un estudio empírico sobre el proceso de TDD: Fucci et al., 2017.

Los conceptos se aplicaron al caso de la guía: un equipo recibe el requisito «el sistema aplicará descuentos correctos a los clientes frecuentes» y un desarrollador lo da por terminado con una sola prueba que confirma un 10 %. El análisis tiene dos partes:
- **Casos de prueba.** Se mostró que la cadena requisito → criterio de aceptación → caso de prueba → resultado esperado se rompe porque falta el criterio. Se identificaron diez ambigüedades, se separó la información que puede deducirse de la que debe preguntarse y, con reglas supuestas, se diseñaron doce casos normales, de límite y de error. La prueba original equivale a uno de ellos.
- **Pruebas unitarias y TDD.** Se describieron la prueba unitaria, el aislamiento, las aserciones, la estructura Arrange–Act–Assert, el ciclo rojo–verde–refactor y los riesgos de las pruebas frágiles y de la falsa sensación de seguridad. El ciclo se recorrió con un ejemplo pequeño en Java. Al introducir a propósito el error de usar `>` en lugar de `>=`, solo la prueba del valor exacto de la frontera lo detectó.

**La conclusión es condicionada: TDD no puede defenderse en todos los proyectos.** Conviene cuando hay reglas de negocio claras, cuando el código se va a mantener y refactorizar y cuando el equipo puede trabajar en pasos pequeños. Aporta poco en prototipos desechables, cuando el requisito todavía se está explorando o cuando hay que validar la integración, la interfaz o el rendimiento. Lo que sí aplica siempre es aclarar el requisito antes de probar: más pruebas sobre un requisito ambiguo no equivalen a más calidad. El estudio empírico consultado no encontró un efecto importante del orden en que se escriben las pruebas. Además, la mayor parte de la evidencia es normativa o de experiencia profesional, por lo que la conclusión no se generaliza.

Los resultados sirven a equipos de desarrollo y de pruebas para decidir cuándo adoptar TDD y para evaluar si una prueba realmente demuestra que un requisito se cumplió.

---

**Notas para la revisión (se borran antes de pasar al Word):**
- El ciclo se observó con un arnés mínimo en Java, no con JUnit. Si se corre `mvn test`, se puede decir «con JUnit 5», aquí y en el *abstract*.
