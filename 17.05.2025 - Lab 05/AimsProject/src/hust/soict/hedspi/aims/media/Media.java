package hust.soict.hedspi.aims.media;

import java.util.Comparator;

import hust.soict.hedspi.aims.comaparation.*;

public abstract class Media {
	public static final Comparator<Media> TITLE_THEN_COST = new CompareByTitleThenByCost();	
	public static final Comparator<Media> COST_THEN_TITLE = new CompareByCostThenByTitle();
	
	private int id;
	private String title;
	private String category;
	private float cost;

	public Media(int id, String title, String category, float cost) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;		
	}
	
	public Media(String title, float cost) {
		this.title = title;
		this.cost = cost;
	}
	
	public Media(String title) {
		this.title = title;
	}


	public Media(String title, String category, float cost) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

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

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public boolean isMatch(String search_title) {
		return this.getTitle().equalsIgnoreCase(search_title);
	}
	
	public String toString() {
		return "DVD: " + getTitle() + " - " + getCategory() + " - " + ": " + getCost() + " $";
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
        	return true;
        }
        if (!(obj instanceof Media)) {
        	return false;
        }
        Media other = (Media) obj;
        return getTitle().equals(other.getTitle());
    }		
}
