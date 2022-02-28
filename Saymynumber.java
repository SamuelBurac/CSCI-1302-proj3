package p0pe;
import java.util.Scanner;
public class Saymynumber {
	public static String say(int num){
		String wordedNum = "";
		int OGnum = num;// OGnum should never change but testNum can be changed for different needs
		int testNum = num; // below are all the numbers that don't repeat
		
		if ((OGnum / 10) == 0) {
		switch (OGnum) { //switch statement for the numbers and serves as base for this recursive method
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
			testNum /= 10;
			switch (testNum) {
				
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
			wordedNum += "-" + say(OGnum-(testNum * 10));
			testNum = OGnum;
		}
		if ((OGnum/10) == 1) { //finds the teens and adds it to wordedNum
			testNum = OGnum-10;
			
			switch(testNum) {
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
			testNum = OGnum;
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
		
		if(OGnum > 999_999 && OGnum < 1_000_000_000) {//detects from 1,000,000 to 999,999,999
			testNum /= 1_000_000;
			
			wordedNum += say(testNum) + "-million-" + say(OGnum-(testNum * 1_000_000));
		}
		
		if(OGnum > 999_999_999) { //detects from 1,000,000,000,000 to the limit of int
			testNum /= 1_000_000_000;
			
			wordedNum += say(testNum) + "-billion-" + say(OGnum-(testNum * 1_000_000_000));
		}		
		return wordedNum;
	}
	
	
	
	
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int input;
		
		System.out.println("Enter a positive integer: ");
		input = scan.nextInt();
		
		if (input == 0) {
			System.out.println("zero");
		}
		if (input < 0) {
			System.out.println("Please put a positive integer.");
		}
		else {
			System.out.println(say(input));
		}
		scan.close();


	}
}
