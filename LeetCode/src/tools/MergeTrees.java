package tools;

import java.util.ArrayList;
import java.util.List;

public class MergeTrees {
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		int len=0;
		if(l1.length>=l2.length)
			len=l1.length;
		else
			len=l2.length;
		int[] re = new int[len];
        return null;
    }
	static TreeNode[] l1 = new TreeNode[4];
	static TreeNode[] l2 = new TreeNode[5];
	public static void main(String[] args) {
		
		l1[0]=new TreeNode(1);
		l1[1] = new TreeNode(3);
		l1[2] =new TreeNode(2);
		l1[3]=new TreeNode(5);
		l1[0].left=l1[1];
		l1[0].right=l1[2];
		l1[1].left=l1[3];
		l1[1].right=null;
		l1[2].left=null;
		l1[2].right=null;
		l1[3].left=null;
		l1[3].right=null;
		l2[0] =new TreeNode(2);
		l2[1] = new TreeNode(1);
		l2[2]=new TreeNode(3);	
		l2[3]=new TreeNode(4);
		l2[4]=new TreeNode(7);	
		l2[0].left=l2[1];
		l2[0].right=l2[2];
		l2[1].left=null;
		l2[1].right=l2[3];
		l2[2].left=null;
		l2[2].right=l2[4];
		l2[3].left=null;
		l2[3].right=null;
		l2[4].left=null;
		l2[4].right=null;
		mergeTrees(l1[0],l2[0]);
	}

}
class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
 }
