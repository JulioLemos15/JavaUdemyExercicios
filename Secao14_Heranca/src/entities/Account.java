package entities;

public class Account { //Conta
	
	private Integer number; //numero
	private String holder; //titular
	protected Double balance; //saldo //protected faz as permissao da nossa subclasse poder usar balance, diferente de private que só permite a sua propria classe fazer o chamado dela mesma
	
	public Account() {
		
	}

	public Account(Integer number, String holder, Double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() { //Retirar o setBalance porque não podemos modificar o saldo da conta livremente
		return balance;
	}
	
	public void withdraw(double amount) {
		balance -= amount + 5.0; //Metodo de saque, descontar oq foi tirado. E na conta normal assim que a pessoa saca é descontado 5 reais, vamos fazer um metodo na conta poupança para que não seja descontado se a pessoa tiver conta poupança.
	}
	
	public void deposit(double amount) {
		balance += amount; //Metodo de deposito, vai receber a quantidade e somar, amount == quantidade.
	}
}
