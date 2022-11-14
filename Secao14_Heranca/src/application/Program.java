package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
	
	public static void main(String[] args) {
		
		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		//UPCASTING � eu pegar um objeto do businessAccount e atribui-lo para uma variavel do tipo account.
		
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0); //Est� atibuindo um objeto da superClasse para a subClasse.
		Account acc3 = new SavingsAccount(1004, "Julio", 0.0, 0.1); // numero da conta, titular, saldo, e tacha de juros. Saiba diferenciar as classes
		// n�o da erro porque a heren�a � uma rela��o de � um, ou seja uma BusinessAccount ela � uma account. Uma conta emrpesarial tamb�m e uma conta.
		
		//DOWNCASTING � converter um objeto da super classe para subclasse.
		
		BusinessAccount acc4 = (BusinessAccount)acc2;
		
		//BusinessAccount acc4 = acc2; / da um erro porque n�o se pode converter uma subClasse para a superClasse se quiser fazer uma conversao da subClasse para superClasse vamos ter que for�ar fazendo um casting manual, veja abaixo. E s� pode for�ar essa conven��o porque acc2 � uma Account que est� instanciada pela BusinessAccount. Para for�ar utilizamos instanceof e poder utilizar de outra instancia.
		
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200.0); //assim podemos utilizar emprestimo pois acc3 � uma instancia da conta Poupan�a.
			System.out.println("Loan!"); //Loan � emprestimo
		}
		
		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
		
		
		
	}
}
;