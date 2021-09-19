package algorithm;

import java.util.*;

public class Backtracking {

    private void backTrack(List<Integer> input, int level, LinkedList<Integer> currAns, List<List<Integer>> ans, List<Integer> subset) {
        if (level == input.size()) {
            ans.add(new ArrayList<>(currAns));
            return;
        }

        for (int i = 0; i < subset.size(); ++i) {
            currAns.add(subset.get(i));
            List<Integer> set = generateSubset(subset, i);
            // System.out.println(subset.get(i) +": "+set.toString());
            backTrack(input, level+1, currAns, ans, set);
            currAns.removeLast();
        }
    }

    private List<Integer> generateSubset(List<Integer> input, int position) {
        List<Integer> subset = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (i == position)
                continue;
            subset.add(input.get(i));
        }

        return subset;
    }

    public List<List<Integer>> findPossibleArrangements(List<Integer> input) {

        List<List<Integer>> ans = new LinkedList<>();

        backTrack(input, 0, new LinkedList<>(), ans, input);

        return ans;
    }

    public static void main(String[] args) {

        Backtracking backtracking = new Backtracking();
        List<List<Integer>> ans = backtracking.findPossibleArrangements(Arrays.asList(1,2,3));

        for (List a: ans) {
            System.out.println(a.toString());
        }
    }
}
