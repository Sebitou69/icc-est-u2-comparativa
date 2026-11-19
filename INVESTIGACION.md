# INVESTIGACION — Quick Sort (PL1.1)

## Datos generales

| Campo | Información |
|---|---|
| Institución | Universidad Politécnica Salesiana |
| Carrera | Computación |
| Asignatura | Estructura de Datos |
| Práctica | PL1.1 — Comparativa de métodos de ordenamiento y benchmarking |
| Docente | Ing. Pablo Torres, Mgtr. |
| Autor | Sebastián Cárdenas |
| Algoritmo elegido | Quick Sort |
| Repositorio | [icc-est-u2-comparativa](https://github.com/Sebitou69/icc-est-u2-comparativa) |

## 1. Identificación de la implementación

- Archivo fuente: [src/Ordenamiento.java](src/Ordenamiento.java)
- Método: `quickSort(int[] list, int start, int end)`
- Invocación durante el experimento: [src/Experimentos.java](src/Experimentos.java)
- Variante: partición con dos índices y pivote tomado de la posición central del intervalo, `list[(start + end) / 2]`.
- Se utiliza como V2 sobre arreglos `int[]`, sin delegar la operación a `Arrays.sort`.

[Explicar con palabras propias de dónde surgió la implementación, si se adaptó código consultado y qué decisiones se cambiaron.]

## 2. Funcionamiento paso a paso y recursión

Parámetros empleados: `list` (arreglo), `start` (índice inicial), `end` (índice final). La implementación retorna inmediatamente cuando `start >= end`.

[Explicar personalmente el caso base, cómo se mueven los índices `i` y `j`, cuándo intercambian, cómo se forman los subintervalos recursivos y por qué el proceso progresa.]

[Indicar la propiedad o invariante que se mantiene después de cada partición y justificar que el resultado final es ascendente.]

## 3. Pivote, partición y valores repetidos

En la versión del repositorio, el pivote es el **valor** situado en el punto medio del intervalo; las comparaciones avanzan desde ambos extremos y realizan intercambios cuando `i <= j`.

[Explicar por qué se eligió ese pivote, qué ocurre cuando hay valores iguales, y cómo funcionan los límites de las llamadas recursivas.]

## 4. Traza manual solicitada

Entrada: `[7, 2, 7, 0, 4, 2]`  
Salida esperada: `[0, 2, 2, 4, 7, 7]`

| Paso | Intervalo (`start`, `end`) | Pivote | Movimiento / intercambio | Estado del arreglo |
|---|---|---|---|---|
| 1 | [Completar] | [Completar] | [Completar] | [Completar] |
| 2 | [Completar] | [Completar] | [Completar] | [Completar] |
| 3 | [Completar] | [Completar] | [Completar] | [Completar] |
| ... | [Agregar los pasos necesarios] | | | |
| Final | | | | `[0, 2, 2, 4, 7, 7]` |

[Completar manualmente todas las particiones y subdivisiones de **esta implementación**, no de otra variante de Quick Sort.]

## 5. Complejidad, memoria y estabilidad

| Aspecto solicitado | Desarrollo |
|---|---|
| Mejor caso temporal | [Orden de complejidad y justificación para esta partición] |
| Caso promedio temporal | [Orden de complejidad, supuestos sobre los datos y justificación] |
| Peor caso temporal | [Orden de complejidad y ejemplo que lo provoque en esta implementación] |
| Memoria auxiliar | [Explicar almacenamiento adicional y pila de llamadas] |
| Estabilidad | [Justificar si conserva o no el orden relativo de elementos iguales] |

[Relacionar el análisis con las decisiones específicas del código. No atribuir propiedades de otras variantes a esta.]

## 6. Caso desfavorable y relación con el benchmarking

En [src/Pruebas.java](src/Pruebas.java) hay pruebas con 10 000 valores iguales y con un arreglo de 10 000 valores previamente ordenados. El registro de ejecución está en [evidencias/pruebas.md](evidencias/pruebas.md).

[Elegir y ejecutar un caso desfavorable para **este** Quick Sort, documentar la entrada, el resultado real, su evidencia y explicar por qué resulta desfavorable. Si se produce un fallo, indicar la causa y la corrección.]

Los tiempos de Quick Sort observados en la ejecución registrada son:

| Sample | Tiempo (ms) |
|---:|---:|
| 10 000 | 1.3894 |
| 50 000 | 3.9517 |
| 100 000 | 6.9858 |

[Relacionar al menos dos observaciones concretas con el análisis anterior y con las limitaciones de una medición por tamaño. No afirmar que un método es siempre más rápido.]

## 7. Referencias técnicas y adaptación

Citar al menos dos fuentes técnicas **realmente consultadas**, con datos identificables y fecha de consulta. Distinguir las ideas o fragmentos adaptados de las modificaciones propias.

1. [Autor o entidad]. [Título del recurso]. [Enlace o datos bibliográficos]. Fecha de consulta: [día/mes/año].
2. [Autor o entidad]. [Título del recurso]. [Enlace o datos bibliográficos]. Fecha de consulta: [día/mes/año].

[Describir las modificaciones efectuadas frente a las fuentes consultadas y redactar las explicaciones con palabras propias.]
