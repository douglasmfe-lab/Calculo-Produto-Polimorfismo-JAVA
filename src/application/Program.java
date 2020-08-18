package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner (System.in);
		ArrayList <Product> list = new ArrayList<>();
		
		String name = " ";
		double price = 0;
		double customsFee = 0;
		Date manufactureDate = new Date();
		
		
		System.out.print("Enter the numbers of products: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.printf("Product #" + i + " data: \n");
			System.out.print("Common, used or imported (c/u/i)? ");
			char option = sc.next().charAt(0);
				
			switch(option) {
		
			case 'c':
				System.out.print("Name: ");
				sc.nextLine();
				name = sc.nextLine();
				System.out.print("Price: ");
				price = sc.nextDouble();
				list.add(new Product(name, price));
				break;
			
			case 'u':	
				System.out.print("Name: ");
				sc.nextLine();
				name = sc.nextLine();
				System.out.print("Price: ");
				price = sc.nextDouble();
				System.out.print("Manufacture date(DD/MM/YYYY): ");
				sc.nextLine();
				String date = sc.nextLine();
				manufactureDate = sdf.parse(date);
				list.add(new UsedProduct(name, price, manufactureDate));
				break;
					
			case 'i':
				System.out.print("Name: ");
				sc.nextLine();
				name = sc.nextLine();
				System.out.print("Price: ");
				price = sc.nextDouble();
				System.out.print("customs fee: ");
				customsFee = sc.nextDouble();
				Product product = new ImportedProduct(name, price, customsFee); 
				list.add(product);
				break;
				
			default:
				System.out.println("Opção inválida! Digite novamente a opção (c/u/i): ");
				option = sc.next().charAt(0);
				}
		
		}	
		System.out.println();
		System.out.println("PRICE TAGS: ");
		
		for(Product x: list) {
			
			System.out.print(x.priceTag() + "\n");	
		}
							
		sc.close();
	}

}