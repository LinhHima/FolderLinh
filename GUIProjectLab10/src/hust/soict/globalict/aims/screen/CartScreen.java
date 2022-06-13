package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import hust.soict.globalict.aims.Aims.Store;
import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame{

	private Cart cart;

	public CartScreen(Cart cart) {
		super();
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
					
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
		});
		
	}
		public static void main(String[] args) {
			Cart cart = new Cart();
			DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation",20f,12);
			DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",10f,20);
			DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f,30);
			DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Trek", "Science Fiction",26.1f,50);
			Track track1 = new Track("Moon",1);
			Track track2 = new Track("Sun",2);
			Track track3 = new Track("Eclipsse",3);
			Track track4 = new Track("HoangAnhCute",4);
			Track[] track =new Track[] {track1,track2,track3};
			ArrayList<Track> tracklist2= new ArrayList<Track>(Arrays.asList(track));
			CompactDisc CD1 = new CompactDisc("November","Ballad",30.45f,"Taylor Swift",tracklist2);
			CompactDisc CD2 = new CompactDisc("Downtown","Pop",20.15f,"Chairle",tracklist2);
			CompactDisc CD3 = new CompactDisc("Love","Ballad",10.15f,"Kay",tracklist2);
			Book book1 = new Book("Doraemon","Comic",12.5f);
			Book book2 = new Book("Conan","Comic",13.5f);
			cart.addMedia(dvd1);
			cart.addMedia(dvd2);
			cart.addMedia(dvd3);
			cart.addMedia(dvd4);
			cart.addMedia(CD1);
			cart.addMedia(CD2);
			cart.addMedia(CD3);
			new CartScreen(cart);
		}
}
