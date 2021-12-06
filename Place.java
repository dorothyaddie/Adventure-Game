//this is the place class
//methods that only work for some places
//maybe some methods can only be called when in certain rooms, meaning they are parameters

public class Place {
  private String name; 

  /*Constructor that makes a new place*/
  public Place(String name) {
    this.name = name;
   //name of place
  }

  /** things a place has: 
  * - a name (String)
  * - a description (String, printed to console)
  * - objects in it (that user can interact with)
  * - create new print method (placePrint) to print name
  * 
  */

  public String getName() {
     return name;
  }

  public String toString() {
    return name;
  }

  
}