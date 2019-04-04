package graphs;

import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class LevelOrderTraversal {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		TreeNode nine = new TreeNode(9);
		
		TreeNode twenty = new TreeNode(20);
		
		TreeNode fiften = new TreeNode(15);
		TreeNode seven = new TreeNode(7);
		
		root.left= nine;
		root.right = twenty;
		
		twenty.left = fiften;
		twenty.right = seven;
		
		System.out.println(new LevelOrderTraversal().levelOrder(root));
		
		
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		LinkedList<TreeNode> queueObj = new LinkedList<TreeNode>();
		LinkedList<Integer> levelObj = new LinkedList<Integer>();
		
		if(null== A) {
			return output;
		}
		
		queueObj.add(A);
		levelObj.add(0);
		
		while(!queueObj.isEmpty()) {
			
			TreeNode treeNodeObj = queueObj.getLast();
			Integer level = levelObj.getLast();
			
			if(output.size()<=level) {
				ArrayList<Integer> listObj = new ArrayList<Integer>();
				listObj.add(treeNodeObj.val);
				output.add(level, listObj);
			}else {
				ArrayList<Integer> listObj = output.get(level);
				listObj.add(treeNodeObj.val);
			}
			
			if(null!= treeNodeObj.left) {
				queueObj.addFirst(treeNodeObj.left);
				levelObj.addFirst(level+1);
			}
			
			if(null!= treeNodeObj.right) {
				queueObj.addFirst(treeNodeObj.right);
				levelObj.addFirst(level+1);
			}
			
			queueObj.removeLast();
			levelObj.removeLast();
			
		}
		
	
		return output;
	}

}
