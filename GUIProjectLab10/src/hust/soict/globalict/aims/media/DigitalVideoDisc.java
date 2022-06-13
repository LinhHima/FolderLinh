package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class DigitalVideoDisc extends Disc implements Playable{
	// Contructor
	public DigitalVideoDisc() {
		
	}
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category, float cost, int length) {
		super(title,category,cost,length);
	}
	public DigitalVideoDisc(int id,String title, String category, float cost) {
		super(id,title,category,cost);
	}
	public DigitalVideoDisc(int length, String director) {
		super(length,director);
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing DVD: "+super.getTitle());
		System.out.println("DVD length: "+super.getLength());
	}
	
	@Override
	public int compareTo(Media o) {
		if(o instanceof DigitalVideoDisc) {
			DigitalVideoDisc tmp =(DigitalVideoDisc)o;
			if(super.getTitle().compareTo(tmp.getTitle())!=0)
				return super.getTitle().compareTo(tmp.getTitle());
			else {
				return super.getCategory().compareTo(tmp.getCategory());
			}	
		}
		return 0;
	}
	

}