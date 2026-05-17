package TASK2_EMPLOYEE;

import java.util.*;

class Node {
    Karyawan data;
    Node left, right;

    Node(Karyawan data) {
        this.data = data;
        left = right = null;
    }
}

public class BSTKaryawan {
    private Node root;

    // INSERT
    public void insert(Karyawan k) {
        root = insertRec(root, k);
        System.out.println("✓ Insert: " + k);
    }

    private Node insertRec(Node root, Karyawan k) {
        if (root == null) return new Node(k);
        if (k.id < root.data.id) root.left = insertRec(root.left, k);
        else if (k.id > root.data.id) root.right = insertRec(root.right, k);
        else System.out.println("⚠ ID " + k.id + " sudah ada!");
        return root;
    }

    // SEARCH
    public Karyawan cari(int id) {
        Node result = cariRec(root, id);
        return result == null ? null : result.data;
    }

    private Node cariRec(Node root, int id) {
        if (root == null || root.data.id == id) return root;
        return id < root.data.id ? cariRec(root.left, id) : cariRec(root.right, id);
    }

    // MIN & MAX
    public Karyawan cariMin() {
        if (root == null) return null;
        Node curr = root;
        while (curr.left != null) curr = curr.left;
        return curr.data;
    }

    public Karyawan cariMax() {
        if (root == null) return null;
        Node curr = root;
        while (curr.right != null) curr = curr.right;
        return curr.data;
    }

    // DELETE
    public void hapus(int id) {
        Karyawan target = cari(id);
        if (target == null) {
            System.out.println("✗ ID " + id + " tidak ditemukan!");
            return;
        }
        root = hapusRec(root, id);
        System.out.println("✓ Hapus: " + target);
    }

    private Node hapusRec(Node root, int id) {
        if (root == null) return null;

        if (id < root.data.id) root.left = hapusRec(root.left, id);
        else if (id > root.data.id) root.right = hapusRec(root.right, id);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            Node successor = getMinNode(root.right);
            root.data = successor.data;
            root.right = hapusRec(root.right, successor.data.id);
        }
        return root;
    }

    private Node getMinNode(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }

    // TRAVERSAL
    public void inorder() {
        System.out.print("InOrder (terurut): ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data.nama + " ");
            inorderRec(root.right);
        }
    }

    public void preorder() {
        System.out.print("PreOrder (root→kiri→kanan): ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data.nama + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public void postorder() {
        System.out.print("PostOrder (kiri→kanan→root): ");
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data.nama + " ");
        }
    }

    // STATISTIK
    public int getJumlah() {
        return hitungJumlah(root);
    }

    private int hitungJumlah(Node root) {
        if (root == null) return 0;
        return 1 + hitungJumlah(root.left) + hitungJumlah(root.right);
    }

    public int getTinggi() {
        return hitungTinggi(root);
    }

    private int hitungTinggi(Node root) {
        if (root == null) return -1;
        return Math.max(hitungTinggi(root.left), hitungTinggi(root.right)) + 1;
    }

    //VISUALISASI TREE

    public void tampilkanTree() {
        System.out.println("\n========== STRUKTUR TREE ==========");
        if (root == null) {
            System.out.println("Tree kosong!");
            return;
        }

        int tinggi = getTinggi();
        int lebar = (int) Math.pow(2, tinggi + 1) * 3;

        String[][] canvas = new String[tinggi * 2 + 1][lebar];
        for (String[] row : canvas) {
            Arrays.fill(row, " ");
        }

        gambarTree(root, canvas, 0, lebar / 2, 0, lebar);

        for (String[] row : canvas) {
            boolean kosong = true;
            for (String s : row) {
                if (!s.equals(" ")) {
                    kosong = false;
                    break;
                }
            }
            if (!kosong) {
                for (String s : row) {
                    System.out.print(s);
                }
                System.out.println();
            }
        }
    }

    private void gambarTree(Node node, String[][] canvas, int row, int col, int left, int right) {
        if (node == null) return;

        // Gambar node
        String nama = node.data.nama;
        for (int i = 0; i < nama.length(); i++) {
            if (col + i < canvas[0].length) {
                canvas[row][col + i] = String.valueOf(nama.charAt(i));
            }
        }

        int mid = (left + right) / 2;
        int anakRow = row + 2;

        if (node.left != null) {
            int anakCol = (left + mid) / 2;
            // Gambar garis kiri
            for (int i = 1; i <= col - anakCol; i++) {
                if (canvas[row + 1][col - i].equals(" ")) {
                    canvas[row + 1][col - i] = "_";
                }
            }
            canvas[row + 1][anakCol + (col - anakCol) / 2] = "/";
            gambarTree(node.left, canvas, anakRow, anakCol, left, mid);
        }

        if (node.right != null) {
            int anakCol = (mid + right) / 2;
            // Gambar garis kanan
            for (int i = 1; i <= anakCol - col; i++) {
                if (canvas[row + 1][col + i].equals(" ")) {
                    canvas[row + 1][col + i] = "_";
                }
            }
            canvas[row + 1][col + (anakCol - col) / 2] = "\\";
            gambarTree(node.right, canvas, anakRow, anakCol, mid, right);
        }
    }
}