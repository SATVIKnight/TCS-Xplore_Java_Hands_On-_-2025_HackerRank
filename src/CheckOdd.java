import java.util.Scanner;

public class CheckOdd {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int digit = sc.nextInt();
        int count=0;
        while(digit>0){
            if((digit%10)%2 == 1) count++;
            digit/=10;
        }
        if(count>=3)System.out.println("TRUE");
        else System.out.println("FALSE");
    }
}
// input:
//    123456
//    123
//output:
//    TRUE
//    FALSE