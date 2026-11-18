import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

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

    }
}
