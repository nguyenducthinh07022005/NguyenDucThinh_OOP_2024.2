package hust.soict.hedspi.aims.comaparation;

import java.util.Comparator;
import hust.soict.hedspi.aims.media.Media;

public class CompareByTitleThenByCost implements Comparator<Media>{
	@Override
    public int compare(Media media1, Media media2) {
        if ((media1.getTitle().compareTo(media2.getTitle()) != 0)) {
            return media1.getTitle().compareTo(media2.getTitle());
        }
        return Float.compare(media2.getCost(), media1.getCost());
    }		
}
