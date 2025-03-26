
public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();			    
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation", "No", 87, 18.99f);
		anOrder.addDigitalVideoDisc(dvd3); 
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd4);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd5);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Aladin","Animation", "No", 87, 18.99f);
		anOrder.addDigitalVideoDisc(dvd6);
		
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd7);
		
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd8);
		
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Aladin","Animation", "No", 87, 18.99f);
		anOrder.addDigitalVideoDisc(dvd9);
		
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd10);
		
		DigitalVideoDisc dvd11 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd11);
		
		DigitalVideoDisc dvd12 = new DigitalVideoDisc("Aladin","Animation", "No", 87, 18.99f);
		anOrder.addDigitalVideoDisc(dvd12);
		
		DigitalVideoDisc dvd13 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd13);
		
		DigitalVideoDisc dvd14 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd14);
		
		DigitalVideoDisc dvd15 = new DigitalVideoDisc("Aladin","Animation", "No", 87, 18.99f);
		anOrder.addDigitalVideoDisc(dvd15);
		
//		DigitalVideoDisc dvd16 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
//		anOrder.addDigitalVideoDisc(dvd16);
//		
//		DigitalVideoDisc dvd17 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
//		anOrder.addDigitalVideoDisc(dvd17);
//		
//		DigitalVideoDisc dvd18 = new DigitalVideoDisc("Aladin","Animation", "No", 87, 18.99f);
//		anOrder.addDigitalVideoDisc(dvd18);
//		anOrder.removeDigitalVideoDisc(dvd18);
//		
//		DigitalVideoDisc dvd19 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
//		anOrder.addDigitalVideoDisc(dvd19);
//		
//		DigitalVideoDisc dvd20 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
//		anOrder.addDigitalVideoDisc(dvd20);
//		
//		DigitalVideoDisc dvd21 = new DigitalVideoDisc("Aladin","Animation", "No", 87, 18.99f);
//		anOrder.addDigitalVideoDisc(dvd21);
		
		DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3, dvd4};
		anOrder.addDigitalVideoDisc(dvdList);
		
		anOrder.addDigitalVideoDisc(dvd15, dvd2);
		System.out.printf("\tTotalCost\t\t%.2f", anOrder.totalCost());
	}
}
