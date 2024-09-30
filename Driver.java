//package calc;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		String numberMap = "1234567890.";
		String operatorMap = "*/+-^";

		Operations OP = new Operations(); //creating an instance of the Operations class
		
		ArrayList<Float> operands = new ArrayList<Float>(); //store each operand in float list to allow decimals
		ArrayList<Character> op = new ArrayList<Character>(); //store the operator in char list
		
		String input = ReadLine();
		//System.out.println(input);
		LoopInputLine(input, numberMap, operatorMap, operands, op);
		
		//checking to see if it adds operands
		System.out.println("Operands: " + operands);
		System.out.println("Operators: " + op);
		
		System.out.println(input + "=" + DoTheMath(operands, op, OP));
		
	}
	
	//need a function that reads the whole input line
	public static String ReadLine() {
		Scanner s = new Scanner(System.in);
		System.out.println("Type mathematical equation below (no spaces please):");
		
		//for storing the input and then we can loop through it using charAt()
		String inputResult = s.nextLine(); 
		return inputResult;
	}
	
	//loops through the input to separate and parse string, and put it into the array lists
	public static void LoopInputLine(String newInput, String numbers, String operators, ArrayList<Float> operands, ArrayList<Character> op) {
		
		char operatorToAdd;
		String temp = "";
		float convertedString = 0f; //used to store the float converted from a string that user inputs
		boolean match = false;
		boolean parse = false; //letting us know when to parse
		int lengthCounter = 0;

		
		for(int i = 0; i < newInput.length(); i++) {
			
			for(int j = 0; j < numbers.length(); j++) {
				parse = false;
				if(newInput.charAt(i) == numbers.charAt(j) && match == false) {
					temp += numbers.charAt(j); //adding this to temp string
					//System.out.println("Temp: " + temp);
					lengthCounter += 1;
				}
			}
			
			
			match = false;
			
			
			
			for(int k = 0; k < operators.length(); k++) {
				if(newInput.charAt(i) == operators.charAt(k) && match == false) {
					//temp = ""; resets temp once it sees an operator
					operatorToAdd = operators.charAt(k);
					op.add(operatorToAdd);

					match = true;
					//once we hit an operator, we can parse the temp string to int for adding to operand list
					parse = true; 
					lengthCounter += 1;
				}
			}
			//this if statement parses the final string in temp and then adds it to operand list
			if(parse == true|| lengthCounter == newInput.length()) {
				convertedString = Float.parseFloat(temp); //taking temp and converting it to float for calculation (just numbers right now)
				//System.out.println("Here is converted string: " + convertedString);
				
				operands.add(convertedString); //actually adding the operand
				temp = ""; //making temp empty
			}
			
			match = false;
		}
	}
	
	public static float DoTheMath(ArrayList<Float> operands, ArrayList<Character> op, Operations OP) {
		float result = operands.get(0); //sets result to first operand
		//loop will go through as many times as there are numbers in the expression
		for(int i = 0; i < op.size(); i++) {
			if(op.get(i) == '^') {
				result = OP.Exponent(result, operands.get(i+1));
			}
			if(op.get(i) == '*') {
				result = OP.Multiplication(result, operands.get(i+1));
			}
			else if(op.get(i) == '/') {
				result = OP.Division(result, operands.get(i+1));
			}
			else if(op.get(i) == '+') {
				result = OP.Addition(result, operands.get(i+1)); //result = result + nextOperand
			}
			else if(op.get(i) == '-') {
				result = OP.Subtraction(result, operands.get(i+1)); //result = result - nextOperand
			}
		}
		return result;
	}
	
}
