// InventarioLista.java
public class InventarioLista {
    Node cabeca;

    // Adiciona um novo item ao final da lista (percorre até o último nó)
    public void adicionarItem(Item novoItem) {
        Node novoNode = new Node(novoItem);
        
        if (cabeca == null) {
            cabeca = novoNode;
        } else {
            Node atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNode;
        }
        System.out.println("Item guardado no inventário: " + novoItem.nome);
    }

    // Percorre a lista e exibe todos os itens
    public void listarItens() {
        System.out.println("\n=== INVENTÁRIO DO EXPLORADOR ===");
        Node atual = cabeca;
        if (atual == null) {
            System.out.println("O inventário está vazio.");
        }
        while (atual != null) {
            System.out.println("- " + atual.dado.toString());
            atual = atual.proximo;
        }
        System.out.println("================================\n");
    }
}