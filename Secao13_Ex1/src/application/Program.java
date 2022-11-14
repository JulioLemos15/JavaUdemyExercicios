package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: "); //Entre com o nome do departamento:
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data:"); //Insira os dados do trabalhador
		System.out.println("Name: "); //Nome
		String workerName = sc.nextLine();
		System.out.println("Level"); //Nivel
		String workerLevel = sc.nextLine();
		System.out.println("Base salary"); // salário base
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName)); //Para Instanciar a classe trabalhador, nós instaciamos um novo objeto do tipo worker os dados desses objetos é o nome que eu digitei, uma instancia de workerLevel no valor que eu digitei, e o valor de salario base q eu digitei, associado a esse objeto vai ter outro objeto do tipo department e o nome desse departamento vai ser o nome que eu digitei, departmentName.
		
		System.out.println("How many contracts to this worker? "); //quantos contratos esse trabalhador vai ter?
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract #" + i + " data: "); // Entre com uma data
			System.out.print("Date (DD/MM/YYYY)"); //Usuario vai digitar uma data nesse formato, e para receber uma data nesse formato vamos criar o metodo para a data no começo do código
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: "); //Valor por hora.
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hour): "); //Duração do contrato.
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract); //Faz o contrato ser Associado com o trabalhador.
			
		}
		System.out.println("");
		System.out.print("Enter month and yarn to calculate income (MM/YYYY): "); //Entre com mês e ano para calcular o salário.
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2)); // para pegar apenas mes
		int year = Integer.parseInt(monthAndYear.substring(3)); // para pegar apenas ano
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName()); //A composição de objetos eu tenho o objeto worker, vou acessar o outro objeto que ta associado a ele q é o department e depois vou associar o nome.
		System.out.println("Income for: " + monthAndYear + " : " + String.format("%.2f", worker.income(year, month))); // para pegar apenas mes e ano
		
		
		
		
		
		sc.close();
	}

}
