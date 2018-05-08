package com.company;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DijkstraTest {

     List<Vertex> nodes;

     List<Edge> edges;


    public void execute(){


        nodes = new ArrayList<Vertex>();

        edges = new ArrayList<Edge>();


        for( int i = 0 ; i < 11; i++)
        {
            Vertex vertex = new Vertex("Node_" + i,"Node_" + i);
            nodes.add(vertex);
        }

        //adding random edges
        addLane("Edge_0", 0, 1, 85);
        addLane("Edge_1", 0, 2, 352);
        addLane("Edge_2", 0, 4, 643);
        addLane("Edge_3", 2, 6, 631);
        addLane("Edge_4", 1, 10, 64);
        addLane("Edge_5", 3, 7, 123);
        addLane("Edge_6", 5, 8, 35);
        addLane("Edge_7", 2, 5, 160);
        addLane("Edge_8", 7, 9, 167);
        addLane("Edge_9", 5, 8, 361);
        addLane("Edge_10", 9, 10, 20);
        addLane("Edge_11", 1, 10, 10);



        // Checking from location 1 to location 10
        Graph graph = new Graph(nodes,edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(0));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));

        System.out.println("Shortest path according to Dijkstra is ");

        for (Vertex x:path
             ) {
            System.out.println(x.getName());
        }

    }


    private void addLane(String laneId, int sourceLocNo, int destLocNo,
                         int duration) {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
        edges.add(lane);
    }


}
