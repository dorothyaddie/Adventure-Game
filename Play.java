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
    ArrayList<String> allChoices = new ArrayList<String>();
    String word1;
    String word2;

    while (playing == true) {
      System.out.print("\nYou are currently in the " + current.getName() + ". \nYou see " + current.getDescription() + " \nFrom here, you can travel to ");
      
      ArrayList<Place> currNeighbors = world.getNeighbors(current.getName());
      world.printNeighbors(currNeighbors);

      System.out.println("What would you like to do?\n");
      choice = sc.nextLine();
      allChoices.add(choice);
      word1 = choice.split(" ")[0];
      word2 = choice.split(" ")[1];

      // if user types a place
      for (Place n : currNeighbors) {
      //gets name (string) and compares to choice (also string)
        if ((n.getName().equals(word1)) || (n.getName().equals(word2))) {
          current = n;
        }
      }

      //if user wants to take an item, update inventory
      if (word1.equals("take")) {
        inventory = current.take(inventory, word2);
      }

      // if user says "inventory," print inventory
      if (word2.equals("inventory")) {
        System.out.println("\nYou are currently carrying: ");
        for (String s : inventory) {
          System.out.println(s);
        }
      }

      /*All methods we can do inside the shed are here*/
      //if we want to allow the user to take anything else on the walls we just need to add them to the items list for each place
      if (current.getName().equals("shed")) {
        if (choice.equals("take can")) {
          current.setDescription("a small wooden table. The walls of the shed are wooden and there are a few items hanging on the wall: a shovel, a spade, a rake, and gardening gloves.");
        }
      }

      /*All methods we can do inside the garden take place here*/
      else if (current.getName().equals("garden")) {

        int countWater = Collections.frequency(allChoices, "water plant");

        //if user typed "water plant"
        if ((choice.equals("water plant")) && (countWater == 1)) { //this is the first time we've watered the plant
          System.out.println("\nYou watered the plant!");
          current.setDescription("the outside of the shed. To your side, there is a small patch of land fenced off with a plastic net. Inside the patch of land, there is a large tomato plant that's grown many huge tomatoes!");
          current.addItem("tomato");
        }
        else if ((choice.equals("water plant")) && (countWater > 1)) { //we've watered the plant more than once
          System.out.println("\nThe large tomato plant is now wilted and yellowed. All its leaves have fallen off, as well as the one tomato. Your beloved tomato plant is dead. Better luck next time!");
          playing = false;
        }
      }
    }
  }
}