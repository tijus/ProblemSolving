package resource;

import java.util.Objects;

public class Pair<T, H> {

    private T first;
    private H second;

    public Pair() {}

    public Pair(T first) {
        this.first = first;
    }

    public Pair(T first, H second) {
        this.first = first;
        this.second = second;
    }


    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public H getSecond() {
        return second;
    }

    public void setSecond(H second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return first.equals(pair.first) &&
                second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
