package algorithm;


import resource.Graph;


import java.util.*;

public class TopologicalSort {

    private Stack<Graph> topologicalStack;
    Set<Graph> visited;

    TopologicalSort() {
        this.topologicalStack = new Stack<>();
        this.visited = new HashSet<>();
    }

    public List<Graph> topologicalSort(Graph root) {
        List<Graph> sortedGraph = new ArrayList<>();

        dfs(root);
        while (!topologicalStack.isEmpty()) {
            sortedGraph.add(topologicalStack.pop());
        }

        return sortedGraph;
    }

    private void dfs(Graph curNode) {
        if (curNode == null || isVisited(curNode))
            return;

        visited.add(curNode);

        for (Graph kid: curNode.children) {
            dfs(kid);
        }

        topologicalStack.add(curNode);
    }

    private boolean isVisited(Graph node) {
        return visited.contains(node);
    }
}
