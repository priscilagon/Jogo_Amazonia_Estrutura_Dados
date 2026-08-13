public class AlgoritmoQuickSort {

    // ==========================================
    // 1. RECURSÃO (DIVISÃO E CONQUISTA)
    // ==========================================
    public static void quickSort(int[] array, int inicio, int fim) {
        // Condição de parada: se a partição tiver tamanho 1 ou 0, já está ordenada
        if (inicio < fim) {
            // Reorganiza o array e descobre a posição definitiva do pivô
            int indicePivo = particionar(array, inicio, fim);

            // Chama o Quick Sort para a sub-lista à ESQUERDA do pivô
            quickSort(array, inicio, indicePivo - 1);
            
            // Chama o Quick Sort para a sub-lista à DIREITA do pivô
            quickSort(array, indicePivo + 1, fim);
        }
    }

    // ==========================================
    // 2. PARTICIONAMENTO (O coração do Quick Sort)
    // ==========================================
    private static int particionar(int[] array, int inicio, int fim) {
        // Escolhemos o último elemento da partição atual como Pivô
        int pivo = array[fim];
        
        // O ponteiro 'i' marca o limite de onde estão os elementos MENORES que o pivô
        int i = inicio - 1;

        // O ponteiro 'j' varre o array verificando quem é menor que o pivô
        for (int j = inicio; j < fim; j++) {
            
            // Se encontrar alguém menor ou igual ao pivô, joga para o lado esquerdo
            if (array[j] <= pivo) {
                i++; // Expande a área dos menores
                trocar(array, i, j); // Faz a troca
            }
        }

        // No final, coloca o pivô exatamente no meio (entre os menores e os maiores)
        trocar(array, i + 1, fim);
        
        // Retorna o índice onde o pivô ficou, para dividir as próximas chamadas
        return i + 1; 
    }

    // Método auxiliar simples para trocar dois elementos de lugar
    private static void trocar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // ==========================================
    // MÉTODO MAIN PARA TESTE
    // ==========================================
    public static void main(String[] args) {
        int[] array = {10, 80, 30, 90, 40, 50, 70};

        System.out.println("Array original: ");
        imprimirArray(array);

        // Chama o Quick Sort passando o primeiro e o último índice
        quickSort(array, 0, array.length - 1);

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