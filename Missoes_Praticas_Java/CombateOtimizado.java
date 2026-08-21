import java.util.ArrayList;
import java.util.List;

class Projetil {
    boolean ativo;
    int id;

    public Projetil(int id) {
        this.ativo = false;
        this.id = id;
        System.out.println("Memória alocada: Projétil " + id + " criado com sucesso.");
    }

    public void atirar() {
        this.ativo = true;
        System.out.println("Pew! Projétil " + id + " está cruzando a tela.");
    }

    public void desativar() {
        this.ativo = false;
        System.out.println("Projétil " + id + " colidiu e voltou para a piscina de descanso.");
    }
}

class PoolDeProjeteis {
    private List<Projetil> pool;

    public PoolDeProjeteis(int capacidade) {
        System.out.println("--- CARREGANDO FASE (Alocando memória...) ---");
        pool = new ArrayList<>();
        for (int i = 1; i <= capacidade; i++) {
            pool.add(new Projetil(i));
        }
        System.out.println("----------------------------------------------\n");
    }

    public Projetil solicitarProjetil() {
        for (Projetil p : pool) {
            if (!p.ativo) {
                return p;
            }
        }
        System.out.println("ALERTA: Piscina vazia! Nenhum projétil disponível no momento.");
        return null;
    }
}

public class CombateOtimizado {
    public static void main(String[] args) {
        PoolDeProjeteis pool = new PoolDeProjeteis(10);
        List<Projetil> tirosNaTela = new ArrayList<>();

        System.out.println("=== JOGADOR APERTOU O GATILHO (8 Tiros) ===");
        for (int i = 0; i < 8; i++) {
            Projetil p = pool.solicitarProjetil();
            if (p != null) {
                p.atirar();
                tirosNaTela.add(p);
            }
        }

        System.out.println("\n=== 4 PROJÉTEIS ACERTARAM O CHEFÃO ===");
        for (int i = 0; i < 4; i++) {
            tirosNaTela.get(i).desativar();
        }

        System.out.println("\n=== JOGADOR CONTINUA ATIRANDO (Mais 5 Tiros) ===");
        for (int i = 0; i < 5; i++) {
            Projetil p = pool.solicitarProjetil();
            if (p != null) {
                p.atirar();
            }
        }
    }
}
