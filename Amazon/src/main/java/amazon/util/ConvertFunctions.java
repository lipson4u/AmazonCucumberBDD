package amazon.util;

import java.text.DecimalFormat;

public class ConvertFunctions {

	
	public static double RoundAmounts(Double Amount) {
		DecimalFormat df = new DecimalFormat("#.##");      
		Amount = Double.valueOf(df.format(Amount));
		return Amount;
		
	}
	
	public static String ExtractValue(String value) {
		value =  value.substring(0, value.indexOf('€'));
		return value;
	}
	
	public static String RemoveCommafromCurrencyFormat(String value) {
		value = value.replace(",", ".");
		return value;
		
	}
	
	public static double ConvertStringtoDouble(String str) {
		
		return Double.parseDouble(str);
		
	}
}
