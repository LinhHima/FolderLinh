package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class MediaStore extends JPanel {
	private Media media;
	protected Cart cart;
	//public StoreScreen storeScreen;
	public MediaStore(Media media,Cart cart) {
		this.media =media;
		this.cart = cart;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+ " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton cart_button = new JButton("Add to cart");
		container.add(cart_button);
		 cart_button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ae) {
	                Add_to_cart(media,cart);
	            }
	        });

		if(media instanceof Playable) {
			JButton button_play = new JButton("Play");
			container.add(button_play);
			 button_play.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent ae) {
		                Play_media(media);
		            }
			 });
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	protected void Add_to_cart(Media media2, Cart cart) {
		// TODO Auto-generated method stub
		this.cart =cart;
		this.cart.addMedia(media2);
	}
	protected void Play_media(Media media2) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null,
				"Title: "+media2.getTitle() +"; Category: "+media2.getCategory()
				+"; Cost: "+media2.getCost(),
				"Information",
				JOptionPane.INFORMATION_MESSAGE
				);
	}
}
