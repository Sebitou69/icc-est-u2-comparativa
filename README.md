# PL1.1 - Comparativa de métodos de ordenamiento

## Datos

- **Universidad:** Universidad Politécnica Salesiana
- **Carrera:** Computación
- **Materia:** Estructura de Datos
- **Docente:** Ing. Pablo Torres, Mgtr.
- **Autor:** Sebastián Cárdenas
- **Sistema:** Windows
- **Java:** JDK 26.0.1
- **IDE:** IntelliJ IDEA 2026.1.2
- **Procesador:** Intel Core i5-13420H
- **RAM:** 32 GB DDR4 (2 módulos de 16 GB)

## Objetivo

Comparar el tiempo de cuatro variantes de ordenamiento usando arreglos de 10 000, 50 000 y 100 000 elementos.

## Métodos utilizados

| Variante | Método | Tipo de arreglo |
|---|---|---|
| V1 | Burbuja | `int[]` |
| V2 | Quick Sort | `int[]` |
| V3 | `Arrays.sort` | `int[]` |
| V4 | `Arrays.sort` con `Comparator<Integer>` | `Integer[]` |

Los dos primeros métodos están implementados en `Ordenamiento.java`. V3 y V4 usan la biblioteca de Java. En V4, `Comparator` establece el orden ascendente de los objetos `Integer`.

## Archivos del proyecto

- `src/Generador.java`: genera números aleatorios entre 0 y el tamaño de la muestra.
- `src/Ordenamiento.java`: contiene los cuatro métodos.
- `src/Benchmark.java`: recibe un `Runnable` y mide con `System.nanoTime()`.
- `src/Results.java`: guarda el método, el tamaño (`sample`) y la duración en nanosegundos (`long`); convierte a milisegundos al mostrarla.
- `src/Experimentos.java`: prepara los arreglos, ejecuta los ordenamientos y valida sus resultados.
- `src/Pruebas.java`: ejecuta las pruebas de aceptación.
- `src/Main.java`: imprime la lista final de resultados.
- `evidencias/pruebas.md`: registra las pruebas y enlaza las capturas de `evidencias/assets/`.

## Cómo ejecutar

Desde IntelliJ IDEA se pueden ejecutar las clases `Pruebas` y `Main` directamente.

Desde la terminal, ubicada en la raíz del repositorio:

```bash
mkdir build
javac -d build src/*.java
java -cp build Pruebas
java -cp build Main
```

El proyecto no requiere librerías externas.

## Cómo se hicieron las mediciones

Para cada tamaño se genera un único arreglo de números aleatorios. Burbuja, Quick Sort, `Arrays.sort` y Comparator reciben copias independientes de ese mismo arreglo, en ese orden.

La generación, las copias, la conversión a `Integer[]` y la creación del comparador se hacen antes del cronómetro. `Benchmark` ejecuta únicamente el ordenamiento recibido como `Runnable`, mide el tiempo en nanosegundos y devuelve un objeto `Results`.

Cuando termina cada medición, `Experimentos` comprueba que el arreglo coincida con una copia de referencia ordenada. Si es correcto, lo guarda en `List<Results>`. Si falla, informa el error conservando la excepción original y no registra un resultado exitoso. Después de las doce ejecuciones, `Main` imprime la lista completa.

Los tiempos no incluyen la preparación ni la validación, pero sí el trabajo interno del propio algoritmo.

## Resultados

![Resultados de Main](evidencias/assets/resultados-consola.png)

| Método | Sample | Tiempo (ms) |
|---|---:|---:|
| Método burbuja | 10 000 | 53.4269 |
| Quick Sort | 10 000 | 1.3894 |
| Arrays.sort | 10 000 | 0.9561 |
| Comparator sort | 10 000 | 10.0522 |
| Método burbuja | 50 000 | 2980.8852 |
| Quick Sort | 50 000 | 3.9517 |
| Arrays.sort | 50 000 | 4.4868 |
| Comparator sort | 50 000 | 11.177 |
| Método burbuja | 100 000 | 12426.0086 |
| Quick Sort | 100 000 | 6.9858 |
| Arrays.sort | 100 000 | 8.588 |
| Comparator sort | 100 000 | 26.7482 |

Los valores corresponden a una sola ejecución por método y tamaño en el equipo indicado. No bastan para afirmar que un método será siempre más rápido. La variante con `Comparator` trabaja con `Integer[]`, por lo que no solo cambia el comparador: también cambia la representación de los datos.

En esta ejecución, `Arrays.sort(int[])` obtuvo el menor tiempo con 10 000 elementos; Quick Sort obtuvo los menores tiempos con 50 000 y 100 000. Se utilizan clones para que ningún método reciba un arreglo que ya haya sido ordenado por otro.

## Pruebas

![Resultados de Pruebas](evidencias/assets/pruebas-consola.png)

Las entradas, los resultados esperados y los resultados observados de CA01 a CA11 se encuentran en [evidencias/pruebas.md](evidencias/pruebas.md).

## Análisis personal

Me sorpendio mucho ver lo exageradamente lento que es un bubble sort cuando tiene que ordenar arreglos muy largos,

## Conclusiones

1. El quicksort es enormemente mas rapido que el bubble sort, por lo que debo usar obligatoriamente un quicksort si quiero tener un codigo bien optimizado temporalmente hablando
2. Para listas no tan grandes (menos de 50k), es mucho mas eficiente usar el metodo sort de la clase Arrays de java
3. El manejo de excepciones es fundamental para que no se propague la excepcion por el resto del codigo, evitando asi que se interrumpa la ejecucion del resto del codigo

### Datos de las mediciones

En la captura, Quick Sort registró **1.3894 ms** con 10 000 elementos, **3.9517 ms** con 50 000 y **6.9858 ms** con 100 000. En los mismos tamaños, Bubble Sort registró 53.4269 ms, 2980.8852 ms y 12426.0086 ms. `Arrays.sort(int[])` obtuvo 0.9561 ms con 10 000 elementos. Estos son los datos de una sola ejecución, no promedios.

La prueba CA09 comprobó que una excepción de la operación se conserva y que no se añade una medición fallida a la lista.

## Repositorio

- [Código y archivos de la práctica](https://github.com/Sebitou69/icc-est-u2-comparativa)
- [Investigación de Quick Sort](INVESTIGACION.md)

El hash que se entrega en AVAC debe ser el del último commit después de terminar la práctica.
