package graphs;

import java.util.ArrayList;
import java.util.TreeMap;

public class OrderPeopleHeight {

	public static void main(String[] args) {

		ArrayList<Integer> heights = new ArrayList<Integer>();

		heights.add(5);
		heights.add(3);
		heights.add(2);
		heights.add(6);
		heights.add(1);
		heights.add(4);

		ArrayList<Integer> indexs = new ArrayList<Integer>();

		indexs.add(0);
		indexs.add(1);
		indexs.add(2);
		indexs.add(0);
		indexs.add(3);
		indexs.add(2);

		System.out.println(new OrderPeopleHeight().order(heights, indexs));
	}

	public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

		for (int i = 0; i < A.size(); i++) {
			treeMap.put(A.get(i), B.get(i));
		}

		while (!treeMap.isEmpty()) {

			int height = treeMap.lastKey();
			int index = treeMap.get(height);
			treeMap.remove(height);

			if (result.isEmpty()) {
				result.add(height);
			} else if (height == 0) {
				result.add(0, height);
			} else {
				result.add(index, height);
			}

		}

		return result;
	}

}
