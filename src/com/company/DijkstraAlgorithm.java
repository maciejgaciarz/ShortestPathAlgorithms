package com.company;

import java.util.List;

public class DijkstraAlgorithm {


    public int getNodeShortestDistanced(Graph g) {

        List<Vertex> nodes = g.getVertexes();

        int storedNodeIndex = 0;
        int storedDist = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.size(); i++) {
            int currentDist = nodes.get(i).getDistanceFromSource();
            if (!nodes.get(i).isVisited() && currentDist < storedDist) {
                storedDist = currentDist;
                storedNodeIndex = i;
            }
        }
        return storedNodeIndex;
    }


        public void calculateShortestDistances (Graph g) {
            // node 0 as source
            List<Vertex> nodes = g.getVertexes();


            nodes.get(0).setDistanceFromSource(0);
            int nextNode = 0;
            // visit every node
            for (int i = 0; i < nodes.size(); i++) {
                // loop around the edges of current node
                //ArrayList<Edge> currentNodeEdges = nodes.get(nextNode).getEdges();
                List<Edge> currentNodeEdges = g.getEdges();
                for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
                    int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);
                    // only if not visited
                    if (!nodes.get(neighbourIndex).isVisited()) {
                        int tentative = nodes.get(nextNode).getDistanceFromSource() + currentNodeEdges.get(joinedEdge).getWeight();
                        if (tentative < nodes.get(neighbourIndex).getDistanceFromSource()) {
                            nodes.get(neighbourIndex).setDistanceFromSource(tentative);
                        }
                    }
                }
                // all neighbours checked so node visited
                nodes.get(nextNode).setVisited(true);
                // next node must be with shortest distance
                nextNode = getNodeShortestDistanced(g);
            }
        }


        // display result
        public void printResult(Graph g)
        {
            List<Vertex> nodes = g.getVertexes();
            String output = "Number of nodes = " + g.getVertexes().size();
            output += "\nNumber of edges = " + g.getEdges().size();
            for (int i = 0; i < nodes.size(); i++) {
                output += ("\nThe shortest distance from node 0 to node " + i + " is " + nodes.get(i).getDistanceFromSource());
            }
            System.out.println(output);
        }








//    private final List<Vertex> nodes;
//    private final List<Edge> edges;
//    private Set<Vertex> settledNodes;
//    private Set<Vertex> unSettledNodes;
//    private Map<Vertex, Vertex> predecessors;
//    private Map<Vertex, Integer> distance;
//
//    public DijkstraAlgorithm(Graph graph) {
//        // create a copy of the array so that we can operate on this array
//        this.nodes = new ArrayList<Vertex>(graph.getVertexes());
//        this.edges = new ArrayList<Edge>(graph.getEdges());
//    }
//
//    public void execute(Vertex source) {
//        settledNodes = new HashSet<Vertex>();
//        unSettledNodes = new HashSet<Vertex>();
//        distance = new HashMap<Vertex, Integer>();
//        predecessors = new HashMap<Vertex, Vertex>();
//        distance.put(source, 0);
//        unSettledNodes.add(source);
//        while (unSettledNodes.size() > 0) {
//            Vertex node = getMinimum(unSettledNodes);
//            settledNodes.add(node);
//            unSettledNodes.remove(node);
//            findMinimalDistances(node);
//        }
//    }
//
//    private void findMinimalDistances(Vertex node) {
//        List<Vertex> adjacentNodes = getNeighbors(node);
//        for (Vertex target : adjacentNodes) {
//            if (getShortestDistance(target) > getShortestDistance(node)
//                    + getDistance(node, target)) {
//                distance.put(target, getShortestDistance(node)
//                        + getDistance(node, target));
//                predecessors.put(target, node);
//                unSettledNodes.add(target);
//            }
//        }
//
//    }
//
//    private int getDistance(Vertex node, Vertex target) {
//        for (Edge edge : edges) {
//            if (edge.getSource().equals(node)
//                    && edge.getDestination().equals(target)) {
//                return edge.getWeight();
//            }
//        }
//        throw new RuntimeException("Should not happen");
//    }
//
//    private List<Vertex> getNeighbors(Vertex node) {
//        List<Vertex> neighbors = new ArrayList<Vertex>();
//        for (Edge edge : edges) {
//            if (edge.getSource().equals(node)
//                    && !isSettled(edge.getDestination())) {
//                neighbors.add(edge.getDestination());
//            }
//        }
//        return neighbors;
//    }
//
//    private Vertex getMinimum(Set<Vertex> vertexes) {
//        Vertex minimum = null;
//        for (Vertex vertex : vertexes) {
//            if (minimum == null) {
//                minimum = vertex;
//            } else {
//                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
//                    minimum = vertex;
//                }
//            }
//        }
//        return minimum;
//    }
//
//    private boolean isSettled(Vertex vertex) {
//        return settledNodes.contains(vertex);
//    }
//
//    private int getShortestDistance(Vertex destination) {
//        Integer d = distance.get(destination);
//        if (d == null) {
//            return Integer.MAX_VALUE;
//        } else {
//            return d;
//        }
//    }
//
//    /*
//     * This method returns the path from the source to the selected target and
//     * NULL if no path exists
//     */
//    public LinkedList<Vertex> getPath(Vertex target) {
//        LinkedList<Vertex> path = new LinkedList<Vertex>();
//        Vertex step = target;
//        // check if a path exists
//        if (predecessors.get(step) == null) {
//            return null;
//        }
//        path.add(step);
//        while (predecessors.get(step) != null) {
//            step = predecessors.get(step);
//            path.add(step);
//        }
//        // Put it into the correct order
//        Collections.reverse(path);
//        return path;
//    }

}