package algorithm;


import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    List<Integer> list;
    int low, high;

    public BinarySearch(List<Integer> list) {
        this.list = list;
        this.low = 0;
        this.high = list.size() - 1;
    }

    public BinarySearch(Integer[] arr) {
        this.list = Arrays.asList(arr);
        this.low = 0;
        this.high = arr.length - 1;
    }

    public BinarySearch(List<Integer> list, int low, int high) {
        this.list = list;
        this.low = low;
        this.high = high;
    }

    public BinarySearch(Integer[] arr, int low, int high) {
        this.list = Arrays.asList(arr);
        this.low = low;
        this.high = high;
    }

    public boolean contains(int key) {

        int low = 0, high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) < key) {
                low = mid + 1;
            } else if (list.get(mid) > key) {
                high = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public int first(int key) {

        int low = 0, high = list.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low + 1) / 2;

            if (list.get(mid) < key) {
                low = mid + 1;
            } else if (list.get(mid) > key) {
                high = mid - 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }

    public int last(int key) {
        int low = 0, high = list.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low + 1) / 2;

            if (list.get(mid) < key) {
                ans = mid;
                low = mid + 1;
            } else if (list.get(mid) > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int leastGreater(int key) {
        int low = 0, high = list.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low + 1) / 2;

            if (list.get(mid) < key) {
                low = mid + 1;
            } else if (list.get(mid) > key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int mostLesser(int key) {
        int low = 0, high = list.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low + 1) / 2;

            if (list.get(mid) < key) {
                ans = mid;
                low = mid + 1;
            } else if (list.get(mid) > key) {
                high = mid - 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
