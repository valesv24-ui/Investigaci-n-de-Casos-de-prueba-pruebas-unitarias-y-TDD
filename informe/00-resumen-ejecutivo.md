# Resumen ejecutivo

> Tarea 10 · Responsable: Valery Salas Vargas · Revisa: Maykel Meoño González · Mínimo 150 palabras · Debe coincidir con el *abstract* (tarea 11)

Este informe analiza los casos de prueba, las pruebas unitarias y el desarrollo guiado por pruebas (TDD) para responder la pregunta **¿conviene aplicar TDD en todos los proyectos de software?** La investigación es documental y cualitativa. Se basa en ocho fuentes:
- normas y documentos de organismos internacionales: el programa ISTQB de nivel básico y la norma ISO/IEC/IEEE 29119-1;
- un libro de texto de ingeniería del software: Pressman;
- documentación técnica y artículos de referencia profesional: JUnit 5, Agile Alliance, Vocke y Fowler;
- un estudio empírico sobre el proceso de TDD: Fucci et al., 2017.

Los conceptos se aplicaron a un caso concreto, un requisito que otorga un descuento del 10 %. El análisis tiene dos partes:
- **Casos de prueba.** Se trazó la cadena requisito → criterio de aceptación → caso de prueba → resultado esperado. Se identificaron siete ambigüedades del requisito, con la pregunta que habría que hacerle al cliente en cada una. Con partición de equivalencia, valores límite y conjetura de errores se diseñaron diez casos: nueve unitarios (dos normales, cinco de límite, uno de error y uno que es de límite y de error a la vez) y uno que corresponde a otro nivel de prueba.
- **Pruebas unitarias y TDD.** Se describieron la prueba unitaria, el aislamiento, las aserciones y la estructura Arrange–Act–Assert, el ciclo rojo–verde–refactor y los riesgos de las pruebas frágiles y de la falsa sensación de seguridad. El ciclo se recorrió con un ejemplo pequeño en Java: cada prueba nueva se vio fallar y luego pasar. Al introducir a propósito el error de usar `>` en lugar de `>=`, solo la prueba del valor exacto 100 lo detectó.

**La conclusión es condicionada: TDD no conviene en todos los proyectos.** Conviene cuando hay reglas de negocio claras, cuando el código se va a mantener y refactorizar y cuando el equipo trabaja en pasos pequeños y uniformes. Aporta poco en prototipos desechables, cuando el requisito todavía se está explorando o cuando lo que hay que validar es la integración, la interfaz o el rendimiento. El estudio empírico consultado indica que el beneficio estaría más en trabajar en pasos pequeños que en escribir la prueba primero. Aun así, la mayor parte de la evidencia es normativa o de experiencia profesional, por lo que la conclusión no se generaliza.

---

**Notas para la revisión (se borran antes de pasar al Word):**
- El ciclo se observó con un arnés mínimo en Java, no con JUnit. Si se corre `mvn test`, se puede decir «con JUnit 5», aquí y en el *abstract*.
