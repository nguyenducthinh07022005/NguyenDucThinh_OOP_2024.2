package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private String director;
	private int length;
	private static int nbDigitalVideoDiscs = 0;
	
	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	//Auto generate Constructor by: Source -> Generate Constructor using Fields
	// DVD object by NO attributes
//	public DigitalVideoDisc() {
//		super();
//	}
	
	// DVD object by title
	public DigitalVideoDisc(String title) {
		super(title);
	}	

	// DVD object by title, category, cost
//	public DigitalVideoDisc(String title, String category, float cost) {
//		super();
//		this.title = title;
//		this.category = category;
//		this.cost = cost;
//	}
	
	// DVD object by title, category, director, cost	
//	public DigitalVideoDisc(String title, String category, String director, float cost) {
//		super();
//		this.title = title;
//		this.category = category;
//		this.director = director;
//		this.cost = cost;
//	}
	
	// DVD object by ALL attributes
//	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
//		super();
//		this.title = title;
//		this.category = category;
//		this.director = director;
//		this.length = length;
//		this.cost = cost;
//	}
	
	public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {		
		// TODO Auto-generated constructor stub
		super(id, title, category, cost, length, director);
	}
	
	public DigitalVideoDisc(String title, float cost) {
		super(title, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		// TODO Auto-generated constructor stub
		super(title, category, length, cost );
		
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	public void setLength(int length) {
		this.length = length;
	}

	public static int getNbDigitalVideoDiscs() {
		return nbDigitalVideoDiscs;
	}
	
	@Override
	public String toString() {
		return("DVD: " + super.toString() + " - " + this.getDirector() + " - " + this.getLength() + " mins");
	}	
		
	@Override
	public void play() {
		// TODO Auto-generated method stub
		if(this.getLength() <= 0) {
			System.out.println("DVD: " + this.getTitle() + " can\'t be played");
		}
		else {
			System.out.println("DVD playing: " + this.getTitle() + " - " + this.getLength() + " mins");
		}
		
		
	}


}
	