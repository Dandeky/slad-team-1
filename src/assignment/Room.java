package assignment;

public class Room {

    private int roomId;
    private int noOfPeople;
    private int price;
    private String type;

    Room(int roomId,int noOfPeople,int price, String type){
        this.roomId = roomId;
        this.noOfPeople = noOfPeople;
        this.price = price;
        this.type = type;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }
}
