public class NoArvore {
    int pontuacao;
    String nomeJogador;
    NoArvore esquerda;
    NoArvore direita;

    public NoArvore(int pontuacao, String nomeJogador) {
        this.pontuacao = pontuacao;
        this.nomeJogador = nomeJogador;
        this.esquerda = null;
        this.direita = null;
    }
}
