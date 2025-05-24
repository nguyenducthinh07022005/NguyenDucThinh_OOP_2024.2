package hust.soict.program.test.screen.customer.store;

import hust.soict.hedspi.aims.store.Store;

import java.util.Arrays;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "src/hust/soict/hedspi/aims/screen/customer/view/Store.fxml" + "";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        /*
         * Add some items to store here
         * ...
         */
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
        launch(args);

    }
}
