import com.google.common.graph.*;
import java.util.*;

//this class will store the actual graph
public class Exit {
  /*Constructor creates a new graph of type Place*/
  public Exit() {

    /*Makes a graph*/
    MutableGraph<Place> map = GraphBuilder.undirected().build();

    /*Creating all the rooms*/
    Place bedroom = new Place("bedroom");
    Place hallway = new Place("hallway");
    Place entrance = new Place("entrance");
    Place foyer = new Place("foyer");
    Place balcony = new Place("balcony");
    Place bathroom = new Place("bathroom");
    Place kitchen = new Place("kitchen");
    Place living = new Place("living");
    Place dining = new Place("dining");
    Place pool = new Place("pool");
    Place beach = new Place("beach");
    Place closet = new Place("closet");

    /*Connecting the rooms with edges and creating nodes*/
    map.putEdge(entrance, foyer);
    map.putEdge(foyer, closet);
    map.putEdge(foyer, bathroom);
    map.putEdge(foyer, kitchen);
    map.putEdge(foyer, living);
    map.putEdge(foyer, hallway);
    map.putEdge(hallway, bedroom);
    map.putEdge(bedroom, balcony);
    map.putEdge(living, dining);
    map.putEdge(kitchen, dining);
    map.putEdge(kitchen, bathroom);
    map.putEdge(living, pool);
    map.putEdge(pool, beach);

    System.out.println(map);

    System.out.println(map.adjacentNodes(foyer));
  }
}