package control_1Logica;

public class Time_classSystem {

	//ATTRIBUTE
	private long time = System.currentTimeMillis();
		
	//GETTER
	public long getTime() {
		return time;
	}

	//MAIN
	public static void main(String[] args) {
		
		//INSTANCIATE AND PRINT
		Time_classSystem inicialTimer = new Time_classSystem();
		System.out.println("[Inicial Time: " + inicialTimer.getTime() + "];");
		
		//SLEEP
		try {
			Thread.sleep(2000); //2seg
			System.out.println("[SLEEP: 2000; [ms]"); //consume time
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		//INSTANCIATE AND PRINT
		Time_classSystem finalTimer = new Time_classSystem();
		System.out.println("\n[DIFERENCE: " + (finalTimer.getTime() - inicialTimer.getTime()) + "]; [ms]");
	}
}
