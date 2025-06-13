package com.quido.bst;

import java.util.*;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Inserção
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);

        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value){
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    // Busca
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(TreeNode node, int value) {
        if (node == null) return false;
        if (value == node.value) return true;
        return value < node.value ? searchRecursive(node.left, value) : searchRecursive(node.right, value);
    }

    // Remoção
    public void remove(int value) {
        root = removeRecursive(root, value);
    }

    private TreeNode removeRecursive(TreeNode node, int value) {
        if (node == null) return null;

        if (value < node.value) {
            node.left = removeRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = removeRecursive(node.right, value);
        } else {
            // nó com dois filhos ou nenhum
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // nó com dois filhos
            int minValue = findMin(node.right);
            node.value = minValue;
            node.right = removeRecursive(node.right, minValue);
        }
        return node;
    }

    public int findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node.value;
    }

    // Travessias
    public void inOrder() {
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(TreeNode node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.value + " ");
            inOrderRecursive(node.right);
        }
    }

    public void preOrder() {
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    public void postOrder() {
        postOrderRecursive(root);
        System.out.println();
    }

    private void postOrderRecursive(TreeNode node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.print(node.value + " ");
        }
    }

    // Caminhamento em largura
    public List<Integer> levelOrder() {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.value);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return result;
    }

    // Busca com rastreamento
    public SearchResult searchWithTrace(int target) {
        List<Integer> visited = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            visited.add(current.value);
            if (target == current.value) {
                return new SearchResult(true, visited);
            } else if (target < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return new SearchResult(false, visited);
    }

    public static class SearchResult {
        public boolean found;
        public List<Integer> visited;

        public SearchResult(boolean found, List<Integer> visited) {
            this.found = found;
            this.visited = visited;
        }
    }

    // Métodos para retornar listas dos caminhamentos
    public List<Integer> getPreOrder() {
        List<Integer> list = new ArrayList<>();
        preOrderToList(root, list);
        return list;
    }

    private void preOrderToList(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.value);
            preOrderToList(node.left, list);
            preOrderToList(node.right, list);
        }
    }

    public List<Integer> getInOrder() {
        List<Integer> list = new ArrayList<>();
        inOrderToList(root, list);
        return list;
    }

    public void inOrderToList(TreeNode node, List<Integer> list) {
        if (node != null) {
            inOrderToList(node.left, list);
            list.add(node.value);
            inOrderToList(node.right, list);
        }
    }

    public List<Integer> getPostOrder() {
        List<Integer> list = new ArrayList<>();
        postOrderToList(root, list);
        return list;
    }

    public void postOrderToList(TreeNode node, List<Integer> list) {
        if (node != null) {
            postOrderToList(node.left, list);
            postOrderToList(node.right, list);
            list.add(node.value);
        }
    }
}