public abstract class Carta {
    protected String nome;
    
    public Carta(String nome) {
        this.nome = nome;
    }
    
    public abstract void acao(Jogador jogador, Tabuleiro tabuleiro);
}