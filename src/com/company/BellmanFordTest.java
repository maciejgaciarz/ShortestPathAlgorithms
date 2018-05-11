package com.company;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordTest {

    private List<Vertex> nodes;
    private List<Edge> edges;


    public Graph createGraph(){
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();

        for (int i = 0 ; i<4; i++){

            nodes.add(new Vertex(i," Vertex"));

        }

        edges.add(new Edge(Integer.toString(0),nodes.get(0),nodes.get(1),5));
        edges.add(new Edge(Integer.toString(1),nodes.get(1),nodes.get(0),3));
        edges.add(new Edge(Integer.toString(2),nodes.get(0),nodes.get(2),2));
        edges.add(new Edge(Integer.toString(3),nodes.get(2),nodes.get(3),6));
        edges.add(new Edge(Integer.toString(4),nodes.get(1),nodes.get(3),4));
        edges.add(new Edge(Integer.toString(5),nodes.get(3),nodes.get(0),-1));

        return new Graph(nodes,edges);
    }

}
