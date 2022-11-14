package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>(); //quando tiver uma composição de tem muitos, que no caso é uma lista não inclui no construtor, simplesmente inicia a lista vazia
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts; // não pode deixa o setContracts porque a minha lista de trabalhador(Worker) inicialmente vai ser instanciada como lista vazia e depois vou poder adicionar e remover contratos nessa lista, só que de maneira alguma eu posso permitir q essa lista seja trocada e no metodo setContracts ele recebe outra lista e essa outra lista é atribuida para a lista de contratos do trabalhador.
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract); // dois metodos esse e o de baixo add e remove, responsaveis por fazer ou desfazer a associação entre um trabalhador e um contrato
	}
	public void removeContract(HourContract contract) {
		contracts.remove(contract);  
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) { // para cada contrado c na lista de contracts
			cal.setTime(c.getDate()); // cal é definido como Calendario pegando a data das horas do contrato.s
			int c_year = cal.get(Calendar.YEAR);
			int c_month = cal.get(Calendar.MONTH);
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
