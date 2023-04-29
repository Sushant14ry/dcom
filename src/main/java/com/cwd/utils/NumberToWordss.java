package com.cwd.utils;
public class NumberToWordss {

	public static String NumToWords(int a) {
		
		String word = "";
		String uniarry[] = {"Zero ","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine ","Ten ",
				"Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Nineteen "};
		String tensarry[] = {"Zero","Ten","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
		
		if(a == 0) {
			return "Zero";
		}
		if(a<0) {
			String number = " "+a;
			number = number.substring(1);
			return "Minus"+NumToWords(Integer.parseInt(number));
		}
		if((a/100000) > 0) {
			word = word + NumToWords(a/100000)+"Lakh ";
			a = a%100000;
		}
		if((a/1000) > 0) {
			word = word+ NumToWords(a/1000)+"Thousand ";
			a = a%1000;
		}
		if((a/100) > 0) {
			word = word+NumToWords(a/100)+"Hundred ";
			a = a%100;
		}
		
		if(a>0) {
			if(a<20) {
				word = word+uniarry[a];
			}else {
				word = word+tensarry[a/10];
				if((a%10) > 0) {
					word = word+"-"+uniarry[a%10];
				}
			}
		}
		
		return word;
	}
	
	
}
