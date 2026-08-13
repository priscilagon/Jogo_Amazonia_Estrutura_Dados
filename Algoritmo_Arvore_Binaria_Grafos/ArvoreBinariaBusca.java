public class ArvoreBinariaBusca {

    // 1. Classe interna que representa cada elemento da árvore
    class No {
        int valor;
        No esquerda;
        No direita;

        public No(int valor) {
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }
    }

    // A árvore só precisa conhecer o nó raiz para acessar o resto
    private No raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    // ==========================================
    // INSERÇÃO
    // ==========================================
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No atual, int valor) {
        // Se achou um espaço vazio, cria o novo nó aqui
        if (atual == null) {
            return new No(valor);
        }

        // Regra da BST: Menor vai para a ESQUERDA
        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        } 
        // Regra da BST: Maior vai para a DIREITA
        else if (valor > atual.valor) {
            atual.direita = inserirRecursivo(atual.direita, valor);
        }
        
        // Retorna o nó atual inalterado (ignora valores duplicados)
        return atual;
    }

    // ==========================================
    // BUSCA
    // ==========================================
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No atual, int valor) {
        // Se chegou no fim da árvore e não achou
        if (atual == null) {
            return false;
        }

        // Se achou o valor exato!
        if (valor == atual.valor) {
            return true;
        }

        // Se o valor procurado é menor, procura só na subárvore da esquerda
        if (valor < atual.valor) {
            return buscarRecursivo(atual.esquerda, valor);
        } 
        // Se for maior, procura só na subárvore da direita
        else {
            return buscarRecursivo(atual.direita, valor);
        }
    }

    // ==========================================
    // IMPRIMIR (Travessia In-Order)
    // ==========================================
    public void exibirEmOrdem() {
        System.out.print("Árvore em ordem crescente: ");
        exibirEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void exibirEmOrdemRecursivo(No atual) {
        if (atual != null) {
            exibirEmOrdemRecursivo(atual.esquerda); // Visita toda a esquerda (menores)
            System.out.print(atual.valor + " ");    // Imprime o atual
            exibirEmOrdemRecursivo(atual.direita);  // Visita toda a direita (maiores)
        }
    }

    // ==========================================
    // MÉTODO MAIN PARA TESTE
    // ==========================================
    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        /*
               Construindo a seguinte árvore:
                      50
                    /    \
                  30      70
                 /  \    /  \
               20   40  60   80
        */
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        // Imprimindo - A mágica do "In-Order" é que ele SEMPRE imprime ordenado!
        arvore.exibirEmOrdem(); 
        // Saída esperada: 20 30 40 50 60 70 80

        // Testando a busca
        int alvo1 = 40;
        int alvo2 = 90;
        
        System.out.println("\nBuscando o número " + alvo1 + "...");
        System.out.println("Encontrado? " + arvore.buscar(alvo1)); // True

        System.out.println("Buscando o número " + alvo2 + "...");
        System.out.println("Encontrado? " + arvore.buscar(alvo2)); // False
    }
}