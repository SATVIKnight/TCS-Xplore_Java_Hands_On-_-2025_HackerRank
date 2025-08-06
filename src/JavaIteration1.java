//Java Iteration
import java.util.*;

public class JavaIteration1 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char res = 'z';
        for(int i=0; i<s.length();i++ ){
            if(s.charAt(i)<res) res = s.charAt(i);
        }
        System.out.println(res);

    }
}