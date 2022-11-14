package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.ReservationMuitoRuim;

public class JeitoMuitoRuim {
	
	public static void main(String[] args) throws ParseException { //O programa tem que propragar o thorws ParseException para podermos utilizar o Date
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: "); //número do quarto
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {//after é um método de Date que testa se uma data é depois da outra.
			System.out.println("Error in reservation: Check-out date must be after check-in date.");//Erro na reserva: A data de check-out deve ser depois da data de check-in
		}
		else {//caso ao contrario, ai sim nós vamos reservar o quarto
			ReservationMuitoRuim reservation = new ReservationMuitoRuim(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");//Insira os dados para atualizar a reserva:
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); //as variaveis ja foram declaradas em cima então é so aproveitalas, não precisa declarar de novo o Date.
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date(); // cria uma data com horario de agora!
			if(checkIn.before(now) || checkOut.before(now)) {//before(now) é se a data for anterior da de hoje.
				System.out.println("Error in reservation: Reservation dates for update must be future.");//Erro na reserva: As datas de reserva para atualização devem ser futuras.
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date.");//Erro na reserva: A data de check-out deve ser depois da data de check-in
			}
			else {
				reservation.updateDates(checkIn, checkOut); //metodo responsavel por atualizar as datas, código está dentro de entities.
				System.out.println("Reservation: " + reservation);
			}
		}
		
		//ATENÇÂO: Esse Método é muito ruim porque colocamos a validação no programa principal e não na reserva, e isso é um problema de delegação
		
		sc.close();
	}
}
