package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

	private Cart cart;
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML 
	private TableColumn<Media,String> colMediaTitle;
	
	@FXML 
	private TableColumn<Media,String> colMediacategory;
	@FXML
	private TableColumn<Media,Float> colMediaCost;

	@FXML 
	private Button btnPlay;
	@FXML
	private Button btnRemove;
	
	public CartScreenController(Cart cart) {
		super();
		this.cart =cart;
	}
	@FXML 
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
		colMediacategory.setCellValueFactory(new PropertyValueFactory<Media,String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media,Float>("cost"));
		tblMedia.setItems(this.cart.getItemsInCart());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						if(newValue!=null) {
							updateButtonBar(newValue);
						}
					}
				}
			);
		
	}
	 void updateButtonBar(Media media) {
		// TODO Auto-generated method stub
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}else {
			btnPlay.setVisible(false);
		}
	}
	  @FXML
	    void btnRemovePressed(ActionEvent event) {
		  Media media = tblMedia.getSelectionModel().getSelectedItem();
		  cart.removeMedia(media);
	    }

}
