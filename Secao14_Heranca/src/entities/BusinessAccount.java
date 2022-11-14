package entities;

public class BusinessAccount extends Account { //Estamos definindo que a minha classe BusinessAccount (Conta Empresarial) ela ter� todos os dados de comportamento de Account extends metodo de heran�a.
	
	private Double loanLimit; //limite de emprestimo
	
	public BusinessAccount() {
		super(); //Utilizamos pq se na classe account tiver uma logica implementada em seu construtor padrao, poderemos repitir a mesma logica nessa subclasse. Caso seja incluida no futuro algunha logica em Account n�o precisamos nos preocupar com essa subclasse BussinessAccount. 
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) { //Precisamos reaproveitar os argumentos da classe Account no nosso construtor.
		super(number, holder, balance); //Chama o construtor da super classe que � a classe Account e pra isso utiliza a palavra super com os argumentos d	entro dela.
		this.loanLimit = loanLimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}
	
	public void loan(double amount) {
		if(amount <= loanLimit) {
		//deposit(amount); Emprestimo de dinheiro, vou emprestar o dinheiro esse dinheiro vai entrar na conta e usamos o msm metodo de deposit declarado na super classe que � a account. e ele pega a quantia do emprestimo e faz a soma com o metodo de deposit.
		balance += amount -10.0; //10 � o pre�o da taxa	
		}
	}
	
	@Override //indica para o compilador que isso � uma sobreposi��o de metodo.
	public void withdraw(double amount) {
		super.withdraw(amount); //desconta normalmente oq est� na superClasse que � os 5 reias. Com o super podemos reutilizar o metodo que est� na superClasse
		balance -= 2.0; //E nessa conta Empresa desconta tambem mais 2 reais.
	}
	
}
