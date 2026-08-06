// HistoricoConsumo.java
public class HistoricoConsumo {
    Item[] historico;
    int topo; // Controla a posição do último item inserido

    public HistoricoConsumo(int capacidade) {
        historico = new Item[capacidade];
        topo = -1; // -1 indica que a pilha está vazia
    }

    // Empilha (push) o item consumido
    public void registrarConsumo(Item item) {
        if (topo == historico.length - 1) {
            System.out.println("Aviso: Histórico de consumo cheio!");
            return;
        }
        topo++;
        historico[topo] = item;
        System.out.println("Ação: Jogador consumiu '" + item.nome + "'.");
    }

    // Remove (pop) e reverte o consumo mais recente
    public Item desfazerConsumo() {
        if (topo == -1) {
            System.out.println("Aviso: Nada a desfazer!");
            return null;
        }
        Item itemRemovido = historico[topo];
        historico[topo] = null; // Limpa a referência
        topo--;
        System.out.println("Ação Desfeita! '" + itemRemovido.nome + "' retornou ao inventário.");
        return itemRemovido;
    }
}