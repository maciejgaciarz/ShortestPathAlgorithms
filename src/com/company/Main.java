package com.company;

public class Main {

    public static void main(String[] args) {


        //creating a sample Graph
        Graph graph = new GraphGenerator().randomGraphGenerator(200,500);


        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm();
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(graph);



        double dijkstraStart = System.nanoTime();
        //dijkstra execution
        dijkstraAlgorithm.execute(graph.getVertexes().get(0));
        double dijkstraEnd = System.nanoTime();



        double bellmanStart = System.nanoTime();
        //bellman execution
        bellmanFordAlgorithm.execute(graph,0);
        double bellmanEnd = System.nanoTime();


        //to get milliseconds
        double dijkstraDuration = (dijkstraEnd - dijkstraStart) / 1000000.0;
        double bellmanDuration = (bellmanEnd - bellmanStart) / 1000000.0;

        System.out.println("Time Dijkstra took to findPath: " + dijkstraDuration +" miliseconds");
        System.out.println("Time Bellman-Ford took to findPath: " + bellmanDuration +" miliseconds");
    }


}
//Czyli suma stopni wierzchołków w grafie równa się podwojonej ilości krawędzi.