import java.util.Stack;

public class LeetCodeTest {
    public static int reverse(int x) {
        Stack<String> capacity=new Stack<String>();
        String temp=""+x;
        String ans="";
        int fin =0;
        char[] StringTemp = temp.toCharArray();
        if(StringTemp[0]!='-'){
            for (int i = 0; i < StringTemp.length; i++) {
                capacity.push(String.valueOf(StringTemp[i]));
            }
                while (!capacity.isEmpty()){
                 ans=ans+capacity.pop();
                }
                try {
                    fin = Integer.parseInt(ans);
                }catch (Exception e){
                    return 0;
                }

        }else{
            for (int i = 1; i < StringTemp.length; i++) {
                capacity.push(String.valueOf(StringTemp[i]));
            }
                while (!capacity.isEmpty()){
                    ans=ans+capacity.pop();
                }
            try {
                fin = 0-Integer.parseInt(ans);
            }catch (Exception e){
                return 0;
            }

        }
        return fin;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-656777));
    }
}
