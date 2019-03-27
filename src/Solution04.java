/*题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
则重建二叉树并返回。

解题思路：
在二叉树的前序遍历序列中，第一个数字总是树的根结点的值。但在中序遍历序列中，根结点的值在序列的中间，
左子树的结点的值位于根结点的值的左边，而右子树的结点的值位于根结点的值的右边。
因此我们需要扫描中序遍历序列，才能找到根结点的值。
前序遍历序列的第一个数字1就是根结点的值。扫描中序遍历序列，就能确定根结点的值的位置。
根据中序遍历特点，在根结点的值1前面的3个数字都是左子树结点的值，
位于1后面的数字都是右子树结点的值。

同样，在前序遍历的序列中，根结点后面的3个数字就是3个左子树结点的值，
再后面的所有数字都是右子树结点的值。这样我们就在前序遍历和中序遍历两个序列中，
分别找到了左右子树对应的子序列。
既然我们已经分别找到了左、右子树的前序遍历序列和中序遍历序列，
我们可以用递归的方法分别去构建左右子树。
* */

import java.util.ArrayList;
import java.util.Collections;

public class Solution04 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i+startPre-startIn+1,endPre,in,i+1,endIn);
                break;
            }

        return root;
    }


}
