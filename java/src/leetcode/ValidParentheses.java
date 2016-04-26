package leetcode;

import java.util.Stack;

public class ValidParentheses {
	
	//String validChar = "()[]{}";
	
	public boolean isValid(String s) {
		if(s.length() == 0){
			return true;
		}
		
        if(s.length() % 2 != 0){
        	return false;
        }
		
        Stack<Character> stack = new Stack<Character>();
		
        for(int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
        	
//        	if(!validChar.contains(c+"")){
//        		return false;
//        	}
        	
        	if(c == '(' || c == '[' || c == '{'){
        		stack.push(c);
        	}else if(c == ')' || c == ']' || c == '}'){
        		if(stack.isEmpty())
        			return false;
        		
        		char m = stack.pop();
        		
        		switch(m){
        		case '(':
        			if(c != ')')
        				return false;
        			break;
        		case '[':
        			if(c != ']')
        				return false;
        			break;
        		case '{':
        			if(c != '}')
        				return false;
        			break;
        		default:
        			return false;
        		}
        	}else{
        		return false;
        	}
        }
        if(!stack.isEmpty())
        	return false;
        
		return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
