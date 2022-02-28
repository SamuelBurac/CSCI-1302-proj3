//SayMyLargeNumber.java
//CSCI 1302
//Project 3
//05/01/2021
//Samuel Burac

import java.util.Scanner;
public class SayMyLargeNumber {
	public static String say(long num){
		String wordedNum = "";
		long OGnum = num;// OGnum should never change but testNum can be changed for different needs
		long testNum = num; // below are all the numbers that don't repeat
		int OGNumber; // is used for switch cases because Long types can't be used in a switch case
		int testNumber;
		/**the say method takes in a number from 1 to 9.2 quintillion and returns the worded form 
		*of the number as a string type. For instance if you enter 746 it will print out seven-hundered-forty-six.
		*It does this by finding out how large the number is and adding the correct number word to wordedNum and
		*then calling itself for the numbers that weren't written.
		*for example if you enter 123456 it would call itself on 123 and then add thousand then it would call itself
		*on 456.
		*/
			
		
		if ((OGnum / 10) == 0) {
			OGNumber = (int)OGnum;
		switch (OGNumber) { //switch statement for the numbers and serves as base for this recursive method
		case 1:
			wordedNum += "one";
			break;
			
		case 2:
			wordedNum += "two";
			break;	
		
		case 3:
			wordedNum += "three";
			break;
		
		case 4:
			wordedNum += "four";
			break;
			
		case 5:
			wordedNum += "five";
			break;	
			
		case 6:
			wordedNum += "six";
			break;	
			
		case 7:
			wordedNum += "seven";
			break;
			
		case 8:
			wordedNum += "eight";
			break;
			
		case 9:
			wordedNum += "nine";
			break;
		}
		}
		if((OGnum / 10) > 1 && (OGnum / 10) < 10) { //detects if a number is in tens place except for 10-19 because those have teens
			OGNumber = (int)OGnum;
			testNumber = OGNumber;
			testNumber /= 10;
			switch (testNumber) {
				
			case 2:
				wordedNum += "twenty";
				break;	
			
			case 3:
				wordedNum += "thirty";
				break;
			
			case 4:
				wordedNum += "forty";
				break;
				
			case 5:
				wordedNum += "fifty";
				break;	
				
			case 6:
				wordedNum += "sixty";
				break;	
				
			case 7:
				wordedNum += "seventy";
				break;
				
			case 8:
				wordedNum += "eighty";
				break;
				
			case 9:
				wordedNum += "ninety";
				break;
			}
			wordedNum += "-" + say(OGnum-(testNumber * 10));
			testNumber = OGNumber;
		}
		if ((OGnum/10) == 1) { //finds the teens and adds it to wordedNum
			OGNumber = (int)OGnum;
			testNumber = OGNumber-10;
			
			switch(testNumber) {
			case 0:
				wordedNum += "ten";
				break;
				
			case 1:
				wordedNum += "eleven";
				break;
				
			case 2:
				wordedNum += "twelve";
				break;	
			
			case 3:
				wordedNum += "thirteen";
				break;
			
			case 4:
				wordedNum += "fourteen";
				break;
				
			case 5:
				wordedNum += "fifteen";
				break;	
				
			case 6:
				wordedNum += "sixteen";
				break;	
				
			case 7:
				wordedNum += "seventeen";
				break;
				
			case 8:
				wordedNum += "eighteen";
				break;
				
			case 9:
				wordedNum += "nineteen";
				break;
			}
			testNumber = OGNumber;
		}
		
		if((OGnum/100) > 0 && (OGnum/100) < 10) { //detects hundreds
			testNum /= 100;
						//calls say on just the singular digit then calls say on the rest 
			wordedNum += say(testNum)+ "-hundred-" + say(OGnum-(testNum * 100)); //of the number without the first digit this goes for the rest aswell.
		}
		
		if(OGnum > 999 && OGnum < 1_000_000) { //detects from 1,000 to 999,999
			testNum /= 1_000;
			
			wordedNum += say(testNum) + "-thousand-" + say(OGnum-(testNum * 1_000));
		}
		
		if(OGnum > 999_999 && OGnum < 1_000_000_000) {//detects from 1 million to 999,999,999
			testNum /= 1_000_000;
			
			wordedNum += say(testNum) + "-million-" + say(OGnum-(testNum * 1_000_000));
		}
		
		if(OGnum >= 1_000_000_000 && OGnum < 1_000_000_000_000L) { //detects from 1 billion to 1 trillion
			testNum /= 1_000_000_000;
			
			wordedNum += say(testNum) + "-billion-" + say(OGnum-(testNum * 1_000_000_000));
		}		
		
		if(OGnum >= 1_000_000_000_000L && OGnum < 1_000_000_000_000_000L) { //detects from 1 trillion to 1 quadrillion
			testNum /= 1_000_000_000_000L;
			
			wordedNum += say(testNum) + "-trillion-" + say(OGnum-(testNum * 1_000_000_000_000L));
		}
		
		if(OGnum >= 1_000_000_000_000_000L && OGnum < 1_000_000_000_000_000_000L) { //detects from 1 quadrillion to 1 quintillion
			testNum /= 1_000_000_000_000_000L;
					   
			wordedNum += say(testNum) + "-quadrillion-" + say(OGnum-(testNum * 1_000_000_000_000_000L));
		}
		
		if(OGnum >= 1_000_000_000_000_000_000L) { //detects from 1 quintillion to the limit of Long
			testNum /= 1_000_000_000_000_000_000L;
					   
			wordedNum += say(testNum) + "-quintillion-" + say(OGnum-(testNum * 1_000_000_000_000_000_000L));
		}
		
		return wordedNum; // wordedNum is the number in word form to which words from each number are added 
	}
	
	
	
	
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		String input;
		long Number;
		int i = 0;
		NumTooLarge problem = new NumTooLarge 
				("The number you entered is too large, please try a smaller number.");
		NumTooLarge problema = new NumTooLarge
				("Please enter a number");
		
		System.out.println("Enter a positive integer: ");
		input = scan.next();
		try {
			
			if (input.length() == 19) {
				if (input.charAt(0) == 57 && input.charAt(1) == 50 && input.charAt(2) == 50) {
				throw problem;
				}
			}
			if(input.length() > 19) {
				throw problem;
			}
			
			for (int b = 0; b < input.length(); ++b) {
				if (input.charAt(b) >= 65 && input.charAt(b) <= 90 || input.charAt(b) >= 97 && input.charAt(b) <=122) {
					++i;
				}
			}
			
			if(i > 0) {
				throw problema;
			}
		
		Number = Long.parseLong(input);
			
		if (Number == 0) {
			System.out.println("zero");
		}
		if (Number < 0) {
			System.out.println("negative " + say(Number * -1));
		}
		else {
			System.out.println(say(Number));
		}
		
		}
		catch(NumTooLarge exception) {
			if (input.length() == 19) {
				if (input.charAt(0) == 57 && input.charAt(1) == 50) {
				System.out.println(problem.getMessage());
				}
			}
			
			if(input.length() > 19) {
				System.out.println(problem.getMessage());
			}
			
			if(i > 0) {
				System.out.println(problema.getMessage());
			}
		}
		
		scan.close();


	}
}
