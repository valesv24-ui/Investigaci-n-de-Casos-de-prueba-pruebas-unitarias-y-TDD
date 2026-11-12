# Control de correspondencia entre apartados

> Tarea 17 · Ambos · Fecha límite: jue 12 nov · Revisado contra la guía (secciones 2, 3 y 4) el 12-nov-2026, con lo que está en el repositorio.
> Estado: ✅ cumple · ⚠ falta algo · ❌ no está.

## Tabla de la guía

| Estructura | Verificación antes de entregar | Estado | Qué falta | Quién |
|---|---|---|---|---|
| Portada / índice | Portada integrada de Word; índice automático actualizado y paginado | ❌ | El documento Word no está armado | Maykel |
| Resúmenes | Resumen ejecutivo ≥ 150 palabras; *abstract* en inglés ≥ 150 palabras | ⚠ | Las extensiones cumplen (≈ 480 y ≈ 250). El *abstract* debe actualizarse con la pregunta central y el caso de la guía (clientes frecuentes, 10 ambigüedades, 12 casos) | Maykel |
| Introducción | Más extensa y detallada que el resumen ejecutivo | ✅ | ≈ 750 palabras frente a ≈ 480 | — |
| Metodología ↔ lecciones | Al menos cinco pasos; una lección por paso | ⚠ | 7 pasos. Entre los dos archivos se cubren los 7 pasos. Las de Valery ya tienen las tres partes que pide la guía (aprendizaje, dificultad y mejora). A las de Maykel les falta la columna «qué se mejoraría» | Maykel |
| Planificación / desarrollo | Plan y resultados distinguibles; consignas reproducidas en subtítulos del desarrollo | ⚠ | Desarrollo A ✅. En el Desarrollo B los subtítulos no reproducen las consignas de la ficha, y la pregunta 3 está respondida con otra redacción (ver abajo). En la planificación faltan «consultas previstas» y «criterios para escoger las fuentes», que la guía pide (sección 3, punto 08) | Maykel |
| Citas, bibliografía e IA | Fuentes verdaderas y comprobables; APA; declaración transparente del uso de IA | ✅ | Todas las obras citadas están en la lista y todas las de la lista se citan. Pressman se verificó el 12-nov con un ejemplar digital: © 2010, traductores y citas de las p. 385 y 425 | — |
| Encabezado / pie / archivo | Datos completos en todas las páginas; numeración automática; nombre correcto | ❌ | Se hace en Word: encabezado con el curso, los dos nombres completos, el facilitador, la investigación y el grupo; número de página en el pie, sin numerar la portada. El archivo debe llamarse `ISW-622-Grupo02-InformeDeInvestigación_ValerySalasVargas_MaykelMeoñoGonzález.pdf` | Maykel, revisa Valery |

## Otros requisitos de la guía

| Requisito | Dónde lo pide | Estado | Nota |
|---|---|---|---|
| Orden obligatorio de los 13 componentes, sin unirlos ni omitirlos | Secc. 3 | ⚠ | Al armar el Word, seguir este orden: portada, índice, resumen ejecutivo, (encabezado), *abstract*, introducción, metodología, planificación, desarrollo, conclusiones, lecciones, referencias, anexos. La postura sobre TDD va dentro del desarrollo o de las conclusiones, no como apartado aparte |
| Estilos Título 1, 2 y 3 de Word | Secc. 2 | ❌ | Para que el índice sea automático |
| Portada con fecha en formato largo | Secc. 3, punto 01 | ❌ | «sábado, 14 de noviembre del 2026» |
| Al menos 6 fuentes, 3 técnicas primarias u oficiales | Secc. 4 | ✅ | 8 fuentes. Oficiales: ISTQB, ISO/IEC/IEEE 29119-1 y la guía de JUnit 5 |
| Matriz de lectura crítica con 4 columnas, en el informe o los anexos | Secc. 2 y 4 | ✅ | Tabla resumen agregada el 12-nov. Hay que copiarla al Anexo A, porque la copia actual del anexo tiene páginas viejas (p. 40 en lugar de p. 40–41) |
| Pregunta central y conclusión exigida | Ficha del Tema 2 | ✅ | En la introducción, el resumen, las conclusiones y la postura. Las conclusiones responden qué cambia en el razonamiento del equipo y por qué más pruebas no equivale a más calidad |
| Preguntas de debate 1, 2 y 3 | Ficha del Tema 2 | ⚠ | 1 y 2 ✅ en el Desarrollo A. La 3 debe rehacerse en el Desarrollo B |
| Presentación: al menos 15 diapositivas, PowerPoint u otro formato entregable, sin Gamma | Secc. 2 | ⚠ | El contenido de las diapositivas de Valery está listo. Falta montarlas con las de Maykel |
| Actividad práctica de cierre | Secc. 1 | ⚠ | Diseño a cargo de Maykel; no está en el repositorio |
| Exposición: ambos exponen y defienden | Secc. 2 | — | Ensayo del viernes 13 |

## Pendientes para Maykel por la guía

1. **Pregunta de debate 3.** La guía la formula así: *«¿Cuándo aportaría valor escribir primero las pruebas y cuándo podría generar trabajo inútil?»*. La respuesta actual del Desarrollo B trata otra cosa (si una suite en verde da confianza). La sección 2.2 del Desarrollo B y la tabla de la postura ya tienen material para responderla.
2. **Subtítulos del Desarrollo B con las consignas textuales:**
   - «Prueba unitaria, aislamiento, aserciones y estructura AAA (Preparar–Actuar–Afirmar).»
   - «Ciclo de TDD: rojo, verde y refactorización; qué pretende prevenir y qué no garantiza.»
   - «Pruebas mantenibles, pruebas frágiles y el riesgo de una falsa sensación de seguridad.»
3. **Caso del Desarrollo B.** Hay que cambiar «el requisito R-01 (descuento del 10 % a las compras de 100 o más)» por la regla aclarada del Desarrollo A, sección 3.3. La demostración cubre la regla de monto para un cliente ya clasificado como frecuente.
4. **Anexos.** El comentario de la clase en el Anexo E dice «R-01: el sistema aplica un descuento del 10 % a las compras de 100 o más». Hay que ajustarlo, igual que el comentario de `CalculadoraDescuento.java`. También hay que actualizar la copia de la matriz del Anexo A.
5. **Planificación.**
   - Agregar las consultas previstas (por ejemplo, al profesor: formato del archivo y año de Pressman, que resultó ser 2010) y los criterios para escoger las fuentes.
   - Cambiar «Caso del descuento del 10 %» por «Caso de los clientes frecuentes» en la tabla de la presentación.
6. **Abstract.** Actualizar la pregunta central, el caso y las cifras (10 ambigüedades y 12 casos). La guía pide que explique «las instrucciones de la asignación, el alcance del tema y las actividades solicitadas».
7. **Lecciones de Maykel.** Agregar la columna «qué se mejoraría» y las dos correcciones ya comentadas: el esfuerzo de refactorización también es significativo, y lo de Vocke lo encontró él mismo.
