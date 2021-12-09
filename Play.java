import java.util.Scanner;
import java.util.Set;
import com.google.common.graph.*;
import java.util.*;
import java.util.ArrayList;

class Play {

  /** Runs gameplay */
  public static void main(String[] args) {
    //creates a new map
    Exit world = new Exit();
    Place current = world.getShed();
    boolean play = true;
    Scanner sc = new Scanner(System.in);
    String choice;
    ArrayList<String> inventory = new ArrayList<String>();
    ArrayList<String> allChoices = new ArrayList<String>();
    String word1;
    String word2;
    ArrayList<String> allPlaces = world.getPlaces();
    boolean isOpen = false;

    while (play) {
      System.out.print("\nYou are currently in the " + current.getName() + ". \nYou see " + current.getDescription() + " \nFrom here, you can travel to ");
      
      ArrayList<Place> currNeighbors = world.getNeighbors(current.getName());
      world.printNeighbors(currNeighbors);

      System.out.println("What would you like to do?\n");
      choice = sc.nextLine();
      allChoices.add(choice);
      word1 = choice.split(" ")[0];
      word2 = choice.split(" ")[1];

      // if user types a place
      if (allPlaces.contains(word2)) {
        boolean isNeighbor = false;
        for (Place n : currNeighbors) {
        //gets name (string) and compares to choice (also string)
          if (n.getName().equals(word2)) {
            current = n;
            isNeighbor = true;
          }
        }
        if (!(isNeighbor)) {
          System.out.println("Sorry, you can't travel to the " + word2 + " from the " + current + ".");
        }
      }

      //if user wants to take an item
      else if (word1.equals("take")) {
        inventory = current.take(inventory, word2);
      }

      // if user says "inventory"
      else if (word2.equals("inventory")) {
        System.out.println("\nYou are currently carrying: ");
        for (String s : inventory) {
          System.out.println(s);
        }
      }

      // if user is in the shed
      if (current.getName().equals("shed")) {
        if (choice.equals("take can")) {
          current.setDescription("a small wooden table. The walls of the shed are wooden and there are a few items hanging on the wall: a shovel, a spade, a rake, and gardening gloves.");
        } else if (!(word1.equals("go")) && (!(word1.equals("print"))) && (!(word1.equals("take")))) {
          System.out.println("Sorry, you can't do that.");
        } 
      }

      // if user is in the garden
      else if (current.getName().equals("garden")) {

        int countWater = Collections.frequency(allChoices, "water plant");

        //if user typed "water plant"
        if ((choice.equals("water plant")) && (countWater == 1) && (inventory.contains("can"))) { //this is the first time we've watered the plant
          System.out.println("\nYou watered the plant.");
          current.setDescription("the outside of the shed. To your side, there is a small patch of land fenced off with a plastic net. Inside the patch of land, there is a large tomato plant that's grown many huge tomatoes!");
          current.addItem("tomato");
        }
        else if ((choice.equals("water plant")) && (countWater > 1) && (inventory.contains("can"))) { //we've watered the plant more than once
          System.out.println("\nThe large tomato plant is now wilted and yellowed. All its leaves have fallen off, as well as the one tomato. Your beloved tomato plant is dead. Better luck next time!"); // change desc of garden and remove tomato, don't quit game.
          play = false;
        }
        else if ((choice.equals("water plant")) && (!(inventory.contains("can")))) { //if user tries to water the plant without the can
          System.out.println("You don't have any water, silly.");
        }
        else if (!(word1.equals("go")) && (!(word1.equals("print"))) && (!(word1.equals("take")) )) {
          System.out.println("Sorry, you can't do that.");
        } 
      }

      // if user is in the dining
      else if (current.getName().equals("dining")) {
        if (choice.equals("take book")) {
          current.setDescription("an elegantly set table with three chairs around it. A beautiful picture window overlooks your garden. On a shelf below the window, there's a happy basil plant. A door leads to the garden, and a doorway leads to the kitchen.");
        }
        else if (!(word1.equals("go")) && (!(word1.equals("print"))) && (!(word1.equals("take")) )) {
          System.out.println("Sorry, you can't do that.");
        } 
      }

      // if user is in the kitchen
      else if (current.getName().equals("kitchen")) {
        int countCrust = Collections.frequency(allChoices, "take crust");
        int countCheese = Collections.frequency(allChoices, "take cheese");

        if ((choice.equals("open fridge")) && (countCrust == 0) && (countCheese == 0)) {
          System.out.println("Inside the fridge, there's a homemade vegan pizza crust and a blend of vegan pizza cheese. This is excellent because you like vegan food and you're a little hungry.");
          current.addItem("crust");
          current.addItem("cheese");
        }
        else if ((choice.equals("open fridge")) && (countCrust == 1) && (countCheese == 1)){
          System.out.println("The fridge is empty.");
        }
        else if (choice.equals("close fridge")) {
          System.out.println("You closed the fridge.");
          if (current.getItems().contains("crust")) {
            current.getItems().remove("crust");
          }
          if (current.getItems().contains("cheese")){
            current.getItems().remove("cheese");
          }
        }
        else if (choice.equals("make pizza")) {
          if ((inventory.contains("crust")) && (inventory.contains("cheese")) ) {
            System.out.print("Congrats! You made a pizza! ");
            if ((inventory.contains("tomato"))) {
              System.out.print("You made a yummy pizza sauce using your fresh garden tomato. ");
            }
            else {
              System.out.print("It's a little plain without any sauce. ");
            }
            if ((inventory.contains("basil"))) {
              System.out.print(" The fresh sprinkle of basil on top is a lovely, flavorful touch. ");
            }
            if ((inventory.contains("book"))) {
              System.out.print(" And with that handy dandy recipe book, it all turned out wonderfully. Yum! Enjoy!");
              play = false;
            }
            else {
              System.out.print(" Unfortunately, you didn't know what temperature to set the oven to, so it's very burnt. Better luck next time!");
              play = false;
            }
          } else {
            System.out.println("You can't make a pizza without the basic pizza ingredients, silly – you need some pizza crust and pizza cheese.");
          }
        }
        else if (!(word1.equals("go")) && (!(word1.equals("print"))) && (!(word1.equals("take")) )) {
          System.out.println("Sorry, you can't do that.");
        } 
      }
    }
  }
}