package assignment;

public class Hotel {

    private String hotelName;
    private int totalRooms;
    
    Object[] rooms;

   Hotel(String hotelName, String[] roomTypes){
        this.hotelName = hotelName;
        this.totalRooms = roomTypes.length;
        
        
        rooms = new Object[ totalRooms ];
        
            for(int t=0;t<totalRooms;t++){
                
                rooms[t] =  new Room(t , roomTypes[t]);
            }
        }
        
    
    
    
    public String getHotelName() {
        return hotelName;
    }
    
    public int getTotalRooms(){
        return totalRooms;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
