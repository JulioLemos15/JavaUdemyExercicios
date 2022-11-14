package application;

import java.sql.Date;

import entities.Order;
import entities.enums.OrderStatus;

public class Program {
	
	public static void main(String[] args) {
		
		Order order = new Order(1080, new Date(0), OrderStatus.AGUARDANDO_PAGAMENTO);
		
		System.out.println(order);
	}
}
