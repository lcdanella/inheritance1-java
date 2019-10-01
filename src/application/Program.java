package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.entities.ImportedProduct;
import model.entities.Product;
import model.entities.UsedProducts;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of products: ");
		List<Product> products = new ArrayList<Product>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i ++) {
			System.out.printf("Product #%s data: %n", i+1);
			System.out.print("Common, used or imported? ");
			char op = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (op == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
			} else if (op == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				products.add(new UsedProducts(name, price, manufactureDate));
			} else if (op == 'c') {
				products.add(new Product(name, price));
			}
		}
		
		System.out.printf("%n%nPRICE TAGS: %n");
		for (Product product : products) {
			System.out.println(product.priceTag());
		}
		
	}

}
