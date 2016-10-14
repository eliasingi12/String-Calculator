package stringcalc;

import java.util.ArrayList;

public class StringCalculator
{
	public static int Add(String numbers)
	{
		if(numbers.equals(""))
			return 0;
		else if(numbers.contains(",") || numbers.contains("//"))
			return sum(splitNumbers(numbers));
		else
			return 1;
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers)
	{
	    String delimeter = ",|\n";

	    if(numbers.startsWith("//"))
	    {
	    	int delIndex = numbers.indexOf("//") + 2;
	    	delimeter = delimeter + "|" + numbers.substring(delIndex, delIndex + 1);
	    	numbers = numbers.substring(delIndex + 2);
	    	
	    	return numbers.split(delimeter);
	    }
	    else 
			return numbers.split(delimeter);
	}
      
    private static int sum(String[] numbers)
    {
    	ArrayList <Integer> negativeNum = new ArrayList <Integer>();

 	    for(String number : numbers)
 	    {
			int negNumber = toInt(number);

 	    	if(negNumber < 0)
 	    	{
 	    		negativeNum.add(negNumber);
 	    		throw new RuntimeException("Negatives not allowed: " + negativeNum);
 	    	}
 	    }

 	    int total = 0;

        for(String number : numbers)
        {
        	if(toInt(number) > 1000)
        		continue;
        	total += toInt(number);
		}
		return total;
    }
}