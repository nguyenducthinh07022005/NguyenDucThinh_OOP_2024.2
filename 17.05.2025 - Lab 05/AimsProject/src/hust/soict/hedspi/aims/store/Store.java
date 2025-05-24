package hust.soict.hedspi.aims.store;
import java.util.ArrayList;
import java.util.List;
import hust.soict.hedspi.aims.media.Media;

public class Store {
	public ArrayList<Media> itemsInStore = new ArrayList<>(); 
	
	public void addMedia(Media media) {
		if(!itemsInStore.contains(media)) {
			itemsInStore.add(media);
			System.out.println("Media added: " + media.getTitle());
		}
		else {
			System.out.println("Media already in store: " + media.getTitle());
		}
	}

	public void removeMedia(Media media) {
		if(itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("Media removed: " + media.getTitle());
		}
		else {
			System.out.println("Media not exist in store: " + media.getTitle());
		}		
	}
	
	public void displayStore() {
		System.out.println("***********************STORE***********************");
		System.out.println("Available Media:");
		for (Media media : itemsInStore) {
			System.out.println(media);
		}
		System.out.println("***************************************************");		
	}
	
	public ArrayList<Media> getItemsInStore(){
		return itemsInStore;
	}

	public Media searchMediaByTitle(String search_title) {
		// TODO Auto-generated method stub
		for (Media media : itemsInStore) {
	        if (media.getTitle().equalsIgnoreCase(search_title)) {
	            return media;
	        }
	    }
	    return null;
	}
}