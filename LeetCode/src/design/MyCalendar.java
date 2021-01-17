package design;

import java.util.Comparator;
import java.util.TreeMap;

class MyCalendar {

    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        this.map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer ceilKey = map.ceilingKey(start);
        Integer floorKey = map.floorKey(start);

        if ((ceilKey == null || map.get(ceilKey) <= start) && (floorKey == null || end <= floorKey)) {
            map.put(start, end);
            return true;
        }

        return false;
    }
}
