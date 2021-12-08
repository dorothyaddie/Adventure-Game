import java.util.Scanner;
import java.util.Set;
import com.google.common.graph.*;
import java.util.*;
import java.util.ArrayList;

public class Play {

  //we will always start in the garden
  //do description and then list the adjacent nodes
  //give the player a choice out of all the adjacent nodes
  //if the player chooses one of the possible nodes: 
    //do steps 2-3
  //if the player does not choose of the nodes:
    //throw exceptions
  
  /*Constructor creates a new instance of the map*/

  //creates a new map
  //private static Exit world = new Exit();
  //creates a variable for current node
  private static Place current = Exit.shed; //maybe use Iterable? create Traverser and do breadth first traversal (i think), point to garden in map using index in Iterable? maybe use a map to store each Place and its index, access each Place by index determined by Iterable... HashMap?
  // ok OR use a getter in Exit to get Node w name "garden"
  private static boolean playing;
  static Scanner sc = new Scanner(System.in);
  private static String choice;
  private Exit world = new Exit();
  private static ArrayList<String> inventory = new ArrayList<String>();
  
  public static void playGame(Exit world) {
    //creates a new map
    playing = true;
    while (playing == true) {
      Set<Place> currNeighbors = Exit.getNeighbors(current);
      System.out.println("You are currently in the " + current.getName() + ". You see " + current.getDescription() + " From here, you can travel to the "); 
      for (Place s : currNeighbors) {
        System.out.print(s + " ");
        } 
      System.out.println(". What should you like to do?");
      choice = sc.nextLine();

      /*All methods we can do inside the shed are here*/
      //if we want to allow the user to take anything else on the walls we just need to add them to the items list for each place
      if (current.getName().equals("shed")) {
        //if what we typed is an item
        if (current.getItems().contains(choice.split(" ")[1])) {
          //remove the item from the items 
          current.getItems().remove(choice.split(" ")[1]);
          //add it to inventory
          Character.take(inventory, choice.split(" ")[1]);
        }
        //not a place or an item
        else if (!current.getItems().contains(choice.split(" ")[1])) {
          System.out.println("You cannot take this item.");
        //}
        //not an item but a place
        //if we are in the shed
        //add else later
          }
        }
      //for each place check if it is in the neighbors 
      for (Place n : currNeighbors) {
      //gets name (string) and compares to choice (also string)
        if (n.getName().equals(choice.split(" ")[1])) {
          current = n;
          } 
      }
      //create a set and loop through it
      //for (Place n : currNeighbors) {
        //gets name (string) and compares to choice (also string)
        //if (n.getName().equals(choice.split(" ")[1])) {
          //current = n;
        //} 
        //if we are in the shed
        //add else later
      //}
      // if (map.adjacentNodes(Exit.current).getName().contains(choice)) {
      //   //i think we will have to use get name
      // }
      // current = Exit.choice; //use Iterable and potential HashMap; get Place in Exit with that name
      playing = true;
      
      
    }
  }
}