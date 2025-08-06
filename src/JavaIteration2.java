//Java Iteration 2
import java.math.BigInteger;
import java.util.Scanner;

public class JavaIteration2 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<5; i++){
            int n = sc.nextInt();
            BigInteger res = factorial(n);
            System.out.println(res);
        }
    }
    static BigInteger factorial(int N)
    {
        // Initialize result
        BigInteger f
                = new BigInteger("1"); // Or BigInteger.ONE

        // Multiply f with 2, 3, ...N
        for (int i = 2; i <= N; i++)
            f = f.multiply(BigInteger.valueOf(i));

        return f;
    }
}