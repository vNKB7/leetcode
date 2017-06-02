package brand_new;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _134_Gas_Station {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length == 0)
			return 0;
		int n = gas.length;
		int[] remain = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			remain[i] = gas[i] - cost[i];
			sum += remain[i];
		}

		if (sum < 0)
			return -1;

		int start = 0;
		int count = 0;
		int cur = 0;
		
		while (count < n) {
			cur += remain[(start + count) % n];
			if (cur < 0) {
				cur = 0;
				start = (start + count + 1) % n;
				count = 0;
			} else {
				count = count + 1;
			}
		}
		return start;
	}

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream inputStream = new FileInputStream("in.txt");
		Scanner sc = new Scanner(inputStream, "UTF-8");
		String[] gas = sc.nextLine().split(",");
		String[] cost = sc.nextLine().split(",");
		
		int[] g = new int[gas.length];
		int[] c = new int[cost.length];
		for(int i = 0; i < gas.length; i++){
			g[i] = Integer.parseInt(gas[i]);
			c[i] = Integer.parseInt(cost[i]);
		}
		
		System.out.println(new _134_Gas_Station().canCompleteCircuit(g, c));
	}
}
