package Modul_5_Tugas;

import java.util.Scanner;

class TreeNode {
    String value;
    TreeNode left, right;

    TreeNode(String item) {
        value = item;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;

    BinaryTree() {
        root = null;
    }

    void insert(String value) {
        root = insertRec(root, value);
    }

    TreeNode insertRec(TreeNode root, String value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value.compareTo(root.value) < 0)
            root.left = insertRec(root.left, value);
        else if (value.compareTo(root.value) > 0)
            root.right = insertRec(root.right, value);
        return root;
    }

    void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan Jumlah Node!:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Masukkan Nodenya! :");
        for (int i = 0; i < n; i++) {
            String node = sc.nextLine();
            tree.insert(node);
        }

        System.out.println("PreOrder traversal:");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println("InOrder traversal:");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.println("PostOrder traversal:");
        tree.postOrder(tree.root);
        System.out.println();
    }
}