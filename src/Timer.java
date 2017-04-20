/*
 * This class will be modified when added to the application GUI so that the time remaining is UPDATED not written on consecutive lines.
 */
public class Timer {
	
	public static void runTimer() throws InterruptedException {
		
		int timet= 3 * 60; // Convert to seconds
		long delay = timet * 1000;

	    do {
			int minutes = timet / 60;
			int seconds = timet % 60;
			System.out.println(minutes +":" + seconds);
			Thread.sleep(1000);
			timet = timet - 1;
			delay = delay - 1000;

	    }
	    while (delay != 0);
	    	System.out.println("Time's Up!");
	}
	
	public static void main(String[] args) throws InterruptedException {
		runTimer();
	}
}