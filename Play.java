import java.util.Scanner;
import java.util.Set;
import com.google.common.graph.*;
import java.util.*;
import java.util.ArrayList;
//make a list of descriptions and remove them as needed

class Play {

  //we will always start in the garden
  //do description and then list the adjacent nodes
  //give the player a choice out of all the adjacent nodes
  //if the player chooses one of the possible nodes: 
    //do steps 2-3
  //if the player does not choose of the nodes:
    //throw exceptions
  
  /*Constructor creates a new instance of the map*/

  public static void main(String[] args) {
    //creates a new map
    Exit world = new Exit();
    Place current = world.getShed();
    boolean playing = true;
    Scanner sc = new Scanner(System.in);
    String choice;
    ArrayList<String> inventory = new ArrayList<String>();

    while (playing == true) {
      System.out.print("\nYou are currently in the " + current.getName() + ". \nYou see " + current.getDescription() + " \nFrom here, you can travel to ");
      
      ArrayList<Place> currNeighbors = world.getNeighbors(current.getName());
      world.printNeighbors(currNeighbors);

      System.out.println("What would you like to do?");
      choice = sc.nextLine();
      //for each place check if it is in the neighbors 
      for (Place n : currNeighbors) {
      //gets name (string) and compares to choice (also string)
        if (n.getName().equals(choice.split(" ")[1])) {
          current = n;
          } 
      }

      /*All methods we can do inside the shed are here*/
      //if we want to allow the user to take anything else on the walls we just need to add them to the items list for each place
      if (current.getName().equals("shed")) {
        //if what we typed is an item
        if (current.getItems().contains(choice.split(" ")[1])) {
          //remove the item from the items 
          current.getItems().remove(choice.split(" ")[1]);
          //add it to inventory
          take(inventory, choice.split(" ")[1]);
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

      /*All methods we can do inside the garden take place here*/
      if (current.getName().equals("garden")) {
        if (choice.equals("water plant")) {
          System.out.print("You watered the plant!");
          current.setDescription("the outside of the shed. To your side, there is a small patch of land fenced off with a plastic net. Inside the patch of land, there is a large tomato plant that's grown one huge tomato!");
          current.addItem("tomato");
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
      
      
    }
  }

  public static ArrayList<String> take(ArrayList<String> inventory, String item) {
      inventory.add(item);
      System.out.print("You are now carrying a ");
      for (String i : inventory) {
        System.out.println(i + ".");
      }
      return inventory;

  }
}