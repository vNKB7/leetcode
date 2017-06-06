package brand_new;

import java.util.Arrays;

public class _338_Counting_Bits {
	public int[] countBits(int num) {
        int[] result = new int[num+1];
        if(num == 0)
            return result;
        
        int index = 1;
        int base = 1;
        
        while(true){
            for(int i = 0; i < base; i++){
                result[index++] = 1 + result[i];
                if(index > num)
                    return result;
            }            
            base *= 2;
        }
    }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new _338_Counting_Bits().countBits(5)));
	}

}
