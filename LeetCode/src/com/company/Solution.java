package com.company;

import resource.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;


public class Solution {

    class MaxStack {

        private class Entry {

            int value;
            int max;

            Entry (int value, int max ) {
                this.value = value;
                this.max = max;
            }
        }

        Stack<Entry> stack;

        /** initialize your data structure here. */
        public MaxStack() {
            this.stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.add(new Entry(x, x));
            } else {
                Entry topEntry = stack.peek();
                stack.add(new Entry(x, Math.max(x, topEntry.max)));
            }
        }

        public int pop() {
            return !stack.isEmpty() ? stack.pop().value : -1;
        }

        public int top() {
            return !stack.isEmpty() ? stack.peek().value : -1;
        }

        public int peekMax() {
            return !stack.isEmpty() ? stack.peek().max : -1;
        }

        public int popMax() {
            Stack<Entry> tempEntry = new Stack<>();
            Entry curEntry = stack.pop();
            while (curEntry.max != curEntry.value) {
                tempEntry.push(curEntry);
                curEntry = stack.pop();
            }

            int maxElement = curEntry.max;

            while (!tempEntry.isEmpty()) {
                curEntry = tempEntry.pop();
                curEntry.max = Math.max(curEntry.value, stack.peek().max);
                stack.push(curEntry);
            }

            return maxElement;
        }
    }

    

    public static void main(String[] args) {




    }
}
