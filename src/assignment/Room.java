package assignment;

public class Room {
    private int roomNo;
    private int noOfPeople;
    private int price;
    private String type;

    Room(int roomNoInit,int noOfPeopleInit,int priceInit,String typeInit){
        roomNo = roomNoInit;
        noOfPeople = noOfPeopleInit;
        price = priceInit;
        type = typeInit;

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
