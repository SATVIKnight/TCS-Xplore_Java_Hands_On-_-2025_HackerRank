import java.util.Scanner;

public class ResortPrice {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Resort [] resorts = new Resort[4];
        for(int i=0; i<resorts.length; i++){
            int resortId = sc.nextInt();
            sc.nextLine();
            String resortName = sc.nextLine();
            String category = sc.nextLine();
            double price = sc.nextDouble();
            double rating = sc.nextDouble();
            sc.nextLine();
            resorts[i]= new Resort(resortId, resortName, category, price, rating);
        }
        String givenCategory = sc.nextLine();
        int res = findAvgPriceByCategory(resorts, givenCategory);
        if(res>0)System.out.println("Average price of the "+givenCategory+" Resort:" +res);
        else System.out.println("There are no such available resort");
    }

    public static int findAvgPriceByCategory(Resort [] resorts, String givenCategory){
        int sum =0;
        int count =0;
        for(int i=0; i<resorts.length; i++){
            if(resorts[i].getCategory().equalsIgnoreCase(givenCategory) && resorts[i].getRating() > 4){
                sum += resorts[i].getPrice();
                count++;
            }
        }
        if (count>0){
            int avgPrice = sum/count;
            return avgPrice;
        }
        else return 0;
    }
}

class Resort{
    private int resortId;
    private String resortName;
    private String category;
    private double price;
    private double rating;

    public int getResortId(){return this.resortId;}
    public String getResortName(){return this.resortName;}
    public String getCategory(){return this.category;}
    public double getPrice(){return this.price;}
    public double getRating(){return this.rating;}

    public void setResortId(int id){this.resortId = id;}
    public void setResortName(String name){this.resortName = name;}
    public void setCategory(String category){this.category = category;}
    public void setPrice(int price){this.price = price;}
    public void setRating(int rating){this.rating = rating;}

    Resort(int resortId, String resortName, String category, double price, double rating){
        this.resortId = resortId;
        this.resortName = resortName;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }
}
//testcase:
//1005
//Samudra
//3 star
//3500.00
//3.5
//1001
//O by Tamara
//5 Star
//7500.00
//4
//1007
//Edens resort
//3 Star
//2500.00
//4.7
//1003
//Tea Valley
//3 Star
//4600.00
//4.3
//3 Star
//output:
//Average price of the 3 Star Resort: 3550