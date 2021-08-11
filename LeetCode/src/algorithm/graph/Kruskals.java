package algorithm.graph;

import java.util.Arrays;

public class Kruskals {

    public int findMinimumSpanningTree(int vertices, int[][] edges) {

        Edge[] graph = new Edge[edges.length];

        for (int i = 0; i < edges.length; i++) {
            graph[i] = new Edge(edges[i][0], edges[i][1], edges[i][2]);
        }

        Arrays.sort(graph, (a, b) -> a.getCost() - b.getCost());

        UnionFind unionFind = new UnionFind(vertices);
        int minimumCost = 0;
        for (Edge edge : graph) {
            if (!unionFind.isCycle(edge)) {
                unionFind.union(edge);
                minimumCost += edge.getCost();
            }
        }

        return minimumCost;
    }
}
