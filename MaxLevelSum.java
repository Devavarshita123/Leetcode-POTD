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
class MaxLevelSum
{
    public int maxLevelSum(TreeNode root) 
    {
        int count = 0;
        int result = 0;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            count++;
            int sum = 0;
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode top = q.poll();
                sum+=top.val;
                if(top.left!=null)
                    q.add(top.left);
                if(top.right!=null)
                    q.add(top.right);
            }
            if(maxSum<sum)
            {
                maxSum = sum;
                result = count;
            }

        }
        return result;
    }
}
