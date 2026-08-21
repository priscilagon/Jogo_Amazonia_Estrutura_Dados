import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoPonderado {

    public class Aresta {
        String destino;
        int distanciaKm; 

        public Aresta(String destino, int distanciaKm) {
            this.destino = destino;
            this.distanciaKm = distanciaKm;
        }

        @Override
        public String toString() {
            return destino + " (" + distanciaKm + "km)";
        }
    }
    
    private Map<String, List<Aresta>> adjacencias;

    public GrafoPonderado() {
        this.adjacencias = new HashMap<>();
    }

    public void adicionarVertice(String cidade) {
        adjacencias.putIfAbsent(cidade, new ArrayList<>());
    }

    public void adicionarAresta(String origem, String destino, int distanciaKm) {
        adjacencias.get(origem).add(new Aresta(destino, distanciaKm));
        adjacencias.get(destino).add(new Aresta(origem, distanciaKm));
    }

    public boolean verificarCaminhoDireto(String origem, String destino) {
        if (!adjacencias.containsKey(origem)) {
            System.out.println("Zona de origem desconhecida.");
            return false;
        }
        for (Aresta rota : adjacencias.get(origem)) {
            if (rota.destino.equals(destino)) {
                System.out.println("-> ROTA DIRETA DISPONÍVEL!");
                System.out.println("Origem: " + origem + " | Destino: " + destino);
                System.out.println("Custo de Energia: " + rota.distanciaKm + " pontos.");
                return true;
            }
        }
        System.out.println("-> SEM ROTA DIRETA entre " + origem + " e " + destino + ". Faça escalas.");
        return false;
    }

    public static void main(String[] args) {
        GrafoPonderado mapa = new GrafoPonderado();
        mapa.adicionarVertice("Base Alpha");
        mapa.adicionarVertice("Posto Omega");
        mapa.adicionarVertice("Nebulosa Sombria");

        mapa.adicionarAresta("Base Alpha", "Posto Omega", 50);
        
        System.out.println("\nTentando viajar da Base Alpha para Posto Omega:");
        mapa.verificarCaminhoDireto("Base Alpha", "Posto Omega");

        System.out.println("\nTentando viajar da Base Alpha para Nebulosa Sombria:");
        mapa.verificarCaminhoDireto("Base Alpha", "Nebulosa Sombria"); 
    }
}
