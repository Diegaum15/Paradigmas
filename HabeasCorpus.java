public class HabeasCorpus extends SorteOuReves{
    public HabeasCorpus(String descricao, String valor)
    {
        super(descricao, valor);
    }

    @Override
    public void acao(Jogador jogador)
    {
        jogador.adicionaCarta();
        System.out.println(this.descricao);
    }
}