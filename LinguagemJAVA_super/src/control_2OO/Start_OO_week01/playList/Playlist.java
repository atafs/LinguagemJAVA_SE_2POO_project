package control_2OO.Start_OO_week01.playList;

public class Playlist {

	// ATTRIBUTES
	private final static int INITIAL_SIZE = 10;
	private Song[] songVector;
	private int index;

	// CONSTRUTOR
	public Playlist() {
		songVector = new Song[INITIAL_SIZE];
		index = 0;
	}

	// METHODS
	public void addSong(Song s) {

		// AUX ARRAY
		if (songVector.length == index) {
			Song[] aux = new Song[songVector.length * 2];

			for (int i = 0; i < songVector.length; i++) {
				aux[i] = songVector[i];
			}
			songVector = aux;
		}

		// ADD SONG
		songVector[index] = s;
		index++;
	}

	// CAN ONLY DELETE ONE SONG (no sorting algorithms used)
	public void removeSong(String name) {

		int removingPosition = -1;

		// SEARCH for SONG
		for (int i = 0; i < index; i++) {
			if (songVector[i].getName() == name) {
				removingPosition = i;
			}
		}

		// SEARCH for CHANGE in LOCAL VARIABLE
		if (removingPosition != -1) {
			songVector[removingPosition] = null;
		}
	}

	// PRINT ALL THE SONGS
	@Override
	public String toString() {

		// PRINT
		String toNull = "... EMPTY FILE OF MUSIC ...";
		String toReturn = "";

		for (int i = 0; i < index; i++) {
			toReturn += " " + (i + 1);

			if (songVector[i] != null) {
				toReturn += " - " + songVector[i].toString();
				toReturn += " \n";
			} else {
				toReturn += " - " + toNull + "\n";
			}
		}
		return toReturn;
	}
}
