
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
        this.peao = new Peao();
        this.saldo = saldoInicial;
        this.propriedades = new ArrayList<>();
        this.conta = new Conta();
        this.carta = false;
        this.posicaoAtual = 0;
    }

    public int lancaDado() {
        return Dado.lancaDado();
    }
    
    public String getNome() {
        return nome;
    }

    public int getSaldo() {
        return saldo;
    }

    public Peao getPeao() {
        return peao;
    }

    public List<CartaTerreno> getPropriedades() {
        return propriedades;
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

    public void pagarTaxa(Jogador jogador, int valor) 
    {
        saldo -= valor;
        jogador.receberPagamento(valor);
    }

    // Verifica se o jogador consegue pagar 
    public boolean pagar(int valor)
    {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public void jogada(int Dado, Jo)

    
}
