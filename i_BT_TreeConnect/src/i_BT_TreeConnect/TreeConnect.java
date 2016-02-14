package i_BT_TreeConnect;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class TreeConnect {
	
	public TreeLinkNode getNextRight(TreeLinkNode p) {
		TreeLinkNode temp = p.next;
 
        /* Traverse nodes at p's level and find and return
         the first node's first child */
        while (temp != null) {
            if (temp.left != null) {
                return temp.left;
            }
            if (temp.right != null) {
                return temp.right;
            }
            temp = temp.next;
        }
 
        // If all the nodes at p's level are leaf nodes then return NULL
        return null;
    }
 
    /* Sets nextRight of all nodes of a tree with root as p */
    public void connect(TreeLinkNode p) {
    	TreeLinkNode temp = null;
 
        if (p == null) {
            return;
        }
 
        // Set nextRight for root
        p.next = null;
 
        // set nextRight of all levels one by one
        while (p != null) {
        	TreeLinkNode q = p;
 
            /* Connect all childrem nodes of p and children nodes of all other nodes
             at same level as p */
            while (q != null) {
                
                // Set the nextRight pointer for p's left child
                if (q.left != null) {
                 
                    // If q has right child, then right child is nextRight of
                    // p and we also need to set nextRight of right child
                    if (q.right != null) {
                        q.left.next = q.right;
                    } else {
                        q.left.next = getNextRight(q);
                    }
                }
 
                if (q.right != null) {
                    q.right.next = getNextRight(q);
                }
 
                // Set nextRight for other nodes in pre order fashion
                q = q.next;
            }
 
            // start from the first node of next level
            if (p.left != null) {
                p = p.left;
            } else if (p.right != null) {
                p = p.right;
            } else {
                p = getNextRight(p);
            }
        }
    }
	
	public void connectRecur(TreeLinkNode p) {
		 
        // Base case
        if (p == null) {
            return;
        }
 
        /* Before setting nextRight of left and right children, set nextRight
         of children of other nodes at same level (because we can access 
         children of other nodes using p's nextRight only) */
        if (p.next != null) {
            connectRecur(p.next);
        }
 
        /* Set the nextRight pointer for p's left child */
        if (p.left != null) {
            if (p.right != null) {
                p.left.next = p.right;
                p.right.next = getNextRight(p);
            } else {
                p.left.next = getNextRight(p);
            }
 
            /* Recursively call for next level nodes.  Note that we call only
             for left child. The call for left child will call for right child */
            connectRecur(p.left);
        }
         
        /* If left child is NULL then first node of next level will either be
         p->right or getNextRight(p) */
        else if (p.right != null) {
            p.right.next = getNextRight(p);
            connectRecur(p.right);
        } else {
            connectRecur(getNextRight(p));
        }
    }
 
    /* This function returns the leftmost child of nodes at the same level as p.
     This function is used to getNExt right of p's right child
     If right child of p is NULL then this can also be used for the left child */
    public TreeLinkNode getNextRight1(TreeLinkNode p) {
    	TreeLinkNode temp = p.next;
 
        /* Traverse nodes at p's level and find and return
         the first node's first child */
        while (temp != null) {
            if (temp.left != null) {
                return temp.left;
            }
            if (temp.right != null) {
                return temp.right;
            }
            temp = temp.next;
        }
 
        // If all the nodes at p's level are leaf nodes then return NULL
        return null;
    }

	public void connect1(TreeLinkNode root) {

		root.next = null;

		// Set the next right for rest of the nodes (other than root)
		connectRecur(root);

	}

	void connectRecur1(TreeLinkNode p) {

		// Base case
		if (p == null) {
			return;
		}

		// Set the nextRight pointer for p's left child
		if (p.left != null) {
			p.left.next = p.right;
		}

		// Set the nextRight pointer for p's right child
		// p->nextRight will be NULL if p is the right most child at its level
		if (p.right != null) {
			p.right.next = (p.next != null) ? p.next.left : null;
		}

		// Set nextRight for other nodes in pre order fashion
		connectRecur(p.left);
		connectRecur(p.right);
	}

}
