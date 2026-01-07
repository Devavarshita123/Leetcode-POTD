/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class MaxProductOfSplittedBinaryTree 
{
    final int MOD = 1_000_000_007;
    //To calculate the maximum Product take long so that don't overflow
    long maxProduct = 0;
  //To find the total sum of all the nodes in binary tree.
    int total = 0;
  //Function to get the sum of nodes in binary tree.
    public int getSum(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return getSum(root.left) + root.val + getSum(root.right);
    }
  //functio to get product
  //product at every stage will be sum* the remaining
  // compare the product with the prviously computed value.
    public long minDiff(TreeNode temp)
    {
        if(temp==null)
        {
            return 0;
        }
        long sum = minDiff(temp.left)+temp.val+minDiff(temp.right);
        maxProduct = Math.max(maxProduct,sum*(total-sum));
        return sum;
    }
    public int maxProduct(TreeNode root) 
    {
        TreeNode temp = root;
        total = getSum(temp);
        temp = root;
        minDiff(temp);
        return (int)(maxProduct%MOD);
    }
}
