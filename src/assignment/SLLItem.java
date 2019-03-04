/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author w6c71
 */
public class SLLItem
    {
        Name listInfo = new Name();
        SLLItem nextItem;
        
        public SLLItem(Name data, String theName, String dataSet, SLLItem restOfList){
            if(data instanceof Birthdays){
                listInfo = new Birthdays();
                ((Birthdays) listInfo).SetBirth(dataSet);
            }
            else if(data instanceof PhoneNo){
                listInfo = new PhoneNo();
                ((PhoneNo) listInfo).SetPhone(Integer.parseInt(dataSet));
            }
            listInfo.SetName(theName);
            nextItem = restOfList;
        }
        
        public SLLItem(Name data,String theName, String theBirth){
            this(data, theName, theBirth, null);
        }
        
        public SLLItem(SLLItem restOfList){
            nextItem = restOfList;
        }
        
        public SLLItem getNextItem(){
            Assignment.hop++;
            return nextItem;
        }
        
        public void setNextItem(SLLItem nextOne){
            nextItem = nextOne;
            Assignment.hop++;
        }
        
        public String getName(){
            Assignment.hop++;
            return listInfo.GetName();
        }
        
        public String getBirth(){
            Assignment.hop++;
            return ((Birthdays)listInfo).GetBirth();
        }
        
        public int getPhone(){
            Assignment.hop++;
            return ((PhoneNo)listInfo).GetPhone();
        }
        
        public void setName(String name){
            listInfo.SetName(name);
            Assignment.hop++;
        }
        
        public void setBirth(String bDate){
            ((Birthdays)listInfo).SetBirth(bDate);
            Assignment.hop++;
        }
        
        public void setPhone(int phoneNum){
            ((PhoneNo)listInfo).SetPhone(phoneNum);
            Assignment.hop++;
        }
    }
