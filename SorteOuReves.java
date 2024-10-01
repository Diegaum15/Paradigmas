public abstract class SorteOuReves{
    protected String descricao;
    protected int valor;
    
    public SorteOuReves(String descricao, String valor) 
    {
        this.descricao = descricao;
        this.valor = valor;
    }
    
    public void acao(Jogador jogador) {
        // Lógica para sorte ou revés
    }
}