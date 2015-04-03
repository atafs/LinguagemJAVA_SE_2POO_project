package control_2OO.Start_OO_week01.playList;

public class Main {

	public static void main(String[] args) {

		// INSTANTIATE
		Playlist playList = new Playlist();

		Song s1 = new Song("Americo", 20);
		Song s2 = new Song("Tomas", 30);
		Song s3 = new Song("Ana", 40);
		Song s4 = new Song("Batalha", 50);

		System.out.println("Tentativa1: PRINT ALL SONGS FROM LIST - IUL ;-)\n");

		// ADD SONG
		playList.addSong(s1);
		playList.addSong(s2);
		playList.addSong(s3);
		playList.addSong(s4);

		System.out.println("Tentativa2: ");
		System.out.println(playList.toString());

		// REMOVE SONG (can only delete one song)
		playList.removeSong(s2.getName());
		System.out.println("Tentativa3: ");
		System.out.println(playList.toString());
	}
}
