package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _241_Different_Ways_to_Add_Parentheses {
	
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			if(c == '+' || c == '-' || c == '*'){
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()));
				
				for(int a : left){
					for(int b : right){
						switch(c){
						case '+':
							result.add(a+b);
							break;
						case '-':
							result.add(a-b);
							break;
						case '*':
							result.add(a*b);
							break;
						}
					}
				}
			}
		}
		
		if(result.size() == 0)
			result.add(Integer.parseInt(input));
		
		return result;
	}
	

	public static void main(String[] args) {
	}

}
