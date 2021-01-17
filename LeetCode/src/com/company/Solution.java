package com.company;

import org.w3c.dom.Node;
import resource.TreeNode;

import java.util.*;


public class Solution {

    Map<Integer, List<TreeNode>> map;

    // base case = list of one node

    // event case = empty list of nodes

    // everyting else (list of nodes are the children node, once left and once right);

    public List<TreeNode> allPossibleFBT(int n) {

        this.map = new HashMap<>();
        if (!map.containsKey(n)) {
            List<TreeNode> listOfPossibilities = new ArrayList<>();
            if (n == 1) {
                listOfPossibilities.add(new TreeNode(0));
            } else if (n % 2 == 1) {
                for (int x = 0; x<n; x++) {
                    int y = n - x - 1;
                    for (TreeNode left: allPossibleFBT(x)) {
                        for(TreeNode right: allPossibleFBT(y)) {
                            TreeNode currNode = new TreeNode(0);
                            currNode.left = left;
                            currNode.right = right;
                            listOfPossibilities.add(currNode);
                        }
                    }
                }
            }
            map.put(n, listOfPossibilities);
        }
        return map.get(n);

    }

    public static void main(String[] args) {
        List<TreeNode> allPossibleFBT = new Solution().allPossibleFBT(7);

        for (TreeNode possibleFBT: allPossibleFBT) {
            System.out.println(possibleFBT.val);
        }
    }
}
