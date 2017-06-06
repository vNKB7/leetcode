package brand_new;

public class _306_Additive_Number {

	public boolean isAdditiveNumber(String num) {
		if(num.length() == 0)
			return false;
		
		for(int i = 0; i <= num.length() / 2; i++){
			for(int j = i+1; j <= i+(num.length()-1-i)/2; j++){
				String aStr = num.substring(0, i+1);
				String bStr = num.substring(i+1, j+1);
				if(aStr.length() > 1 && aStr.charAt(0)=='0' || aStr.length()==0)
					break;
				if(bStr.length() > 1 && bStr.charAt(0)=='0' || bStr.length()==0)
					break;
				long a = Long.parseLong(aStr);
				long b = Long.parseLong(bStr);
				
				int start = j+1, end = j+1;
				boolean flag = false;
				while(true){
					String c = ""+(a+b);
					int remain = num.length() - start;
					end = start+c.length();
					if(c.length() > remain){
						flag = false;
						break;
					}else if(c.length() <= remain){
						String next = num.substring(start, end);
						if(!next.equals(c)){
							flag = false;
							break;
						}
						if(c.length() == remain){
							return true;
						}
						a = b;
						b = Long.parseLong(c);
					}
					start = end;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new _306_Additive_Number().isAdditiveNumber("2461016264268110179"));
	}

}
