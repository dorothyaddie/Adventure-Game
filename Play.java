import java.util.Scanner;
import java.util.Set;
import com.google.common.graph.*;
import java.util.*;
import java.util.ArrayList;
import com.google.common.base.CharMatcher;
import java.util.regex.Pattern;

class Play {

  /** Runs gameplay */
  public static void main(String[] args) {
    //creates a new map
    Exit world = new Exit();
    Place current = world.getGarden();
    boolean play = true;
    Scanner sc = new Scanner(System.in);
    String choice;
    ArrayList<String> inventory = new ArrayList<String>();
    ArrayList<String> allChoices = new ArrayList<String>();
    String word1;
    String word2;
    ArrayList<String> allPlaces = world.getPlaces();
    boolean isOpen = false;
    boolean choiceSuccess;
    int countSpace;
    String lines = "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n";

    System.out.println("\n\nWelcome to your home! Wander at your leisure. \nIf you find yourself wanting help at any point, simply type \"help\". \nHave fun!");

    while (play) {
      choiceSuccess = true;
      System.out.print(lines + "\nYou are currently in the " + current.getName() + ". \nYou see " + current.getDescription() + " \nFrom here, you can travel to ");
      
      ArrayList<Place> currNeighbors = world.getNeighbors(current.getName());
      world.printNeighbors(currNeighbors);

      System.out.println("What would you like to do?\n");
      System.out.print(">>>> ");
      choice = sc.nextLine();

      word1 = choice.split(" ")[0];
      countSpace = CharMatcher.is(' ').countIn(choice);

      if (choice.equals("inventory")) {
        System.out.println("\nYou are currently carrying: ");
        if (inventory.isEmpty()) {
          System.out.println("nothing!");
        }
        else {
          for (String s : inventory) {
            System.out.println(s);
          }
        }
      } else if (choice.equals("help")) { // if user types "help"
        System.out.println(lines + "If you would like to see this information again, say \"help\". \nIf you would like to see what you're carrying, say \"inventory\". \nIf you would like to see all of the successful moves you've made so far, say \"history\". \nIf you would like to go somewhere, say \"go\" followed by the one-word name of the place you'd like to travel to. \n    Example: \"go garden\". \n\nIf you would like to take something, say \"take\" followed by a one-word name of the object you'd like to try to take. \n    Example: \"take can\". \n\nDo not capitalize. Do not use punctuation. \n\nIn addition to \"go\" and \"take\", there are four additional actions you may be able to do: \n\"water\", \"open\", \"close\", and \"make\". \nThere are no other actions. \nTry these when the moment feels right.");
      } else if (choice.equals("history")) {
        System.out.println(lines + "Here are all of the successful moves you've made so far, in order:\n" + allChoices);
      } else if (countSpace != 1) { // if user types a command that was not two words
        System.out.println("\nPlease use a two-word command.");
        choiceSuccess = false;
      } else { // if user types a two word command
        word2 = choice.split(" ")[1];

        // if user types a place
        if ((allPlaces.contains(word2)) && (word1.equals("go"))) {
          boolean isNeighbor = false;
          for (Place n : currNeighbors) {
            if (n.getName().equals(word2)) {
              current = n;
              isNeighbor = true;
            }
          }
          if (!(isNeighbor)) {
            System.out.println("\nSorry, you can't travel to the " + word2 + " from the " + current + ".");
            choiceSuccess = false;
          }
        }
        else if (word1.equals("go")) {
          System.out.println("\nThis isn't a valid place. \nPlease say the name of the place you want to go to. \nExample: \"go garden.\"");
        }

        //if user wants to take an item
        else if (word1.equals("take")) {
          ArrayList<String> oldInventory = new ArrayList<String>();
          oldInventory.addAll(inventory);
          inventory = current.take(inventory, word2);
          if (oldInventory.equals(inventory))   { // nothing was taken
            choiceSuccess = false;
          }
       }

        else if ((choice.equals("open book")) && (inventory.contains("book"))) {
            System.out.println("\nYou gently open the book to a random page. \nIt's a handwritten homemade pizza recipe! \nAll it calls for is pizza crust, pizza cheese, tomato (optional) and any additional herbs or spices (optional).");
          }

        // if user is in the shed
        if (current.getName().equals("shed")) {
          if (choice.equals("take can")) {
            current.setDescription("a small wooden table. \nThe walls of the shed are wooden and there are a few items hanging on the wall: \na shovel, a spade, a rake, and gardening gloves.");
          } 
          else if (!(word1.equals("go")) && (!(word1.equals("print"))) && (!(word1.equals("take")))) {
            System.out.println("\nSorry, you can't do that. \nYou can type \"help\" to learn more about moves.");
            choiceSuccess = false;
          } 
        }

        // if you take the shovel, you can take the plant! if have take plant, and have open recipe book and taken seeds, then in garden, you can plant seeds. then water seeds, = peppers! and tomatoes! and onions! yay!

        // if user is in the garden
        else if (current.getName().equals("garden")) {
          int countWater = Collections.frequency(allChoices, "water plant");

          //if user typed "water plant"
          if ((choice.equals("water plant")) && (countWater == 0) && (inventory.contains("can"))) { //this is the first time we've watered the plant
            System.out.println("\nYou watered the plant! The plant instantly grew into a large tomato plant with many huge tomatoes!");
            current.setDescription("the outside of the shed. \nTo your side, there is a small patch of land fenced off with a plastic net. \nInside the patch of land, there is a large tomato plant that's grown many huge tomatoes!");
            current.addItem("tomato");
          }
          else if ((choice.equals("water plant")) && (countWater > 0) && (inventory.contains("can"))) { //we've watered the plant more than once
            System.out.println("\nYou watered the plant... again...");
            current.setDescription("that the large tomato plant is now wilted and yellowed. \nAll its leaves have fallen off, as well as the one tomato. \nYour beloved tomato plant is dead.");
            current.getItems().remove("tomato");
          }
          else if ((choice.equals("water plant")) && (!(inventory.contains("can")))) { //if user tries to water the plant without the can
            System.out.println("\nYou don't have any water, silly.");
            choiceSuccess = false;
          }
          else if (!(word1.equals("go")) && (!(word1.equals("print"))) && (!(word1.equals("take")) )) {
            System.out.println("\nSorry, you can't do that. \nYou can always type \"help\" to learn more about acceptable actions.");
            choiceSuccess = false;
          } 
        }

        // if user is in the dining
        else if (current.getName().equals("dining")) {
          if (choice.equals("take book")) {
            current.setDescription("an elegantly set table with three chairs around it. \nA beautiful picture window overlooks your garden. \nOn a shelf below the window, there's a happy basil plant. \nA door leads to the garden, and a doorway leads to the kitchen.");
          } else if (!(word1.equals("go")) && (!(word1.equals("print"))) && (!(word1.equals("take")) )) {
            System.out.println("\nSorry, you can't do that. \nYou can always type \"help\" to learn more about acceptable actions.");
            choiceSuccess = false;
          } 
        }

        // if user is in the kitchen
        else if (current.getName().equals("kitchen")) {
          int countCrust = Collections.frequency(allChoices, "take crust");
          int countCheese = Collections.frequency(allChoices, "take cheese");

          if (choice.equals("open oven")) {
            System.out.println("\nGood thinking, but you don't need to do this.\nWhenever you're ready to make something, just say \"make\" followed by the dish you want to make!");
          }
          else if ((choice.equals("open fridge")) && (countCrust == 0) && (countCheese == 0)) {
            System.out.println("\nInside the fridge, there's a homemade vegan pizza crust and a blend of vegan pizza cheese. \nThis is excellent because you like vegan food and you're a little hungry.");
            current.addItem("crust");
            current.addItem("cheese");
          }
          else if ((choice.equals("open fridge")) && (countCrust == 1) && (countCheese == 0)) {
            System.out.println("\nInside the fridge, there's a blend of vegan pizza cheese.");
            current.addItem("cheese");
          }
          else if ((choice.equals("open fridge")) && (countCrust == 0) && (countCheese == 1)) {
            System.out.println("\nInside the fridge, there's a homemade vegan pizza crust.");
            current.addItem("crust");
          }
          else if ((choice.equals("open fridge")) && (countCrust == 1) && (countCheese == 1)){
            System.out.println("\nThe fridge is empty.");
          }
          else if (choice.equals("close fridge")) {
            System.out.println("\nYou closed the fridge.");
            if (current.getItems().contains("crust")) {
              current.getItems().remove("crust");
            }
            if (current.getItems().contains("cheese")){
              current.getItems().remove("cheese");
            }
          }
          else if ((word1.equals("make")) && (!(word2.equals("pizza")))) {
            System.out.println("\nNice idea, but you don't have the ingredients to make this dish.\nTry something else?");
          }
          else if (choice.equals("make pizza")) {
            if ((inventory.contains("crust")) && (inventory.contains("cheese")) ) {
              System.out.println("\nCONGRATULATIONS! You made a pizza! ");
              if ((inventory.contains("tomato"))) {
                System.out.println("You made a yummy pizza sauce using your fresh garden tomato. ");
              }
              else {
                System.out.println("It's a little plain without any sauce. ");
              }
              if ((inventory.contains("basil"))) {
                System.out.println(" The fresh sprinkle of basil on top is a lovely, flavorful touch. ");
              }
              if ((inventory.contains("book"))) {
                System.out.println(" And with that handy dandy recipe book, it all turned out wonderfully. Yum! Enjoy!");
                play = false;
              }
              else {
                System.out.println(" Unfortunately, you didn't know what temperature to set the oven to, so it's very burnt. Better luck next time!");
                play = false;
              }
            } else {
              System.out.println("\nYou can't make a pizza without the basic pizza ingredients, silly\n – you need some pizza crust and pizza cheese.");
              choiceSuccess = false;
            }
          }
          else if (!(word1.equals("go")) && (!(word1.equals("print"))) && (!(word1.equals("take")) )) {
            System.out.println("\nSorry, you can't do that. \nYou can always type \"help\" to learn more about acceptable actions.");
            choiceSuccess = false;
          } 
        }
      }

      // if command did what user wanted it to do
      if (choiceSuccess) { 
        allChoices.add(choice);
      }
    }
  }
}