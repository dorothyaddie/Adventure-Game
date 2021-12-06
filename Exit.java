import com.google.common.graph.*;
import java.util.*;

//this class will store the actual graph
public class Exit {
  /*Constructor creates a new graph of type Place*/
  public Exit() {

    /*Makes a graph*/
    MutableGraph<Place> map = GraphBuilder.undirected().build();

    /*Creating all the rooms*/
    Place shed = new Place("shed");
    Place garden = new Place("garden");
    Place dining = new Place("dining");
    Place kitchen = new Place("kitchen");


    /*Connecting the rooms with edges and creating nodes*/
    map.putEdge(shed, garden);
    map.putEdge(garden, dining);
    map.putEdge(dining, kitchen);
    map.putEdge(garden, kitchen);

    System.out.println(map);

    System.out.println(map.adjacentNodes(shed));
  }
}