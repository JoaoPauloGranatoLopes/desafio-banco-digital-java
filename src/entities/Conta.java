package entities;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta() {

	}

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	public void sacar(double valorSaque) {
		if (valorSaque > saldo) {
			throw new RuntimeException("Não existe saldo suficiente em conta!");
		} else {
			saldo -= valorSaque;
		}

	}

	public void depositar(double valorDeposito) {
		saldo += valorDeposito;
	}

	public void transferir(double valorTransferencia, IConta contaDestino) {
		this.sacar(valorTransferencia);

		contaDestino.depositar(valorTransferencia);

	}

}
