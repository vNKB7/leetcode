package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
        ArrayList<String> rt = new ArrayList<String>();
        generate(rt, "", 0, n);
        return rt;
    }
	
	
	public void generate(ArrayList<String> list, String str, int pairs, int left){
		if(left > 0){
			if(pairs > 0){
				generate(list, str+")", pairs - 1, left);
			}
			
			generate(list, str+"(", pairs + 1, left - 1);
		}else if(pairs > 0){
			for(int i = 0; i < pairs; i ++){
				str += ")";
			}
			
			list.add(str);
		}else{
			list.add(str);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		List<String> rt = new GenerateParentheses().generateParenthesis(3);
		for(String str : rt){
			System.out.println(str);
		}

	}

}
