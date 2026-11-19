# Pruebas de aceptación — PL1.1

Ejecución comprobada con OpenJDK 26.0.1 en un IDE IntelliJ Idea. 

Comandos ejecutados desde la raíz del proyecto:

~~~bash
mkdir build
javac -d build src/*.java
java -cp build Pruebas
java -cp build Main
~~~

| Caso | Entrada o procedimiento | Resultado esperado | Resultado observado | Estado | Evidencia                                          |
|---|---|---|---|---|----------------------------------------------------|
| CA01 | Generar 10 000, 50 000 y 100 000 enteros | Longitud exacta, valores de 0 a n | Todas las longitudes y valores verificados automáticamente | OK | [Pruebas](assets/pruebas-consola.png)              |
| CA02 | Generar 0 y -1 elementos | Arreglo vacío y excepción explícita | Arreglo de longitud 0 e `IllegalArgumentException` | OK | [Pruebas](assets/pruebas-consola.png)              |
| CA03 | Preparar copias de una muestra con repeticiones | Entradas independientes con el mismo orden inicial | Copias independientes; la base permanece intacta | OK | [Pruebas](assets/pruebas-consola.png)              |
| CA04 | Ordenar `[7, 2, 7, 0, 4, 2]` con V1–V4 | `[0, 2, 2, 4, 7, 7]` | Cuatro salidas iguales a la referencia ordenada | OK | [Pruebas](assets/pruebas-consola.png)              |
| CA05 | Ordenar `[]`, `[5]` y `[3, 3, 3]` | Sin errores, mismos valores | Cuatro variantes correctas para los tres casos | OK | [Pruebas](assets/pruebas-consola.png)              |
| CA06 | Ordenar `[0, 1, 2, 3]` y `[3, 2, 1, 0]` | `[0, 1, 2, 3]` | Cuatro variantes correctas en ambas entradas | OK | [Pruebas](assets/pruebas-consola.png)              |
| CA07 | Ordenar clones de `[8, 8, 3, 5, 3, 0, 1]` | Base intacta, salidas iguales por valor | Base conservada y cuatro salidas correctas | OK | [Pruebas](assets/pruebas-consola.png)              |
| CA08 | Medir por lambda el ordenamiento de tres números | Nombre, sample y tiempo correcto en ns y ms | `Results` verificado, sin incluir la validación en el tiempo medido | OK | [Pruebas](assets/pruebas-consola.png)              |
| CA09 | Enviar un Runnable que lanza una excepción | Causa original conservada, ningún resultado válido registrado | Se propagó la misma excepción y la lista permaneció vacía | OK | [Pruebas](assets/pruebas-consola.png)              |
| CA10 | Ejecutar los tres tamaños con cuatro variantes | 12 objetos, impresión completa y capturas iguales a la tabla del README | 12 resultados impresos; captura y tabla del README con los mismos valores | OK | [Salida de consola](assets/resultados-consola.png) |
| CA11 | Ordenar datos iguales, ordenados y un patrón de pirámide de 501 elementos | Quick Sort produce orden ascendente y conserva los valores; traza coherente | Casos de datos iguales y ordenados verificados en IntelliJ; la pirámide se comprobó adicionalmente con Java 21 en Linux. La revisión manual de la traza queda a cargo del autor | Parcial | [Captura anterior](assets/pruebas-consola.png), [comprobación de pirámide](assets/ca11-piramide.txt) |

La comprobación de pirámide está registrada por separado porque la captura original de IntelliJ se tomó antes de incorporarla a `Pruebas.java`. Para dejar una única captura que incluya todo, hay que ejecutar de nuevo `Pruebas.main()` en IntelliJ y actualizar `assets/pruebas-consola.png`.
