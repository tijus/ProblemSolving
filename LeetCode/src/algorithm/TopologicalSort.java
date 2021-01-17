package algorithm;


import resource.GraphNode;


import java.util.*;

public class TopologicalSort {

    List<GraphNode> ans = new ArrayList<>();
    Set<GraphNode> visited = new HashSet<>();
    Stack<GraphNode> sortOrderedStack = new Stack<>();

    public List<GraphNode> topologicalSort(GraphNode root) {
        dfs(root);

        while (!sortOrderedStack.isEmpty()) {
            ans.add(sortOrderedStack.pop());
        }

        return ans;
    }

    private void dfs(GraphNode node) {
        if (visited.contains(node))
            return;

        visited.add(node);

        for (GraphNode child: node.children) {
            dfs(child);
        }

        ans.add(node);
    }
}
