public class CartaTerreno extends Carta {
    private int valorCompra;
    private int aluguel;
    private Jogador dono;
    
    public CartaTerreno(String nome, int valorCompra, int aluguel) {
        super(nome);
        this.valorCompra = valorCompra;
        this.aluguel = aluguel;
        this.dono = null;
    }
    
    @Override
    public void acao(Jogador jogador, Tabuleiro tabuleiro) {
        // Lógica para compra do terreno
    }
}