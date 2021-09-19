package algorithm.graph;

import resource.WeightedGraphNode;

import java.util.*;

public class Prims {

    public int findMinimumSpanningTree(int vertex, int[][] edges) {

        Map<WeightedGraphNode, List<WeightedGraphNode>> graph = new HashMap<>();

        WeightedGraphNode sourceVertex = null;

        for (int[] edge: edges) {
            List<WeightedGraphNode> kids = new ArrayList<>();
            WeightedGraphNode currentNode = new WeightedGraphNode(edge[0], edge[2]);
            if (sourceVertex == null)
                sourceVertex = currentNode;
            else {
                // let the source vertex be of the least id in the graph
                if (sourceVertex.getNodeId() > currentNode.getNodeId()) {
                    sourceVertex = currentNode;
                }
            }
            if (graph.containsKey(currentNode)) {
                kids = graph.get(currentNode);
            }

            kids.add(new WeightedGraphNode(edge[1], edge[2]));
            graph.put(currentNode, kids);
        }

        Set<WeightedGraphNode> visited = new HashSet<>();
        return sourceVertex != null ? runPrimsAlgorithm(sourceVertex, visited, graph) : 0;
    }

    private int runPrimsAlgorithm(
            WeightedGraphNode source,
            Set<WeightedGraphNode> visited,
            Map<WeightedGraphNode, List<WeightedGraphNode>> graph
    ){

        int minCost = 0;

        PriorityQueue<WeightedGraphNode> queue = new PriorityQueue<>((a, b) -> {
            if (a.getNodeCost() == b.getNodeCost()) {
                return a.getNodeId() - b.getNodeId();
            }
            return a.getNodeCost() - b.getNodeCost();
        });

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            WeightedGraphNode minCostNode = queue.poll();
            for (WeightedGraphNode kid: graph.get(minCostNode)) {
                if (!visited.contains(kid)) {
                    visited.add(kid);
                    queue.add(kid);
                }
            }

            minCost += minCostNode.getNodeCost();
        }
        return minCost;
    }
}
