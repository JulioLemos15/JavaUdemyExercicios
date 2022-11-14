package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservationMuitoRuim {
	
	private Integer roomNumber; //numero do quarto
	private Date checkIn; //dia entrada
	private Date checkOut; //dia saida
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //formatação da data
	
	public ReservationMuitoRuim() {
		
	}

	public ReservationMuitoRuim(Integer roomNumber, Date checkIn, Date checkOut) {
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
	
	public void updateDates(Date checkIn, Date checkOut) {
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
