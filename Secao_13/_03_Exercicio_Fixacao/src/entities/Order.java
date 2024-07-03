package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

//import javax.swing.text.DateFormatter;


import entities.enums.OrderStatus;

public class Order {

	private static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private static DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDateTime moment;
	private OrderStatus stats;
	private Client client;
	
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(LocalDateTime moment, OrderStatus stats, Client client) {
		this.moment = moment;
		this.stats = stats;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStats() {
		return stats;
	}

	public void setStats(OrderStatus stats) {
		this.stats = stats;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0;
		for(OrderItem i : items) {
			sum += i.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + fmt1.format(moment) + "\n");
		sb.append("Order status: " + stats + "\n");
		sb.append("Client: " + client.getName() 
		+ " (" + fmt2.format(client.getBirthDate()) + ") - " + 
		client.getEmail() + "\n");
		sb.append("Order items:\n");
		for(OrderItem i : items) {
			sb.append(i + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		return sb.toString();
	}
	
	
}
