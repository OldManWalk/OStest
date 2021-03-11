import java.util.Stack;

public class NumberADD {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
        public boolean isPalindrome(ListNode head) {
            ListNode first = head;
            ListNode second= head;
            boolean ans=true;
            Stack<Integer> stack=new Stack<Integer>();
            while (first!=null){
                stack.push(first.val);
                first=first.next;
            }
            while (second!=null){
                if (second.val!=stack.pop()){
                    ans=false;
                    break;
                }else{
                    second=second.next;
                }
            }
            return  ans;
    }


    public static void main(String[] args) {

          Stack<Integer> a=new Stack<Integer>();
          a.push(1);
        a.push(2);
        a.push(3);
        a.push(4);
        a.push(5);
        a.push(6);
        while (!a.isEmpty()){
            System.out.println(a.pop());
        }

    }
}