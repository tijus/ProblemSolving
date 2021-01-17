package resource;

import java.util.List;

public class GraphNode {

    public int value;
    public List<GraphNode> children;

    GraphNode(int value, List<GraphNode> children) {
        this.value = value;
        this.children = children;
    }
}
