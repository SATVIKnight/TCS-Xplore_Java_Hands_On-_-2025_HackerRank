import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class VehicleBrand {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vehicle [] vehicles = new Vehicle[n];
        for(int i=0; i<n; i++){
            int reg = sc.nextInt();
            int q = sc.nextInt();
            sc.nextLine();
            String t = sc.nextLine();
            String b = sc.nextLine();
            vehicles[i] = new Vehicle(reg, q, t, b);
        }
        String givenType = sc.nextLine();
        String brandPrefix = sc.nextLine();

        int res1 = getAverageQuantityByType(vehicles, givenType);
        if(res1>0)System.out.println(res1);
        else System.out.println("No vehicles found for the given type");

        Vehicle res2 = searchVehicleWithBrandPrefix(vehicles, brandPrefix);
        if(res2!= null)System.out.println(res2.getRegistrationNumber()+"-"+ res2.getQuantity()+"-"+res2.getType()+"-"+res2.getBrand());
        else System.out.println("No vehicle found with the given brand prefix");
    }

    public static int getAverageQuantityByType(Vehicle [] vehicles, String givenType){
        int sum = 0;
        int count =0;
        for(int i=0; i<vehicles.length; i++){
            if(vehicles[i].getType().equalsIgnoreCase(givenType)){
                sum+= vehicles[i].getQuantity();
                count++;
            }
        }
        if(count>0){
            int avg = sum/count;
            return avg;
        }
        return 0;
    }

    public static Vehicle searchVehicleWithBrandPrefix(Vehicle[] vehicles, String brandPrefix){
        for(int i=0; i<vehicles.length; i++){
            if(vehicles[i].getBrand().substring(0,brandPrefix.length()).equalsIgnoreCase(brandPrefix))return vehicles[i];
        }
        return null;
    }
}

class Vehicle{
    private int registrationNumber;
    private int quantity;
    private String type;
    private String brand;

    public void setRegistrationNumber(int num){this.registrationNumber = num;}
    public void setQuantity(int quantity){this.quantity = quantity;}
    public void setType(String type){this.type = type;}
    public void setBrand(String brand){this.brand = brand;}

    public int getRegistrationNumber(){return this.registrationNumber;}
    public int getQuantity(){return this.quantity;}
    public String getType(){return this.type;}
    public String getBrand(){return this.brand;}

    Vehicle(int reg, int q, String t, String b){
        this.registrationNumber = reg;
        this.quantity = q;
        this.type = t;
        this.brand = b;
    }
}