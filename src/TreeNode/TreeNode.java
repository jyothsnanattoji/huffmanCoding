package TreeNode;


public class TreeNode implements Comparable<TreeNode>{
    public char ch;
    public int count;
    public TreeNode left;
    public TreeNode right;

    //creating a constructor of treeNode class
    public TreeNode (char ch, int count)
    {
        this.ch=ch;
        this.count=count;
        this.left=null;
        this.right=null;
    }

    //creating one more constructor which also has left and right node as its parameters
    public TreeNode( int count , TreeNode left, TreeNode right)
    {
        this.count=count;
        this.left=left;
        this.right=right;
    }

    @Override
    public int compareTo(TreeNode n) {
        return Integer.compare(this.count, n.count);
    }
}
