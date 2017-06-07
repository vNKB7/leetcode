package brand_new;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class _341_Flatten_Nested_List_Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// 一次全部取出
// class NestedIterator implements Iterator<Integer> {
// List<Integer> list = new ArrayList<>();
// int index = 0;
//
// public NestedIterator(List<NestedInteger> nestedList) {
// for(NestedInteger ni : nestedList)
// parse(ni);
// }
//
// private void parse(NestedInteger ni){
// if(ni.isInteger()){
// list.add(ni.getInteger());
// }else{
// List<NestedInteger> children = ni.getList();
// for(NestedInteger nii : children)
// parse(nii);
// }
// }
//
// @Override
// public Integer next() {
// return list.get(index++);
// }
//
// @Override
// public boolean hasNext() {
// return index < list.size();
// }
// }

class NestedIterator implements Iterator<Integer> {
	Stack<NestedInteger> stack = new Stack<>();
	NestedInteger next = null;

	public NestedIterator(List<NestedInteger> nestedList) {
		for (int i = nestedList.size() - 1; i >= 0; i--)
			stack.push(nestedList.get(i));
	}

	@Override
	public Integer next() {
		return next.getInteger();
	}

	@Override
	public boolean hasNext() {
		if (stack.size() > 0) {
			next = stack.pop();
			while (!next.isInteger()) {
				List<NestedInteger> nestedList = next.getList();
				if (nestedList.size() != 0) {
					for (int i = nestedList.size() - 1; i >= 1; i--) {
						stack.push(nestedList.get(i));
					}
					next = nestedList.get(0);
				} else if (stack.size() > 0) {
					next = stack.pop();
				} else {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

}