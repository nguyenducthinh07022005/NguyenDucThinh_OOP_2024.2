package hust.soict.hedspi.aims.store;

import java.util.Arrays;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class StoreTest {
	
	public static void main(String args[]) {
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		store.addMedia(dvd1);
		
		Book book1 = new Book(2, "The silent of the lambs", "Horror", 20.79f, Arrays.asList("Thomas Harris"));
		store.addMedia(book1);
		
		CompactDisc cd1 = new CompactDisc(3, "Alan Walker best songs", "Pop", 52.75f, 52, "No", "Alan Walker", Arrays.asList());
		Track track1 = new Track("Lily", 4);
		Track track2 = new Track("Alone", 5);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		store.addMedia(cd1);
		
		store.displayStore();
		
		store.removeMedia(book1);
		
		
		
		
		
		
		
		
	}
	
	
	

}
