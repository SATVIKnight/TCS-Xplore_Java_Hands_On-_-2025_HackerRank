import java.util.Scanner;

public class LowerCase {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int count =0;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)>='a' && word.charAt(i)<='z') count++;
        }
        if(count>0) System.out.println(count);
        else System.out.println("No lower case character present");
    }
}
//input
//XpLore
//output
//4