package hust.soict.globalict.aims.Aims;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class Aims {
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a Media's details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Get a lucky item from cart");
		System.out.println("5. Place order");
		System.out.println("6. Play CD or DVD in cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5-6");
    }


	public static void main(String[] args) {
		MemoryDaemon md = new MemoryDaemon();
		Thread th= new Thread(md);
		th.setDaemon(true);
		Cart anOrder = new Cart();
		//Create sample DVDs
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation",20f,12);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",10f,20);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f,30);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Trek", "Science Fiction",26.1f,50);
		//Create sample CompactDisc
		Track track1 = new Track("Moon",1);
		Track track2 = new Track("Sun",2);
		Track track3 = new Track("Eclipsse",3);
		Track track4 = new Track("HoangAnhCute",4);
		Track[] track =new Track[] {track1,track2,track3};
		ArrayList<Track> tracklist2= new ArrayList<Track>(Arrays.asList(track));
		CompactDisc CD1 = new CompactDisc("November","Ballad",30.45f,"Taylor Swift",tracklist2);
		CompactDisc CD2 = new CompactDisc("Downtown","Pop",20.15f,"Chairle",tracklist2);
		CompactDisc CD3 = new CompactDisc("Love","Ballad",10.15f,"Kay",tracklist2);
		CD2.addTrack(track4);
		CD2.removeTrack(track2);
		CD1.addTrack(track2);
		//Add sample to the Cart
		anOrder.addMedia(dvd1);
		anOrder.addMedia(dvd2);
		anOrder.addMedia(dvd3);
		anOrder.addMedia(dvd4);
		anOrder.addMedia(CD1);
		anOrder.addMedia(CD2);
		anOrder.addMedia(CD3);
		//Create store
		Store str = new Store();
		str.addMedia(dvd1);
		str.addMedia(dvd2);
		str.addMedia(dvd3);
		str.addMedia(dvd4);
		str.addMedia(CD1);
		str.addMedia(CD2);
		str.addMedia(CD3);
