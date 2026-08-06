// FilaDeEntrada.java
public class FilaDeEntrada {
    String[] fila;
    int inicio; // Próximo a sair (dequeue)
    int fim;    // Próxima posição livre (enqueue)

    public FilaDeEntrada(int capacidade) {
        fila = new String[capacidade];
        inicio = 0;
        fim = 0;
    }

    // Insere (enqueue) no final da fila
    public void cadastrarEntrada(String nome) {
        if (fim == fila.length) {
            System.out.println("Aviso: Fila de entrada cheia!");
            return;
        }
        fila[fim] = nome;
        System.out.println("Fila: " + nome + " chegou ao porto e aguarda na fila.");
        fim++;
    }

    // Remove (dequeue) do início da fila
    public String processarProximaEntrada() {
        if (inicio == fim) {
            System.out.println("Aviso: Fila vazia! Não há ninguém aguardando.");
            return null;
        }
        String nomeRemovido = fila[inicio];
        fila[inicio] = null;
        inicio++;
        System.out.println("Fila: Embarque liberado para " + nomeRemovido + "!");
        return nomeRemovido;
    }
}