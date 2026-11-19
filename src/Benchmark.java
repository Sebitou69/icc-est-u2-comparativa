public class Benchmark{

    public static Results medir(Runnable accion, String nombre,int sample){

        //Tiempo actual
        long tiempoActual = System.nanoTime();
        //Accion
        accion.run();
        //Tiempo final
        long tiempoFinal = System.nanoTime();
        //Retornar results
        long tiempoTotal = tiempoFinal - tiempoActual;
        double tFinal = tiempoTotal / 1_000_000.0;
        Results results = new Results(tFinal,nombre,sample);
        return results;

    }

}
