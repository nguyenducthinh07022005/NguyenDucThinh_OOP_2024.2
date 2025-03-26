public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
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
	
	void removeDigitalVideoDisc(DigitalVideoDisc disc) {
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
}
