//package calc;

public class Operations {
	
	public float x;
	public float y;
	
	
	public float Addition(float x, float y) {
		float result = x;
		result += y;
		return result;
	}
	
	public float Subtraction(float x, float y) {
		float result = x;
		result -= y;
		return result; 
	}
	
	public float Multiplication(float x, float y) {
		float result = x;
		result *= y;
		return result;
	}
	
	public float Division(float x, float y) {
		float result = x;
		result /= y;
		return result;
	}
	
	public float Exponent(float x, float y) {
		float result = 0;
		for(int i = 0; i < y; i++) {
			result = Multiplication(x, x);
		}
		return result;
	}
	
}
