package hust.soict.hedspi.aims.media;

public class Track implements Playable{
	private String title;
	private int length;

	public Track(String title, int length) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.length = length;		
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		if (length <= 0) {
            System.out.println("Track " + this.getTitle() + " can\'t be played");
        }
        System.out.println("Track playing: " + this.getTitle() + " - " + this.getLength() + " mins");
        System.out.println("Track length: " + length);		
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
        	return true;
        }
        if (!(obj instanceof Track)) {
        	return false;
        }
        Track other = (Track) obj;
        return title.equals(other.title) && length == other.length;
    }
}
