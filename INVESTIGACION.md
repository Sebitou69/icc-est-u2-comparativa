# INVESTIGACIÓN - Quick Sort

## Datos

- **Universidad:** Universidad Politécnica Salesiana
- **Carrera:** Computación
- **Materia:** Estructura de Datos
- **Docente:** Ing. Pablo Torres, Mgtr.
- **Autor:** Sebastián Cárdenas
- **Práctica:** PL1.1

## 1. Implementación utilizada

El algoritmo investigado es Quick Sort. Se encuentra en [`src/Ordenamiento.java`](src/Ordenamiento.java), dentro del método `quickSort(int[] list, int start, int end)`. Se ejecuta desde [`src/Experimentos.java`](src/Experimentos.java) como la variante V2.

Lo adapte de internet a traves de una guia por stack overflow cambiando el nombre de algunas variables como mas se me acomodara, ademas, le pedi a la ia que lo revisara pues parece que el codigo original tenia un bug de recursividad.

La implementación final no es idéntica al ejemplo de Stack Overflow: en el repositorio se toma como pivote el valor de la posición central y se recorren los datos desde los dos extremos. El código de la pregunta de Stack Overflow utiliza el primer elemento como pivote y otra forma de particionar. GeeksforGeeks muestra la idea general de Quick Sort y otras variantes.

## 2. Funcionamiento

El método recibe el arreglo y los índices `start` y `end` del tramo que debe ordenar.

1. Si `start >= end`, ya no hay nada que dividir y la llamada termina.
2. El pivote se obtiene mediante `list[(start + end) / 2]`. Es el valor de la posición central, no necesariamente la mediana de los números.
3. El índice `i` avanza desde la izquierda mientras encuentra valores menores que el pivote. `j` retrocede desde la derecha mientras encuentra valores mayores.
4. Cuando `i <= j`, se intercambian esos elementos y ambos índices avanzan. Este paso también permite progresar si hay valores repetidos.
5. Se repite el procedimiento en los dos tramos que quedaron pendientes. Los límites se reducen hasta alcanzar el caso base.

Después de cada partición, los valores del tramo izquierdo no son mayores que los del tramo derecho; cada tramo se ordena recursivamente hasta obtener el arreglo ascendente.

## 3. Pivote y repetidos

El pivote se elige por su posición central en el tramo actual. Cuando dos valores son iguales al pivote, las comparaciones estrictas `<` y `>` se detienen, pero el intercambio y los cambios de `i` y `j` impiden que el bucle quede detenido.

El método ordena el mismo `int[]` recibido y no crea un segundo arreglo para particionar. La posición central no garantiza divisiones equilibradas: depende de los valores presentes en cada tramo.

## 4. Traza de referencia

Se sigue la lógica del método publicado para la entrada `[7, 2, 7, 0, 4, 2]`. Los índices comienzan en 0.

| Tramo | Pivote | Intercambio | Estado después |
|---|---:|---|---|
| 0–5 | 7 | posiciones 0 y 5 | `[2, 2, 7, 0, 4, 7]` |
| 0–5 | 7 | posiciones 2 y 4 | `[2, 2, 4, 0, 7, 7]` |
| 0–3 | 2 | posiciones 0 y 3 | `[0, 2, 4, 2, 7, 7]` |
| 0–3 | 2 | posición 1 consigo misma | `[0, 2, 4, 2, 7, 7]` |
| 2–3 | 4 | posiciones 2 y 3 | `[0, 2, 2, 4, 7, 7]` |
| 4–5 | 7 | posiciones 4 y 5, con valores iguales | `[0, 2, 2, 4, 7, 7]` |

La primera partición genera los tramos 0–3 y 4–5. El tramo 0–3 deja pendiente 2–3. Los tramos de un solo elemento no necesitan nuevas particiones. El resultado final es `[0, 2, 2, 4, 7, 7]`.

## 5. Complejidad, memoria y estabilidad

| Caso | Complejidad temporal | Motivo |
|---|---|---|
| Mejor caso | `O(n log n)` | Las particiones quedan aproximadamente equilibradas. |
| Promedio | `O(n log n)` | Bajo una distribución de entradas que normalmente produce particiones suficientemente equilibradas. |
| Peor caso | `O(n²)` | Las particiones quedan repetidamente muy desbalanceadas. |

La partición hace los intercambios dentro del mismo arreglo, por lo que usa `O(1)` de espacio auxiliar directo. Sin embargo, la recursión ocupa pila: aproximadamente `O(log n)` con divisiones equilibradas y hasta `O(n)` en un caso muy desbalanceado.

Esta implementación **no es estable**: al intercambiar elementos lejanos puede alterar el orden relativo de valores iguales. Con un `int[]` solo se observan los valores, no la identidad de cada elemento repetido.

## 6. Caso desfavorable y observaciones

Patrón analizado: una lista que crece hasta el centro y después disminuye, por ejemplo `[1, 2, 3, 4, 5, 4, 3, 2, 1]`.

En este ejemplo, el primer pivote es 5, el mayor valor. Al particionar, el 5 queda aislado al final y el resto permanece en un tramo grande. Si se repiten divisiones muy desbalanceadas, el trabajo puede aproximarse a `n + (n - 1) + (n - 2) + ... + 1`, que crece como `O(n²)`. No basta con que el centro sea máximo una sola vez: el comportamiento desfavorable depende de que el desequilibrio continúe en las llamadas siguientes.

En [`src/Pruebas.java`](src/Pruebas.java) se incluyen los casos de 10 000 valores iguales, 10 000 valores ordenados y **CA11-piramide**, con 501 elementos. En este último, la entrada aumenta de 0 a 250 y luego desciende hasta 0. El pivote inicial es 250, y se verifica que Quick Sort produce el mismo resultado que `Arrays.sort`. Esta entrada comienza con una partición muy desbalanceada: el máximo queda separado del resto.

Se comprobó el caso de pirámide de forma independiente con OpenJDK 21.0.12.1 en Linux y se guardó el resultado en [evidencias/assets/ca11-piramide.txt](evidencias/assets/ca11-piramide.txt). La captura actual de IntelliJ corresponde a la ejecución anterior a esta prueba adicional.

Los resultados reales de Quick Sort en el benchmarking fueron:

| Sample | Tiempo (ms) |
|---:|---:|
| 10 000 | 1.3894 |
| 50 000 | 3.9517 |
| 100 000 | 6.9858 |

De 10 000 a 50 000 elementos, el tiempo pasó de 1.3894 a 3.9517 ms. De 50 000 a 100 000 pasó de 3.9517 a 6.9858 ms. Estas observaciones corresponden a muestras aleatorias y una única medición por tamaño, así que no demuestran cómo se comportaría en todos los casos.

## 7. Fuentes y adaptación

Las dos fuentes  fueron consultadas el 18 de noviembre de 2026:

1. Stack Overflow. [Stackoverflow with Quicksort Java implementation](https://stackoverflow.com/questions/14907334/stackoverflow-with-quicksort-java-implementation). Pregunta y respuestas sobre el manejo de límites en llamadas recursivas.
2. GeeksforGeeks. [Quick Sort](https://www.geeksforgeeks.org/dsa/quick-sort-algorithm/). Explicación de pivotes, particiones y complejidad.

El proyecto utiliza una variante con pivote central e índices que avanzan desde ambos extremos. El proyecto contó con apoyo de IA en la revisión del código, además de brindar una manera de estructurar de manera mas llamativa visualmente todos los archivos .md
