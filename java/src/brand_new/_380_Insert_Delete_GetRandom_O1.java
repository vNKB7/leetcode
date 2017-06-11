package brand_new;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class _380_Insert_Delete_GetRandom_O1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class RandomizedSet {

	Map<Integer, Integer> map;
	List<Integer> index;
	Random rd = new Random();

	/** Initialize your data structure here. */
	public RandomizedSet() {
		map = new HashMap<Integer, Integer>();
		index = new ArrayList<Integer>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val))
			return false;
		else {
			map.put(val, index.size());
			index.add(val);
			return true;
		}
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if(!map.containsKey(val))
			return false;
		else{
			if(val != index.get(index.size()-1)){
				index.set(map.get(val), index.get(index.size()-1));
				map.put(index.get(index.size()-1), map.get(val));
			}
			map.remove(val);
			index.remove(index.size()-1);
			return true;
		}
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int i = rd.nextInt(index.size());
		return index.get(i);
	}
}
