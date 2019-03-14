package assignment;

public class Room {

    private int roomId;
    private String type;
    
//Single, double , family, business
    
    
    Room(int roomId, String type){
        this.roomId = roomId;
        this.type = type;
    }

    public int getRoomId() {
        return roomId;
    }

  
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
