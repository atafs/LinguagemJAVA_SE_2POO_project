package control_2OO.Start_OO_week01.playList;

public class Song {

	// ATTRIBUTES
	private String name;
	private int duration; // [Seconds]

	// CONSTRUTOR
	public Song(String name, int duration) {
		this.name = name;
		this.duration = duration;
	}

	// GETTERS and SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	// toSTRING
	@Override
	public String toString() {
		return "[Name: " + name + "]; [Duration: " + duration + "];";
	}
}
