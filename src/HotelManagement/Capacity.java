
package HotelManagement;


public class Capacity {

    static int getCapacity(String rn)
    {
        if(rn.equals("Standard-AC"))
            return 2;
        else if(rn.equals("Standard-Non-AC"))
            return 2;
        else if(rn.equals("Cottage"))
            return 3;
        else if(rn.equals("Tent"))
            return 5;
        else if(rn.equals("Deluxe"))
            return 3;
        else if(rn.equals("Super-Deluxe"))
            return 2;
        else if(rn.equals("Economy"))
            return 4;
        else if(rn.equals("Single-AC"))
            return 1;
        else if(rn.equals("Executive"))
            return 2;
        else if(rn.equals("Royal-Executive"))
            return 1;
        return -1;
    }   
    
    public static void main(String args[])
    {
    }
}