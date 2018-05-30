package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

            runTests(150);





    }


    static void runTests(int amountOfRuns) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter DjikstraWriter = new PrintWriter("resultsDjikstra.txt", "UTF-8");
        PrintWriter BellmanWriter = new PrintWriter("resultsBellman.txt", "UTF-8");

        double bellmanStart = 0.0;
        double bellmanEnd = 0.0;
        double dijkstraStart = 0.0;
        double dijkstraEnd = 0.0;


        //generating wanted graph
        Graph graph = new GraphGenerator().randomGraphGenerator(50,100);


        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm();
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();

        for(int i=0;i<amountOfRuns ;i++){


            bellmanStart = System.nanoTime();
            bellmanFordAlgorithm.execute(graph,0);
            bellmanEnd = System.nanoTime();


            dijkstraStart = System.nanoTime();
            dijkstraAlgorithm.calculateShortestDistances(graph);
            dijkstraEnd = System.nanoTime();


            double bellmanDuration = (bellmanEnd - bellmanStart) / 1000000.0;
            double dijkstraDuration = (dijkstraEnd - dijkstraStart) / 1000000.0;

            BellmanWriter.println(bellmanDuration);
            DjikstraWriter.println(dijkstraDuration);



//            System.out.println("Time Dijkstra took to findPath: " + dijkstraDuration +" miliseconds");
//            System.out.println("Time Bellman-Ford took to findPath: " + bellmanDuration +" miliseconds");

        }
        System.out.println("amount of vertexes " + graph.getVertexes().size());
        System.out.println("amount of edges " + graph.getEdges().size());


        DjikstraWriter.close();
        BellmanWriter.close();
    }


}