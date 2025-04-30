package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	public DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	public int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered < MAX_NUMBER_ORDERED) {			
			itemsOrdered[qtyOrdered++] = disc;
			System.out.printf("The disc \"%s\" has been added\nCurrent qty: %d%n", disc.getTitle(), qtyOrdered );
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i] == disc) {
				System.out.printf("The DVD \"%s\" has been removed\n", itemsOrdered[i].getTitle());
				itemsOrdered[i] = null;
				for (int j = i; j < qtyOrdered - 1; j++) {
	                itemsOrdered[j] = itemsOrdered[j + 1];
	            }				
				itemsOrdered[--qtyOrdered] = null;	
				System.out.printf("Current qty: %d%n", qtyOrdered);
				break;
			}
		}
	}
	
	public float totalCost() {
		float totalCost = 0;
		String title = null;
		for(int i = 0; i < qtyOrdered; i++) {
			totalCost += itemsOrdered[i].getCost();
			title = itemsOrdered[i].getTitle();
			if(title.length() < 7 ) {
				System.out.println(i+1 + "\t" + title + "\t\t\t" + itemsOrdered[i].getCost());
			}
			else {
				System.out.println(i+1 + "\t" + title + "\t\t" + itemsOrdered[i].getCost());
			}			
		}
		return totalCost;
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for(DigitalVideoDisc dvd : dvdList) {
			addDigitalVideoDisc(dvd);
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
	    addDigitalVideoDisc(dvd1);
	    addDigitalVideoDisc(dvd2);
	}
	
	public void searchDVDbyTitle(String search_title) {
		String DVD_found = null;
		for(int i = 0; i < qtyOrdered; i++) {
			boolean match = itemsOrdered[i].isMatch(search_title);
			if(match == true) {
				 DVD_found = itemsOrdered[i].toString();
			}			
		}
		if(DVD_found == null) {
			System.out.println("DVD not found");
		}
		else {
			System.out.println(DVD_found);
		}		
	}
	
	public void print() {
		float totalCost = 0;
		System.out.println("******************************CART******************************");
		System.out.println("Ordered Items:");
		for(int i = 0; i < qtyOrdered; i++) {
			totalCost += itemsOrdered[i].getCost();
			System.out. println(itemsOrdered[i].toString());
		}
		System.out.println("Total cost: " + totalCost);
		System.out.println("****************************************************************");		
	}	
	
	private List<Media> itemsOrders = new ArrayList<>();
	
	public void addMedia(Media media) {
		if (!itemsOrders.contains(media)) {
			itemsOrders.add(media);
			System.out.println("Media added: " + media.getTitle());
		} 
		else {
			System.out.println("Media already in cart: " + media.getTitle());
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrders.contains(media)) {
			itemsOrders.remove(media);
			System.out.println("Media removed: " + media.getTitle());
		} 
		else {
			System.out.println("Media not exist in cart: " + media.getTitle());
		}
	}
	
	public void sortByTitle() {
		Collections.sort(itemsOrders, Media.TITLE_THEN_COST);
		System.out.println("Cart sorted by title then by cost");
	}
	
	public void sortByCost() {
		Collections.sort(itemsOrders, Media.COST_THEN_TITLE);
		System.out.println("Cart sorted by cost then by title");
	}	
	
	public void searchDVDbyTitle_v2(String search_title) {
		String DVD_found = null;
		for(Media media : itemsOrders) {
			if(media.isMatch(search_title)) {
				 DVD_found = media.toString();
			}			
		}
		if(DVD_found == null) {
			System.out.println("DVD not found");
		}
		else {
			System.out.println(DVD_found);
		}		
	}
	
	public List<Media> getItemsOrders(){
		return itemsOrders;
	}
}
