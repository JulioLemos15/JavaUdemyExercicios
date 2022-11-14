package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.ReservationRuim;

public class JeitoRuim {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: "); //n�mero do quarto
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {//after � um m�todo de Date que testa se uma data � depois da outra.
			System.out.println("Error in reservation: Check-out date must be after check-in date.");//Erro na reserva: A data de check-out deve ser depois da data de check-in
		}
		else {//caso ao contrario, ai sim n�s vamos reservar o quarto
			ReservationRuim reservation = new ReservationRuim(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");//Insira os dados para atualizar a reserva:
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); //as variaveis ja foram declaradas em cima ent�o � so aproveitalas, n�o precisa declarar de novo o Date.
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkIn, checkOut); //metodo responsavel por atualizar as datas, c�digo est� dentro de entities. Em uma variavel String porque meu reservetion.updateDates vai me retorna uma String e esse String que vai dizer se aconteceu erro ou n�o
			if(error != null) {
				System.out.println("Error in reservation: " + error);
			}
			else {
				System.out.println("Reservation: " + reservation);
			}
			
		}
		
		//ATEN��O
		
		sc.close();
	}
}
