import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UsingStacksSuitorsLab implements Runnable {
	
	private static int threadCount = 0;
	private String name;

	public UsingStacksSuitorsLab() {
		name = "#" + threadCount++ + "Thread";
	}

	public static void main(String[] args) {
		String s1 = "food";		    //not a palindrome
		String s2 = "racecar";      //a palindrome

		System.out.println("String1 is \"" + s1 + "\"");
		System.out.println("String2 is \"" + s2 + "\"");

		System.out.println("----------Iterative Reversing-----------");
		System.out.print(s1 + " reversed is: ");
		printReverse(s1);
		System.out.println();
		System.out.print(s2 + " reversed is: ");
		printReverse(s2);

		System.out.println("\n----------Recursive Reversing-----------");
		System.out.print(s1 + " reversed is: ");
		recPrintReverse(s1);
		System.out.print("\n" + s2 + " reversed is: ");
		recPrintReverse(s2);

		System.out.println("\n----------Is Palindrome Testing-----------");

		System.out.println(s1 + " is a palindrome: " + isPalindrome(s1));
		System.out.println(s2 + " is a palindrome: " + isPalindrome(s2));

		System.out.println(s1 + " is a palindrome(recursively): " + isPalindromeRec(s1));
		System.out.println(s2 + " is a palindrome(recursively): " + isPalindromeRec(s2));

		System.out.println("----------Thread Building----------");
		/*System.out.println("Did we build a Queue of Threads and start them? " + buildThreadQueue());*/

		System.out.println("----------Finding Place to Stand----------");
		int n = 6;
		System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));

		n = 10;
		System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));

	} 

	public static void printReverse(String target) {
		//using Stack
		Stack<Character> reverseString = new Stack<Character>();

		for(int i=0;i<target.length();i++){
			reverseString.push(target.charAt(i));
			//System.out.println("pushed: " + target.charAt(i) + " to next stack frame");
		}

		while(!reverseString.isEmpty()){
			System.out.print(reverseString.pop() + " ");
		}
	}

	public static void recPrintReverse(String target) {
		if(target.length() <= 1){
			System.out.print(target + " ");
		}else{
			recPrintReverse(target.substring(1));
			System.out.print(target.charAt(0) + " ");
		}
	}

	public static boolean isPalindrome(String input) {
		Stack<Character> reverseString = new Stack<Character>();
		char compareToChar;

		for(int i=0;i<input.length();i++){
			reverseString.push(input.charAt(i));
		}

		for(int i=0;i<input.length();i++){
			compareToChar = reverseString.pop();
			if(compareToChar == input.charAt(i)){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	public static boolean isPalindromeRec(String sentence)	{
		if(sentence.length() <= 1){
			
			return true;
		}else if(sentence.charAt(0) == sentence.charAt(sentence.length()-1)){
			return isPalindromeRec(sentence.substring(1, sentence.length()-1));
		}else{
			return false;
		}
	}

	public static int findPlaceToStand(int numSuitors) {
		Queue<Integer> suitorsPosition = new LinkedList<Integer>();
		int count = 0;
		int someSuitor = 0;
		for(int i=0;i<numSuitors;i++){
			suitorsPosition.add(i);
		}

		while(suitorsPosition.size() > 1){
			count++;
			
			if(count == 3){
				someSuitor = suitorsPosition.remove();
				count = 0;			
			}
		}
		return someSuitor;
	}	

	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.println(name + ": " + i + "th iteration");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				//do nothing here
			}
		}
	}
}