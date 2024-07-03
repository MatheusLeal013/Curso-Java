package entities;

public class ImportedProduct extends Product {
	
	private Double customsFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFree() {
		return customsFee;
	}

	public void setCustomsFree(Double customsFree) {
		this.customsFee = customsFree;
	}
	
	@Override
	public String priceTag() {
		// IMPORTANTE
		return getName() // Isso me deixou confuso, não esquecer desse detalhe
		+ " $ " 
	    + String.format("%.2f", getPrice() + customsFee)
	    + " (Customs free: $ "
	    + String.format("%.2f", customsFee)
	    + ")";
	}
}
