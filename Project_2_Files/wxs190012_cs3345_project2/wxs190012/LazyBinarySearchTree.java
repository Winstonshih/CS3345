/**
 * Winston Shih
 * CS 3345.002 - Satpute
 * 4/8/2025
 * This class defines the methods of the Lazy Binary Search Tree class.
 * @param <T> Generic type.
 */
public class LazyBinarySearchTree<T> {
	private TreeNode<T> root;
	/**
	 * No-arg default constructor for LazyBinarySearchTree.
	 */
	public LazyBinarySearchTree()
	{
		this.root=null;
	}
	private static class TreeNode<T>{
		int key;
		T element;
		TreeNode<T> leftChild;
		TreeNode<T> rightChild;
		boolean deleted;
		int height;
		/**
		 * This is a constructor that has a defined key, leftChild, and rightChild.
		 * @param key integer data of node
		 * @param leftChild left child of node.
		 * @param rightChild right child of node
		 */
		TreeNode(int key, TreeNode<T> leftChild, TreeNode<T> rightChild)
		{
			this.key=key;
			this.leftChild=leftChild;
			this.rightChild=rightChild;
			this.deleted=false;
			this.height=0;
			this.element=null;
		}
	}
	/**
	 * Checks to see if insert is successfully implemented.
	 * @param key integer value of node
	 * @return true if insert operation is successful.
	 */
	public boolean insert(int key)
	{
		if(key<1||key>99)
		{
			throw new IllegalArgumentException("Error in insert: IllegalArgumentException raised");
		}
		root=insert(key,root);
		if(root!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * insertNode inserts node into AVL Tree.
	 * @param key integer value of inserted node.
	 * @param t node to be inserted.
	 * @return balance(t) new root node after node t is inserted.
	 */
	private TreeNode<T> insert(int key, TreeNode<T> t)
	{
		if(t==null)
		{
			return new TreeNode<>(key, null, null);
		}
		if(t.deleted&&t.key==key)
		{
			t.key=key;
			t.deleted=false;
			return t;
		}
		if(key<t.key)
		{
			t.leftChild=insert(key,t.leftChild);
		}
		else if (key>t.key)
		{
			t.rightChild=insert(key,t.rightChild);
		}
		else if(key==t.key)
		{
		    return null;
		}
		else
		{
			return null;
		}
		return t;
	}
	/**
	 * This remove method will return true if it can find the node it is told to remove.
	 * @param key value of node to be removed.
	 * @return true if specific node was successfully removed or false if not.
	 */
	public boolean delete(int key)
	{
		if(key<1||key>99)
		{
			throw new IllegalArgumentException("Error in delete: IllegalArgumentException raised");
		}
		if(remove(key,root))
		{
			return true;
		}
		return false;
	}
	/**
	 * remove will traverse AVL Tree to look for node to be removed.
	 * @param key value of node that will be removed
	 * @param t node that will be removed
	 * @return true if node is found and is not deleted.
	 */
	private boolean remove(int key, TreeNode<T> t)
    {
        if(t == null)
        {   
            return false; 
        }
    
        if(key < t.key)
        {
            return remove(key, t.leftChild);
        }
        else if(key > t.key)
        {
            return remove(key, t.rightChild);
        }
        else if(!t.deleted)
        {
            t.deleted = true;
            return t.deleted; 
        }
        else
        {
            return false;
        }
    }
    /**
	 * findMin finds smallest node in AVL Tree.
	 * @param t node that roots left subtree.
	 * @return node with largest value.
	 */
	private int findMin(TreeNode<T> t)
	{
		if(t==null)
		{
			return -1;
		}
		else if(t.leftChild==null)
		{
			return t.key;
		}
		return findMin(t.leftChild);
	}
	/**
	 * Returns smallest node in AVL tree.
	 * @return findMin(root) smallest node in tree with root as root.
	 */
	public int findMin()
	{
		return findMin(root);
	}
	/**
	 * findMax returns biggest node in AVL Tree.
	 * @return findMax(root) biggest node of AVL Tree.
	 */
	public int findMax()
	{
		return findMax(root);
	}
	/**
	 * findMax goes from root node to right to look for biggest node in AVL Tree.
	 * @param t node that roots right subtree
	 * @return t.key biggest node
	 */
	private int findMax(TreeNode<T> t)
	{
	    TreeNode<T> root=t;
	    if(root==null)
	    {
	        return -1;
	    }
	    if(root!=null)
		{
			while(root.rightChild!=null)
			{
				root=root.rightChild;
			}
		}
		return root.key;
	}
	/**
	 * Public contains method looks for a specific node in AVL tree.
	 * @param key value of node to be found
	 * @return true if node can be found or false if node is not found.
	 */
	public boolean contains(int key)
	{
		if(contains(key, root))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Private contains method looks for a specific node in AVL tree.
	 * @param key value of node to be found
	 * @param t node that method will look for
	 * @return true if node can be found or false if node is not found.
	 */
	private boolean contains(int key, TreeNode<T> t)
	{
		if(key<1||key>99)
		{
			throw new IllegalArgumentException("Error in contains: IllegalArgumentException raised");
		}
		if(t==null||t.deleted) {
			return false;
		}
		if(key<t.key)
		{
			return contains(key, t.leftChild);
		}
		else if(key>t.key)
		{
			return contains(key, t.rightChild);
		}
		else{
			return true;
		}
	}
	/**
	 * Prints out AVL Tree in preorder traversal from root node to left subtree and then right subtree.
	 * @return list of nodes printed.
	 */
	public String toString()
	{
	    if(root==null)
	    {
	        return "Empty Tree";
	    }
		return printTree(root);
	}
	/**
	 * printTree prints tree in preorder traversal.
	 * @param t node
	 * @return list of the TreeNodes in preorder traversal.
	 */
	private String printTree(TreeNode<T> t)
	{
	    String current="";
	    String leftChild="";
	    String rightChild="";
	    String treeList="";
	    if(t==null)
	    {
	        return "";
	    }
	    if(t.deleted)
	    {
	        current+="*";
	    }
	    current+=t.key;
	    leftChild=printTree(t.leftChild);
	    rightChild=printTree(t.rightChild);
	    treeList=current;
	    if(!leftChild.isEmpty())
	    {
	        treeList+=" ";
	        treeList+=leftChild;
	    }
	    if(!rightChild.isEmpty())
	    {
	        treeList+=" ";
	        treeList+=rightChild;
	    }
	    return treeList;
	}
	/**
	 * isEmpty checks to see if AVL tree is empty by checking to see if root
	 * is null.
	 */
	 private boolean isEmpty()
	 {
	     if(root==null)
	     {
	         return true;
	     }
	     else
	     {
	         return false;
	     }
	 }
	/**
	 * Height method returns the height of the tree.
	 * @param t node 
	 * @return max height of the AVL Tree.
	 */
	private int height(TreeNode<T> t)
	{
		if(t==null)
		{
			return -1;
		}
		else
		{
			return 1 + Math.max(height(t.leftChild),height(t.rightChild));
		}
	}
	/**
	 * Returns height of AVL tree with root as root node.
	 * @return height(root) height of tree with root as root node.
	 */
	public int height()
	{
		return height(root);
	}
	/**
	 * Private size method returns how many nodes are in AVL tree.
	 * @return treeSize size of AVL tree (including deleted nodes).
	 */
	private int size(TreeNode<T> t)
	{
		int treeSize=0;
		if(t==null)
		{
			treeSize=0;
		}
		else
		{
			treeSize=1+size(t.leftChild)+size(t.rightChild);
		}
		return treeSize;
	}
	/**
	 * Returns size of AVL tree by invoking private size method.
	 * @return size(root) size of AVL tree.
	 */
	public int size()
	{
		return size(root);
	}
}