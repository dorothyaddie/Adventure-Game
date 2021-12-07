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
  Exit map = new Exit();
  //creates a variable for current node
  Place current = garden; //maybe use Iterable? create Traverser and do breadth first traversal (i think), point to garden in map using index in Iterable? maybe use a map to store each Place and its index, access each Place by index determined by Iterable... HashMap?
  // ok OR use a getter in Exit to get Node w name "garden"
  private boolean playing = true;
  Scanner sc = new Scanner(System.in);
  private String choice;
  
  public void playGame(Exit map) {
    while (playing == true) {
      System.out.println("You are currently at" + current + "You see" + current.getDescription() + "Your possible movements are" + map.adjacentNodes(current) + "Where would you like to go?");
      choice = sc.nextLine();
      if (map.adjacentNodes(current).contains(choice)) {
        //i think we will have to use get name
      }
      current = choice; //use Iterable and potential HashMap
      playing = true;
      
      
    }
  }
}