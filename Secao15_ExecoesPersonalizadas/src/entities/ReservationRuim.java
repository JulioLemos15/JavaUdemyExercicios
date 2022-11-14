package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservationRuim {
	
	private Integer roomNumber; //numero do quarto
	private Date checkIn; //dia entrada
	private Date checkOut; //dia saida
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //formatação da data
	
	public ReservationRuim() {
		
	}

	public ReservationRuim(Integer roomNumber, Date checkIn, Date checkOut) {
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
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date(); // cria uma data com horario de agora!
		if(checkIn.before(now) || checkOut.before(now)) {//before(now) é se a data for anterior da de hoje.
			return "Error in reservation: Reservation dates for update must be future.";//Erro na reserva: As datas de reserva para atualização devem ser futuras.
		}
		if (!checkOut.after(checkIn)) {
			return "Error in reservation: Check-out date must be after check-in date.";//Erro na reserva: A data de check-out deve ser depois da data de check-in
		} //Se passar pelos dois if e não executar nenhum erro, ai sim ele passa a atualizar as datas
		
		this.checkIn = checkIn; //fazer o checkIn do meu objeto receber o checkIn que vem do meu metodo
		this.checkOut = checkOut;
		
		return null; //esse é o criterio para falar que minha operação não teve nenhum erro, sem o return null da erro por conta de ser um Método String.
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
