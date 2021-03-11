package LeetCodeTest;

public class RomantoInteger {
    public  static int romanToInt(String s) {
        char[] temp=s.toCharArray();
        int ans=0;
        for(int i=0;i<temp.length;i++){
            switch (temp[i]){
                case 'I':
                    if(i+1<temp.length) {
                        if (temp[i + 1] == 'V' || temp[i + 1] == 'X') {
                            ans = ans - 2;
                        }
                    }
                    ans=ans+1;
                    break;

                case 'V':
                    ans=ans+5;
                    break;

                case 'X':
                    if(i+1<temp.length) {
                        if (temp[i + 1] == 'L' || temp[i + 1] == 'C') {
                            ans = ans - 20;
                        }
                    }
                    ans=ans+10;
                    break;

                case 'L':
                    ans=ans+50;
                    break;

                case 'C':
                    if(i+1<temp.length) {
                        if (temp[i + 1] == 'D' || temp[i + 1] == 'M') {
                            ans = ans - 200;
                        }
                    }
                    ans=ans+100;
                    break;

                case 'D':
                    ans=ans+500;
                    break;

                case 'M':
                    ans=ans+1000;
                    break;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
            System.out.println(romanToInt("IV"));
    }
}
