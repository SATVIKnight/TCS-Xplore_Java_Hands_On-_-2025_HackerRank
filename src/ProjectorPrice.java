import java.util.Scanner;
public class ProjectorPrice {
    public static Projector findMaximumPriceByRating(Projector [] projectors, int givenRating){
        int maxPrice = 0;
        Projector res = null;
        for(int i=0; i<projectors.length; i++){
            if(maxPrice<projectors[i].getPrice() && projectors[i].getAvailableIn().equalsIgnoreCase("TataCliq") && projectors[i].getRating()>givenRating){
                maxPrice = projectors[i].getPrice();
                res = projectors[i];
            }
        }
        return res;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Projector[] projectors = new Projector[4];
        for(int i=0; i<projectors.length; i++){
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            int price = sc.nextInt();
            int rating = sc.nextInt();
            sc.nextLine();
            String availableIn = sc.nextLine();
            projectors[i] = new Projector(id, name, price, rating, availableIn);
        }
        int givenRating = sc.nextInt();
        Projector res = findMaximumPriceByRating(projectors, givenRating);
        if(res == null) System.out.println("No such Projector");
        else System.out.println(res.getProjectorId());
    }
}

class Projector{
    private int projectorId;
    private String projectorName;
    private int price;
    private int rating;
    private String availableIn;

    public void setProjectorId(int id){this.projectorId = id;}
    public void setProjectorName(String name){this.projectorName = name;}
    public void setPrice(int price){this.price = price;}
    public void setRating(int rating){this.rating = rating;}
    public void setAvailableIn(String availableIn){this.availableIn = availableIn;}

    public int getProjectorId(){return this.projectorId;}
    public String getProjectorName(){return this.projectorName;}
    public int getPrice(){return this.price;}
    public int getRating(){return this.rating;}
    public String getAvailableIn(){return this.availableIn;}

    Projector(int projectorId, String projectorName, int price, int rating, String availableIn){
        this.projectorId = projectorId;
        this.projectorName = projectorName;
        this.price = price;
        this.rating = rating;
        this.availableIn = availableIn;
    }
}
//input
//1001
//Epson
//30000
//5
//TataCliq
//1002
//Benq
//40000
//4
//Amazon
//1003
//Sony
//80000
//5
//TataCliq
//1004
//Optomo
//7000
//3
//Flipkart
//3
//output
//1003