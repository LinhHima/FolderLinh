package hust.soict.globalict.aims.media;

public class BookTest {
	
	public static void main(String[] args) {
		Book book = new Book("OOP Java","Science",10f);
		book.setContent("mon nay kho qua ban oi . ban can co gang hoc mon nay nhieu nhieu nhieu hon nua .");
		System.out.println(book.toString());

	}

}
