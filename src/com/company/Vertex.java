package com.company;

import java.util.ArrayList;

public class Vertex {

    final private int id;
    final private String name;

    private int distanceFromSource = Integer.MAX_VALUE;
    private boolean visited;

    public int getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(int distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    private ArrayList<Edge> edges = new ArrayList<Edge>(); // now we must create edges

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    private boolean isVisited;


    public Vertex(int id, String name) {
        this.id = id;
        this.name = name;

    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }





}
