package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{

	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	//Constructor
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(String title) {
		super(title);
	}
	public CompactDisc(String title, String category, float cost,int length, String director) {
		super(title,category,cost,length,director);
	}
	public CompactDisc(int id,String title, String category, float cost) {
		super(id,title,category,cost);
	}
	public CompactDisc(String title, String category, float cost) {
		super(title,category,cost);
	}
	public CompactDisc(int length, String director) {
		super(length,director);
	}
	
	public CompactDisc(String artist, ArrayList<Track> tracks) {
		super();
		this.artist = artist;
		this.tracks = tracks;
	}
	public CompactDisc(String title, String category, float cost, String artist, ArrayList<Track> tracks) {
		super(title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	//Getter
	public String getArtist() {
		return artist;
	}
	//Function 
	public void addTrack(Track newtrack) {
		for(Track i: tracks) {
			if(i.compareTitle(newtrack.getTitle())) {
				System.out.println("The track already exists!");
				return;
			}
		}
		tracks.add(newtrack);
		System.out.println("Add "+newtrack.getTitle()+" successfully!");
	}
	
	public void removeTrack(Track oldtrack) {
		for(Track i:tracks) {
			if(i.compareTitle(oldtrack.getTitle())) {
				tracks.remove(oldtrack);
				System.out.println("Remove "+oldtrack.getTitle()+" successfully!");
				return;
			}
		}
		System.out.println(oldtrack.getTitle()+" doesn't exist in track!");
	}
	
	public int getlength() {
		int sum=0;
		for(Track i:tracks) {
			sum+=i.getLength();
		}
		return sum;
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		for(Track i:tracks) {
			System.out.println("Playing CD: "+i.getTitle());
			System.out.println("CD length: "+i.getLength());
		}
	}
	
	@Override
	public int compareTo(Media o) {
		if(o instanceof CompactDisc) {
			CompactDisc tmp =(CompactDisc)o;
			if(super.getTitle().compareTo(tmp.getTitle())!=0)
				return super.getTitle().compareTo(tmp.getTitle());
			else {
				return super.getCategory().compareTo(tmp.getCategory());
			}	
		}
		return 0;
	}
}
