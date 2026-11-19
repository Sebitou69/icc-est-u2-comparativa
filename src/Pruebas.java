import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Pruebas {

    private static final Generador generador = new Generador();
    private static final Ordenamiento ordenamiento = new Ordenamiento();
    private static final Benchmark benchmark = new Benchmark();
    private static final Comparator<Integer> comparador = Integer::compare;

    public static void main(String[] args) {
        probar("CA01", () -> {
            for (int size : new int[]{10_000, 50_000, 100_000}) {
                int[] datos = generador.generate(size);
                exigir(datos.length == size, "Tamaño incorrecto");
                for (int numero : datos) {
                    exigir(numero >= 0 && numero <= size, "Valor fuera de rango");
                }
            }
        });

        probar("CA02", () -> {
            exigir(generador.generate(0).length == 0, "Cero debe producir arreglo vacío");
            boolean rechazado = false;
            try {
                generador.generate(-1);
            } catch (IllegalArgumentException e) {
                rechazado = true;
            }
            exigir(rechazado, "No se rechazó el tamaño negativo");
        });

        probar("CA03", () -> {
            int[] original = {7, 2, 7, 0, 4, 2};
            int[] bubble = original.clone();
            int[] quick = original.clone();
            int[] javaSort = original.clone();
            Integer[] base = aObjetos(original);
            Integer[] comparator = base.clone();
            exigir(bubble != original && quick != original && javaSort != original, "Clones reutilizados");
            exigir(bubble != quick && bubble != javaSort && quick != javaSort, "Clones compartidos");
            exigir(comparator != base, "Arreglo Integer sin clonar");
            exigir(Arrays.equals(bubble, original) && Arrays.equals(quick, original)
                    && Arrays.equals(javaSort, original), "Entradas diferentes");
            for (int i = 0; i < original.length; i++) {
                exigir(comparator[i] == original[i], "Entrada Integer diferente");
            }
            bubble[0] = 999;
            comparator[0] = 999;
            exigir(original[0] == 7 && base[0] == 7, "Se modificó una base");
        });

        probar("CA04", () -> comprobarTodas(new int[]{7, 2, 7, 0, 4, 2}));

        probar("CA05", () -> {
            comprobarTodas(new int[]{});
            comprobarTodas(new int[]{5});
            comprobarTodas(new int[]{3, 3, 3});
        });

        probar("CA06", () -> {
            comprobarTodas(new int[]{0, 1, 2, 3});
            comprobarTodas(new int[]{3, 2, 1, 0});
        });

        probar("CA07", () -> {
            int[] original = {8, 8, 3, 5, 3, 0, 1};
            int[] respaldo = original.clone();
            comprobarTodas(original);
            exigir(Arrays.equals(original, respaldo), "La base original cambió");
        });

        probar("CA08", () -> {
            int[] datos = {5, 1, 3};
            Results resultado = benchmark.medir(() -> Arrays.sort(datos), "Prueba", datos.length);
            exigir(resultado.getFunctionName().equals("Prueba"), "Nombre incorrecto");
            exigir(resultado.getSample() == 3, "Sample incorrecto");
            exigir(resultado.getDuration() >= 0, "Nanosegundos inválidos");
            exigir(resultado.getDurationMs() == resultado.getDuration() / 1_000_000.0,
                    "Conversión a milisegundos incorrecta");
            exigir(Arrays.equals(datos, new int[]{1, 3, 5}), "No se ordenó");
        });

        probar("CA09", () -> {
            List<Results> resultados = new ArrayList<>();
            RuntimeException original = new IllegalArgumentException("Fallo de prueba");
            boolean recibido = false;
            try {
                Results resultado = benchmark.medir(() -> { throw original; }, "Fallido", 3);
                resultados.add(resultado);
            } catch (RuntimeException e) {
                recibido = e == original;
            }
            exigir(recibido, "No se conservó la excepción original");
            exigir(resultados.isEmpty(), "Se registró un resultado fallido");
        });

        probar("CA11-caso-limite", () -> {
            int[] grande = new int[10_000];
            Arrays.fill(grande, 7);
            comprobarTodas(grande);
            int[] ordenado = new int[10_000];
            for (int i = 0; i < ordenado.length; i++) {
                ordenado[i] = i;
            }
            comprobarTodas(ordenado);
        });
    }

    private static void probar(String id, Runnable prueba) {
        try {
            prueba.run();
            System.out.println(id + " | OK");
        } catch (RuntimeException e) {
            System.out.println(id + " | ERROR: " + e.getMessage());
            throw e;
        }
    }

    private static void comprobarTodas(int[] original) {
        int[] respaldo = original.clone();
        int[] esperado = original.clone();
        Arrays.sort(esperado);

        int[] bubble = original.clone();
        int[] quick = original.clone();
        int[] javaSort = original.clone();
        Integer[] comparator = aObjetos(original);

        ordenamiento.bubbleSort(bubble);
        ordenamiento.quickSort(quick, 0, quick.length - 1);
        ordenamiento.arraysSort(javaSort);
        ordenamiento.comparatorSort(comparator, comparador);

        exigir(Arrays.equals(bubble, esperado), "Bubble Sort incorrecto");
        exigir(Arrays.equals(quick, esperado), "Quick Sort incorrecto");
        exigir(Arrays.equals(javaSort, esperado), "Arrays.sort incorrecto");
        exigir(comparator.length == esperado.length, "Tamaño Integer incorrecto");
        for (int i = 0; i < esperado.length; i++) {
            exigir(comparator[i] != null && comparator[i] == esperado[i], "Comparator incorrecto");
        }
        exigir(Arrays.equals(original, respaldo), "El arreglo original fue modificado");
    }

    private static Integer[] aObjetos(int[] datos) {
        Integer[] objetos = new Integer[datos.length];
        for (int i = 0; i < datos.length; i++) {
            objetos[i] = datos[i];
        }
        return objetos;
    }

    private static void exigir(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new IllegalStateException(mensaje);
        }
    }
}
