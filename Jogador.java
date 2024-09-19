
public class Jogador {
    private String nome;
    private int posicaoAtual;
    private Conta conta;
    private Peao peao;
    private List<CartaTerreno> propriedades;
    private boolean carta; 
    
    public Jogador(String nome, Peao peao, int saldoInicial) 
    {
        this.nome = nome;
        this.peao = peao;
        this.saldo = saldoInicial;
        this.propriedades = new ArrayList<>();
        this.conta = new Conta();
        this.carta = false;
        this.posicaoAtual = 0;
    }
    
    public void comprarPropriedade(CartaTerreno propriedade) {
        if (saldo >= propriedade.getValorCompra()) {
            saldo -= propriedade.getValorCompra();
            propriedades.add(propriedade);
            propriedade.setDono(this);
        }
    }
    
    public void pagarAluguel(Jogador dono, int valorAluguel) {
        saldo -= valorAluguel;
        dono.receberPagamento(valorAluguel);
    }
    
    public void receberPagamento(int valor) {
        saldo += valor;
    }
}
