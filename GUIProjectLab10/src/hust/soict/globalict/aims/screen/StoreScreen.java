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
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.Aims.Store;
import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

import javax.swing.JLabel;
public class StoreScreen extends JFrame{
	Store store;
	public Cart cart;

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
			JMenuItem addBook = new JMenuItem("Add Book");
			smUpdateStore.add(addBook);
	        addBook.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	                new AddBookToStoreScreen(store,cart);
	            }
	        });

	        JMenuItem addCD = new JMenuItem("Add CD");
	        smUpdateStore.add(addCD);
	        addCD.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	                new AddCompactDiscToStoreScreen(store,cart);
	            }
	        });

	        JMenuItem addDVD = new JMenuItem("Add DVD");
	        smUpdateStore.add(addDVD);
	        addDVD.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	                new AddDigitalVideoDiscToStoreScreen(store,cart);
	            }
	        });

	        menu.add(smUpdateStore);
	        
	        // menu.add(new JMenuItem("View Store"));
	        JMenuItem viewStore = new JMenuItem("View store");
	        menu.add(viewStore);
	        viewStore.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ae) {
	            	//dispose();
	                new StoreScreen(store,cart);
	            }
	        });

	        JMenuItem viewCart = new JMenuItem("View cart");
	        menu.add(viewCart);
	        viewCart.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ae) {
	                new CartScreen(cart);
	            }
	        });

		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
		title.setForeground(Color.CYAN);
		
		JButton cart_t = new JButton("View cart");
		cart_t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new CartScreen(cart);
            }
        });
		cart_t.setPreferredSize(new Dimension(100,50));
		cart_t.setMaximumSize(new Dimension(100,50));
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart_t);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(5,5,2,2));
		
		ArrayList<Media> mediaInstore = store.getItemsInStore();
		for(int i=0;i<mediaInstore.size();i++) {
			MediaStore cell = new MediaStore(mediaInstore.get(i),cart);
			center.add(cell);
		}
		return center;
	}
	public StoreScreen(Store store,Cart cart) {
		this.store=store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(),BorderLayout.NORTH);
		cp.add(createCenter(),BorderLayout.CENTER);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Store");
		setSize(1024,768);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		Store store = new Store();
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
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(dvd4);
		store.addMedia(CD1);
		store.addMedia(CD2);
		store.addMedia(CD3);
		new StoreScreen(store,cart);
	}
}
