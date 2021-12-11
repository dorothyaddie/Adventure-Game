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

  public ArrayList<String> take(ArrayList<String> inventory, String item) {
    if ((this.getItems().contains(item)) && (!(item.equals("basil")))) {
      //remove the item from the items 
      this.getItems().remove(item);
      //add it to inventory
      inventory.add(item);
      System.out.println("\nYou are now carrying a " + item + ".");
    } else if ((this.getItems().contains(item)) && (item.equals("basil"))) {
      //remove the item from the items 
      this.getItems().remove(item);
      //add it to inventory
      inventory.add(item);
      System.out.println("\nYou are now carrying a " + item + " leaf.");
    } else if (item.equals("tomatoes")) {
      System.out.println("\nYou cannot take more than one tomato. Take only what you\nneed.");
    } else if (item.equals("food")) {
      System.out.println("\nBe a little more specific.");
    } else if ((item.equals("watering")) && (this.getItems().contains("can"))) {
      this.getItems().remove("can");
      //add it to inventory
      inventory.add("can");
      System.out.println("\nYou are now carrying a can.");
    }else {
      System.out.println("\nYou don't need to take the " + item + ". Take only what you need.");
    }
    return inventory;
  }

  /*Override toString to print name as a string*/
  public String toString() {
    return this.name;
  }
}