public class Benchmark{

    public static Results medir(Runnable accion, String nombre, String sample){

        //Tiempo actual
        long tiempoActual = System.nanoTime();
        //Accion
        accion.run();
        //Tiempo final
        long tiempoFinal = System.nanoTime();
        //Retornar results
        long tiempoTotal = tiempoFinal - tiempoActual;
        double tFinal = tiempoTotal / 1000000000.0;
        Results results = new Results(tFinal,nombre,sample);
        return results;

    }

}
