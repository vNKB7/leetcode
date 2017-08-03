package brand_new;

public class _434_Number_of_Segments_in_a_String {
	public int countSegments(String s) {
		String[] piece = s.trim().split(" ");
		int count = 0;
		for(String str : piece){
			if(str.length() > 0)
				count++;
		}
		
		return count;
	}

	public static void main(String[] args) {

	}

}
