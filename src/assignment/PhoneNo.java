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
public class PhoneNo extends Name{
        private int phoneNum;
        
        PhoneNo()
        {
            phoneNum = 0;
            name = "";
            Assignment.hop++;
        }
        
        public int GetPhone(){
            Assignment.hop++;
            return phoneNum;
        }
        
        public void SetPhone(int aPhone){
            phoneNum = aPhone;
            Assignment.hop++;
        }
    }
