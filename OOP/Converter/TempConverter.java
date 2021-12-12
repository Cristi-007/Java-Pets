public class TempConverter {
	
	public void convertToFahr(double celsius) {
		System.out.println ( ((celsius*1.8)+32) + "F");
	}
	
	public void convertToCelsius(double fahr) {
		System.out.println ( ((fahr-32)* 0.5556) + "C" );
	}	
}