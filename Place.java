//this is the place class
//methods that only work for some places
//maybe some methods can only be called when in certain rooms, meaning they are parameters

import java.util.ArrayList;

public class Place {
  private String name; 
  private ArrayList<String> items; 
  private String description; 
  private String updatedDescription;

  /*Constructor that makes a new place*/
  public Place(String name, ArrayList<String> items, String description) {
    this.name = name;
    this.items = items; 
    this.description = description;
    this.updatedDescription = updatedDescription;
   //name of place
  }

  /** things a place has: 
  * - a name (String)
  * - a description (String, printed to console)
  * - objects in it (that user can interact with)
  */

  /*Getter for the updated description*/
  public String getUpdatedDescription() {
    return this.updatedDescription;
  }
  /*Getter for the name*/
  public String getName() {
     return this.name;
  }

  /*Getter for the description*/
  public String getDescription() {
    return this.description;
  }

  /*Getter for the items*/
  public ArrayList<String> getItems() {
    return this.items;
  }

  public String toString() {
    return name;
  }

  
}