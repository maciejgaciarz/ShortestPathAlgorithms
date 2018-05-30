package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Graph {

    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    public Graph(List<Vertex> vertexes, List<Edge> edges) {
//
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public Graph(int Vertexes, int Edges){


        List<Vertex> nodes = new ArrayList<Vertex>(Vertexes);

        List<Edge> edges =  new ArrayList<Edge>(Edges);


        //vertices
        for( int i = 0 ; i < Vertexes; i++)
        {
            Vertex vertex = new Vertex(i,"Node_" + String.valueOf(i));
            nodes.add(vertex);
        }


        //edges
        for( int i = 0 ; i < Edges ; i++)
        {
            //random source
            int source = ThreadLocalRandom.current().nextInt( 0 , Vertexes);

            //random destination
            int destination = ThreadLocalRandom.current().nextInt( 0 , Vertexes);

            //random weight for each edge
            int weight = ThreadLocalRandom.current().nextInt(1, 1000);

            addLane(nodes,edges,"Edge_"+String.valueOf(i),source,destination,weight);
        }


        this.vertexes = nodes;
        this.edges = edges;
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    private static void addLane(List<Vertex> nodes, List<Edge> edges, String laneId, int sourceLocNo, int destLocNo, int weight)
    {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), weight );

        edges.add(lane);
    }



}
