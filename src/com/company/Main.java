package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        DijkstraTest DijkstraTest = new DijkstraTest();


        double dijkstraStart = System.nanoTime();
        DijkstraTest.execute();
        double dijkstraEnd = System.nanoTime();


        BellmanFordTest BellmanTest = new BellmanFordTest();

        Graph weighted = BellmanTest.createGraph();

        BellmanFordAlgorithm Bellman = new BellmanFordAlgorithm();


        double bellmanStart = System.nanoTime();
        Bellman.execute(weighted,0);
        double bellmanEnd = System.nanoTime();


        double dijkstraDuration = (dijkstraEnd - dijkstraStart) / 1000000.0;
        double bellmanDuration = (bellmanEnd - bellmanStart) / 1000000.0;

        System.out.println("Time Dijkstra took to execute: " + dijkstraDuration +" miliseconds");
        System.out.println("Time Bellman-Ford took to execute: " + bellmanDuration +" miliseconds");


    }


}
//Czyli suma stopni wierzchołków w grafie równa się podwojonej ilości krawędzi.
