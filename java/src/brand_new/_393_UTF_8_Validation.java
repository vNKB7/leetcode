package brand_new;

public class _393_UTF_8_Validation {
	public boolean validUtf8(int[] data) {
		if(data.length == 0)
			return true;
		
		int i = 0;
		while(i < data.length){
			int length = 0;
			if(data[i] >>> 7 == 0)
				length = 1;
			else if(data[i] >>> 5 == 6)
				length = 2;
			else if(data[i] >>> 4 == 14)
				length = 3;
			else if(data[i] >>> 3 == 30)
				length = 4;
			else
				return false;
			if(i+length > data.length)
				return false;
			
			if(!isValid(data, i, length))
				return false;
			
			i += length;
		}
		return true;
	}
	
	public boolean isValid(int[] data, int i, int length){
		if(length == 1){
			return true;
		}else if(length == 2){
			return (data[i+1] >>> 6) == 2;
		}else if(length == 3){
			return (data[i+1] >>> 6) == 2 && (data[i+2] >>> 6) == 2;
		}else if(length == 4){
			return (data[i+1] >>> 6) == 2 && (data[i+2] >>> 6) == 2 && (data[i+3] >>> 6) == 2;
		}else{
			return false;
		}
	}
	

	public static void main(String[] args) {
		System.out.println(new _393_UTF_8_Validation().validUtf8(new int[]{115,100,102,231,154,132,13,10}));
	}

}
