import java.util.ArrayList;
import java.util.List;

public class Generador {

    public static int[] generate(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("The size must be a positive integer");
        } else if (size == 0) {
            return new int[0];
        } else {
            int[] list = new int[size];
            for (int i = 0; i < size; i++) {
                list[i] = (int) (Math.random() * (size + 1L));
            }
            return list;
        }
    }
}
