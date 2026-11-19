import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Results> results = new Experimentos().ejecutar();
        int ultimoSample = -1;

        for (Results resultado : results) {
            if (resultado.getSample() != ultimoSample) {
                if (ultimoSample != -1) {
                    System.out.println();
                }
                ultimoSample = resultado.getSample();
                System.out.println("Array with size " + ultimoSample);
                System.out.println();
            }
            System.out.println(resultado);
        }
    }
}
