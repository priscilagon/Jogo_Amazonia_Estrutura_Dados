// Item.java
public class Item {
    String nome;
    String tipo;
    int valor;
    int quantidade;

    // Construtor para inicializar o item
    public Item(String nome, String tipo, int valor, int quantidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    // Método auxiliar para facilitar a exibição dos dados no console
    @Override
    public String toString() {
        return nome + " [" + tipo + "] - Valor: " + valor + " | Qtd: " + quantidade;
    }
}