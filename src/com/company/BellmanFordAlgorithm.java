package com.company;

public class BellmanFordAlgorithm {


    public void execute(Graph graph, int sourceVertexNumber) {
        //result is distance array that marks the distance from sourceVertex - 0 to 0,1,2,3,4...inf vertex of graph

        int[] distances = new int[graph.getVertexes().size()];

        int[] predecessors = new int[graph.getVertexes().size()];


        //filling distances array, 0 is the source so dist is 0
        for (int i = 0; i < graph.getVertexes().size(); i++) {

            distances[i] = Integer.MAX_VALUE;
            predecessors[i] = 0;
        }
        distances[sourceVertexNumber] = 0;


        //relax the edges
        for (int i = 1; i <= graph.getVertexes().size() - 1; i++) {
            for (int j = 0; j < graph.getEdges().size(); j++) {
                int u = graph.getEdges().get(j).getSource().getId();
                int v = graph.getEdges().get(j).getDestination().getId();
                int w = graph.getEdges().get(j).getWeight();

                if (distances[u] != Integer.MAX_VALUE
                        && distances[v] > distances[u] + w) {
                    distances[v] = distances[u] + w;
                    predecessors[v] = u;
                }
            }
        }

        //look for negative cycles
        for (int i = 0; i < graph.getEdges().size(); i++) {

            int u = graph.getEdges().get(i).getSource().getId();
            int v = graph.getEdges().get(i).getDestination().getId();
            int w = graph.getEdges().get(i).getWeight();

            if (distances[u] != Integer.MAX_VALUE && distances[v] > distances[u] + w) {
                System.out.println("Negative weight cycle detected");
                //No negative weight cycle found!
                return;
            }


        }

//        //print the distance and predecessor array
//        System.out.println("Distance array: ");
//        for (int d : distances
//                ) {
//            System.out.println(d);
//        }
//        System.out.println("Predecessor array: ");
//        for (int p : predecessors
//                ) {
//            System.out.println(p);
//        }
    }
}
