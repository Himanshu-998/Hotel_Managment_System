
package HotelManagement;
public class RoomRate {
    
        

    static int getCost(String rn)
    {
        if(rn.equals("Standard-AC"))
            return 1000;
        else if(rn.equals("Standard-Non-AC"))
            return 750;
        else if(rn.equals("Cottage"))
            return 650;
        else if(rn.equals("Tent"))
            return 550;
        else if(rn.equals("Deluxe"))
            return 1500;
        else if(rn.equals("Super-Deluxe"))
            return 2000;
        else if(rn.equals("Economy"))
            return 850;
        else if(rn.equals("Single-AC"))
            return 1000;
        else if(rn.equals("Executive"))
            return 2500;
        else if(rn.equals("Royal-Executive"))
            return 5000;
        return -1;
    }
    public static void main(String args[])
    {
    }
}