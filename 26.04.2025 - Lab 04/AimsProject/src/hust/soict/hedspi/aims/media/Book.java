package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media implements Playable{
	private List<String> authors = new ArrayList<String>();

	public Book(int id, String title, String category, float cost, List<String> authors) {
		// TODO Auto-generated constructor stub
		super(id, title, category, cost);
		this.authors = authors;		
	}
	
	public Book(int id, String title, String category, float cost) {
		// TODO Auto-generated constructor stub
		super(id, title, category, cost);
	}
	
	public Book(String title, float cost) {
		super(title, cost);
	}

	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("Author already exist");
		}
		else {
			authors.add(authorName);
		}
			
	}

	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Author " + authorName + " removed");
		}
		else {
			System.out.println("Author not exist");
		}
	}
	
	@Override
	public String toString() {
		return "Book - " + super.toString() + " - Authors: " + authors;
	}
	
	@Override
	public void play() {
		
		
		
	}
}
