package TASK2_EMPLOYEE;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEM MANAJEMEN KARYAWAN (BST) ===\n");

        BSTKaryawan bst = new BSTKaryawan();

        // Insert data sesuai dengan milik Anda
        bst.insert(new Karyawan(105, "Wijaya", "Pimpinan"));
        bst.insert(new Karyawan(102, "Diana", "Keuangan"));
        bst.insert(new Karyawan(108, "Panji", "Teknik"));
        bst.insert(new Karyawan(101, "Cahyani", "HRD"));
        bst.insert(new Karyawan(104, "Wahyu", "Operasional"));
        bst.insert(new Karyawan(106, "Habibi", "Operasional"));
        bst.insert(new Karyawan(103, "Sari", "Keuangan"));
        bst.insert(new Karyawan(110, "Rizky", "Teknik"));
        bst.insert(new Karyawan(107, "Lestari", "HRD"));
        bst.insert(new Karyawan(109, "Fajar", "Teknik"));

        System.out.println();

        // Tampilkan visual tree
        bst.tampilkanTree();

        // Traversal
        System.out.println("\n========== TRAVERSAL ==========");
        bst.inorder();
        bst.preorder();
        bst.postorder();

        // Statistik
        System.out.println("\n========== STATISTIK ==========");
        System.out.println("Total karyawan: " + bst.getJumlah());
        System.out.println("Tinggi pohon: " + bst.getTinggi());
        System.out.println("ID terkecil: " + bst.cariMin().id + " - " + bst.cariMin().nama);
        System.out.println("ID terbesar: " + bst.cariMax().id + " - " + bst.cariMax().nama);

        // Delete demo
        System.out.println("\n========== DELETE DEMO ==========");
        System.out.println("\n>>> Menghapus Diana (ID 102):");
        bst.hapus(102);
        bst.tampilkanTree();

        System.out.println("\n=== PROGRAM SELESAI ===");
    }
}