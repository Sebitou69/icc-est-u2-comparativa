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
        Results results = new Results(tiempoTotal,nombre,sample);
        return results;

    }

}
