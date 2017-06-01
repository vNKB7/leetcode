package brand_new;

import java.util.HashMap;
import java.util.Map;

public class _166_Fraction_to_Recurring_Decimal {
	public String fractionToDecimal(int numerator, int denominator) {
		String sign = (long)numerator  * (long)denominator >= 0 ? "" : "-";
		long a = Math.abs((long)numerator);
		long b = Math.abs((long)denominator);
		String result = "";
		Map<Long, Integer> map = new HashMap<>();
		result += "" + a / b;
		long mod = a % b;
		if (mod > 0) {
			result += ".";
			int index = result.length();
			map.put(mod, index);
			while (mod > 0) {
				index++;
				mod *= 10;
				result += mod / b + "";
				mod %= b;
				if (map.containsKey(mod)) {
					int i = map.get(mod);
					result = result.substring(0, i) + "(" + result.substring(i);
					result += ")";
					return sign+result;
				}else{
				    map.put(mod, index);
				}
			}
		}
		return sign+result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
