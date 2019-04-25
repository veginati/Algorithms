package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommutableIsands_Prim_Worked_MST {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> outerArrayList = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> integerAL1 = new ArrayList<Integer>();

		integerAL1.add(1);
		integerAL1.add(2);
		integerAL1.add(1);

		ArrayList<Integer> integerAL2 = new ArrayList<Integer>();

		integerAL2.add(2);
		integerAL2.add(3);
		integerAL2.add(4);

		ArrayList<Integer> integerAL3 = new ArrayList<Integer>();

		integerAL3.add(1);
		integerAL3.add(4);
		integerAL3.add(3);

		ArrayList<Integer> integerAL4 = new ArrayList<Integer>();

		integerAL4.add(4);
		integerAL4.add(3);
		integerAL4.add(2);

		ArrayList<Integer> integerAL5 = new ArrayList<Integer>();

		integerAL5.add(1);
		integerAL5.add(3);
		integerAL5.add(10);

		outerArrayList.add(integerAL1);
		outerArrayList.add(integerAL2);
		outerArrayList.add(integerAL3);
		outerArrayList.add(integerAL4);
		outerArrayList.add(integerAL5);

		System.out.println(new CommutableIsands_Prim_Worked_MST().solve_V3(4, outerArrayList));

	}

	/**
	 * Approach O(pow(V,2) ) approach using Adjacent index approach.
	 * 
	 * @param A
	 * @param B
	 * @return
	 * 
	 * 		problem: Heap space issue, memory issue.
	 */
	public int solve(int A, ArrayList<ArrayList<Integer>> B) {

		int[][] graphPathsCost = new int[A + 1][A + 1];
		boolean[] visitedNodes = new boolean[A + 1];
		int[] minNodeValues = new int[A + 1];

		int totalCost = 0;

		for (int i = 0; i < B.size(); i++) {
			graphPathsCost[B.get(i).get(0)][B.get(i).get(1)] = B.get(i).get(2);
			graphPathsCost[B.get(i).get(1)][B.get(i).get(0)] = B.get(i).get(2);
		}

		// initialize default values.
		for (int i = 0; i < minNodeValues.length; i++) {
			minNodeValues[i] = Integer.MAX_VALUE;
		}

		minNodeValues[1] = 0;

		int count = 0;

		while (count < A) {

			int index = getMinNode(minNodeValues, visitedNodes);

			if (index > 0) {

				count++;

				for (int i = 0; i < A + 1; i++) {

					if (graphPathsCost[index][i] > 0 && graphPathsCost[index][i] < minNodeValues[i]
							&& !visitedNodes[i]) {

						minNodeValues[i] = graphPathsCost[index][i];
					}
				}
			} else {
				break;
			}
		}

		for (int i = 1; i < A + 1; i++) {
			totalCost += minNodeValues[i];
		}

		return totalCost;
	}

	/**
	 * Approach without memory
	 * 
	 * @param A
	 * @param B
	 * @return Time complexity issue.
	 */
	public int solve_v2(int A, ArrayList<ArrayList<Integer>> B) {

		// int[][] graphPathsCost = new int[A + 1][A + 1];
		boolean[] visitedNodes = new boolean[A + 1];
		int[] minNodeValues = new int[A + 1];

		int totalCost = 0;

		// initialize default values.
		for (int i = 0; i < minNodeValues.length; i++) {
			minNodeValues[i] = Integer.MAX_VALUE;
		}

		minNodeValues[1] = 0;

		int count = 0;

		while (count < A) {

			int index = getMinNode(minNodeValues, visitedNodes);

			if (index > 0) {

				count++;

				for (int k = 0; k < B.size(); k++) {

					if (B.get(k).get(0) == index) {

						int temp = B.get(k).get(1);

						if (B.get(k).get(2) < minNodeValues[temp] && !visitedNodes[temp]) {

							minNodeValues[temp] = B.get(k).get(2);
						}

					}

					if (B.get(k).get(1) == index) {

						int temp = B.get(k).get(0);

						if (B.get(k).get(2) < minNodeValues[temp] && !visitedNodes[temp]) {

							minNodeValues[temp] = B.get(k).get(2);
						}

					}

				}

			} else {
				break;
			}
		}

		for (int i = 1; i < A + 1; i++) {
			totalCost += minNodeValues[i];
		}

		return totalCost;
	}

	/**
	 * Approach O(E Log V) ) approach using Adjacent index approach.
	 * 
	 * @param A
	 * @param B
	 * @return
	 * 
	 * 		problem: Heap space issue, memory issue.
	 */
	public int solve_V3(int A, ArrayList<ArrayList<Integer>> B) {

		List<HashMap<Integer, Integer>> listObj = new ArrayList<HashMap<Integer, Integer>>(A);

		for (int i = 0; i < A+1; i++) {
			listObj.add(new HashMap<Integer, Integer>());
		}

		boolean[] visitedNodes = new boolean[A + 1];
		int[] minNodeValues = new int[A + 1];

		int totalCost = 0;

		for (int i = 0; i < B.size(); i++) {

			HashMap<Integer, Integer> mapObj = listObj.get(B.get(i).get(0));
			mapObj.put(B.get(i).get(1), B.get(i).get(2));

			HashMap<Integer, Integer> mapObj1 = listObj.get(B.get(i).get(1));
			mapObj1.put(B.get(i).get(0), B.get(i).get(2));

		}

		// initialize default values.
		for (int i = 0; i < minNodeValues.length; i++) {
			minNodeValues[i] = Integer.MAX_VALUE;
		}

		minNodeValues[1] = 0;

		int count = 0;

		while (count < A) {

			int index = getMinNode(minNodeValues, visitedNodes);

			if (index > 0) {

				count++;

				HashMap<Integer, Integer> hashMapObj = listObj.get(index);

				Set<Integer> keySet = hashMapObj.keySet();

				Iterator<Integer> integerIterator = keySet.iterator();

				while (integerIterator.hasNext()) {

					int temp = integerIterator.next();

					if (hashMapObj.get(temp) < minNodeValues[temp] && !visitedNodes[temp]) {

						minNodeValues[temp] = hashMapObj.get(temp);
					}

				}

			} else {
				break;
			}
		}

		for (int i = 1; i < A + 1; i++) {
			totalCost += minNodeValues[i];
		}

		return totalCost;
	}
	

	private int getMinNode(int[] nodeValues, boolean[] visitedNodes) {

		int minCost = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < nodeValues.length; i++) {

			if (nodeValues[i] < minCost && !visitedNodes[i]) {
				minCost = nodeValues[i];
				index = i;
			}
		}

		if (index > 0) {
			visitedNodes[index] = true;
		}

		return index;
	}

}
