import com.google.common.graph.*;
import java.util.Set;
import java.util.*;

//this class will store the actual graph
public class Exit {
  /*Makes the parameters for the rooms*/
  private ArrayList<String> shedItems = new ArrayList(Arrays.asList("can"));
  private ArrayList<String> gardenItems = new ArrayList<String>();
  private ArrayList<String> diningItems = new ArrayList(Arrays.asList("book", "basil"));
  private ArrayList<String> kitchenItems = new ArrayList(Arrays.asList());
  /*Creating all the rooms*/
  private Place shed = new Place("shed", shedItems, "a small wooden room. \nThere are a few tools hanging on the wall, including \na shovel and a saw. \nOn the floor is a watering can, full of water.");
  private Place garden = new Place("garden", gardenItems,"a small patch of land fenced off with plastic net. \nInside, there is a small plant with a cage around it.");
  private Place dining = new Place("dining", diningItems, "an elegantly set table with three chairs around it.\nA beautiful picture window overlooks your garden. \nOn a shelf by the window, there's a recipe book and a happy\nbasil plant.");
  private Place kitchen = new Place("kitchen", kitchenItems, "a well-lit space with an oven and a fridge. \nThe floor is tiled with brightly colored ceramic, and\nthere's a whiff of nutmeg in the air. \nYou feel warm, held, and a bit hungry.");
  private MutableGraph<Place> map = GraphBuilder.undirected().build();

  /*Constructor creates a new graph of type Place*/
  public Exit() {

    /*Connecting the rooms with edges and creating nodes*/
    map.putEdge(shed, garden);
    map.putEdge(garden, dining);
    map.putEdge(dining, kitchen);
    map.putEdge(garden, kitchen);
  }

  public Place getGarden() {
    return this.garden;
  }

  public Place getShed() {
    return this.shed;
  }

  public Place getDining() {
    return this.dining;
  }

  public Place getKitchen() {
    return this.kitchen;
  }

  public ArrayList<String> getPlaces() {
    ArrayList<String> places = new ArrayList<String>();
    Set<Place> setOfPlaces = map.nodes();
    for (Place p : setOfPlaces) {
      places.add(p.getName());
    }
    return places;
  }

  public ArrayList<Place> getNeighbors(String userHere) {
    Set<Place> setOfNeighbors = new HashSet<Place>();
    ArrayList<Place> listNeighbors = new ArrayList<Place>(); //neighbors has to be ordered so we can print nicely
    Set<Place> allPlaces = map.nodes();

    for (Place p : allPlaces) {
      if (p.getName() == userHere) {
        setOfNeighbors = map.adjacentNodes(p);
      }
    }

    for (Place p : setOfNeighbors) {
      listNeighbors.add(p);
    }

    return listNeighbors;
  }

  public void printNeighbors(ArrayList<Place> neighbors) {
    if (neighbors.size() > 2) {
      for (int i = 0; i < (neighbors.size() - 1); i++) {
        Place s = neighbors.get(i);
        System.out.print("the " + s + ", ");
      } 
      System.out.println("and the " + neighbors.get(neighbors.size()-1) + ".");
      } else if (neighbors.size() == 2) {
        System.out.println("the " + neighbors.get(0) + " and the " + neighbors.get(1) + ".");
      } else if (neighbors.size() == 1) {
        System.out.println("the " + neighbors.get(0) + ".");
      }
  }

}