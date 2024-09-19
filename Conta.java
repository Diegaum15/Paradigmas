
public class Conta{
    private int saldo;

    public Conta()
    {
        this.saldo = 1500;
    }

    public int getSaldo()
    {
        return this.saldo;
    }

    @Override
    public String toString()
    {
        return "Possui: " + this.saldo;
    }
    // Atributos
    // Construtores
    // Metodos get set
    // Outros metodos 
}