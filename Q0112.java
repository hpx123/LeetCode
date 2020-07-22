
public class Q0112 {
    public static int i = 0;
    public static final int[] num = new int[]{5, 4, 11, 7, 0, 0, 2, 0, 0, 0, 8, 13, 0, 0, 4, 0, 1, 0, 0};
    public static void main(String[] args) {

        TreeNode root = new TreeNode();
        root = createTree(root, i);
        System.out.println(hasPathSum(root, 18));

    }

    public static void preorder(TreeNode root){
        if(root!=null){
            System.out.println(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }

    /**
     * 递归
     * @param node
     * @param i
     * @return
     */
    private static TreeNode createTree(TreeNode node, int i) {
        if(Q0112.num[i] == 0){
            return null;
        }else {
            node.setVal(Q0112.num[i]);
        }
        TreeNode leftNode = new TreeNode();
        node.left = createTree(leftNode, ++Q0112.i);
        TreeNode rightNode = new TreeNode();
        node.right = createTree(rightNode,++Q0112.i);
        return node;
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        System.out.println(sum);
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return sum == root.val;
        }

        return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    }
}
