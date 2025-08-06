import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GadgetPrice {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Gadget[] gadgets = new Gadget[n];
        for(int i=0; i<n; i++){
            int mn = sc.nextInt();
            int s = sc.nextInt();
            sc.nextLine();
            String t = sc.nextLine();
            String b = sc.nextLine();
            gadgets[i] = new Gadget(mn, s, t, b);
        }
        String givenType = sc.nextLine();
        String givenBrand = sc.nextLine();
        int givenModelNumber = sc.nextInt();

        int res1 = countTotalStockForType(gadgets, givenType);
        if(res1>0)System.out.println(res1);
        else System.out.println("No Gadget found with mentioned attribute.");

        Gadget res2 = findGadgetByBrandAndModel(gadgets, givenBrand, givenModelNumber);
        if(res2!= null)System.out.println(res2.getStock()+ "-" + res2.getType());
        else System.out.println("No Gadget found with mentioned attribute.");
    }

    public static int countTotalStockForType(Gadget[] gadgets, String givenType){
        int sum=0;
        for(int i=0; i<gadgets.length; i++){
            if(gadgets[i].getType().equalsIgnoreCase(givenType)) sum+= gadgets[i].getStock();
        }
        return sum;
    }

    public static Gadget findGadgetByBrandAndModel(Gadget[] gadgets, String givenBrand, int givenModelNumber){
        for(int i=0; i<gadgets.length; i++){
            if(gadgets[i].getBrand().equalsIgnoreCase(givenBrand) && gadgets[i].getModelNumber()== givenModelNumber) return gadgets[i];
        }
        return null;
    }
}

class Gadget{
    private int modelNumber;
    private int stock;
    private String type;
    private String brand;

    public void setModelNumber(int num){this.modelNumber = num;}
    public void setStock(int stock){this.stock = stock;}
    public void setType(String type){this.type = type;}
    public void setBrand(String brand){this.brand = brand;}

    public int getModelNumber(){return this.modelNumber;}
    public int getStock(){return this.stock;}
    public String getType(){return this.type;}
    public String getBrand(){return this.brand;}

    Gadget(int mn, int s, String t, String b){
        this.modelNumber =mn;
        this.stock = s;
        this.type = t;
        this.brand = b;
    }
}

