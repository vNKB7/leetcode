package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _29_Divide_Two_Integers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int divide(int dividend, int divisor) {
		if(dividend == 0){
			return 0;
		}
		
		if(divisor == 0){
			return Integer.MAX_VALUE;
		}
		 
		if(divisor == 1){
			return dividend;
		}
		
		List<Integer> stack = new ArrayList<Integer>();
		while(divisor < dividend){
			stack.add(divisor);
			int tmp = 0;
			for(int i = 0; i < 10; i++){
				tmp += divisor;
			}
			divisor = tmp;
		}
		
		int result = 0;
		while(dividend > 0){
			if(stack.size() == 0){
				break;
			}
			divisor = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			while(dividend > )
		}
		
		
		return 0;
	}

}
