package hust.soict.globalict.aims.screen;
import hust.soict.globalict.aims.Aims.Store;
import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.media.*;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());

        JPanel inputPane = new JPanel(new GridLayout(0, 2, 2, 2));
        inputPane.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 40));

        inputPane.add(new JLabel("Title:"));
        JTextField title = new JTextField(50);
        inputPane.add(title);

        inputPane.add(new JLabel("Category:"));
        JTextField category = new JTextField(50);
        inputPane.add(category);

        inputPane.add(new JLabel("Director:"));
        JTextField director = new JTextField(50);
        inputPane.add(director);

        inputPane.add(new JLabel("Length:"));
        JTextField length = new JTextField(50);
        inputPane.add(length);

        inputPane.add(new JLabel("Cost:"));
        JTextField cost = new JTextField(50);
        inputPane.add(cost);

        JPanel footPane = new JPanel();
        JButton addButton = new JButton("ADD");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                store.addMedia(new DigitalVideoDisc(title.getText(), category.getText(),
                         Float.parseFloat(cost.getText().toString()),Integer.parseInt(length.getText().toString())));
                new StoreScreen(store,cart);
            }
        });
        footPane.add(addButton);
        inputPane.add(footPane, BorderLayout.SOUTH);
        center.add(inputPane, BorderLayout.CENTER);
        return center;
    }

    public AddDigitalVideoDiscToStoreScreen(Store store,Cart cart) {
        super(store,cart);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Add Digital Video Disc To Store");
        setSize(800, 450);
    }
}