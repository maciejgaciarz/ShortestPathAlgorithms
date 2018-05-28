package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GraphGenerator {

    public GraphGenerator() {}

    public Graph randomGraphGenerator(int maxVertexes, int maxEdges){


        List<Vertex> nodes = new ArrayList<Vertex>();

        List<Edge> edges =  new ArrayList<Edge>();


        //randomize vertexes
        int vertexesAmount = ThreadLocalRandom.current().nextInt(2, maxVertexes);

        for( int i = 0 ; i < vertexesAmount; i++)
        {
            Vertex vertex = new Vertex(i,"Node_" + String.valueOf(i));
            nodes.add(vertex);
        }
        System.out.println("amount of vertexes " + vertexesAmount);



        //randomize edges
        int edgesAmount = ThreadLocalRandom.current().nextInt(1, maxEdges);

        for( int i = 0 ; i < edgesAmount ; i++)
        {
            //random source
            int source = ThreadLocalRandom.current().nextInt( 0 /*vertexesAmount - 1*/, vertexesAmount);

            //random destination
            int destination = ThreadLocalRandom.current().nextInt( 0 /*vertexesAmount - 1*/, vertexesAmount);

            //random weight for each edge
            int weight = ThreadLocalRandom.current().nextInt(1, 1000);


            addLane(nodes,edges,"Edge_"+String.valueOf(i),source,destination,weight);
        }

        System.out.println("amount of edges " + edgesAmount);

        return new Graph(nodes, edges);
    }

    private void addLane(List<Vertex> nodes, List<Edge> edges, String laneId, int sourceLocNo, int destLocNo, int weight)
    {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), weight );

        edges.add(lane);
    }


    public static boolean isBetween(int value, int min, int max)
    {
        return((value > min) && (value < max));
    }
}
