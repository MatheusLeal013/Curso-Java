package application;

import java.time.LocalDate;
import java.util.Scanner;

import entities.Order;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Order order = new Order(1080, LocalDate.now(), OrderStatus.PENDING_PAYMENT);
		
		System.out.println(order);
		
		// Converter String para enum
		OrderStatus os1 = OrderStatus.DELIVERED;
		
		// String deve corresponder exatamente ao tipo enum
		OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
		OrderStatus os3 = OrderStatus.valueOf(sc.next());
		
		System.out.println(os1);
		System.out.println(os2);
		System.out.println(os3);
	}

}
