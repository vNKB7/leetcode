package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _401_Binary_Watch {
	public List<String> readBinaryWatch(int num) {
		List<String> result = new ArrayList<>();
		
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 60; j++){
				if(Integer.bitCount(i) + Integer.bitCount(j) == num){
					result.add(String.format("%d:%02d", i, j));
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
