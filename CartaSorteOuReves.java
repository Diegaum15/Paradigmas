public class CartaSorteOuReves extends Carta {
    private String descricao;
    
    public CartaSorteOuReves(String nome, String descricao) {
        super(nome);
        this.descricao = descricao;
    }
    
    @Override
    public void acao(Jogador jogador, Tabuleiro tabuleiro) {
        // Lógica para sorte ou revés
    }
}