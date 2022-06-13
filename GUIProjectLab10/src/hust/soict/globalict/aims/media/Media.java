package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public abstract class Media implements Comparable<Media>{
	private int  id;
	private String title;
	private String category;
	private float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	public Media() {
		// TODO Auto-generated constructor stub
		
	}
	public Media(String title, float cost) {
		this.title=title;
		this.cost=cost;
		
	}
	public Media(String title,String category, float cost) {
		this.title=title;
		this.category=category;
		this.cost=cost;
	}
	public Media(int id,String title, String category, float cost) {
		this.id=id;
		this.title=title;
		this.category=category;
		this.cost=cost;
	}
	
	//getter 
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	public void assignMedia(Media m) {
		this.id = m.id;
		this.title = m.title;
		this.category = m.category;
		this.cost = m.cost;
	}
	public String toString() {
		return this.getTitle();
	}
	
	public boolean isMatch(String title) {
		 StringTokenizer st = new StringTokenizer(title);
		 StringTokenizer stt = new StringTokenizer(this.title);

		 ArrayList<String> arrtitle = new ArrayList<String>();
		 ArrayList<String> arrDVD = new ArrayList<String>();

		 while (st.hasMoreTokens()) {
			arrtitle.add(st.nextToken());
		 }

		while (stt.hasMoreTokens()) {
			arrDVD.add(stt.nextToken());
		}

		for(String dvd : arrDVD){
			for(String tokennn  : arrtitle){
				if(dvd.equals(tokennn))
					return true;
			}
		}
		return false;
	}
	public boolean equals(Object o) {
		if(o==this) return true;
		if(!(o instanceof Media)) return false;
		Media tmp =(Media) o;
		return tmp.getId()==this.getId();
	}
	@Override
	public int compareTo(Media o) {
		if(this.title.compareTo(o.getTitle())!=0)
			return this.title.compareTo(o.getTitle());
		else {
			return this.category.compareTo(o.getCategory());
		}
	}
}