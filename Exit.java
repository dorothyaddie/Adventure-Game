import com.google.common.graph.*;
import java.util.Set;
import java.util.*;

//this class will store the actual graph
public class Exit {
  /*Makes the parameters for the rooms*/
  private static String[] shedItems = {"watering can"};
  private static String[] gardenItems = {"tomato plant"};
  private static String[] diningItems = {"table"};
  private static String[] kitchenItems = {"recipe book", "oven", "pizza crust", "cheese", "tomato sauce"};
  /*Creating all the rooms*/
  public static Place shed = new Place("shed", shedItems, "This is the description for shed.");
  public static Place garden = new Place("garden", gardenItems,"This is the description for garden.");
  public static Place dining = new Place("dining", diningItems, "This is the description for dining.");
  public static Place kitchen = new Place("kitchen", kitchenItems, "This is the description for kitchen.");

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