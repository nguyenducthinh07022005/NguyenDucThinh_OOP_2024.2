package hust.soict.hedspi.aims.media;


public abstract class Disc extends Media implements Playable{
	private int length;
	private String director;

	public Disc(int id, String title, String category, float cost, int length, String director) {
		// TODO Auto-generated constructor stub
		super(id, title, category, cost);
		this.length = length;
		this.director = director;		
	}
	
	public Disc(String title) {
		super(title);
	}
	
	public Disc(int id, String title, String category, float cost, String artist, String director) {
		// TODO Auto-generated constructor stub
		super(id, title, category, cost);
	}

	

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
}
