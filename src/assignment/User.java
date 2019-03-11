
package assignment;

public class User {
    
    private int id;
    private String firstName;
    private String lastName;
    private int tel;
    private String username;
    private String password;
    
    User(int i,String f,String l,int t,String u,String p){
        id = i;
        firstName = f;
        lastName = l;
        tel = t;
        username = u;
        password = p;
    }
    
    //Getters
    
    private int getId(){
        return id;
    }
    private String getFirstName(){
        return firstName;
    }
    private String getLastName(){
        return lastName;
    }
    private int getTel(){
        return tel;
    }
    
    //Setters
    
    private void setFirstName(String s){
        firstName = s;
    }
    private void setLastName(String s){
        lastName = s;
    }
    private void setTel(int s){
        tel = s;
    }
    
}
