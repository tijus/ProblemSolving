package com.company;

import java.util.Arrays;

public class Solution {

    private static class CostGraph {
        int E, V;
        int cost;

        CostGraph(int E, int V, int cost) {
            this.E = E;
            this.V = V;
            this.cost = cost;
        }
    }

    private static class Subset {
        int parent, rank;
    }

    private int find(int vertex, Subset[] subsets) {
        if (subsets[vertex].parent != vertex) {
            subsets[vertex].parent = find(subsets[vertex].parent, subsets);
        }
        return subsets[vertex].parent;
    }

    private void union(CostGraph graph, Subset[] subsets) {
        int xRoot = find(graph.E, subsets);
        int yRoot = find(graph.V, subsets);

        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank += 1;
        }
    }

    private boolean isCycle(CostGraph graph, Subset[] subsets) {
        return find(graph.E, subsets) == find(graph.V, subsets);
    }

    public int minimumCost(int N, int[][] connections) {
        CostGraph[] graphs = new CostGraph[connections.length];

        int minimumCost = 0;

        for (int i = 0; i < connections.length; i++) {
            graphs[i] = new CostGraph(connections[i][0], connections[i][1], connections[i][2]);
        }

        Arrays.sort(graphs, (a, b) -> a.cost - b.cost);

        Subset[] parents = new Subset[N];

        for (int i = 1; i <= N; i++) {
            parents[i] = new Subset();
            parents[i].parent = i;
            parents[i].rank = 1;
        }

        for (CostGraph graph : graphs) {
            if (!isCycle(graph, parents)) {
                union(graph, parents);
                minimumCost += graph.cost;
            }
        }
        return minimumCost;
    }
}
