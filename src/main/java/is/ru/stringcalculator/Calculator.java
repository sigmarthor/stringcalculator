package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) throws Exception {
		if(text.equals("")){
			return 0;
		}
		else if(text.matches(".*[,\n].*")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number) throws Exception {
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers) throws Exception {
		if (numbers.startsWith("//")) {
			String customDelimiter = "";
			customDelimiter += numbers.charAt(2);
			String newNumbers = numbers.substring(4);
			return newNumbers.split(customDelimiter);
		}
	    return numbers.split(",|\n");
	}
      
    private static int sum(String[] numbers) throws Exception {
 	    negativeNumberCheck(numbers);
 	    int total = 0;
        for(String number : numbers){
        	if (toInt(number) <= 1000) {
			    total += toInt(number);
			}
		}
		return total;
    }

    private static void negativeNumberCheck(String[] numbers) throws Exception {
    	String negativeNumbers = "";
		for(int i = 0; i < numbers.length; i++) {
			if (toInt(numbers[i]) < 0) {
				negativeNumbers += numbers[i];
				if (i + 1 < numbers.length) {
					negativeNumbers += ", ";
				}
			}
		}
		if (negativeNumbers.length() > 0) {
			throw new Exception("Negatives not allowed: " + negativeNumbers);
    	}
    }
}