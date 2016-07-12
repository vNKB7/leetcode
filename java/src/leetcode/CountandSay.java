package leetcode;

import java.util.ArrayList;


//连续的数字不会超过3个，设个数为n，指定数为x，则nxnx中两个x不能相同，只有可能两个n相同。故数串中只能出现1~3
public class CountandSay {
	
	public String countAndSay(int n) {
		String str = "1";
		String nextStr = "";
		
		for(int i = 0; i < n - 1; i++){
			nextStr = "";
			int index = 0;
			int length = str.length();
			
			while(index < length){
				char curNum = str.charAt(index);
				
				if(index + 1 < length && str.charAt(index+1) == curNum){
					if(index + 2 < length && str.charAt(index+2) == curNum){
							nextStr += "3"+curNum;
							index += 3;
					}else{
						nextStr += "2"+curNum;
						index += 2;
					}
				}else{
					nextStr += "1"+curNum;
					index ++;
				}
			}
			str = nextStr;
		}
		
		return str;
	}
	/*
	 * 用StringBuilder拼接字符串要比String快
	 */
	public String countAndSay2(int n) {
		String str = "1";
		StringBuilder nextStr = new StringBuilder();
		
		char[] set = new char[1];
		
		for(int i = 0; i < n - 1; i++){
			nextStr = new StringBuilder();
			int index = 0;
			int length = str.length();
			
			while(index < length){
				char curNum = str.charAt(index);
				
				if(index + 1 < length && str.charAt(index+1) == curNum){
					if(index + 2 < length && str.charAt(index+2) == curNum){
							nextStr.append("3");
							nextStr.append(curNum);
							index += 3;
					}else{
						nextStr.append("2");
						nextStr.append(curNum);
						index += 2;
					}
				}else{
					nextStr.append("1");
					nextStr.append(curNum);
					index ++;
				}
			}
			str = nextStr.toString();
		}
		
		return str;
	}

	public static void main(String[] args) {
		CountandSay c = new CountandSay();
		for(int i = 1; i < 10; i++){
			System.out.println(c.countAndSay(i));
		}
	}
}
