package hust.soict.hedspi.aims.screen.manager;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame {
	private Store store;

	 private JPanel createNorth() {
	        JPanel north = new JPanel();
	        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
	        north.add(createMenuBar());
	        north.add(createHeader());
	        return north;
	    }

	    private JMenuBar createMenuBar() {
	        JMenu menu = new JMenu("Options");
	        
	        JMenuItem viewStoreItem = new JMenuItem("View store");
	        viewStoreItem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Refresh the current screen
	                dispose();
	                new StoreManagerScreen(store);
	            }
	        });
	        menu.add(viewStoreItem);

	        // Sub-menu "Update Store"
	        JMenu smUpdateStore = new JMenu("Update Store");
	        
	        JMenuItem addBookItem = new JMenuItem("Add Book");
	        addBookItem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	                new AddBookToStoreScreen(store);
	            }
	        });
	        
	        JMenuItem addCDItem = new JMenuItem("Add CD");
	        addCDItem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	                new AddCompactDiscToStoreScreen(store);
	            }
	        });
	        
	        JMenuItem addDVDItem = new JMenuItem("Add DVD");
	        addDVDItem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	                new AddDigitalVideoDiscToStoreScreen(store);
	            }
	        });
	        
	        smUpdateStore.add(addBookItem);
	        smUpdateStore.add(addCDItem);
	        smUpdateStore.add(addDVDItem);
	        menu.add(smUpdateStore);

	        JMenuBar menuBar = new JMenuBar();
	        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	        menuBar.add(menu);

	        return menuBar;
	    }
	    
	    private JPanel createHeader() {
	        JPanel header = new JPanel();
	        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

	        JLabel title = new JLabel("AIMS");
	        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
	        title.setForeground(Color.CYAN);

	        header.add(Box.createRigidArea(new Dimension(10, 10)));
	        header.add(title);
	        header.add(Box.createHorizontalGlue());
	        header.add(Box.createRigidArea(new Dimension(10, 10)));

	        return header;
	    }

	    private JPanel createCenter() {
	        JPanel center = new JPanel();
	        center.setLayout(new GridLayout(3, 3, 2, 2));

	        ArrayList<Media> mediaInStore = store.getItemsInStore();
	        
	        if (mediaInStore != null && !mediaInStore.isEmpty()) {
	            int size = Math.min(9, mediaInStore.size());
	            
	            for (int i = 0; i < size; i++) {
	                MediaStore cell = new MediaStore(mediaInStore.get(i));
	                center.add(cell);
	            }
	            
	            for (int i = size; i < 9; i++) {
	                center.add(new JPanel());
	            }
	        } else {
	            for (int i = 0; i < 9; i++) {
	                center.add(new JPanel());
	            }
	        }

	        return center;
	    }
	    
	    public StoreManagerScreen(Store store) {
	        this.store = store;
	        
	        Container cp = getContentPane();
	        cp.setLayout(new BorderLayout());
	        cp.add(createNorth(), BorderLayout.NORTH);
	        cp.add(createCenter(), BorderLayout.CENTER);
	        
	        setTitle("Store");
	        setSize(1024, 768);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
	    }
	
	public static void main(String[] args) {
	    Store store = new Store();

	    store.addMedia(new DigitalVideoDisc("The Lion King", 19.95f));
	    store.addMedia(new Book("Star Wars", 24.95f));
	    store.addMedia(new CompactDisc("Aladin", 18.99f));
	    store.addMedia(new DigitalVideoDisc(4, "Avengers", "Action", 29.99f, 120, "Joss Whedon"));
	    store.addMedia(new Book("The Godfather", 21.50f));
	    store.addMedia(new CompactDisc("Inception", 22.00f));
	    store.addMedia(new DigitalVideoDisc(7, "Forrest Gump", "Drama", 19.80f, 142, "Robert Zemeckis"));
	    store.addMedia(new Book("Titanic", 20.00f));
	    store.addMedia(new CompactDisc("The Matrix", 23.45f));

	    JFrame frame = new JFrame("Store Manager");
	    frame.setSize(1024, 768);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    StoreManagerScreen screen = new StoreManagerScreen(store);
	    screen.store = store;

	    frame.setLayout(new BorderLayout());
	    frame.add(screen.createNorth(), BorderLayout.NORTH);
	    frame.add(screen.createCenter(), BorderLayout.CENTER);

	    frame.setVisible(true);
	}

	
	
	

}
