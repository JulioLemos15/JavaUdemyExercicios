package model.exceptions; //Vai ser uma exeção Lançada por algum erro lançada por algum erro na minha entidade de dominio que é o reservation.

public class DomainExceptionMelhorJeito extends RuntimeException{//RuntimeException é um tipo de exceção que o compilador não obriga você a tratar, mas caso for uma subclasse de exception o compilador vai obrigar a tratar.
	//No caso o exception é serializeb ele precisa ter uma versão e o valor padrao de versão é o valor 1L
	private static final long serialVersionUID = 1L;
	
	public DomainExceptionMelhorJeito(String msg) {
		super(msg); //repassa a mensagem pro construtor da superClasse, porque é para permitir que eu possa instanciar a minha exeção personalizada que é essa classe, passando uma mensagem pra ela e essa mensagem fica armazenada dentro da minha exeção.
	}
}
