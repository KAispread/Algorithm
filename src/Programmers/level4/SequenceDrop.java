package Programmers.level4;

import java.util.ArrayList;
/*
* Level 4 - 1,2,3 떨어뜨리기
* */

class Solution {
    public int[] solution(int[][] edges, int[] target) {

        Node[] nodes = new Node[target.length + 1];
        for (int i = 0; i < target.length; i++) {
            nodes[i + 1] = new Node(i + 1, target[i]);
        }

        for (int[] edge : edges) {
            nodes[edge[0]].children.add(nodes[edge[1]]);
        }

        ArrayList<Node> leafs = new ArrayList<>();

        for (int idx = 1; idx <= target.length; idx++) {
            if (nodes[idx].initialize()) {
                leafs.add(nodes[idx]);
            }
        }

        ArrayList<Node> drops = new ArrayList<>();
        Node root = nodes[1];
        while (!checkFinishDrop(leafs)) {
            Node drop = root.getNextDropLeaf();
            drops.add(drop);
            drop.showCnt++;
            if (drop.isBurst()) {
                return new int[] { -1 };
            }
        }

        return drops.stream().mapToInt(node -> node.nextValue()).toArray();




    }

    boolean checkFinishDrop(ArrayList<Node> leafs) {
        boolean rst = true;
        for (Node leaf : leafs) {
            rst &= leaf.isEnough();
        }
        return rst;
    }
}

class Node {

    int index;
    int targetValue;
    int showCnt;

    ArrayList<Node> children;

    Node road = null;
    Node next = null;
    boolean isLeaf = false;

    Node(int index, int value) {
        this.index = index;
        this.targetValue = value;

        children = new ArrayList<>();
    }

    boolean initialize() {

        if (children.size() == 0) {
            isLeaf = true;
            return isLeaf;// it's leaf
        }

        children.sort((a, b) -> a.index - b.index);

        Node temp = null;
        for (Node child : children) {
            if (road == null) {
                road = child;
                temp = child;
            } else {
                temp.next = child;
                temp = temp.next;
            }
        }
        temp.next = road;

        return isLeaf;
    }

    boolean isEnough() {
        return 3 * showCnt >= targetValue;
    }

    boolean isBurst() {
        return showCnt > targetValue;
    }

    int nextValue() {
        showCnt--;
        int rst = Math.max(1, targetValue - 3 * showCnt);
        targetValue -= rst;
        return rst;
    }

    Node getNextDropLeaf() {

        if (isLeaf) {
            return this;
        } else {
            Node temp = road.getNextDropLeaf();
            road = road.next;
            return temp;
        }
    }
}
