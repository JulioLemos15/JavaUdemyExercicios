package entities;

public class BusinessAccount extends Account { //Estamos definindo que a minha classe BusinessAccount (Conta Empresarial) ela terá todos os dados de comportamento de Account extends metodo de herança.
	
	private Double loanLimit; //limite de emprestimo
	
	public BusinessAccount() {
		super(); //Utilizamos pq se na classe account tiver uma logica implementada em seu construtor padrao, poderemos repitir a mesma logica nessa subclasse. Caso seja incluida no futuro algunha logica em Account não precisamos nos preocupar com essa subclasse BussinessAccount. 
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) { //Precisamos reaproveitar os argumentos da classe Account no nosso construtor.
		super(number, holder, balance); //Chama o construtor da super classe que é a classe Account e pra isso utiliza a palavra super com os argumentos d	entro dela.
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
		//deposit(amount); Emprestimo de dinheiro, vou emprestar o dinheiro esse dinheiro vai entrar na conta e usamos o msm metodo de deposit declarado na super classe que é a account. e ele pega a quantia do emprestimo e faz a soma com o metodo de deposit.
		balance += amount -10.0; //10 é o preço da taxa	
		}
	}
	
	@Override //indica para o compilador que isso é uma sobreposição de metodo.
	public void withdraw(double amount) {
		super.withdraw(amount); //desconta normalmente oq está na superClasse que é os 5 reias. Com o super podemos reutilizar o metodo que está na superClasse
		balance -= 2.0; //E nessa conta Empresa desconta tambem mais 2 reais.
	}
	
}
