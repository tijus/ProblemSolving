package design;

import java.util.PriorityQueue;

class MedianFinder {


    PriorityQueue<Integer> maxHeap, minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        maxHeap.add(num);
        if (maxHeap.size() - minHeap.size()> 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size())
            return Double.valueOf(maxHeap.poll());
        return (maxHeap.poll() + minHeap.poll()) / (double)2;
    }
}
