package LeetCodeTest;

import org.w3c.dom.ls.LSInput;

import java.util.Stack;

public class RemoveNthNodeFromEndofList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack=new Stack<ListNode>();
        int count=1;
        while (head!=null){
            stack.push(head);
            head=head.next;
        }
        while (!stack.isEmpty()){
            if(count==n-1) {
                stack.pop();
            }else if(count==n+1){
                stack.pop();
            }
            else{
                stack.pop();
            }

            count++;
        }

    }

    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2,a);
        ListNode c=new ListNode(3,b);
        ListNode d=new ListNode(4,c);
        ListNode e=new ListNode(5,d);
        ListNode f=new ListNode(6,e);
        ListNode k=removeNthFromEnd(f,3);
        while (k!=null){
            System.out.println(k.val);
            k=k.next;
        }
    }
}
