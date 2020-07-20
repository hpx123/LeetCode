import java.util.Scanner;

public class Q0005 {
    public static String longestPalindrome(String s) {
        int len = -1;
        String longest = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String temp = s.substring(i,j+1);
                if(temp.length() > len){
                    int count = longestLen(temp);
                    if(count > len){
                        longest = temp;
                        len = count;
                    }
                }
            }
        }
        return longest;
    }

    public static int longestLen(String s) {
        StringBuffer temp = new StringBuffer(s);
        String m = temp.reverse().toString();
        if(m.equals(s)){
            return m.length();
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        System.out.printf(longestPalindrome(s));
    }
}
