import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoPonderado {

    // 1. Criamos uma classe interna para representar a conexão com o peso
    public class Aresta {
        String destino;
        int distanciaKm; // O "peso"

        public Aresta(String destino, int distanciaKm) {
            this.destino = destino;
            this.distanciaKm = distanciaKm;
        }

        @Override
        public String toString() {
            // Formata a exibição para ficar mais didático
            return destino + " (" + distanciaKm + "km)";
        }
    }
    
    // 2. Agora a lista guarda objetos do tipo 'Aresta'
    private Map<String, List<Aresta>> adjacencias;

    public GrafoPonderado() {
        this.adjacencias = new HashMap<>();
    }

    public void adicionarVertice(String cidade) {
        adjacencias.putIfAbsent(cidade, new ArrayList<>());
    }

    // 3. Atualizamos o método para receber também a distância
    public void adicionarAresta(String origem, String destino, int distanciaKm) {
        // Cria a aresta de ida
        adjacencias.get(origem).add(new Aresta(destino, distanciaKm));
        // Como é bidirecional (mão dupla), cria a aresta de volta
        adjacencias.get(destino).add(new Aresta(origem, distanciaKm));
    }

    public void imprimirGrafo() {
        for (String cidade : adjacencias.keySet()) {
            System.out.print("Saindo de " + cidade + " você pode ir para: ");
            System.out.println(adjacencias.get(cidade));
        }
    }

    public static void main(String[] args) {
        GrafoPonderado mapa = new GrafoPonderado();

        // Adicionando as cidades
        mapa.adicionarVertice("Manaus");
        mapa.adicionarVertice("Presidente Figueiredo");
        mapa.adicionarVertice("Rio Preto da Eva");
        mapa.adicionarVertice("Itacoatiara");

        // Adicionando as estradas e as distâncias (pesos) em KM
        mapa.adicionarAresta("Manaus", "Presidente Figueiredo", 107);
        mapa.adicionarAresta("Manaus", "Rio Preto da Eva", 80);
        mapa.adicionarAresta("Rio Preto da Eva", "Itacoatiara", 190);

        // Visualizando as conexões
        mapa.imprimirGrafo();
    }
}