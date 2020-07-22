public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {
            left = null;
            right = null;
      }
      TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
      }

      public void setVal(int val) {
            this.val = val;
      }
}
