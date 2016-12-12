package com.week01.tuesday;

public class Problems {
	
//	Problem 1
	public static boolean isNumberOdd(int number) {
		return number % 2 != 0; 
	}

//	Problem 2
	public static boolean isNumberPrime(int number) {
		if (number <= 1) {
			return false;
		}
		for(int i = 2; i < Math.sqrt(number); i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}

//	 Problem 3
	public static int factorial(int number) {
		if(number == 0) {
			return 1;
		}
		int result = 1;
		for(int i = 1; i <= number; i++) {
			result *= i;
		}
		return result;
	}
	
	public static int factorialDigits(int number) {
		int digit, result=0;
		while(number > 0){
			digit = number % 10;
			number = number / 10;
			result += factorial(digit);
		}
		return result;
	}

//	Problem 4
	public static int numberLength(int number){
		if (number == 0 ) {
			return 1;
		}
		int counter = 0;
		while(number > 0){
			number /= 10;
			counter++;
		}
		return counter;
	}

	public static int fibonacci(int number){
		if (number == 1 || number == 2) {
			return 1;
		}

		return fibonacci(number - 1) + fibonacci(number - 2);
	}

	public static int fibonacciSequence(int number){
		int result = 0;
		for(int i = 1; i <= number; i++){
			int fibNum = fibonacci(i);
			result *= Math.pow(10,numberLength(fibNum));
			result += fibonacci(i);
		}
		return result;
	}

//	Problem 5
	public static int reverseNumber(int number){
		int result = 0;
		while(number != 0){
			result = result * 10;
			result += number % 10;
			number /= 10;
		}

		return result;
	}
	public static boolean isPalindrome(int number){
		return number == reverseNumber(number);
	}

//	Problem 6
	public static String reverseString(String str){
	String result = "";
	for(int i = str.length() - 1; i >= 0; i--){
		result += str.charAt(i);
	}
	return result;
	}

	public static String reverseOddWords(String sentence){
		String result = "";
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (isNumberOdd(i)) {
				reverseString(words[i]);
			}
			if (i == 0) {
				result += words[i];
			}
			else if (isNumberOdd(i)){
				result += " " + reverseString(words[i]);
			}
			else{
				result += " " + words[i];	
			}	
		}
		return result;

	}

//	Problem 7
	public static boolean isSumPalindrome(int input){
		return isPalindrome((input + reverseNumber(input)));
	}

//	Problem 8
	public static boolean isDivisor(int divisor, int number){
		return number % divisor == 0;
	}

	public static int sumOfDivisors(int numberA, int numberB){
		int result = 0;
		for(int i = numberA; i <= numberB; i++){
			for (int j = 1; j <= i; j++) {
				if (isDivisor(j,i)) {
					result += j;
				}
			}
		}
		return result;
	}

//	Problem 9
	public static boolean stringContainsChar(String str, char c){
		if(str.length() == 0){
			return false;
		}
		else{
			return str.charAt(0) == c || stringContainsChar(str.substring(1),c);
		}
	}

	public static boolean isVowel(char c){
		String vowels = "aeiouAEIOU";
		return stringContainsChar(vowels, c);
	}

//	Consonant == !isVowel
	public static boolean isConsonant(char c){
		String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
		return stringContainsChar(consonants, c);
	}

	public static boolean isDigit(char c){
		String digits = "0123456789";
		return stringContainsChar(digits, c);
	}

	public static String [] vowelsConsonantsDigits(String sentence){
		int vowels = 0, consonants = 0, digits = 0;

		for(int i = 0; i < sentence.length(); i++){
			if (isVowel(sentence.charAt(i))) {
				vowels++;
			}
			else if (isConsonant(sentence.charAt(i))){
				consonants++;
			}
			else if (isDigit(sentence.charAt(i))) {
				digits++;
			}
			else{
				continue;
			}
		}

//		Or it can be only : result[0] = "Vowels: " + vowels
		String[] result = new String[3];
		result[0] = "Vowels: " + String.valueOf(vowels);
		result[1] = "Consonants: " + String.valueOf(consonants);
		result[2] = "Digits: " + String.valueOf(digits);

		return result;
	}


	public static void main(String[] args) {
//		 Testing Problem 1
//		 System.out.println(isNumberOdd(3));

//		 Testing Problem 2
//		 System.out.println(isNumberPrime(8));

//		 Testing Problem 3
//		 System.out.println(factorial(5));
//		 System.out.println(factorialDigits(321));

//		 Testing Problem 4
//		 System.out.println(fibonacci(6));
//		 System.out.println(numberLength(0));
//		 System.out.println(fibonacciSequence(5));

//		 Testing Problem 5
//		 System.out.println(reverseNumber(1234));
//		 System.out.println(isPalindrome(12321));

//		 Testing Problem 6
//		 System.out.println(reverseOddWords("This is the first lecture for Programming 101 with Java"));
		
//		 Testing Problem 7
//		 System.out.println(isSumPalindrome(123));
		
//		 Testing Problem 8
//		 System.out.println(isDivisor(5,6));
//		 System.out.println(sumOfDivisors(4,7));

//		 Testing Problem 9
//		 System.out.println(stringContainsChar("Test", 't'));
//		 System.out.println(isVowel('a'));
//		 System.out.println(isDigit('1'));	
//		 
//		 String[] test = new String[3];
//		 test = vowelsConsonantsDigits("It is 18th of Oct 2016");
//		 System.out.println(test[0]);
//		 System.out.println(test[1]);
//		 System.out.println(test[2]);

	}

}
