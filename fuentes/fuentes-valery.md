# Fuentes de Valery · Tarea 1 (límite: mar 3 nov) · Revisa: Maykel

Estado: datos bibliográficos verificados en línea el 1 nov 2026.
Falta: que Valery abra cada original y confirme la cita exacta y la página (regla 2 de la pareja).

---

## Fuente 1 · ISTQB CTFL v4.0

**APA 7**
International Software Testing Qualifications Board. (2024). *Certified Tester Foundation Level syllabus* (Versión 4.0.1). https://www.istqb.org/wp-content/uploads/2024/11/ISTQB_CTFL_Syllabus_v4.0.1.pdf

- La v4.0 salió el 21-04-2023. La v4.0.1 (15-09-2024) es la versión de mantenimiento vigente en istqb.org.
- Si el profesor exige la 4.0 exacta, se cita como «(2023) ... (Versión 4.0)».
- PDF gratuito y oficial.

**Qué respalda (para el Desarrollo A, la Metodología y la Introducción)**
| Sección | Contenido | Uso en el informe |
|---|---|---|
| 1.4.1 Actividades y tareas de prueba | Las condiciones de prueba se elaboran como casos de prueba | Cadena requisito → criterio → caso |
| 1.4.4 Trazabilidad entre la base de prueba y el testware | «establish and maintain traceability throughout the test process between the test basis elements» | Trazabilidad |
| 2.1.3 Las pruebas como impulsoras del desarrollo | TDD «directs the coding through test cases»; ATDD deriva pruebas de los criterios de aceptación | Puente con la parte B de Maykel |
| 2.2.1 Niveles de prueba | Prueba de componente (= unitaria) «focuses on testing components in isolation» | Definición de unitaria |
| 4.2.1 Partición de equivalencia | Particiones sin traslape y no vacías; una prueba por partición | Cobertura de casos normales y de error |
| 4.2.2 Análisis de valores límite | BVA de 2 valores y de 3 valores; el de 3 valores es más riguroso | Cobertura de límites (caso de los clientes frecuentes) |
| 4.5.2 / 4.5.3 Criterios de aceptación y ATDD | Criterios de aceptación como base de las pruebas | Requisito → criterio de aceptación |

Las páginas varían entre la 4.0 y la 4.0.1, así que se anotan con el PDF abierto.

---

## Fuente 2 · ISO/IEC/IEEE 29119

**APA 7**
International Organization for Standardization, International Electrotechnical Commission, & Institute of Electrical and Electronics Engineers. (2022). *Software and systems engineering — Software testing — Part 1: General concepts* (ISO/IEC/IEEE 29119-1:2022). https://webstore.iec.ch/publication/74072

- 2.ª edición, publicada el 04-02-2022, 47 páginas, comité ISO/IEC JTC 1/SC 7.
- Alcance oficial: «specifies general concepts in software testing and presents key concepts for the ISO/IEC/IEEE 29119 series».
- **Es una norma de pago.** Para abrir el original: biblioteca de la UTN, o la vista gratuita de términos y definiciones en ISO OBP (https://www.iso.org/obp).

**Qué respalda**
- Vocabulario formal: caso de prueba, base de prueba, condición de prueba, ítem de cobertura.
- Respaldo normativo para la Introducción («existe un estándar internacional de pruebas»).

**Partes opcionales** (si se quiere más detalle; también son de pago):
- 29119-4:2021 *Test techniques*: partición de equivalencia y valores límite.
- 29119-3:2021 *Test documentation*: formato de especificación de casos de prueba.

---

## Fuente 3 · Pressman

**APA 7**
Pressman, R. S. (2010). *Ingeniería del software: Un enfoque práctico* (7.ª ed.). McGraw-Hill.

- La 7.ª edición en español es de México, McGraw-Hill, c2010, ISBN 978-607-15-0314-5, 777 p.
- **No se encontró ninguna edición de 2012** en los catálogos consultados. Hay que revisar la página legal del ejemplar que se use:
  - Si es una reimpresión de 2012 de la 7.ª edición, APA 7 cita el año del copyright (2010).
  - Hay que confirmar con el profesor si «Pressman (2012)» de la guía se refiere a esta edición.
- Hay que agregar los traductores como aparecen en el ejemplar: (Nombre Apellido, Trad.; 7.ª ed.).

**Qué respalda** (confirmar los capítulos en el ejemplar; en la 7.ª ed. son aprox. los cap. 17–18)
- Estrategias de prueba y prueba de unidad dentro del proceso de ingeniería.
- Pruebas de caja negra: partición de equivalencia y valores límite, como enfoque clásico que complementa al ISTQB.
- Contexto de ingeniería para la Introducción y la Metodología.

---

## Pendientes antes del martes
- [ ] Abrir los 3 originales y anotar la página de cada afirmación citada.
- [ ] Confirmar el año y los traductores de Pressman en el ejemplar.
- [ ] Conseguir acceso a la norma 29119-1 (biblioteca UTN / ISO OBP).
- [ ] Registrar en la bitácora de IA: Claude (claude-opus-5-5), 1 nov 2026, «buscar y verificar ISTQB CTFL v4.0, ISO/IEC/IEEE 29119 y Pressman (2012) en APA». Se aprovechó: datos bibliográficos y el mapeo de secciones.
- [ ] Revisar las 3 fuentes de Maykel (JUnit 5, Beck/Agile Alliance, Fowler).
