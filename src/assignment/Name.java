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
public class Name{
        public String name;
        
        public String GetName(){
            Assignment.hop++;
            return name;
        }
        
        public void SetName(String aName){
            name = aName;
            Assignment.hop++;
        }
        
    }
