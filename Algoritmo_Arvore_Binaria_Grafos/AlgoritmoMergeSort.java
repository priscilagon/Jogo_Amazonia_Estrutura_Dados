public class AlgoritmoMergeSort {

    // ==========================================
    // 1. FASE DE DIVISÃO
    // ==========================================
    public static void mergeSort(int[] array, int inicio, int fim) {
        // Condição de parada: se o início for >= fim, o subvetor tem 1 ou 0 elementos
        if (inicio < fim) {
            // Encontra o meio do array para dividir em duas metades
            int meio = (inicio + fim) / 2;

            // Chama a recursão para a metade esquerda
            mergeSort(array, inicio, meio);
            
            // Chama a recursão para a metade direita
            mergeSort(array, meio + 1, fim);

            // Funde (intercala) as duas metades que já voltaram ordenadas
            merge(array, inicio, meio, fim);
        }
    }

    // ==========================================
    // 2. FASE DE CONQUISTA (INTERCALAÇÃO)
    // ==========================================
    private static void merge(int[] array, int inicio, int meio, int fim) {
        // Descobre os tamanhos dos dois subvetores temporários
        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita = fim - meio;

        // Cria os arrays temporários
        int[] vetorEsquerda = new int[tamanhoEsquerda];
        int[] vetorDireita = new int[tamanhoDireita];

        // Copia os dados do array original para os temporários
        for (int i = 0; i < tamanhoEsquerda; i++) {
            vetorEsquerda[i] = array[inicio + i];
        }
        for (int j = 0; j < tamanhoDireita; j++) {
            vetorDireita[j] = array[meio + 1 + j];
        }

        // Índices para percorrer os vetores temporários e o array original
        int i = 0; // Índice do vetorEsquerda
        int j = 0; // Índice do vetorDireita
        int k = inicio; // Índice do array original

        // Compara os elementos da esquerda e direita e coloca o menor de volta no array original
        while (i < tamanhoEsquerda && j < tamanhoDireita) {
            if (vetorEsquerda[i] <= vetorDireita[j]) {
                array[k] = vetorEsquerda[i];
                i++;
            } else {
                array[k] = vetorDireita[j];
                j++;
            }
            k++; // Avança a posição no array original
        }

        // Se sobrou algum elemento na esquerda, copia de volta
        while (i < tamanhoEsquerda) {
            array[k] = vetorEsquerda[i];
            i++;
            k++;
        }

        // Se sobrou algum elemento na direita, copia de volta
        while (j < tamanhoDireita) {
            array[k] = vetorDireita[j];
            j++;
            k++;
        }
    }

    // ==========================================
    // MÉTODO MAIN PARA TESTE
    // ==========================================
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Array original: ");
        imprimirArray(array);

        // Chama o Merge Sort passando a primeira e a última posição
        mergeSort(array, 0, array.length - 1);

        System.out.println("\nArray ordenado: ");
        imprimirArray(array);
    }

    // Método auxiliar para imprimir o array
    private static void imprimirArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}