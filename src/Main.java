import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        Generador g = new Generador();
        Benchmark b = new Benchmark();
        List<Integer> list = g.generate(100000);
        System.out.println(list);
        Runnable gen = () -> g.generate(100000);
        Results benGenList = b.medir(gen,"Generacion de Listado", "100 000");
        System.out.println(benGenList);


        /*
        long nanoTime = System.nanoTime();
        long currentTimeMillis = System.currentTimeMillis();

        System.out.println("Nano time: " + nanoTime);
        System.out.println("Current time: " + currentTimeMillis);

        Runnable funcion = () -> {
            System.out.println("Ejecutando tarea 1");
            System.out.println("Ejecutando tarea 2");
        };

        List<Integer> list = new ArrayList<>();
        MetodosOrd mO = new MetodosOrd();
        mO.burbuja(list);
        Runnable burbujaOrden = () -> mO.burbuja(list);

        System.out.println("Ejecucion de la funcion runnable");
        funcion.run();

         */

    }
}
