import java.util.Scanner;

public class VowelCount {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String []s1 = s.split(" ");
        int count =0;
        for(int i=0; i<s1.length; i++){
            char f = s1[i].charAt(0);
            if(f == 'a' || f == 'e' ||f == 'i' ||f == 'o' ||f == 'u' ||f == 'A' ||f == 'E' ||f == 'I' ||f == 'O' ||f == 'U'){
                count++;
            }
        }
        if(count>0) System.out.println(count);
        else System.out.println("No String found");
    }
}
//test inputs
//        Everyone should practice and learn to become professional
//        hi guys
//output
//        2
//        No String found