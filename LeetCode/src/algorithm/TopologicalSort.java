package algorithm;


import resource.GraphNode;


import java.util.*;

public class TopologicalSort {

    private Stack<GraphNode> topologicalStack;
    Set<GraphNode> visited;

    TopologicalSort() {
        this.topologicalStack = new Stack<>();
        this.visited = new HashSet<>();
    }

    public List<GraphNode> topologicalSort(GraphNode root) {
        List<GraphNode> sortedGraph = new ArrayList<>();

        dfs(root);
        while (!topologicalStack.isEmpty()) {
            sortedGraph.add(topologicalStack.pop());
        }

        return sortedGraph;
    }

    private void dfs(GraphNode curNode) {
        if (curNode == null || isVisited(curNode))
            return;

        visited.add(curNode);

        for (GraphNode kid: curNode.children) {
            dfs(kid);
        }

        topologicalStack.add(curNode);
    }

    private boolean isVisited(GraphNode node) {
        return visited.contains(node);
    }
}
