package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.matches(".*[,\n].*")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		if (numbers.startsWith("//")) {
			String customDelimiter = "";
			customDelimiter += numbers.charAt(2);
			String newNumbers = numbers.substring(4);
			return newNumbers.split(customDelimiter);
		}
	    return numbers.split(",|\n");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }
}