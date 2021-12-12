public class NumbersComparator {
	
	public static int maxNumber (int firstNumber, int secondNumber) {
		
		if(firstNumber > secondNumber) {
			return firstNumber;
		} else if(firstNumber < secondNumber) {
			return secondNumber;
		} else {
			return 0;
		}
		
	}

	public static int minNumber (int firstNumber, int secondNumber) {
		
		if(firstNumber > secondNumber) {
			return secondNumber;
		} else if(firstNumber < secondNumber) {
			return firstNumber;
		} else {
			return 0;
		}
		
	}
	
}

