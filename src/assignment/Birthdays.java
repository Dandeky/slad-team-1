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
public class Birthdays extends Name{
        private String bDate;
        
        Birthdays()
        {
            bDate = "";
            name = "";
            Assignment.hop++;
        }
        
        public String GetBirth(){
            Assignment.hop++;
            return bDate;
        }
        
        public void SetBirth(String aBirth){
            bDate = aBirth;
            Assignment.hop++;
        }
        
    }
