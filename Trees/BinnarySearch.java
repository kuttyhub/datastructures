import java.lang.Math;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;

public class BinnarySearch {

    public static void main(String[] args) {
        BinnarySearch bst = new BinnarySearch();
        BinnarySearch bstRecrusion = new BinnarySearch();
        int[] a = { 10, 1, 5, 4, 19, 20, 20 };
        for (int i : a) {
            bst.insert(i);
            bstRecrusion.insertRecursion(i);
        }
        bst.preOrderTraverse();
        bstRecrusion.preOrderTraverse();
        // bst.postOrderTraverse();
        // bst.inOrderTraverse();

        // System.out.println(bst.heightOftree());
        // System.out.println(bst.equalityCheck(bst.root, bstRecrusion.root));
        // bst.printKDistanceNode(3);
        // bst.printVerticalOrderBST();
        bst.printLevelOrderBST();
    }

    private class Node {
        int data;
        Node left;
        Node right;

        private Node(int value) {
            this.data = value;
        }
    }

    private Node root;

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        } else {
            Node current = root;
            while (true) {
                if (data < current.data) {
                    if (current.left == null) {
                        current.left = new Node(data);
                        return;
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = new Node(data);
                        return;
                    }
                    current = current.right;
                }
            }
        }
    }

    public void insertRecursion(int data) {
        this.root = insertRecursion(data, this.root);
    }

    private Node insertRecursion(int data, Node node) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insertRecursion(data, node.left);
        } else {
            node.right = insertRecursion(data, node.right);
        }
        return node;
    }

    public void preOrderTraverse() {
        preOrderTraverse(root);
        System.out.println();
    }

    private void preOrderTraverse(Node node) {
        // traversing root,left,right

        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public void postOrderTraverse() {
        postOrderTraverse(root);
        System.out.println();
    }

    private void postOrderTraverse(Node node) {
        // traversing left,right,root

        if (node == null)
            return;
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
        System.out.print(node.data + " ");
    }

    public void inOrderTraverse() {
        inOrderTraverse(root);
        System.out.println();
    }

    public void inOrderTraverse(Node node) {
        // traversing left,root,right

        if (node == null)
            return;
        preOrderTraverse(node.left);
        System.out.print(node.data + " ");
        preOrderTraverse(node.right);
    }

    public int find(int data) {

        Node temp = root;
        while (temp != null) {
            if (data == temp.data) {
                return 1;
            } else {
                if (data < temp.data) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
        }

        return 0;
    }

    public int heightOftree() {
        return heightOftree(root);
    }

    private int heightOftree(Node node) {
        if (node == null) {
            return -1;
        }
        if (node.left == null && node.right == null) {
            return 0;
        }
        return 1 + Math.max(heightOftree(node.left), heightOftree(node.right));

    }

    public int minBT() {
        return minBT(root);
    }

    private int minBT(Node node) {
        // binnary tree travising for finding min o(n)
        if (node == null) {
            return -1;
        }
        if (node.left == null && node.right == null) {
            return node.data;
        }
        return Math.min(Math.min(minBT(node.left), minBT(node.right)), node.data);
    }

    public int minBST() {
        return minBST(root);
    }

    private int minBST(Node node) {
        // bst last left node is min of the tree O(log n)
        if (node == null) {
            return -1;
        }
        Node current = node;
        while (current.left != null && current.right != null) {
            current = current.left;
        }
        return current.data;
    }

    public boolean equalityCheck(Node t1, Node t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 != null && t2 != null) {
            return t1.data == t2.data && equalityCheck(t1.left, t2.left) && equalityCheck(t1.right, t2.right);
        }
        return false;
    }

    public boolean isValidBST() {
        return validityOfBst(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
    }

    private boolean validityOfBst(int min, int max, Node node) {

        if (node == null) {
            return true;
        }
        if (node.data < min || node.data > max) {
            return false;
        }
        return validityOfBst(min, node.data - 1, node.left) && validityOfBst(node.data + 1, max, node.right);
    }

    public void printKDistanceNode(int k) {
        printKDistanceNode(root, k);
    }

    private void printKDistanceNode(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }
        printKDistanceNode(root.left, k - 1);
        printKDistanceNode(root.right, k - 1);
    }

    public void printVerticalOrderBST() {
        TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
        getVerticalOrderBSTNodes(root, 0, map);
        for (Entry<Integer, Vector<Integer>> i : map.entrySet()) {
            System.out.println(i.getValue());
        }
    }

    private void getVerticalOrderBSTNodes(Node root, int hd, TreeMap<Integer, Vector<Integer>> map) {
        // hd means horizontal distance
        if (root == null) {
            return;
        }
        Vector<Integer> list = map.get(hd);
        if (list == null) {
            list = new Vector<Integer>();
            list.add(root.data);
        } else {
            list.add(root.data);
        }
        map.put(hd, list);

        getVerticalOrderBSTNodes(root.left, hd - 1, map);
        getVerticalOrderBSTNodes(root.right, hd + 1, map);
    }

    public void printLevelOrderBST() {
        TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
        getLevelOrderBST(root, 0, map);
        for (Entry<Integer, Vector<Integer>> i : map.entrySet()) {
            System.out.println(i.getValue());
        }
    }

    private void getLevelOrderBST(Node root, int level, TreeMap<Integer, Vector<Integer>> map) {
        if (root == null)
            return;
        Vector<Integer> list = map.get(level);
        if (list == null) {
            list = new Vector<Integer>();
            list.add(root.data);
        } else {
            list.add(root.data);
        }
        map.put(level, list);
        getLevelOrderBST(root.left, level + 1, map);
        getLevelOrderBST(root.right, level + 1, map);

    }
}