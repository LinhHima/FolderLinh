package hust.soict.globalict.aims.cart.Cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

import hust.soict.globalict.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Cart {
	public ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	public ArrayList<DigitalVideoDisc> DVDCart = new ArrayList<DigitalVideoDisc>();
	public ArrayList<CompactDisc> CDCart = new ArrayList<CompactDisc>();
	
	public ObservableList<Media> SortByTitleCost(){
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		return itemsOrdered;
	}
	public ObservableList<Media> SortByCostTitle(){
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		return itemsOrdered;
	}
	public void addMedia(Media media) {
//		for (int i=0;i<itemsOrdered.size();i++) {
//			if ( media.equals(itemsOrdered.get(i))) {
//				System.out.println("The media already exists!");
//				return;
//			}
//		}
		itemsOrdered.add(media);
		System.out.println("The media " +media.getTitle()+" has been added!");
		
	}
	
	
	public void removeMedia(Media media) {
		if(this.itemsOrdered.size() ==0) {
			System.out.println("Fail! The capacity is empty\n");
		}
		else {
			int check=0;
			for(int i=0;i<this.itemsOrdered.size();i++){
				if(this.itemsOrdered.get(i).getTitle().equals(media.getTitle())) {
					this.itemsOrdered.remove(i);
					check=1;
				}
			}
			if(check==1) System.out.println("Remove successfully!");
			else System.out.println("Remove fail!");
		}
	}
	

	public void removeMediaByName(String name) {
		if(this.itemsOrdered.size() ==0) {
			System.out.println("Fail! The capacity is empty\n");
		}
		else {
			int check=0;
			for(int i=0;i<this.itemsOrdered.size();i++){
				if(this.itemsOrdered.get(i).getTitle().equals(name)) {
					this.itemsOrdered.remove(i);
					check=1;
				}
			}
			if(check==1) System.out.println("Remove successfully!");
			else System.out.println("Remove fail!");
		}
	}
	
	
	public Media getALuckyItem() {
		int lucky =(int) Math.random()*(itemsOrdered.size());
		System.out.println(itemsOrdered.get(lucky));
		return itemsOrdered.get(lucky);
		
	}
	
	public float totalCost() {
		float sum =0;
		for(int i=0;i<itemsOrdered.size();i++) {
			
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	
	
	public void print() {
		System.out.println("*************CART*************");
		int sum=0;
		if (itemsOrdered.isEmpty()) {
			System.out.println("There is no item in cart.");
		}else {
			for(int i=0;i<this.itemsOrdered.size();i++) {
				sum+= itemsOrdered.get(i).getCost();
				System.out.println( "id: "+itemsOrdered.get(i).getId()+ " - "
									+itemsOrdered.get(i).getTitle()+" - "
									+itemsOrdered.get(i).getCategory()+" - "
									+itemsOrdered.get(i).getCost()+"$");
			}
		}
		System.out.println("Total cost: ["+sum+"]");
		System.out.println("******************************");
	}
	
	public void sortByID(){
		for (int i = 0; i < itemsOrdered.size()-1; i++) {
            for (int j = 0; j < itemsOrdered.size()-i-1; j++) {
                if (itemsOrdered.get(j).getId() > itemsOrdered.get(j+1).getId()){
                	DigitalVideoDisc m = new DigitalVideoDisc();
                	 m.assignMedia(itemsOrdered.get(j));
                     itemsOrdered.get(j).assignMedia(itemsOrdered.get(j+1));
                     itemsOrdered.get(j+1).assignMedia(m);
                    
                }
            }
		}
	}
	
	public void sortByName() {
		for (int i = 0; i < itemsOrdered.size()-1; i++) {
            for (int j = 0; j < itemsOrdered.size()-i-1; j++) {
                if (itemsOrdered.get(j).getTitle().compareTo(itemsOrdered.get(j+1).getTitle())>0){
                	DigitalVideoDisc m = new DigitalVideoDisc();
                    m.assignMedia(itemsOrdered.get(j));
                    itemsOrdered.get(j).assignMedia(itemsOrdered.get(j+1));
                    itemsOrdered.get(j+1).assignMedia(m);
                }
            }
	    }
     }
	
	public void SearchCartByName(String title) {
		int check = 0;
		for (int i=0;i<itemsOrdered.size();i++) {
			if (itemsOrdered.get(i).isMatch(title)) {
				check =1;
				System.out.println(itemsOrdered.get(i).toString());
			}
		}
		if (check==0) {
			System.out.println("No match is found!");
		}
	}
	
	public void SearchCartByID(int ID) {
		int check = 0;
		for (int i=0;i<itemsOrdered.size();i++) {
			if (itemsOrdered.get(i).getId() == ID) {
				check =1;
				System.out.println(itemsOrdered.get(i).toString());
			}
		}
		if (check==0) {
			System.out.println("No match is found!");
		}
	}
	
	public void remove() {
		this.itemsOrdered.clear();
	}
	
	public boolean isEmpty() {
		if (this.itemsOrdered.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	public void playCart(String title) {
		if (itemsOrdered.size()==0) {
			System.out.println("The cart is empty!");
		} else {
			int flag =0;
			for (int i=0;i<itemsOrdered.size();i++) {
				if (itemsOrdered.get(i).isMatch(title)) {
					flag =1;
					if (itemsOrdered.get(i) instanceof DigitalVideoDisc) {
						DVDCart.add((DigitalVideoDisc) itemsOrdered.get(i));
						for(int j=0;j<DVDCart.size();j++) {
							if (DVDCart.get(j).getTitle()==itemsOrdered.get(i).getTitle()) DVDCart.get(j).play();
						}
					} else {
						if (itemsOrdered.get(i) instanceof CompactDisc) {
							CDCart.add((CompactDisc)itemsOrdered.get(i));
							for(int j=0;j<CDCart.size();j++) {
								if (CDCart.get(j).getTitle()==itemsOrdered.get(i).getTitle()) CDCart.get(j).play();
							}
						}
					}	
				}
			}
			if (flag==0) System.out.println("No match found!");
		}
	}
	public ObservableList<Media> getItemsInCart() {
		// TODO Auto-generated method stub
		return this.itemsOrdered;
	}
	public String get_Info() {
		// TODO Auto-generated method stub
		String src = "";
		int sum=0;
		if (itemsOrdered.isEmpty()) {
			src="There is no item in cart.";
		}else {
			for(int i=0;i<this.itemsOrdered.size();i++) {
				sum+= itemsOrdered.get(i).getCost();
				src=src+"\nid: "+itemsOrdered.get(i).getId()+ " - "
									+itemsOrdered.get(i).getTitle()+" - "
									+itemsOrdered.get(i).getCategory()+" - "
									+itemsOrdered.get(i).getCost()+"$";
			}
		}
		src=src+"\nTotal cost: ["+sum+"]";
		return src;
	}
}
