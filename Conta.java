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

    public void deposita(double valor) throws ValorInvalidoException {
		if (valor <= 0) {
			throw new ValorInvalidoException("Valor invÃ¡lido");
		}
		this.saldo += valor;

	}

    public void debita(double valor) throws ValorInvalidoException, LimiteExcedidoException {
		if (valor <= 0) {
			throw new ValorInvalidoException("Valor InvÃ¡lido!");

		} else if (valor > this.saldo) {
			throw new LimiteExcedidoException("Saldo Insuficiente!");
		}
		this.saldo -= valor;

	}

    @Override
    public String toString()
    {
        return "Possui: " + this.saldo;
    }
    
}