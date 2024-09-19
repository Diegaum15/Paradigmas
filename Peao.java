public class Peao {
    private String cor;
    private int posicaoAtual; // Posição no tabuleiro (0 - 39 em um tabuleiro típico)
    
    public Peao(String cor) {
        this.cor = cor;
        this.posicaoAtual = 0; // Inicia no início do tabuleiro
    }
    
    public void avancarCasas(int numeroDeCasas) {
        this.posicaoAtual = (this.posicaoAtual + numeroDeCasas) % 40; // Exemplo para tabuleiro com 40 casas
    }
    
    public int getPosicaoAtual() {
        return posicaoAtual;
    }
}
