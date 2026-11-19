import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args){

        Generador g = new Generador();
        Benchmark b = new Benchmark();
        Ordenamiento o = new Ordenamiento();
        Comparator<Integer> comparador = Integer::compare;

        int[] list10k = g.generate(10_000);
        int[] list50k = g.generate(50_000);
        int[] list100k = g.generate(100_000);
        int[] listBubble10k = list10k.clone();
        int[] listQuick10k = list10k.clone();
        int[] listJavaSort10k = list10k.clone();
        Integer[] baseComparator10k = new Integer[list10k.length];
        int[] listBubble50k = list50k.clone();
        int[] listQuick50k = list50k.clone();
        int[] listJavaSort50k = list50k.clone();
        Integer[] baseComparator50k = new Integer[list50k.length];
        int[] listBubble100k = list100k.clone();
        int[] listQuick100k = list100k.clone();
        int[] listJavaSort100k = list100k.clone();
        Integer[] baseComparator100k = new Integer[list100k.length];

        for (int i = 0; i < list10k.length; i++) {
            baseComparator10k[i] = list10k[i];
        }

        for (int i = 0; i < list50k.length; i++) {
            baseComparator50k[i] = list50k[i];
        }

        for (int i = 0; i < list100k.length; i++) {
            baseComparator100k[i] = list100k[i];
        }

        Integer[] listComparator10k = baseComparator10k.clone();
        Integer[] listComparator50k = baseComparator50k.clone();
        Integer[] listComparator100k = baseComparator100k.clone();

        Runnable bubble10k = () -> o.bubbleSort(listBubble10k);
        Runnable quick10k = () -> o.quickSort(listQuick10k, 0, list10k.length - 1);
        Runnable javaSort10k = () -> o.arraysSort(listJavaSort10k);
        Runnable comparatorSort10k = () -> o.comparatorSort(listComparator10k,comparador);

        Runnable bubble50k = () -> o.bubbleSort(listBubble50k);
        Runnable quick50k = () -> o.quickSort(listQuick50k, 0, list50k.length - 1);
        Runnable javaSort50k = () -> o.arraysSort(listJavaSort50k);
        Runnable comparatorSort50k = () -> o.comparatorSort(listComparator50k,comparador);

        Runnable  bubble100k = () -> o.bubbleSort(listBubble100k);
        Runnable quick100k = () -> o.quickSort(listQuick100k, 0, listQuick100k.length - 1);
        Runnable javaSort100k = () -> o.arraysSort(listJavaSort100k);
        Runnable comparatorSort100k = () -> o.comparatorSort(listComparator100k,comparador);

        List<Results> results = new ArrayList<>();

        Results sortedGenList10k = b.medir(bubble10k,"Metodo burbuja", list10k.length);
        Results quickGenList10k = b.medir(quick10k,"Quick Sort", list10k.length);
        Results javaGenList10k = b.medir(javaSort10k,"Arrays.sort", list10k.length);
        Results comparatorGenList10k = b.medir(comparatorSort10k,"Comparator sort", list10k.length);

        Results sortedGenList50k = b.medir(bubble50k,"Metodo burbuja", list50k.length);
        Results quickGenList50k = b.medir(quick50k,"Quick Sort", list50k.length);
        Results javaGenList50k  = b.medir(javaSort50k,"Arrays.sort", list50k.length);
        Results comparatorGenList50k = b.medir(comparatorSort50k,"Comparator sort", list50k.length);

        Results sortedGenList100k = b.medir(bubble100k,"Metodo Burbuja", list100k.length);
        Results quickGenList100k = b.medir(quick100k,"Quick sort", list100k.length);
        Results javaGenList100k = b.medir(javaSort100k,"Arrays.sort", list100k.length);
        Results comparatorGenList100k =  b.medir(comparatorSort100k,"Comparator sort", list100k.length);

        results.add(sortedGenList10k);
        results.add(quickGenList10k);
        results.add(javaGenList10k);
        results.add(comparatorGenList10k);

        results.add(sortedGenList50k);
        results.add(quickGenList50k);
        results.add(javaGenList50k);
        results.add(comparatorGenList50k);

        results.add(sortedGenList100k);
        results.add(quickGenList100k);
        results.add(javaGenList100k);
        results.add(comparatorGenList100k);

        System.out.println("Array with size 10 000");
        System.out.println("");
        for (int i = 0; i < 4; i++) {
            System.out.println(results.get(i));
        }
        System.out.println("");

        System.out.println("Array with size 50 000");
        System.out.println("");
        for (int i = 4; i < 8; i++) {
            System.out.println(results.get(i));
        }
        System.out.println("");

        System.out.println("Array with size 100 000");
        System.out.println("");
        for (int i = 8; i < 12; i++) {
            System.out.println(results.get(i));
        }
    }
}
