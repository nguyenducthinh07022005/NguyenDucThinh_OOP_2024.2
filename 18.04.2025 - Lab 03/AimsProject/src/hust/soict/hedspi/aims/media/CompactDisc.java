package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;


public class CompactDisc extends Disc {
	private String artist;
	private List<Track> tracks = new ArrayList<>();

	public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, List<Track> tracks) {
		// TODO Auto-generated constructor stub
		super(id, title, category, cost, length, director);
		this.artist = artist;
		this.tracks = new ArrayList<>(tracks);		
	}

	public CompactDisc(int id, String title, String category, float cost, String artist, String director) {
		// TODO Auto-generated constructor stub
		super(id, title, category, cost, artist, director);
		
	}

	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("Track added: " + track.getTitle());
		}
		else {
			System.out.println("Track already in DVD: " + track.getTitle());
		}
	}
	
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Track removed: " + track.getTitle());			
		}
		else {
			System.out.println("Track not exist in DVD: " + track.getLength());
		}
		
	}
	
	public int getLength() {
		int DVD_length = 0;
		for(Track track : tracks) {
			DVD_length += track.getLength();
		}
		return DVD_length;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		if(getLength() <= 0) {
			System.out.println("CD " + getTitle() + "can\'t be played");			
		}
		else {
			System.out.println("CD playing: " + this.getTitle() + " - " + this.getArtist() + " - " + this.getLength());			
		}
	}
	
	@Override
	public String toString() {
		return "CD - " + super.toString() + " - " + this.getArtist() + " - " + this.getLength() + "min";
	}
}
