package model.exceptions; //Vai ser uma exe��o Lan�ada por algum erro lan�ada por algum erro na minha entidade de dominio que � o reservation.

public class DomainExceptionMelhorJeito extends RuntimeException{//RuntimeException � um tipo de exce��o que o compilador n�o obriga voc� a tratar, mas caso for uma subclasse de exception o compilador vai obrigar a tratar.
	//No caso o exception � serializeb ele precisa ter uma vers�o e o valor padrao de vers�o � o valor 1L
	private static final long serialVersionUID = 1L;
	
	public DomainExceptionMelhorJeito(String msg) {
		super(msg); //repassa a mensagem pro construtor da superClasse, porque � para permitir que eu possa instanciar a minha exe��o personalizada que � essa classe, passando uma mensagem pra ela e essa mensagem fica armazenada dentro da minha exe��o.
	}
}
