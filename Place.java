import com.google.common.graph.*;
import java.util.Set;
import java.util.*;


//this is the place class
//methods that only work for some places
//maybe some methods can only be called when in certain rooms, meaning they are parameters

import java.util.ArrayList;

class Place {
  private String name; 
  private String description; 
  private ArrayList<String> items; 

  /*Constructor that makes a new place*/
  public Place(String name, ArrayList<String> items, String description) {
    this.name = name;
    this.items = items; 
    this.description = description;
   //name of place
  }

  /*Getter for the name*/
  public String getName() {
    return this.name;
  }

  /*Getter for the description*/
  public String getDescription() {
    return this.description;
  }

  /*Setter for the description*/
  public void setDescription(String newDescription) {
    this.description = newDescription;
  }

  /*Getter for the items*/
  public ArrayList<String> getItems() {
    return this.items;
  }

  /*Add item to a Place's items*/
  public void addItem(String item) {
    this.getItems().add(item);
  }

  /*Override toString to print name as a string*/
  public String toString() {
    return this.name;
  }
}