import com.google.common.graph.*;
import java.util.*;

//this class will store the actual graph
public class Exit {
  /*Makes the parameters for the rooms*/
  private String[] shedItems = {"watering can"};
  private String[] gardenItems = {"tomato plant"};
  private String[] diningItems = {"table"};
  private String[] kitchenItems = {"recipe book", "oven", "pizza crust", "cheese", "tomato sauce"};

  /*Constructor creates a new graph of type Place*/
  public Exit() {

    /*Makes a graph*/
    MutableGraph<Place> map = GraphBuilder.undirected().build();

    /*Creating all the rooms*/
    Place shed = new Place("shed", shedItems, "This is the description for shed.");
    Place garden = new Place("garden", gardenItems,"This is the description for garden.");
    Place dining = new Place("dining", diningItems, "This is the description for dining.");
    Place kitchen = new Place("kitchen", kitchenItems, "This is the description for kitchen.");


    /*Connecting the rooms with edges and creating nodes*/
    map.putEdge(shed, garden);
    map.putEdge(garden, dining);
    map.putEdge(dining, kitchen);
    map.putEdge(garden, kitchen);

    System.out.println(map);

    System.out.println(map.adjacentNodes(shed));
  }
}