//		anOrder.removeDigitalVideoDisc(dvd1);
//		anOrder.totalCost();
		
		//main
		int option =5;
		showMenu();
		int checkgetfree=0;
		while(option!=0) {
			Scanner sc = new Scanner(System.in);
			option = sc.nextInt();
			switch(option) {    
			  case 1: {
				  str.viewStore();
				  storeMenu();
				  int opt =5;
				  while(opt!=0) {
					  opt = sc.nextInt();
					  switch(opt) {
					  case 1: 
						  System.out.println("Enter the title of Media:");
						  Scanner scan1 = new Scanner(System.in);
						  String s = scan1.nextLine();
						  str.SearchStore(s);
						  storeMenu();
						  break;
						  
					  case 2: 
						  System.out.println("Enter the title of DVD:");
						  Scanner scan2 = new Scanner(System.in); 
						  String name = scan2.nextLine();
						  boolean check = str.searchMedia(name);
						  if (str.searchMedia(name)) {
							  anOrder.addMedia(str.getMediaByName(name));
							  System.out.println("Add successfully");
						  }else {
							  System.out.println("There isn't any media named: "+name);
						  }
						  storeMenu();
						  break;
						  
					  case 3:
						  anOrder.print();
						  cartMenu();
						  break;
					  case 0: 
						  System.out.println("Go back to Menu!");
						  showMenu();
						  break;
					  default: 
						  System.out.println("Wrong Syntax! Try again!\n");
						  showMenu();
					  }
				  }
				  break;
			  }
//			  
			  case 2: 
				  int choose =0;
				  Scanner input3 = new Scanner(System.in);
				  System.out.println("Do you want to add or remove Media in store?\n "
				  		+ "1.Add Media \n "
				  		+ "2.Remove Media \n "
				  		+ "0.Back to Menu");
				  choose = input3.nextInt();
				  switch (choose) {
					case 1:
						 System.out.println("Enter the name of Media:");
						 Scanner newSc = new Scanner(System.in);
						 String name=newSc.nextLine();
						 System.out.println("Enter the category of Media:");
						 String category=newSc.nextLine();
						 System.out.println("Enter the cost of Media:");
						 float cost= newSc.nextFloat();
						 System.out.println("Enter the length of Media:");
						 int length= newSc.nextInt();
						 DigitalVideoDisc newMedia = new DigitalVideoDisc(name, category, cost,length);
						 str.addMedia(newMedia);
						 System.out.println("Add Successfully!");
						 showMenu();
						break;
					case 2:
						System.out.println("Enter the name of Media:");
						 Scanner newSca = new Scanner(System.in);
						 String namea=newSca.nextLine();
						 str.removeMediaByName(namea);
						 showMenu();
						break;
					case 0:
						showMenu();
						break;
					default:
						 System.out.println("Wrong Syntax! Try again!\n");
						 showMenu();
					
				  }
				  break;
			  case 3: 
				  anOrder.print();
				  cartMenu();
				  int opt3=5;
				  while(opt3!=0) {
					  opt3 = sc.nextInt();
					  switch (opt3) {
						case 2:
							int crt=1;
							while(crt!=0) {
								System.out.println("Sort by:\n1.Name\n2.ID\n3.SortByTitleCost\n4.SortByCostTitle\n0.Back to cart menu.");
								Scanner scc = new Scanner(System.in);
								crt = scc.nextInt();
								switch (crt) {
								case 1:
									anOrder.sortByName();
									anOrder.print();
									crt = 0;
									cartMenu();
									break;
								case 2:
									anOrder.sortByID();
									anOrder.print();
									crt = 0;
									cartMenu();
									break;
								case 3:
									anOrder.SortByTitleCost();
									anOrder.print();
									crt=0;
									cartMenu();
									break;
								case 4:
									anOrder.SortByCostTitle();
									anOrder.print();
									crt=0;
									cartMenu();
									break;
								case 0:
									System.out.println("Go back to cart menu.");
									cartMenu();
									break;
								default:
									System.out.println("Wrong Syntax! Try again!\n");
								}
							}
							break;
						case 1:
							int crt1 =1;
							while(crt1!=0) {
								System.out.println("Filter by:\n1.Name\n2.ID\n0.Back to cart menu.");
								Scanner scc = new Scanner(System.in);
								crt1 = scc.nextInt();
								switch (crt1) {
								case 1:
									 System.out.println("Enter the title of Media:");
									 Scanner scan1 = new Scanner(System.in);
									 String s1 = scan1.nextLine();
									 anOrder.SearchCartByName(s1);
									 crt1 = 0;
									 cartMenu();
									break;
								case 2:
									System.out.println("Enter the id of Media:");
									 Scanner scan2 = new Scanner(System.in);
									 int s2 = scan2.nextInt();
									 anOrder.SearchCartByID(s2);
									anOrder.print();
									crt1 = 0;
									cartMenu();
									break;
								case 0:
									System.out.println("Go back to cart menu.");
									cartMenu();
									break;
								default:
									System.out.println("Wrong Syntax! Try again!\n");
								}
							}
							break;
						case 3:
							System.out.println("Enter the title of Media:");
							 Scanner scan1 = new Scanner(System.in);
							 String s = scan1.nextLine();
							 anOrder.removeMediaByName(s);
							 anOrder.print();
							 cartMenu();
							break;
						case 4:
							if (!anOrder.isEmpty()) {
								checkgetfree++;
								if (checkgetfree==1) {
									Media a = anOrder.getALuckyItem();
									System.out.println("You will get a item for free");
									anOrder.print();
									cartMenu();
								}else {
								    System.out.println("You can get only one free item");
								    cartMenu();
								}
							}else {
								System.out.println("There is no item in your cart.");
								cartMenu();
							}
							break;

						case 5:
							if (!anOrder.isEmpty()) {
							System.out.println("Your order was sent to your system.");
							anOrder.remove();
							checkgetfree=0;
							anOrder.print();
							cartMenu();
							}else {
								System.out.println("There is no item in your cart.");
								cartMenu();
							}
							break;
						case 6: 
							System.out.println("Enter the title you want to play<>: ");
							Scanner scan6 = new Scanner(System.in);
							String title = scan6.nextLine();
							anOrder.playCart(title);
							cartMenu();
							break;
						case 0: 
							  System.out.println("Go back to Menu!");
							  break;
						default: System.out.println("Wrong Syntax! Try again!\n");
						         cartMenu();
					}
					  
				  }
			      showMenu();
					  
				  break;
			  case 0: System.out.println("Exit the program\n"); 
			          break;
			  default: System.out.println("Wrong Syntax. Please try again!\n");
			}
		}
		th.start();
	}

}
