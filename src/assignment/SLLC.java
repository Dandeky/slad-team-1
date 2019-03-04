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
public class SLLC
    {
        public SLLItem head;
        
        public SLLC(){
            head = null;
        }
        
        public void addToHead(Name data, String aName, String dataSet){
            head = new SLLItem(data, aName, dataSet, head);
        }
        
        public void addToTail(SLLItem entryNew){
            SLLItem prevItem = null, currItem = head;
            while (currItem != null){
                prevItem = currItem;
                currItem = currItem.getNextItem();
            }
            if(entryNew.listInfo instanceof Birthdays)
            {
                if (prevItem == null) addToHead(entryNew.listInfo, entryNew.getName(), entryNew.getBirth());
                else {
                    prevItem.setNextItem(entryNew);
                }
            }
            else if(entryNew.listInfo instanceof PhoneNo)
            {
                if (prevItem == null) addToHead(entryNew.listInfo, entryNew.getName(), Integer.toString(entryNew.getPhone()));
                else {
                    prevItem.setNextItem(entryNew);
                }
            }
            Assignment.hop++;
        }
        
        public SLLItem removeFromHead() {
            SLLItem tempItem = head;
            head = head.getNextItem();
            Assignment.hop++;
            return tempItem;
        } 
        
        public SLLItem removeFromTail(){
            SLLItem prevItem = null, currItem = head;
            while (currItem.getNextItem() != null){
                prevItem = currItem;
                currItem = currItem.getNextItem();
            }
            if (prevItem == null) removeFromHead();
            else {
                prevItem.setNextItem(null);
            }
            Assignment.hop++;
            return currItem;
        }
        
        public void displayList(){
            SLLItem currItem = head;
            while (currItem != null) {
                System.out.println("item = " + currItem.toString());
                currItem = currItem.getNextItem();
            }
            Assignment.hop++;
        }
        
        public boolean isEmpty() {
            Assignment.hop++;
            return head == null;
        }
        
        public int size() {
            int count = 0;
            SLLItem currItem = head;
            while(currItem != null){
                count++;
                currItem = currItem.getNextItem();
            }
            Assignment.hop++;
            return count;
        }
        
    }
