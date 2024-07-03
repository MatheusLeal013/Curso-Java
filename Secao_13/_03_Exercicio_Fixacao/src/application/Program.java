package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		LocalDate birthCliente = LocalDate.parse(sc.next(), fmt);
		
		Client client = new Client(nameClient, emailClient, birthCliente);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderStatus = sc.next();
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(orderStatus), client);
		
		for(int i = 0; i < n; i++) {
			System.out.printf("Enter #%d item data:\n", i+1);
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int Quantity = sc.nextInt();
			
			OrderItem item = new OrderItem(Quantity, productPrice, product);
			
			order.addItem(item);
		}
		
		System.out.println();
		
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
		
	}

}
