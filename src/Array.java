import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Array {

    public static void main(String[] args) {

        exemploCodigoGeradoPorIA();
        exemploComFundamentoBasico();
        exemploCodigoGeradoPorIA100k();
    }

    // ❌ Código típico gerado por IA
    // Funciona, mas é ineficiente
    private static void exemploCodigoGeradoPorIA() {
        System.out.println("\n=== Código gerado por IA ===");

        List<Integer> numeros = List.of(1, 2, 3, 4, 5);

        long inicio = System.currentTimeMillis();

        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.contains(3)) {
                System.out.println("Encontrou");
                break;
            }
        }

        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (fim - inicio) + " ms");
    }

    // ✅ Aplicando fundamento básico
    // Remove o loop desnecessário
    private static void exemploComFundamentoBasico() {
        System.out.println("\n=== Código com fundamento básico ===");

        List<Integer> numeros = List.of(1, 2, 3, 4, 5);

        long inicio = System.currentTimeMillis();

        if (numeros.contains(3)) {
            System.out.println("Encontrou");
        }

        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (fim - inicio) + " ms");
    }

    private static void exemploCodigoGeradoPorIA100k() {
        System.out.println("\n=== Código gerado por IA (100k elementos) ===");

        // Simulando 100 mil elementos
        List<Integer> numeros = new java.util.ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            numeros.add(i);
        }

        long inicio = System.currentTimeMillis();

        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.contains(99_999)) {
                System.out.println("Encontrou");
                break;
            }
        }

        long fim = System.currentTimeMillis();

        System.out.println("Tempo de execução: " + (fim - inicio) + " ms");
    }



}
