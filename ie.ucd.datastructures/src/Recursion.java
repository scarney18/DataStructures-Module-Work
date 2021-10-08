
public class Recursion {
	
	//collatz takes a positive int n
	private static int collatz(int n) {
		//if n is not positive return -1
		if(n<1) {
			return -1;
		}
		//when n = 1 return n
		if(n==1) {
			return n;
		}
		//if n is even divide n by 2, calling collatz recursively
		if(n%2 == 0) {
			return collatz(n/2);
		}
		//if n is odd multiply n by 3 and add 1, calling collatz recursively
		else {
			return collatz(3*n+1);
		}
	}
	
	private static int sumOfDigits(int n) { 
		return n == 0 ? 0 : n%10 + sumOfDigits(n/10) ;
	}
	
	public static class Palindrome{
		
		public static boolean isPalindrome(String input) {
			
			input = input.replaceAll("[^A-Za-z]+","");
			StringBuilder revInput = new StringBuilder();
			revInput.append(input);
			revInput.reverse();
			
			if(input.equalsIgnoreCase(revInput.toString())) {
				return true;
			}
			return false;
		}
	
	}
	
	//driver function to test collatz
	public static void main(String[] args) {
		
		System.out.println(collatz(5)); //5 -> 16 -> 8 -> 4 -> 2 -> 1
		System.out.println(collatz(9));
		System.out.println(collatz(871));
		
		System.out.println(sumOfDigits(121));// =4
		System.out.println(sumOfDigits(54321));// =15
		
		//testing some of the cases for palindromes
		System.out.println(Palindrome.isPalindrome("racecar"));
		System.out.println(Palindrome.isPalindrome("Radar"));
		System.out.println(Palindrome.isPalindrome("Step on no pets"));
		System.out.println(Palindrome.isPalindrome("Was it a cat I saw?"));
		System.out.println(Palindrome.isPalindrome("eva, can I see bees in a cave?"));
		System.out.println(Palindrome.isPalindrome("palindrome"));

	}
}
