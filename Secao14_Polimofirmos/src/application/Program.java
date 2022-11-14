package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>(); //instancia uma lista para funcionarios.
		
		System.out.println("Enter the number of employees: ");//Quantidade de Funcionarios
		int n = sc.nextInt(); //Lê a quantidade de funcionarios e guarda na variavel n.
		
		for(int i=1; i<=n; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)? ");//O funcionario é tercerizado?
			char ch = sc.next().charAt(0); //Para ler o caracter.
			System.out.print("Name: ");
			sc.nextLine();//antes de digitar uma String temos que coloca o sc.nextLine antes porque na hora que der entre se n tiver o nextLine antes fica um campo vazio.
			String name = sc.nextLine();
			System.out.println("Hours: ");
			int hours = sc.nextInt();
			System.out.println("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			if(ch == 'y') { // se a resposta for y significa que o funcionario é terceirizado
				System.out.println("additional charge: ");//taxa adicional
				double additionalCharge = sc.nextDouble();
				list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));//instanciamos um novo funcionario terceirizado e adicionamos na nossa lista de funcionarios
			}
			else {
				list.add(new Employee(name, hours, valuePerHour));
			}
		}
		
		System.out.println();
		System.out.println("PAYMENTS:"); //Pagamentos
		for (Employee emp : list) { //Para cada funcionario emp na minha lista
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}
		
		
		sc.close();
	}
}
