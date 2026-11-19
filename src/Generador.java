public class Generador {

    public int[] generate(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("The size must be a positive integer");
        }
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = (int) (Math.random() * (size + 1L));
        }
        return list;
    }
}
