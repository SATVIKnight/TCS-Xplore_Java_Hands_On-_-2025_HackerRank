import java.util.Scanner;
import java.util.Arrays;
public class HeadsetPrice {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        HeadSets [] headsets = new HeadSets[4];
        for(int i=0; i<headsets.length; i++){
            String name = sc.nextLine();
            String brand = sc.nextLine();
            int price = sc.nextInt();
            boolean avail = sc.nextBoolean();
            sc.nextLine();
            headsets[i]= new HeadSets(name, brand, price, avail);
        }
        String givenBrand = sc.nextLine();
        int tot = findTotalPriceForGivenBrand(headsets, givenBrand);
        if(tot>0) System.out.println(tot);
        else System.out.println("No Headsets available with the given brand");

        HeadSets res = findAvailableHeadsetWithSecondMinPrice(headsets);
        if(res!=null){
            System.out.println(res.getHeadsetName());
            System.out.println(res.getPrice());
        }
        else System.out.println("No Headsets available");
    }
    public static int findTotalPriceForGivenBrand(HeadSets [] headsets, String givenBrand){
        int total =0;
        for(int i=0; i<headsets.length; i++){
            if(headsets[i].getBrand().equalsIgnoreCase(givenBrand)) total+= headsets[i].getPrice();
        }
        return total;
    }

    public static HeadSets findAvailableHeadsetWithSecondMinPrice(HeadSets[] headsets){
        int [] arr =  new int [headsets.length];
        for(int i=0; i<arr.length; i++) arr[i] = headsets[i].getPrice();
        Arrays.sort(arr);
        int k=1;
        while(k<arr.length){
            for(int i=0; i<headsets.length && k<arr.length; i++){
                if(headsets[i].getPrice() == arr[k]){
                    if(headsets[i].getAvailable()) return headsets[i];
                    else{
                        k++;
                        i=0;
                    }
                }
            }
        }
        return null;
    }
}

class HeadSets{
    private String headsetName;
    private String brand;
    private int price;
    private boolean available;

    public void setHeadsetName(String headsetName){this.headsetName = headsetName;}
    public void setBrand(String brand){this.brand = brand;}
    public void setPrice(int price){this.price = price;}
    public void setAvailable(boolean available){this.available = available;}

    public String getHeadsetName(){return this.headsetName;}
    public String getBrand(){return this.brand;}
    public int getPrice(){return this.price;}
    public boolean getAvailable(){return this.available;}

    HeadSets(String headsetName, String brand, int price, boolean available){
        this.headsetName = headsetName;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }
}

//input
//boAt BassHeads
//boAt
//1220
//true
//Over Ear Wired
//boAt
//549
//true
//In Ear with Mic
//JBL
//450
//true
//Buds 2 Neo
//RealMe
//500
//true
//boAt
//output
//        1769
//        Buds 2 Neo
//        500