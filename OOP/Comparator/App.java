public class App {
	public static void main (String[] args) {
		int firstNumber = 200;
		int secondNumber = 156;

		
		if(NumbersComparator.maxNumber(firstNumber, secondNumber) != 0) {
			System.out.println ("Numarul maxim este " + NumbersComparator.maxNumber(firstNumber,secondNumber));
		} else {
			System.out.println ("Numerele sunt egale");
		}
		
		
		if(NumbersComparator.minNumber(firstNumber, secondNumber) != 0) {
			System.out.println ("Numarul minim este " + NumbersComparator.minNumber(firstNumber,secondNumber));
		} else {
			System.out.println ("Numerele sunt egale");
		}
	}
}

