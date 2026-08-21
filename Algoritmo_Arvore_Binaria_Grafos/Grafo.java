import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
    
    // Lista de Adjacência: Mapeia um Vértice para a lista de seus vizinhos
    private Map<String, List<String>> adjacencias;

    // Construtor
    public Grafo() {
        this.adjacencias = new HashMap<>();
    }

    // Passo 1: Adicionar a "Cidade" (Vértice)
    public void adicionarVertice(String rotulo) {
        // Só adiciona se o vértice ainda não existir
        adjacencias.putIfAbsent(rotulo, new ArrayList<>());
    }

    // Passo 2: Construir a "Estrada" (Aresta) entre duas cidades
    public void adicionarAresta(String origem, String destino) {
        // Como é um grafo não-direcionado, adicionamos a conexão nos dois sentidos
        adjacencias.get(origem).add(destino);
        adjacencias.get(destino).add(origem);
    }

    // Método didático para visualizar o grafo no console
    public void imprimirGrafo() {
        for (String vertice : adjacencias.keySet()) {
            System.out.print("Vértice " + vertice + " está conectado a: ");
            System.out.println(adjacencias.get(vertice));
        }
    }

    // Função Principal (Teste)
    public static void main(String[] args) {
        Grafo meuGrafo = new Grafo();

        // Adicionando vértices
        meuGrafo.adicionarVertice("Alice");
        meuGrafo.adicionarVertice("Bob");
        meuGrafo.adicionarVertice("Carlos");

        // Criando conexões (arestas)
        meuGrafo.adicionarAresta("Alice", "Bob");
        meuGrafo.adicionarAresta("Alice", "Carlos");

        // Resultado esperado:
        // Alice está conectado a: [Bob, Carlos]
        // Bob está conectado a: [Alice]
        // Carlos está conectado a: [Alice]
        meuGrafo.imprimirGrafo();
    }
}