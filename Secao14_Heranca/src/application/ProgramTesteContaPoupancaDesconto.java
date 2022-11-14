package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class ProgramTesteContaPoupancaDesconto {
	
	public static void main(String[] args) {
		
		Account acc1 = new Account(1001, "Alex", 1000.0);//numero da conta, titular, saldo.
		acc1.withdraw(200.0); //Saque
		System.out.println(acc1.getBalance()); // ver saldo da conta.
		
		//Agora testar a sobreposição da conta poupança
		
		Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
		acc2.withdraw(200.0);
		System.out.println(acc2.getBalance());
		
		// Testa o metodo de BusinessAccount que é o metodo de super que pega da super classe e adicionamos mais 2 reais de desconto.
		
		Account acc3 = new BusinessAccount(1003, "Julio", 1000.0, 500.0);
		acc3.withdraw(200.0);
		System.out.println(acc3.getBalance());
		
	}
}
