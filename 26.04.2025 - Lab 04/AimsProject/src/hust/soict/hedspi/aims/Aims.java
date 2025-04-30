package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
	public static Cart cart = new Cart();
	public static Store store = new Store();
	public static Scanner scanner = new Scanner(System.in);
	
	public static void showMenu() {
		while(true) {
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
		
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: viewStore(); break;
			case 2: updateStore(); break;
			case 3: seeCurrentCart(); break;
			case 0: System.out.println("Goodbye!"); return;
			default: System.out.println("Invalid choice! Please retype: ");
			}
		}
	}
	
    private static void viewStore() {
        store.displayStore();
        storeMenu();
    }

    private static void storeMenu() {
    	while(true) {	
    		System.out.println("1. See a media's details");
    		System.out.println("2. Add a media to cart");
    		System.out.println("3. Play a media");
    		System.out.println("4. See current cart");
    		System.out.println("0. Back");

            int choice = scanner.nextInt();
            switch (choice) {
            case 1: showMediaDetails(); break;
            case 2: addMediaToCart(); break;
            case 3: playMedia(); break;
            case 4: cart.print(); break;
            case 0: return;
            default: System.out.println("Invalid choice! Please retype: ");
            }
        }
    }

    private static void showMediaDetails() {
        System.out.print("Enter media title: ");
        String search_title = scanner.nextLine();
        cart.searchDVDbyTitle(search_title);
    }

	private static void mediaDetailsMenu(Media media) {
        while(true) {
            System.out.println("1. Add to cart");
            if (media instanceof Playable) {
                System.out.println("2. Play");
            }
            System.out.println("0. Back");

            int choice = scanner.nextInt();
            switch (choice) {
            case 1: cart.addMedia(media); System.out.println("Number of items in cart: " + cart.getItemsOrders().size()); break;
            case 2: if (media instanceof Playable) { ((Playable) media).play();} break;
            case 0: return;
            }
        }
    }

    private static void addMediaToCart() {
        System.out.print("Enter media title: ");
        String search_title = scanner.nextLine();
        Media media = store.searchMediaByTitle(search_title);

        if (media != null) {
            cart.addMedia(media);
            System.out.println("Number of items in cart: " + cart.getItemsOrders().size());
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void playMedia() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.searchMediaByTitle(title);

        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or not playable.");
        }
    }

    private static void updateStore() {
        while (true) {
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: addMediaToStore(); break;
                case 2: removeMediaFromStore(); break;
                case 0: return;
            }
        }
    }

    private static void addMediaToStore() {
        System.out.println("1. Add DVD");
        System.out.println("2. Add Book");
        System.out.println("3. Add CD");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        if (choice == 0) return;

        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1: // DVD
                System.out.print("Director: ");
                String director = scanner.nextLine();
                System.out.print("Length (minutes): ");
                int length = scanner.nextInt();
                scanner.nextLine();

                DigitalVideoDisc dvd = new DigitalVideoDisc(
                        store.getItemsInStore().size() + 1,
                        title, category, cost, length, director);
                store.addMedia(dvd);
                break;
            case 2: // Book
                Book book = new Book(
                        store.getItemsInStore().size() + 1,
                        title, category, cost);
                System.out.print("Number of authors: ");
                int numAuthors = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < numAuthors; i++) {
                    System.out.print("Author " + (i+1) + ": ");
                    book.addAuthor(scanner.nextLine());
                }
                store.addMedia(book);
                break;
            case 3: // CD
                System.out.print("Artist: ");
                String artist = scanner.nextLine();
                System.out.print("Director: ");
                String cdDirector = scanner.nextLine();

                CompactDisc cd = new CompactDisc(store.getItemsInStore().size() + 1, title, category, cost, artist, cdDirector);

                System.out.print("Number of tracks: ");
                int numTracks = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < numTracks; i++) {
                    System.out.print("Track " + (i+1) + " title: ");
                    String trackTitle = scanner.nextLine();
                    System.out.print("Track " + (i+1) + " length (seconds): ");
                    int trackLength = scanner.nextInt();
                    scanner.nextLine();
                    cd.addTrack(new Track(trackTitle, trackLength));
                }
                store.addMedia(cd);
                break;
        }
        System.out.println("Media added to store.");
    }

    private static void removeMediaFromStore() {
        System.out.print("Enter media title to remove: ");
        String search_title = scanner.nextLine();
        Media media = store.searchMediaByTitle(search_title);

        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void seeCurrentCart() {
        cart.print();
        cartMenu();
    }

    private static void cartMenu() {
        while (true) {
            System.out.println("1. Filter media");
            System.out.println("2. Sort media");
            System.out.println("3. Remove media");
            System.out.println("4. Play media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
        

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: filterMedia(); break;
                case 2: sortMedia(); break;
                case 3: removeMediaFromCart(); break;
                case 4: playMediaInCart(); break;
                case 5: placeOrder(); return;
                case 0: return;
            }
        }
    }

    private static void filterMedia() {
        System.out.println("1. By ID");
        System.out.println("2. By Title");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        if (choice == 0) return;

        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            boolean found = false;
            for (Media media : cart.getItemsOrders()) {
                if (media.getId() == id) {
                    System.out.println(media);
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("No media found with ID: " + id);
        } else {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            boolean found = false;
            for (Media media : cart.getItemsOrders()) {
                if (media.getTitle().equalsIgnoreCase(title)) {
                    System.out.println(media);
                    found = true;
                }
            }
            if (!found) System.out.println("No media found with title: " + title);
        }
    }

    private static void sortMedia() {
       
        System.out.println("1. By Title");
        System.out.println("2. By Cost");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        if (choice == 0) return;

        if (choice == 1) {
            cart.sortByTitle();
        } else {
            cart.sortByCost();
        }
        cart.print();
    }

    private static void removeMediaFromCart() {
        System.out.print("Enter media title to remove: ");
        String title = scanner.nextLine();
        Media media = store.searchMediaByTitle(title);

        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    private static void playMediaInCart() {
        System.out.print("Enter media title to play: ");
        String search_title = scanner.nextLine();
        Media media = store.searchMediaByTitle(search_title);

        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or not playable.");
        }
    }

    private static void placeOrder() {
        System.out.println("Order created. Your cart will be emptied.");
        cart.getItemsOrders().clear();
    }
        
	public static void main(String[] args) {
		Cart anOrder = new Cart();			    
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King","Animation", 19.95f, 87, "Roger Allers");
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin","Animation", 18.99f, 85, "No");
		anOrder.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3};
		
		anOrder.addDigitalVideoDisc(dvdList);
		
		anOrder.addDigitalVideoDisc(dvd1, dvd2);
		
		System.out.printf("\tTotalCost\t\t%.2f", anOrder.totalCost());	
			
	    showMenu();		
	}
}
