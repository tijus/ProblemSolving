package resource;

import java.util.List;
import java.util.Objects;

public class Graph {

    public int value;
    public List<Graph> children;
    public int cost;

    public Graph(){}

    public Graph(int value, List<Graph> children) {
        this.value = value;
        this.children = children;
    }

    public Graph(int value, List<Graph> children, int cost) {
        this.value = value;
        this.children = children;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return value == graph.value &&
                Objects.equals(children, graph.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, children);
    }
}
