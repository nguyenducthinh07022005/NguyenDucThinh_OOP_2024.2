package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    private Cart cart;
    private Media media;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        if (this.media != null && this.cart != null) {
            
            cart.addMedia(this.media);
            System.out.println("Added " + this.media.getTitle() + " to cart from ItemController.");
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thành công");
            alert.setHeaderText(null);
            alert.setContentText("Đã thêm '" + this.media.getTitle() + "' vào giỏ hàng!");
            alert.showAndWait();

        } else {
            System.err.println("Cart or Media is null in ItemController.");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Không thể thêm sản phẩm vào giỏ hàng.");
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (this.media instanceof Playable) {
            try {
                ((Playable) this.media).play(); 
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Đang phát Media");
                alert.setHeaderText(null);
                alert.setContentText("Đang phát: " + this.media.getTitle());
                alert.showAndWait();
            } catch (PlayerException p) {
                System.err.println("PlayerException caught in ItemController: " + p.getMessage());
                System.err.println("Exception toString(): " + p.toString());
                p.printStackTrace(); 

                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Lỗi Phát Media");
                alert.setHeaderText("Không thể phát Media!");
                alert.setContentText(p.getMessage() + "\n\nChi tiết lỗi: " + p.toString());
                alert.showAndWait();
            }
        } else {
            System.out.println("Selected item is not playable.");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Không thể phát");
            alert.setHeaderText(null);
            alert.setContentText("Mục đã chọn không thể phát.");
            alert.showAndWait();
        }
    }

    public void setData(Media media) {
        if (media == null) return;

        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(String.format("%.2f $", media.getCost()));

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
            btnPlay.setManaged(true); 
        } else {
            btnPlay.setVisible(false);
            btnPlay.setManaged(false); 

            if (btnAddToCart.getParent() instanceof HBox) {
                HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
            }
        }
    }


    @FXML
    public void initialize() {
    }
}