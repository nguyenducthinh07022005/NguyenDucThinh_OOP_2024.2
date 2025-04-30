package hust.soict.hedspi.aims.cart;

import java.util.Scanner;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String args[]) {
		Cart cart = new Cart();	
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King","Animation", 19.95f, 87, "Roger Allers");
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin","Animation", 18.99f, 85, "No");
		cart.addDigitalVideoDisc(dvd3);		
		
		cart.print();	
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\nNhập tên DVD cần tìm: ");
		String search_title = scan.nextLine();		
		cart.searchDVDbyTitle(search_title);
		cart.searchDVDbyTitle_v2(search_title);
		scan.close();
	}
}
