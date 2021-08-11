package algorithm.graph;

public class UnionFind {

    private static class SubSets {
        int parent, rank;
    }

    SubSets[] subSets;

    UnionFind(int vertices) {
        this.subSets = new SubSets[vertices];

        for (int i = 1; i <= vertices; i++) {
            subSets[i] = new SubSets();
            subSets[i].parent = i;
            subSets[i].rank = 1;
        }
    }

    void union(Edge edge) {
        int xRoot = find(edge.getVertex1());
        int yRoot = find(edge.getVertex2());

        if (subSets[xRoot].rank > subSets[yRoot].rank) {
            subSets[yRoot].parent = xRoot;
        } else if (subSets[xRoot].rank < subSets[yRoot].rank) {
            subSets[xRoot].parent = yRoot;
        } else {
            subSets[yRoot].parent = xRoot;
            subSets[xRoot].rank += 1;
        }
    }

    int find(int vertex) {
        if (subSets[vertex].parent != vertex) {
            subSets[vertex].parent = find(subSets[vertex].parent);
        }

        return subSets[vertex].parent;
    }

    boolean isCycle(Edge edge) {
        return find(edge.getVertex1()) == find(edge.getVertex2());
    }


}
