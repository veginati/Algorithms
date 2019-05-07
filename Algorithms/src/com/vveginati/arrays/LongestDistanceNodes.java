package com.vveginati.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

class Pair {

	Integer key;
	Integer value;

	public Pair(Integer key, Integer value) {
		this.key = key;
		this.value = value;
	}
}

public class LongestDistanceNodes {

	public static void main(String[] args) {

		// int[] A = {2,-1,3,4,6,1,5,5,5,8,9,10,11};
		int[] A = { -1, 0, 1, 1, 2, 0, 5, 0, 3, 0, 0, 2, 3, 1, 12, 14, 0, 5, 9, 6, 16, 0, 13, 4, 17, 2, 1, 22, 14, 20, 10, 17, 0, 32, 15, 34, 10, 19, 3, 22, 29, 2, 36, 16, 15, 37, 38, 27, 31, 12, 24, 29, 17, 29, 32, 45, 40, 15, 35, 13, 25, 57, 20, 4, 44, 41, 52, 9, 53, 57, 18, 5, 44, 29, 30, 9, 29, 30, 8, 57, 8, 59, 59, 64, 37, 6, 54, 32, 40, 26, 15, 87, 49, 90, 6, 81, 73, 10, 8, 16};

		System.out.println(new LongestDistanceNodes().solve(A));
	}

	public int solve(int[] A) {

		int max = 0;

		int[] identifyChildNodes = new int[A.length];
		int[] childNodeDepth = new int[A.length];

		HashMap<Integer, Integer> mapObj = new HashMap<Integer, Integer>();

		for (int i = 0; i < A.length; i++) {

			if (A[i] == -1) {
				identifyChildNodes[i] = 1;
				childNodeDepth[i] = 0;
			} else {
				identifyChildNodes[A[i]] = 1;
				childNodeDepth[i] = childNodeDepth[A[i]] + 1;
			}
		}

		List<Pair> pairObjList = new ArrayList<Pair>();

		for (int i = 0; i < A.length; i++) {
			if (identifyChildNodes[i] == 0) {
				pairObjList.add(new Pair(i, childNodeDepth[i]));
			}

		}

		Collections.sort(pairObjList, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return -o1.value.compareTo(o2.value);
			}
		});

		for (int i = 0; i < pairObjList.size(); i++) {

			int count = 0;
			int k = pairObjList.get(i).key;

			while (A[k] != -1) {

				count += 1;

				if (!mapObj.containsKey(A[k])) {
					mapObj.put(A[k], count);
					max = Math.max(max, count);
				} else if (count > mapObj.get(A[k])) {
					max = Math.max(max, mapObj.get(A[k]) + count);
					mapObj.put(A[k], count);
					break;
				} else {
					max = Math.max(max, mapObj.get(A[k]) + count);
					break;
				}

				k = A[k];
			}

		}

		return max;
	}

}
