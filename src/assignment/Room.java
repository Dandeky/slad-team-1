package assignment;

public class Room {
    int roomNo;
    int noOfPeople;
    int price;
    String type;
    
    Room(int x,int y,int z,String t){
        roomNo = x;
        noOfPeople = y;
        price = z;
        type = t;
    }
    
    private int getRoomNo(){
        return roomNo;
    }
    private int getNoOfPeople(){
        return noOfPeople;
    }
    private int getPrice(){
        return price;
    }
    private String getType(){
        return type;
    }
    private void setRoomNo(int x){
        roomNo = x;
    }
    private void setNoOfPeople(int x){
        noOfPeople = x;
    }
    private void setPrice(int x){
        price = x;
    }
    private void setType(String x){
        type = x;
    }
    
    
}
