//this is the place class
//methods that only work for some places
//maybe some methods can only be called when in certain rooms, meaning they are parameters

public class Place {
  private String name; 
  private String[] items; 
  private String description; 

  /*Constructor that makes a new place*/
  public Place(String name, String[] items, String description) {
    this.name = name;
    this.items = items; 
    this.description = description;
   //name of place
  }

  /** things a place has: 
  * - a name (String)
  * - a description (String, printed to console)
  * - objects in it (that user can interact with)
  */

  /*Getter for the name*/
  public String getName() {
     return this.name;
  }

  /*Getter for the description*/
  public String getDescription() {
    return this.description;
  }

  /*Getter for the items*/
  public String[] getItems() {
    return this.items;
  }

  public String toString() {
    return name;
  }

  
}