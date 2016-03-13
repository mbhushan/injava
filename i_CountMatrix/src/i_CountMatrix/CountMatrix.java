package i_CountMatrix;

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public class CountMatrix {

	    public static int cntMatrix(TreeNode A, TreeNode B) {
	    	if(A==null && B==null) return 0;
	        if(A==null) {
	            int L=cntMatrix(A,B.left); if(L==-1) return -1;
	            int R=cntMatrix(A,B.right);if(R==-1) return -1;
	            return L+R+1;
	        }
	        if(B==null) return -1;
	        int L=cntMatrix(A.left,B.left);   if(L==-1) return -1;
	        int R=cntMatrix(A.right,B.right); if(R==-1) return -1;
	        return L+R;
	    }
}

