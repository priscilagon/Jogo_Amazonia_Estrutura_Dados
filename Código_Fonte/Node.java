// Node.java
public class Node {
    Item dado; // Armazena o objeto Item
    Node proximo; // Referência (ponteiro) para o próximo nó da lista

    public Node(Item dado) {
        this.dado = dado;
        this.proximo = null;
    }
}