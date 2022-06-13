package hust.soict.globalict.aims.Aims;
import java.util.ArrayList;
import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public ArrayList<DigitalVideoDisc> DVDStore = new ArrayList<DigitalVideoDisc>();
	public ArrayList<CompactDisc> CDStore = new ArrayList<CompactDisc>();
	public void addMedia(Media media) {
		for(int i=0;i<this.itemsInStore.size();i++){
			if(this.itemsInStore.get(i).getTitle().equals(media.getTitle())) {
				System.out.println("This media has in the list!");
				return;
			}
		}
		itemsInStore.add(media);
	}
	public void removeMedia(Media media) {
		if(this.itemsInStore.size() ==0) {
			System.out.println("Fail! The capacity is empty\n");
		}
		else {
			int check=0;
			for(int i=0;i<this.itemsInStore.size();i++){
				if(this.itemsInStore.get(i).getTitle().equals(media.getTitle())) {
					this.itemsInStore.remove(i);
					check=1;
				}
			}
			if(check==1) System.out.println("Remove successfully!");
			else System.out.println("Remove fail!");
		}
	}
	
	public void removeMediaByName(String name) {
		if(this.itemsInStore.size() ==0) {
			System.out.println("Fail! The capacity is empty\n");
		}
		else {
			int check=0;
			for(int i=0;i<this.itemsInStore.size();i++){
				if(this.itemsInStore.get(i).getTitle().equals(name)) {
					this.itemsInStore.remove(i);
					check=1;
				}
			}
			if(check==1) System.out.println("Remove successfully!");
			else System.out.println("Remove fail!");
		}
	}
	
	public boolean searchMedia(String title) {
		boolean check = false;
		for (int i=0; i<this.itemsInStore.size();i++) {
			if(this.itemsInStore.get(i).getTitle().equals(title)) {
				check=true;
				break;
			}
		}
		return check;
	}
	
	public Media getMediaByName(String title) {
		for (int i=0; i<this.itemsInStore.size();i++) {
			if(this.itemsInStore.get(i).getTitle().equals(title)) {
				return this.itemsInStore.get(i);
			}
		}
		return null;
	}
	
	
	public void SearchStore(String title) {
		int check = 0;
		for (int i=0;i<itemsInStore.size();i++) {
			if (itemsInStore.get(i).isMatch(title)) {
				check =1;
				System.out.println(itemsInStore.get(i).toString());
				if (itemsInStore.get(i) instanceof DigitalVideoDisc) {
					DVDStore.add((DigitalVideoDisc)itemsInStore.get(i));
					for (int j=0;j<DVDStore.size();j++) {
						if(DVDStore.get(j).getTitle()==itemsInStore.get(i).getTitle()) DVDStore.get(j).play();
					}
				} else {
					if (itemsInStore.get(i) instanceof CompactDisc) {
						CDStore.add((CompactDisc) itemsInStore.get(i));
						for (int j=0;j<CDStore.size();j++) {
							if(CDStore.get(j).getTitle()==itemsInStore.get(i).getTitle()) CDStore.get(j).play();
						}
					}
				}
			}
		}
		if (check==0) {
			System.out.println("No match is found!");
		}
	}
	

	
	public void viewStore() {
		System.out.println("List Media in Store:");
		for (int i=0;i<itemsInStore.size();i++) {
			System.out.println("\t"+itemsInStore.get(i).toString());
		}
//		System.out.println();
	}
	public ArrayList<Media> getItemsInStore() {
		// TODO Auto-generated method stub
		return this.itemsInStore;
	}

}
