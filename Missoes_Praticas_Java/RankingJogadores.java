public class RankingJogadores {
    NoArvore raiz;
    private int contagemTop = 0;

    public RankingJogadores() {
        this.raiz = null;
    }

    public void inserirPontuacao(int pontuacao, String nome) {
        raiz = inserirRecursivo(raiz, pontuacao, nome);
    }

    private NoArvore inserirRecursivo(NoArvore atual, int pontuacao, String nome) {
        if (atual == null) {
            return new NoArvore(pontuacao, nome);
        }
        if (pontuacao < atual.pontuacao) {
            atual.esquerda = inserirRecursivo(atual.esquerda, pontuacao, nome);
        } else if (pontuacao > atual.pontuacao) {
            atual.direita = inserirRecursivo(atual.direita, pontuacao, nome);
        }
        return atual; 
    }

    public void exibirTop3() {
        System.out.println("=== TOP 3 LEADERBOARD ===");
        contagemTop = 0; 
        exibirTop3Recursivo(raiz);
        System.out.println("=========================");
    }

    private void exibirTop3Recursivo(NoArvore atual) {
        if (atual != null && contagemTop < 3) {
            exibirTop3Recursivo(atual.direita); 
            if (contagemTop < 3) {
                System.out.println((contagemTop + 1) + "º Lugar: " + atual.pontuacao + " pts - " + atual.nomeJogador);
                contagemTop++;
            }
            exibirTop3Recursivo(atual.esquerda);
        }
    }

    public static void main(String[] args) {
        RankingJogadores ranking = new RankingJogadores();
        ranking.inserirPontuacao(1500, "Jogador 1");
        ranking.inserirPontuacao(3000, "Mestre Jedi");
        ranking.inserirPontuacao(100, "Noob");
        ranking.inserirPontuacao(2500, "Atirador de Elite");
        ranking.inserirPontuacao(2800, "Piloto Fantasma");
        ranking.exibirTop3();
    }
}
