package resource;

import java.util.Objects;

public class WeightedGraphNode {

    private int nodeId;
    private int nodeCost;

    public WeightedGraphNode(int nodeId, int nodeCost) {
        this.nodeId = nodeId;
        this.nodeCost = nodeCost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeId, nodeCost);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightedGraphNode other = (WeightedGraphNode) o;
        return this.nodeCost == other.nodeCost && this.nodeId == other.nodeId;
    }

    public int getNodeId() {
        return nodeId;
    }

    public int getNodeCost() {
        return nodeCost;
    }
}
