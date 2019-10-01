package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProducts extends Product {
	
	private Date manufactureDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


	public UsedProducts() {
		super();
	}
	
	public UsedProducts(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " (used)");
		sb.append(" $ ");
		sb.append(String.format("%.2f", price));
		sb.append(" (Manufacture date: "+ sdf.format(manufactureDate) + ")");
		return sb.toString();
	}
	
	
	
	
	
	

}
