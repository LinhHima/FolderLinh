package hust.soict.globalict.aims.media;

public class Track implements Playable,Comparable<Object>{
	private String title;
	private int length;

	public Track() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	

	public Track(String title) {
		super();
		this.title = title;
	}
	

	public void setTitle(int length) {
		this.length = length;
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public boolean compareTitle(String title) {
		if(title==this.title) return true;
		return false;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing track: "+this.getTitle());
		System.out.println("Track length: "+this.getLength());
		
	}
	public boolean equals(Object o) {
		if(o==this) return true;
		if(!(o instanceof Track)) return false;
		Track tmp =(Track) o;
		if(tmp.getTitle().equals(this.getTitle())&&tmp.getLength()==this.getLength())
			return true;
		return false;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Track) {
			Track tmp =(Track) o;
			if(this.getTitle().compareTo(tmp.getTitle())!=0)
				return this.getTitle().compareTo(tmp.getTitle());
		}
		return 0;
	}
}
