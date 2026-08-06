// Main.java
public class Main {
    public static void main(String[] args) {
        
        System.out.println(">>> INICIANDO TESTE DO MOTOR DE JOGO (TEMA AMAZÔNICO) <<<\n");

        // 1. Instanciando Itens (Baseado na tabela de referência)
        Item isca = new Item("Isca de Tucunaré", "Artefato de pesca", 6, 2);
        Item amuleto = new Item("Amuleto de Cunhã", "Amuleto", 15, 1);
        Item pocao = new Item("Remédio de Andiroba", "Poção", 10, 3);
        Item alimento = new Item("Castanha-do-Pará", "Alimento", 5, 10);

        // 2. Testando a Lista Ligada (Inventário)
        InventarioLista inventario = new InventarioLista();
        inventario.adicionarItem(isca);
        inventario.adicionarItem(amuleto);
        inventario.listarItens();

        // 3. Testando a Pilha LIFO (Histórico de Consumo e Undo)
        System.out.println("--- TESTANDO PILHA (AÇÕES DO JOGADOR) ---");
        HistoricoConsumo historico = new HistoricoConsumo(5);
        historico.registrarConsumo(alimento);
        historico.registrarConsumo(pocao);
        
        // Jogador decidiu desfazer o uso da poção (última ação)
        historico.desfazerConsumo(); 
        System.out.println();

        // 4. Testando a Fila FIFO (Entrada de Jogadores)
        System.out.println("--- TESTANDO FILA (EMBARQUE DE JOGADORES) ---");
        FilaDeEntrada portoFila = new FilaDeEntrada(5);
        portoFila.cadastrarEntrada("Jogador 1 (Boto)");
        portoFila.cadastrarEntrada("Jogador 2 (Curupira)");
        
        // Processando a entrada pela ordem de chegada
        portoFila.processarProximaEntrada();
        portoFila.processarProximaEntrada();
        portoFila.processarProximaEntrada(); // Vai informar que a fila está vazia
    }
}