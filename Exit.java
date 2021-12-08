import com.google.common.graph.*;
import java.util.Set;
import java.util.*;

//this class will store the actual graph
public class Exit {
  /*Makes the parameters for the rooms*/
  private static ArrayList<String> shedItems = new ArrayList(Arrays.asList("can"));
  private static ArrayList<String> gardenItems = new ArrayList<String>;
  private static ArrayList<String> diningItems = new ArrayList(Arrays.asList("table"));
  private static ArrayList<String> kitchenItems = new ArrayList(Arrays.asList("recipe book", "oven", "pizza crust", "cheese", "tomato sauce"));
  /*Creating all the rooms*/
  public static Place shed = new Place("shed", shedItems, "a small wooden table with a watering can full of water. The walls of the shed are wooden and there are a few items hanging on the wall: a shovel, a spade, a rake, and gardening gloves.");
  public static Place garden = new Place("garden", gardenItems,"the outside of the shed. To your side, there is a small patch of land fenced off with plastic net. Inside the patch of land, there is a small tomato plant with a cage around it. ", "the outside of the shed. To your side, there is a small patch of land fenced off with a plastic net. Inside the patch of land, there is a large tomato plant with three tomatoes growing inside the cage.");
  public static Place dining = new Place("dining", diningItems, "This is the description for dining.", "This is the updated description for dining.");
  public static Place kitchen = new Place("kitchen", kitchenItems, "This is the description for kitchen.", "This is the updated description for kitchen.");

  /*Constructor creates a new graph of type Place*/
  public Exit() {

    /*Makes a graph*/
    MutableGraph<Place> map = GraphBuilder.undirected().build();


    /*Connecting the rooms with edges and creating nodes*/
    map.putEdge(shed, garden);
    map.putEdge(garden, dining);
    map.putEdge(dining, kitchen);
    map.putEdge(garden, kitchen);
  }

  public static Set<Place> getNeighbors(Place start) {
    /*Makes a graph*/
    MutableGraph<Place> world = GraphBuilder.undirected().build();


    /*Connecting the rooms with edges and creating nodes*/
    world.putEdge(shed, garden);
    world.putEdge(garden, dining);
    world.putEdge(dining, kitchen);
    world.putEdge(garden, kitchen);

    return world.adjacentNodes(start);
  }

}