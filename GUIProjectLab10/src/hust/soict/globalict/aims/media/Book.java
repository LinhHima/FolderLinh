package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class Book extends Media /*implements Comparable<Book>*/{
	//Book with Map
	String Content ="Nguyen Hoang Anh de thuong";
	List<String> contentTokens ;
	Map<String,Integer> wordFrequency=new TreeMap<>();
	 public String getContent() {
	        return content;
	    }

	 public void setContent(String content) {
	        this.content = content;
	        this.processContent();
	    }
	public void processContent() {
		int cnt=0;
		this.contentTokens =Arrays.asList(this.content.split(" "));
		Collections.sort(this.contentTokens);
		 String token = this.contentTokens.get(0);
	        for (String str : this.contentTokens) {
	            if (str.equals(token)) {
	                cnt++;
	            } else {
	                wordFrequency.put(token, cnt);
	                token = str;
	                cnt = 1;
	            }
	        }
	}
	
    private ArrayList<String> authors = new ArrayList<String>(); 
	private String content;
	//Constructor
	
	public Book(String string, float f) {
		super(string,f);
	}
	public Book(int id,String title, String category, float cost) {
		super(id,title,category,cost);
	}
	public Book(String title,String category, float cost) {
		super(title,category,cost);
	}
	//Getter and Setter
	public ArrayList<String> getAuthors() {
		return authors;
	}
	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	
	
	public void addAuthor(String authorName) {
		int check =0;
		for(String i:this.authors) {
			if(i.equals(authorName)) {
			check=1;
				break;
			}
		}
		if(check==1) System.out.println("The name of author have already !");
		else {
			this.authors.add(authorName);
			System.out.println("Add the name of author successfully !");
		}
	}
	public void removeAuthor(String authorName) {
		int check =0;
		for(String i : this.authors) {
			if(i.equals(authorName)) {
				this.authors.remove(authorName);
				check =1;
			}
		}
		if(check==1) System.out.println("Remove the name of author successully !");
		else System.out.println("Cannot find the name of author !");
	}
	@Override
	public String toString() {
        return "Book: "+super.getTitle()+"\nCategory: "+super.getCategory()+"\nCost: "+super.getCost()+"\nContent: "+this.getContent() +"\nContent length: "+ contentTokens.size() +"\nToken list: "+ contentTokens +"\nWord frequency: "+ wordFrequency;
    }
//	
	@Override
	public int compareTo(Media o) {
		if(o instanceof Book) {
			Book tmp= (Book) o;
			if(super.getTitle().compareTo(tmp.getTitle())!=0)
				return super.getTitle().compareTo(tmp.getTitle());
			else {
				return super.getCategory().compareTo(tmp.getCategory());
			}	
		}
		return 0;
	}
	
}
