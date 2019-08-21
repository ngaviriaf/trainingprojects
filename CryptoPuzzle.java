package co.ngaviriaf.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CryptoPuzzle {
	
	public static void main(String[] args) {
		solveCryptoPuzzle();
	}
	
	static String a = "SEND";
	static String b = "MORE";
	static char op = '+';
	static String r = "MONEY";
	
	static boolean solveCryptoPuzzle(){
		
		List<Character> charSet = new ArrayList<>();
		
		for (int i = 0; i < a.length(); i++) {
			if(!charSet.contains(a.charAt(i))){
				charSet.add(a.charAt(i));
			}
		}
		
		for (int i = 0; i < b.length(); i++) {
			if(!charSet.contains(b.charAt(i))){
				charSet.add(b.charAt(i));
			}
		}
		
		for (int i = 0; i < r.length(); i++) {
			if(!charSet.contains(r.charAt(i))){
				charSet.add(r.charAt(i));
			}
		}
		
		char numbers [] = new char [10];
		Arrays.fill(numbers, '-');
		
		
		if(!solveCryptoPuzzle(charSet, numbers, op)){
			System.out.println("No existe solución");
			return false;
		} else {
			printNumbers(numbers);
		}
		return true;		
	}
	
	static void printNumbers(char [] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i] + " ");
		}	
	}

	static boolean solveCryptoPuzzle(List <Character> charSet, char [] numbers, char operator){
		if(checkSolution(numbers, operator)){
			return true;
		}
		
		int pos = -1;
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == '-'){
				pos = i;
				break;
			}
		}
		
		for(int i = 0; i < charSet.size(); i++){
			if(isSafe(charSet.get(i), numbers)){
				numbers[pos] = charSet.get(i);
				
				
				if(solveCryptoPuzzle(charSet, numbers, operator)){
					return true;
				} else{
					numbers[pos] = '-';
				}
			}
		}
		
		return false;
	}


	static boolean checkSolution(char [] numbers, char operator) {
		int aValue = 0;
		for (int i = a.length()-1; i >= 0; i--) {
			aValue += getValue(a.charAt(i), numbers) * Math.pow(10, i);
		}
		
		int bValue = 0;
		for (int i = b.length()-1; i >= 0; i--) {
			bValue += getValue(b.charAt(i), numbers) * Math.pow(10, i);
		}
		
		int rValue = 0;
		for (int i = r.length()-1; i >= 0; i--) {
			rValue += getValue(r.charAt(i), numbers) * Math.pow(10, i);
		}
		
		return ((aValue + bValue) == rValue);
	}


	static int getValue(char c, char [] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == c){
				return i;
			}
		}
		return -1;
	}

	static boolean isSafe(char c, char [] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == c){
				return false;
			}
		}
		return true;
	}
}
