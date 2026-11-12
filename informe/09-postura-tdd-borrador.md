# Postura condicionada sobre TDD

> Tarea 9 · Responsables: ambos · Integra el lado técnico (Desarrollo B, Maykel) y los argumentos del Desarrollo A (Valery), y coincide con las conclusiones (tarea 12). Pesos y postura aprobados por Valery el 12-nov-2026. Es la postura que defienden los dos.

## Pregunta central

¿Es razonable defender TDD en todos los proyectos o su utilidad depende del problema, el equipo y los requisitos?

## Respuesta corta

**Su utilidad depende del problema, el equipo y los requisitos.** TDD conviene cuando el comportamiento esperado es claro, el código va a cambiar y mantenerse durante tiempo, y el equipo puede sostener la disciplina de pruebas pequeñas. Conviene menos, o conviene otra práctica, cuando el requisito todavía se está explorando, cuando el código es descartable, o cuando lo que importa probar no es una unidad aislada.

## Tabla de argumentos (instrumento del paso 6)

| Condición del proyecto | A favor de TDD | En contra / matiz | Fuente | Peso |
|---|---|---|---|---|
| Requisito claro y lógica de negocio con reglas (como el descuento a clientes frecuentes, una vez aclaradas las reglas) | Los casos salen del criterio de aceptación y las pruebas guían el diseño | Si el requisito está mal entendido, las pruebas confirman el error | ISTQB (2024, p. 26); Vocke (2018) | Alto |
| Código que se mantendrá y refactorizará | Las pruebas en verde dan margen para refactorizar | Las pruebas frágiles encarecen el refactor. Fowler (2023) advierte que omitir el paso de refactor es la forma más común de hacer mal TDD | Fowler (2023); Vocke (2018) | Alto |
| Equipo con poca experiencia en pruebas | Obliga a pensar el diseño y la interfaz antes de codificar | Curva de aprendizaje; riesgo de pruebas mal diseñadas o aserciones débiles | Sin fuente verificada: es una inferencia del equipo (Desarrollo B, secc. 4) | Bajo |
| Defectos y calidad externa | Equipos reportan reducciones de defectos, a cambio de más esfuerzo inicial | Ese beneficio es un testimonio y la entrada no cita estudios. El estudio empírico no encontró efecto importante del orden test-first | Agile Alliance (s. f.); Fucci et al. (2017) | Medio |
| Plazos cortos o prototipo descartable | Detecta errores temprano | Cada prueba tiene costo de escritura y mantenimiento | Vocke (2018) | Medio |
| Interfaces, integración o rendimiento | — | La prueba unitaria no cubre esos niveles; se necesitan otras pruebas | ISTQB (2024); Vocke (2018) | Alto |
| Requisito con ambigüedades sin resolver (como «cliente frecuente» y «descuento correcto» en el caso de la guía) | Escribir los casos antes del código obliga a detectar las ambigüedades y preguntar temprano | Si se resuelven suponiendo, TDD produce pruebas en verde que confirman un requisito mal entendido | Desarrollo A, secc. 2 y 6; ISTQB (2024, p. 45–46) | Alto |
| Necesidad de trazabilidad (auditoría, cambios frecuentes del requisito) | Cada prueba nace de un criterio de aceptación, así que la trazabilidad queda incorporada (IDs CP-xx en las pruebas) | La trazabilidad también se logra con pruebas escritas después, si se documenta la matriz | Desarrollo A, secc. 5; ISTQB (2024, p. 20) | Medio |

## Cuándo sí

1. Hay reglas de negocio con entradas y salidas bien definidas.
2. El código va a evolucionar y se necesita refactorizar con seguridad.
3. El equipo puede trabajar en pasos pequeños. En el estudio de Fucci et al. (2017), los ciclos más cortos se asociaron con mejor calidad. Es una señal débil (un solo coeficiente significativo, p = 0,04), así que se presenta como condición favorable, no como garantía.

En todos los casos, el primer paso es aclarar el requisito y derivar casos de prueba trazables (Desarrollo A). Esa parte sí aplica a todos los proyectos.

## Cuándo no (o cuándo conviene otra cosa)

1. El requisito aún se explora y cambiará por completo: conviene primero aclarar con el cliente.
2. Código desechable o prototipos de corta vida.
3. Lo que se necesita validar es la integración, la interfaz de usuario o el rendimiento, donde las pruebas unitarias aportan poco.

## Contraargumento principal y respuesta

**Contraargumento.** «Escribir la prueba primero es lo que hace valioso a TDD, por lo tanto debería aplicarse siempre.»

**Respuesta.** La evidencia disponible lo matiza. En el estudio de Fucci et al. (2017), el orden en que se escriben prueba y código «had no important influence», y los resultados se asociaron con pasos pequeños y uniformes. Eso sugiere que el beneficio puede estar en el ritmo de trabajo y no en el orden. Aun así, el estudio no usa grupo de control, tiene pocas tareas y no mide mantenibilidad a largo plazo. Además, de los factores de ritmo solo la granularidad frente a la calidad es significativa al nivel de 0,05, y los modelos explican poco de la variación (R² ajustado de 0,10 a 0,12). No permite concluir que el test-first sea inútil. Por eso la postura es condicionada y no absoluta.

## Límites de la evidencia

- Seis de las ocho fuentes son normativas o de experiencia profesional (ISTQB, ISO/IEC/IEEE 29119-1, Pressman, JUnit 5, Agile Alliance y Vocke). Fowler solo describe el ciclo. Solo una fuente es empírica (Fucci et al.).
- La demostración es pequeña e ilustrativa; no mide productividad ni calidad. El ciclo se observó con un arnés mínimo, no con JUnit.
- El estudio empírico es observacional, con muestra por conveniencia y tareas cortas.

## Qué evidencia nueva cambiaría la conclusión (pregunta final de la exposición)

- Estudios controlados con **proyectos reales y de larga duración** que midan mantenibilidad y costo, y que muestren que test-first supera a test-last con la misma granularidad. Con eso la postura se movería hacia recomendar TDD de forma más general.
- Réplicas del estudio de Fucci et al. que contradigan que el orden no importa.
- Datos del propio equipo (defectos, tiempo de corrección y costo de mantenimiento de pruebas) que mostraran que TDD no compensa en su contexto. Eso movería la postura hacia usarlo solo en las partes críticas.
