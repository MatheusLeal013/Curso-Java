package entities;

// Quando se usa um TreeSet, a sua classe do conjunto, ela tem que ser uma 
// implementação do Comparable, para que seja possível que o TreeSet ordene seu objetos
public class Product implements Comparable<Product> {
	private String name;
	private Double price;

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Product other) {
		return name.toUpperCase().compareTo(other.getName().toUpperCase());
	}
}