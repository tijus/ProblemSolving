package com.company;

import java.util.*;


public class Solution {


    Map<Character, List<String>> dict = new HashMap();;

    public int numMatchingSubseq(String S, String[] words) {

        int matchingSubSeq = 0;

        for (String word: words) {
            char startWith = word.charAt(0);
            List<String> startWithString = dict.containsKey(startWith) ? dict.get(startWith) : new ArrayList<>();
            startWithString.add(word);
            dict.put(startWith, startWithString);
        }

        for (int i = 0; i<S.length(); i++) {
            char c = S.charAt(i);
            matchingSubSeq += replaceWord(c);
        }

        return matchingSubSeq;
    }


    private int replaceWord(char c) {
        List<String> words = dict.get(c);

        int countEnds = 0;

        for (String word : words) {
            char a = word.charAt(1);
            List<String> ws = dict.containsKey(a) ? dict.get(a) : new ArrayList<String>();
            String newWord = word.substring(1);
            if (newWord.isEmpty())
                countEnds += 1;
            ws.add(word.substring(1));
            dict.put(a, ws);
            words.remove(word);
            dict.put(c, words);
        }

        return countEnds;
    }

    Set<String> wordSet;
    HashMap<String, Integer> longestChainMap = new HashMap<>();

    public int longestStrChain(String[] words) {

        int maxLengthOfChain = 0;
        wordSet = new HashSet<>(Arrays.asList(words));

        // Sort the arrays into descending order of the lengths
        Arrays.sort(words, (currentString, nextString) -> nextString.length() - currentString.length());

        for (int i = words.length - 1; i >= 0; i--) {
            maxLengthOfChain = Math.max(maxLengthOfChain, findLongestChain(words[i]));
        }

        return maxLengthOfChain;
    }

    private int findLongestChain(String word) {
        if (word.length() == 1)
            return 1;

        if (longestChainMap.containsKey(word))
            return longestChainMap.get(word);

        int currentChainLength = 0;
        for (int i = 0; i < word.length(); i++) {
            String kidString;
            if (i == 0)
                kidString = word.substring(1);
            else
                kidString = word.substring(0, i) + word.substring(i + 1);
            if (wordSet.contains(kidString)) {
                currentChainLength = Math.max(findLongestChain(kidString), currentChainLength);
            }
        }

        currentChainLength += 1;

        longestChainMap.put(word, currentChainLength);

        return currentChainLength;
    }

    // Map<Integer, List<Integer>> graph = new HashMap<>();

   /* public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {

        // build out a graph
        for (int i = 0; i < seqs.size(); i++) {
            for (int j = 0; j < seqs.get(0).size() - 1; ++j) {
                int currNode = seqs.get(i).get(j);
                int nextNode = seqs.get(i).get(j + 1);
                List<Integer> kids;
                if (!graph.containsKey(currNode)) {
                    kids = new ArrayList<>();
                } else {
                    kids = graph.get(currNode);
                }
                kids.add(nextNode);
                graph.put(currNode, kids);
            }
        }

        // do topological sort on a graph
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> orderedStack = new Stack<>();
        topologicalSort(visited, orderedStack, org[0]);

        // compare the resulting list with the given array an array
        int itr = 0;
        while (!orderedStack.isEmpty()) {
            if (org[itr++] != orderedStack.pop())
                return false;
        }

        return true;
    }

    private void topologicalSort(Set<Integer> visited, Stack<Integer> orderedStack, int currNode) {
        if (visited.contains(currNode))
            return;

        visited.add(currNode);

        for (int kid : graph.get(currNode)) {
            topologicalSort(visited, orderedStack, kid);
        }

        orderedStack.push(currNode);
    }

    private static String INITIAL_NODE = "0000";

    public int openLock(String[] deadends, String target) {

        HashMap<String, List<String>> graph = new HashMap<>();
        Set<String> hasDeadEnds = new HashSet<>(Arrays.asList(deadends));

        // construct a graph
        for (int i = 0; i < 1000; i++) {
            String node = convertToFourDigit(i);

            List<String> nextNodes = new ArrayList<>();
            for (int j = 0; j < 4; j ++) {

            }

            List<String> kids;
            if (graph.containsKey(node))
                kids = graph.get(node);
            else
                kids = new ArrayList<>();

            if (!hasDeadEnds.contains(nextNode))
                kids.add(nextNode);
            graph.put(node, kids);
        }

        // find the shortest path using bfs
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(INITIAL_NODE);
        visited.add(INITIAL_NODE);

        int turns = 0;

        label:
        while (!queue.isEmpty()) {
            int currQueueSize = queue.size();
            while (currQueueSize > 0) {
                String currNode = queue.poll();
                if (currNode != null && currNode.equals(target)) {
                    break label;
                }
                if (!visited.contains(currNode) && currNode != null)
                    queue.addAll(graph.get(currNode));
                currQueueSize--;
            }

            turns++;
        }

        return turns == 0 ? -1 : turns;
    }

    private String convertToFourDigit(int digitCombination) {
        StringBuilder fourDigitString = new StringBuilder();
        String currDigit = String.valueOf(digitCombination);
        if (currDigit.length() == 1) {
            fourDigitString.append("0".repeat(3));
        } else if (currDigit.length() == 2) {
            fourDigitString.append("0".repeat(2));
        } else if (currDigit.length() == 3) {
            fourDigitString.append("0".repeat(1));
        }

        fourDigitString.append(digitCombination);

        Map<TreeNode, Integer> map = new TreeMap<>(new Comparator<TreeNode>();

        return fourDigitString.toString();
    }*/

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}));
        System.out.println(solution.longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
    }
}
