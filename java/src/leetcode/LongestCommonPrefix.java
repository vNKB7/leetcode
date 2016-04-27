package leetcode;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0)
			return "";
		
		if(strs.length == 1)
			return strs[0];
		
        int len = strs[0].length();
        
        for(int i = 0; i < strs.length; i++){
        	if(strs[i].length() < len){
        		len = strs[i].length();
        	}
        }
        
        int i = 0;
        
        for(; i < len; i++){
        	char w = strs[0].charAt(i);
        	boolean flag = true;
        	
        	for(int j = 1; j < strs.length; j++){
        		if(strs[j].charAt(i) != w){
        			flag = false;
        			break;
        		}
        	}
        	
        	if(!flag){
        		if(i == 0)
        			return "";
        		else
        			return strs[0].substring(0, i);
        		
        	}
        }

        return strs[0].substring(0, len);
    }
	
	public static void main(String args[]){
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"12356","1234","123456"}));
	}
}
