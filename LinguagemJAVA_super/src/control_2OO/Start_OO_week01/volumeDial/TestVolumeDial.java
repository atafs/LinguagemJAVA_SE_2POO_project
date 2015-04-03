package control_2OO.Start_OO_week01.volumeDial;

public class TestVolumeDial {

	public static void main(String[] args) {
		final int maxVolume = 10;
		
		VolumeDial volumeDial = new VolumeDial(maxVolume);
		
		VolumeDial anotherVolumeDial = new VolumeDial(100);
		anotherVolumeDial.up();
		System.out.println(anotherVolumeDial);
		System.out.println(volumeDial);
		
		volumeDial.up();
		System.out.println(volumeDial);
		volumeDial.down();
		System.out.println(volumeDial);
		volumeDial.down();
		System.out.println(volumeDial);
		
		
	}

}
