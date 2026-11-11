# Abstract

> Tarea 11 · Responsable: Maykel Meoño González · Revisa: Valery Salas Vargas
> Mínimo 150 palabras, en inglés (253 palabras). Alineado el 11-nov con el resumen ejecutivo (tarea 10) y las conclusiones (tarea 12).
> ⚠ Si cambia el resumen, las conclusiones o la demostración (por ejemplo, al correr `mvn test` con JUnit), hay que volver a revisar este texto.

**Abstract**

This report examines test cases, unit tests, and test-driven development (TDD) in order to answer one question: should TDD be applied in every software project? The study is documentary and qualitative, and it draws on eight sources, including the ISTQB Foundation Level syllabus, the JUnit 5 user guide, and an empirical study of the TDD process. The concepts are applied to a small case, a requirement that grants a 10% discount, which is analysed in two parts. The first part traces the path from requirement to acceptance criterion, test case, and expected result. It identifies seven ambiguities in the requirement and designs ten test cases, one of which belongs to another test level, using equivalence partitioning, boundary value analysis, and error guessing. The second part describes unit tests, isolation, assertions, and the Arrange–Act–Assert structure. It walks through a red–green–refactor cycle on a small Java example and discusses brittle tests and the false sense of security that a passing test suite can create. The conclusion is conditional. TDD is worthwhile when business rules are clear, the code will be maintained and refactored, and the team can work in small, uniform steps. It is less suitable for disposable prototypes, for requirements that are still being explored, or when integration, interface, or performance must be validated. The empirical study suggests that the benefit may come from working in small, uniform steps rather than from writing the test first. However, most of the evidence is normative or based on professional experience, so the conclusion cannot be generalised.

**Keywords:** test cases, unit testing, test-driven development, JUnit 5, boundary value analysis

---

**Notas para la revisión (se borran antes de pasar al Word):**
- Valery: el resumen ejecutivo dice «diez casos: dos normales, seis de límite y dos de error, más uno de otro nivel». Eso suma 11, porque CP-08 se cuenta como límite y como error. El abstract dice «diez casos, uno de ellos de otro nivel» (CP-01 a CP-10). Conviene igualar el resumen.
- El abstract no menciona JUnit en la demostración a propósito: el ciclo se observó con un arnés sin JUnit (ver Desarrollo B, secc. 2.1). Si se corre `mvn test`, se puede decir que se ilustra «con JUnit 5».
- Revisión de inglés: se usa ortografía británica (*analysed*, *generalised*). Si prefieren la estadounidense, cambiarlo en todo el texto.
