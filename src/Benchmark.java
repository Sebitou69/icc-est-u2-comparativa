public class Benchmark {

    public static Results medir(Runnable accion, String nombre, int sample) {
        long tiempoActual = System.nanoTime();
        accion.run();
        long tiempoFinal = System.nanoTime();
        return new Results(tiempoFinal - tiempoActual, nombre, sample);
    }
}
