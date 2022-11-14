package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.ReservationMelhorJeito;
import model.exceptions.DomainExceptionMelhorJeito;

public class MelhorJeito {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: "); //número do quarto
			int number = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			ReservationMelhorJeito reservation = new ReservationMelhorJeito(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");//Insira os dados para atualizar a reserva:
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); //as variaveis ja foram declaradas em cima então é so aproveitalas, não precisa declarar de novo o Date.
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e) {//Versão que eu sei que pode acontecer
			System.out.println("Invalid date format");//digitou uma data invalida
		}
		catch (DomainExceptionMelhorJeito e) {//depois posso mostra essa mensagem personalizada 
			System.out.println("Error in reservation: " + e.getMessage());//esse getMessage é a mensagem que instanciamos la na execção que esta em entities.
		}
		catch (RuntimeException e) {//Qualquer outra mensagem inesperada, caso meu programa quebre. è um tipo de exeção generico
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}
}
