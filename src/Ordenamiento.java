import java.util.Arrays;
import java.util.Comparator;

public class Ordenamiento {

    public int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
        return array;
    }


    public int[] quickSort(int[] list, int start, int end) {
        if (start >= end) {
            return list;
        }
        int pivot = list[(start + end) / 2];
        int i = start;
        int j = end;

        while (i <= j) {
            while (list[i] < pivot) i++;
            while (list[j] > pivot) j--;

            if (i <= j) {
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            }
        }

        if (start < j) quickSort(list, start, j);
        if (i < end) quickSort(list, i, end);

        return list;
    }

    public int[] arraysSort(int[] array) {
        Arrays.sort(array);
        return array;
    }

    public Integer[] comparatorSort(Integer[] array, Comparator<Integer> comparator) {
        Arrays.sort(array, comparator);
        return array;
    }
}
