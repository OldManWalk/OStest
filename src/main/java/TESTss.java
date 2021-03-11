import java.util.Stack;

public class TESTss {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static Stack<Integer> stack=new Stack<Integer>();
    public  static  void Allin(TreeNode root){
        stack.push(root.val);
        TreeNode left=root.left;
        if(left!=null){
            Allin(left);
        }
        TreeNode right=root.right;
        if(right!=null){
            Allin(right);
        }
    }

            /*public boolean isSymmetric(TreeNode root) {
                Stack<Integer> stack=new Stack<Integer>();


            }*/



    public static void main(String[] args) {
        TreeNode d=new TreeNode(4,null,null);
        TreeNode e=new TreeNode(5,null,null);
        TreeNode f=new TreeNode(6,null,null);
        TreeNode g=new TreeNode(7,null,null);
        TreeNode b=new TreeNode(2,d,e);
        TreeNode c=new TreeNode(3,f,g);
        TreeNode a=new TreeNode(1,b,c);
  

        Allin(a);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
