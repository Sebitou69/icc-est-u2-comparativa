import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Experimentos {

    private final Generador generador = new Generador();
    private final Benchmark benchmark = new Benchmark();
    private final Ordenamiento ordenamiento = new Ordenamiento();
    private final Comparator<Integer> comparador = Integer::compare;

    public List<Results> ejecutar() {
        List<Results> results = new ArrayList<>();
        int[] sizes = {10_000, 50_000, 100_000};

        for (int size : sizes) {
            int[] original = generador.generate(size);
            int[] esperado = original.clone();
            Arrays.sort(esperado);

            int[] bubble = original.clone();
            int[] quick = original.clone();
            int[] javaSort = original.clone();
            Integer[] objetos = new Integer[size];

            for (int i = 0; i < size; i++) {
                objetos[i] = original[i];
            }
            Integer[] comparator = objetos.clone();

            results.add(medirYValidar(() -> ordenamiento.bubbleSort(bubble),
                    "Metodo burbuja", size, () -> validar(bubble, esperado)));
            results.add(medirYValidar(() -> ordenamiento.quickSort(quick, 0, quick.length - 1),
                    "Quick Sort", size, () -> validar(quick, esperado)));
            results.add(medirYValidar(() -> ordenamiento.arraysSort(javaSort),
                    "Arrays.sort", size, () -> validar(javaSort, esperado)));
            results.add(medirYValidar(() -> ordenamiento.comparatorSort(comparator, comparador),
                    "Comparator sort", size, () -> validar(comparator, esperado)));
        }

        return results;
    }

    private Results medirYValidar(Runnable accion, String nombre, int size, Runnable validacion) {
        try {
            Results resultado = benchmark.medir(accion, nombre, size);
            validacion.run();
            return resultado;
        } catch (RuntimeException e) {
            throw new IllegalStateException("Fallo en " + nombre + " con " + size + " elementos", e);
        }
    }

    private void validar(int[] actual, int[] esperado) {
        if (!Arrays.equals(actual, esperado)) {
            throw new IllegalStateException("El arreglo no coincide con la referencia ordenada");
        }
    }

    private void validar(Integer[] actual, int[] esperado) {
        if (actual.length != esperado.length) {
            throw new IllegalStateException("El tamaño de la salida no coincide");
        }
        for (int i = 0; i < actual.length; i++) {
            if (actual[i] == null || actual[i] != esperado[i]) {
                throw new IllegalStateException("La salida no coincide con la referencia en " + i);
            }
        }
    }
}
