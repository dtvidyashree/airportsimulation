/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportsimulation;

import java.util.ArrayList;

// Queue for storing the plane which request for landing and takeoff
public class Queue {
  public ArrayList al;
  public Queue() {
    this.al = new ArrayList();
  }
  
  // method to add in queue
  public boolean push(Object o) {
    al.add(0, o);
    return true;
  }
  //method to delete in queue
  public Object pop() {
    if (al.size() > 0) {
      return al.remove(al.size() - 1); 
    }
    return null;
  }
  //method to check if it is empty
  public boolean empty() {
    if (al.size() < 1) {
      return true;
    }
    return false;
  }
  //method to find its length
  public int length() {
    return al.size();
  }
  //to String method 
  public String toString(){
    String str = "";
    
    for(int i = 0; i < this.al.size(); i++) {
      str += "Object" + i + ": " + al.get(i).toString() + "\n";
    }    
    return str;
  }
}

  

