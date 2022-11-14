package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptionMelhorJeito;

public class ReservationMelhorJeito {
	
	private Integer roomNumber; //numero do quarto
	private Date checkIn; //dia entrada
	private Date checkOut; //dia saida
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //formatação da data
	
	public ReservationMelhorJeito() {
		
	}

	public ReservationMelhorJeito(Integer roomNumber, Date checkIn, Date checkOut){//devemos tratar/propagar a exeção com throws se utilizarmos exception na nossa subclasse e nos tratamos utilizando throws DomainExceptionMelhorJeito agora com RuntimeException não precisa
		if (!checkOut.after(checkIn)) {//programação defenciva 
			throw new DomainExceptionMelhorJeito ("Error in reservation: Check-out date must be after check-in date.");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}



	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}



	public Date getCheckIn() {
		return checkIn;
	}



	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}



	public Date getCheckOut() {
		return checkOut;
	}



	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();	//getTime me devolve a quantidade em milisegundos da determinada data.
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //converte o valor diff que estava em miliseconds para dias.
	}
	
	public void updateDates(Date checkIn, Date checkOut){//devemos tratar/propagar a exeção com throws se utilizarmos exception na nossa subclasse e nos tratamos utilizando throws DomainExceptionMelhorJeito agora com RuntimeException não precisa
		Date now = new Date(); // cria uma data com horario de agora!
		if(checkIn.before(now) || checkOut.before(now)) {//before(now) é se a data for anterior da de hoje.
			//throw new IllegalArgumentException ("Error in reservation: Reservation dates for update must be future.");Iremos lançar uma exeção utilizamos a palavra throw e temos que instanciar a exeção, essa exeção do java (IllegalArgumentException) a gente usa ela quando os argumentos que voce passa para um metodo eles sao invalidos
			throw new DomainExceptionMelhorJeito ("Error in reservation: Reservation dates for update must be future.");
		}
		if (!checkOut.after(checkIn)) {
			//throw new IllegalArgumentException ("Error in reservation: Check-out date must be after check-in date.");//Erro na reserva: A data de check-out deve ser depois da data de check-in
			throw new DomainExceptionMelhorJeito ("Error in reservation: Check-out date must be after check-in date.");
		} //Se passar pelos dois if e não executar nenhum erro, ai sim ele passa a atualizar as datas
		
		this.checkIn = checkIn; //fazer o checkIn do meu objeto receber o checkIn que vem do meu metodo
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room " + roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights"; //texto que informa o numero do apartamento o dia de entrada e o dia de saida e a quantidade de noites que isso dá.
	}
	
}
