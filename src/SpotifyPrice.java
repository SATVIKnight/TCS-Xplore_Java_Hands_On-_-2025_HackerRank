import java.util.Scanner;
public class SpotifyPrice{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Spotify [] spotify = new Spotify[4];
        for(int i=0; i<4; i++){
            int spotifyId = sc.nextInt();
            sc.nextLine();
            String profileName = sc.nextLine();
            String subscriptionType = sc.nextLine();
            double subscriptionPrice = sc.nextDouble();
            sc.nextLine();
            String groupSessionAvailable = sc.nextLine();
            spotify[i]= new Spotify(spotifyId, profileName, subscriptionType, subscriptionPrice, groupSessionAvailable);
        }
        String subType = sc.nextLine();
        String gpSesAvail = sc.nextLine();
        double res = findAvgSpotifySubsByType(spotify, subType, gpSesAvail);
        if(res>0){System.out.println(res);}
        else{System.out.println("There are no such Spotify Subscription");}
    }
    public static double findAvgSpotifySubsByType(Spotify[] spotify, String subType, String gpSesAvail){
        double sum = 0.0;
        double count =0;
        for(int i=0; i<spotify.length; i++){
            if(spotify[i].getSubscriptionType().equalsIgnoreCase(subType) && spotify[i].getGroupSessionAvailable().equalsIgnoreCase(gpSesAvail)){
                sum += spotify[i].getSubscriptionPrice();
                count++;
            }
        }
        if(count==0){return 0.0;}
        else{
            double ans = sum/count;
            return ans;
        }
    }
}

class Spotify{
    private int spotifyId;
    private String profileName;
    private String subscriptionType;
    private double subscriptionPrice;
    private String groupSessionAvailable;

    public void setSpotifyId(int id){this.spotifyId = id;}
    public void setProfileName(String name){this.profileName = name;}
    public void setSubscriptionType(String type){this.subscriptionType = type;}
    public void setSubscriptionPrice(double price){this.subscriptionPrice = price;}
    public void setGroupSessionAvailable(String avail){this.groupSessionAvailable = avail;}

    public int getSpotifyId(){return this.spotifyId;}
    public String getProfileName(){return this.profileName;}
    public String getSubscriptionType(){return this.subscriptionType;}
    public double getSubscriptionPrice(){return this.subscriptionPrice;}
    public String getGroupSessionAvailable(){return this.groupSessionAvailable;}

    Spotify(int spotifyId, String profileName, String subscriptionType, double subscriptionPrice, String groupSessionAvailable){
        this.spotifyId = spotifyId;
        this.profileName = profileName;
        this.subscriptionType = subscriptionType;
        this.subscriptionPrice = subscriptionPrice;
        this.groupSessionAvailable = groupSessionAvailable;
    }
}
