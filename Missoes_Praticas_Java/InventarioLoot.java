class ItemLoot {
    String nome;
    int raridade;

    public ItemLoot(String nome, int raridade) {
        this.nome = nome;
        this.raridade = raridade;
    }

    @Override
    public String toString() {
        return nome + " (Raridade: " + raridade + ")";
    }
}

public class InventarioLoot {
    public static void quickSort(ItemLoot[] array, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(array, inicio, fim);
            quickSort(array, inicio, indicePivo - 1);
            quickSort(array, indicePivo + 1, fim);
        }
    }
    private static int particionar(ItemLoot[] array, int inicio, int fim) {
        int pivoRaridade = array[fim].raridade;
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (array[j].raridade <= pivoRaridade) {
                i++;
                trocar(array, i, j);
            }
        }
        trocar(array, i + 1, fim);
        return i + 1;
    }
    private static void trocar(ItemLoot[] array, int i, int j) {
        ItemLoot temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        ItemLoot[] inventario = {
            new ItemLoot("Espada Enferrujada", 1),
            new ItemLoot("Amuleto Lendário", 5),
            new ItemLoot("Poção de Vida", 2),
            new ItemLoot("Cajado Épico", 4),
            new ItemLoot("Botas de Couro", 2)
        };
        System.out.println("=== Inventário Bagunçado ===");
        for (ItemLoot item : inventario) System.out.println(item);
        quickSort(inventario, 0, inventario.length - 1);
        System.out.println("\n=== Inventário Organizado (Por Raridade) ===");
        for (ItemLoot item : inventario) System.out.println(item);
    }
}
