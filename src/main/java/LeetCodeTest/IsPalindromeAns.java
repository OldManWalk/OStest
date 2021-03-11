package LeetCodeTest;

public class IsPalindromeAns {
    public static boolean isPalindrome(int x) {
        String temp=""+x;
        boolean ans=true;
        char[] xchar=temp.toCharArray();
        for(int i=xchar.length-1;i>=0;i--){
            if(xchar[xchar.length-1-i]!=xchar[i]) {
               ans=false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(778877));
    }
}
