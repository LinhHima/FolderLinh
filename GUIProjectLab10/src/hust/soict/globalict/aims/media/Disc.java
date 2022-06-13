package hust.soict.globalict.aims.media;

public class Disc extends Media{
	private int length;
	private String director;
	public Disc() {
		// TODO Auto-generated constructor stub
		
	}
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	public Disc(int length) {
		super();
		this.length = length;
	}

	public Disc(String director) {
		super();
		this.director = director;
	}
	public Disc(int length, String director) {
		super();
		this.length = length;
		this.director = director;
	}
	public Disc(String title,String category, float cost) {
		super(title,category,cost);
	}
	public Disc(int id,String title, String category, float cost) {
		super(id,title,category,cost);
	}
	public Disc(String title, String category, float cost, int length, String director) {
		super(title,category,cost);
		this.length=length;
		this.director =director;
	}
	public Disc(String title, String category, float cost, int length) {
		super(title,category,cost);
		this.length=length;
	}
}
