import java.util.Scanner;
import java.util.Set;
import com.google.common.graph.*;
import java.util.*;

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
  private static Place current = Exit.garden; //maybe use Iterable? create Traverser and do breadth first traversal (i think), point to garden in map using index in Iterable? maybe use a map to store each Place and its index, access each Place by index determined by Iterable... HashMap?
  // ok OR use a getter in Exit to get Node w name "garden"
  private static boolean playing;
  static Scanner sc = new Scanner(System.in);
  private static String choice;
  private Exit world = new Exit();
  
  public static void playGame(Exit world) {
    //creates a new map
    playing = true;
    while (playing == true) {
      Set<Place> currNeighbors = Exit.getNeighbors(current);
      System.out.println("You are currently at" + current.getName() + "You see" + current.getDescription() + "Your possible movements are" + currNeighbors + "Where would you like to go?");
      choice = sc.nextLine();
      //create a set and loop through it
      for (Place n : currNeighbors) {
        //gets name (string) and compares to choice (also string)
        if (n.getName().equals(choice)) {
          current = n;
        }
        //add else later
      }
      // if (map.adjacentNodes(Exit.current).getName().contains(choice)) {
      //   //i think we will have to use get name
      // }
      // current = Exit.choice; //use Iterable and potential HashMap; get Place in Exit with that name
      playing = true;
      
      
    }
  }
}