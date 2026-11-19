# Pruebas de aceptación — PL1.1

Ejecución comprobada con OpenJDK 21.0.12.1 en un entorno de pruebas Linux. Los tiempos generados aquí corresponden a ese entorno, no al equipo personal del autor.

Comandos ejecutados desde la raíz del proyecto:

~~~bash
mkdir build
javac -d build src/*.java
java -cp build Pruebas
java -cp build Main
~~~

| Caso | Entrada o procedimiento | Resultado esperado | Resultado observado | Estado | Evidencia |
|---|---|---|---|---|---|
| CA01 | Generar 10 000, 50 000 y 100 000 enteros | Longitud exacta, valores de 0 a n | Todas las longitudes y valores verificados automáticamente | OK | [Pruebas](assets/pruebas-consola.txt) |
| CA02 | Generar 0 y -1 elementos | Arreglo vacío y excepción explícita | Arreglo de longitud 0 e `IllegalArgumentException` | OK | [Pruebas](assets/pruebas-consola.txt) |
| CA03 | Preparar copias de una muestra con repeticiones | Entradas independientes con el mismo orden inicial | Copias independientes; la base permanece intacta | OK | [Pruebas](assets/pruebas-consola.txt) |
| CA04 | Ordenar `[7, 2, 7, 0, 4, 2]` con V1–V4 | `[0, 2, 2, 4, 7, 7]` | Cuatro salidas iguales a la referencia ordenada | OK | [Pruebas](assets/pruebas-consola.txt) |
| CA05 | Ordenar `[]`, `[5]` y `[3, 3, 3]` | Sin errores, mismos valores | Cuatro variantes correctas para los tres casos | OK | [Pruebas](assets/pruebas-consola.txt) |
| CA06 | Ordenar `[0, 1, 2, 3]` y `[3, 2, 1, 0]` | `[0, 1, 2, 3]` | Cuatro variantes correctas en ambas entradas | OK | [Pruebas](assets/pruebas-consola.txt) |
| CA07 | Ordenar clones de `[8, 8, 3, 5, 3, 0, 1]` | Base intacta, salidas iguales por valor | Base conservada y cuatro salidas correctas | OK | [Pruebas](assets/pruebas-consola.txt) |
| CA08 | Medir por lambda el ordenamiento de tres números | Nombre, sample y tiempo correcto en ns y ms | `Results` verificado, sin incluir la validación en el tiempo medido | OK | [Pruebas](assets/pruebas-consola.txt) |
| CA09 | Enviar un Runnable que lanza una excepción | Causa original conservada, ningún resultado válido registrado | Se propagó la misma excepción y la lista permaneció vacía | OK | [Pruebas](assets/pruebas-consola.txt) |
| CA10 | Ejecutar los tres tamaños con cuatro variantes | 12 objetos, impresión completa y capturas iguales a la tabla del README | 12 resultados impresos; capturas y tabla pendientes | Parcial | [Salida de consola](assets/resultados-consola.txt) |
| CA11 | Ejecutar Quick Sort con casos límite y explicar su variante | Código, traza manual y documento coherentes | Pruebas con 10 000 valores iguales y entrada ordenada correctas; traza manual pendiente | Parcial | [Pruebas](assets/pruebas-consola.txt) |

Las pruebas de corrección son independientes de las doce mediciones. El programa valida cada salida frente a una referencia ordenada fuera del intervalo cronometrado; si alguna validación falla, no incorpora esa medición a la lista final.

Las capturas de pantalla de la consola deben realizarse durante la ejecución definitiva en el equipo donde se registrarán los tiempos de entrega, y sus valores deben coincidir con la tabla del README.
