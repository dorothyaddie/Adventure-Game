import java.util.ArrayList;
import com.google.common.graph.*;
import java.util.Set;
import java.util.*;

public class Character {
  //private static ArrayList<String> inventory;

  public ArrayList<String> oldTake(ArrayList<String> inventory, String item) {
    inventory.add(item);
    System.out.print("You are now carrying a ");
    for (String i : inventory) {
      System.out.println(i + ".");
    }
    return inventory;

  }
}
// things a character has: 
// - an inventory (array)
// - take method? for take object?? removes object from room?
