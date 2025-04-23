package hust.soict.hedspi.aims.comaparation;

import java.util.Comparator;

import hust.soict.hedspi.aims.media.Media;

public class CompareByCostThenByTitle implements Comparator<Media>{
	@Override
	public int compare(Media media1, Media media2) {
		if((Float.compare(media1.getCost(), media2.getCost()) != 0)) {
			return Float.compare(media1.getCost(), media2.getCost());
		}
		return media1.getTitle().compareTo(media2.getTitle());
		
	}
	
	

}
