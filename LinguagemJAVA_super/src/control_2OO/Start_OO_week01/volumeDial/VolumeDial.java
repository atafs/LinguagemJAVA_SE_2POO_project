package control_2OO.Start_OO_week01.volumeDial;

public class VolumeDial {

	private final int maxVolume;
	private int volume = 0;
		
	public int getMaxVolume() {
		return maxVolume;
	}

	public int getVolume() {
		return volume;
	}

	public VolumeDial(int maxVolume) {
		this.maxVolume = maxVolume;
	}

	public void up() {	
		if (volume != maxVolume) 
			volume++;		
	}

	public void mute() {
		volume = 0;		
	}
	
	public void down() {
		if (volume != 0) 
			volume--;		
	}

	public String toString() {
		return String.valueOf(volume + " / " + maxVolume);
	}
	
}
