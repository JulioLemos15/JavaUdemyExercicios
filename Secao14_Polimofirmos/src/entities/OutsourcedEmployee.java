package entities;

public class OutsourcedEmployee extends Employee{ //é uma subclasse da classe employ
	
	private Double additionalCharge; //despeza adicional
	
	public OutsourcedEmployee() {
		super();
	}

	public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
		super(name, hours, valuePerHour);
		this.additionalCharge = additionalCharge;
	}

	public Double getAdditionalCharge() {
		return additionalCharge;
	}

	public void setAdditionalCharge(Double additionalCharge) {
		this.additionalCharge = additionalCharge;
	}
	
	//Vamos sobreescrever nosso metodo de pagamento aqui nessa classe de funcionarios tercerizados.
	@Override
	public double payment() { // pagamento
		return super.payment() + additionalCharge * 1.1; // pega o pagamento normal mais os 110% das despezas adicionais para um funcionario tercerizado.
	}
	
}
