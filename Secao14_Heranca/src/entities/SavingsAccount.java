package entities;

public final class SavingsAccount extends Account { //Conta Poupan�a, com (final) faz a minha classe n�o ser herdada por ninguem, ela n pode ser herdada, ninguem pode ser uma subclasse dela.
	
	private Double interestRate; //tacha de juros.
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() {
		balance += balance * interestRate;
	}
	
	//Vamos sobreescrever o metodo withdraw para que na conta poupan�a n�o cobre taxa
	@Override //indica para o compilador que isso � uma sobreposi��o de metodo.
	public final void withdraw(double amount) { // com (final) indica que n�o posso sobrepor de novo esse metodo, caso essa classe pudesse ter uma subclasse
		balance -= amount;
	}
}
