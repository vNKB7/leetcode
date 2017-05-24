package brand_new;

import java.util.ArrayList;
import java.util.List;

public class _89_Gray_Code {
	public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(n == 0){
            result.add(0);
            return result;
        }
        int[] base = new int[n];
        base[0] = 2;
        for(int i = 1; i < n; i++)
            base[i] = base[i-1] * 2;

        for(int i = 0; i < base[n-1]; i++){
            int num = 0;
            for(int j = n-1; j >= 0; j--){
                if(i / base[j] % 2 == 0)
                    num = num * 2 + (i / (base[j]/ 2)) % 2;
                else
                    num = num * 2 + 1 - (i / (base[j]/ 2)) % 2;
            }
            result.add(num);
        }
        
        return result;
    }
	
	
	//1、n位格雷码由n-1位格雷码组成
	//2、G(i) = i ^ (i/2)

	public static void main(String[] args) {
		System.out.println(new _89_Gray_Code().grayCode(2));
	}

}
