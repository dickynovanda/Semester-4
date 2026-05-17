package TASK1_STATION;

import java.util.Scanner;

public class MainSistemStasiun {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================================");
        System.out.println("      SISTEM HIERARKI STASIUN KERETA API");
        System.out.println("==========================================================");

        // Buat objek pengelola hierarki
        HierarkiStasiun hierarki = new HierarkiStasiun();

        // MEMBUAT STASIUN-STASIUN
        System.out.println("\n>>> MEMBUAT STASIUN <<<");

        // Stasiun Pusat (Root)
        NodeStasiun stasiunPusat = new NodeStasiun("STN001", "Stasiun Pusat Jakarta", "Jakarta");

        // Stasiun tingkat 1 (anak langsung dari pusat)
        NodeStasiun stasiunUtara = new NodeStasiun("STN002", "Stasiun Jakarta Utara", "Jakarta Utara");
        NodeStasiun stasiunSelatan = new NodeStasiun("STN003", "Stasiun Jakarta Selatan", "Jakarta Selatan");
        NodeStasiun stasiunTimur = new NodeStasiun("STN004", "Stasiun Jakarta Timur", "Jakarta Timur");
        NodeStasiun stasiunBarat = new NodeStasiun("STN005", "Stasiun Jakarta Barat", "Jakarta Barat");

        // Stasiun tingkat 2 (bawahan stasiun utara)
        NodeStasiun stasiunAncol = new NodeStasiun("STN006", "Stasiun Ancol", "Jakarta Utara");
        NodeStasiun stasiunPluit = new NodeStasiun("STN007", "Stasiun Pluit", "Jakarta Utara");
        NodeStasiun stasiunKelapaGading = new NodeStasiun("STN008", "Stasiun Kelapa Gading", "Jakarta Utara");

        // Stasiun tingkat 2 (bawahan stasiun selatan)
        NodeStasiun stasiunBlokM = new NodeStasiun("STN009", "Stasiun Blok M", "Jakarta Selatan");
        NodeStasiun stasiunKemang = new NodeStasiun("STN010", "Stasiun Kemang", "Jakarta Selatan");

        // Stasiun tingkat 2 (bawahan stasiun timur)
        NodeStasiun stasiunCililitan = new NodeStasiun("STN011", "Stasiun Cililitan", "Jakarta Timur");

        // Stasiun tingkat 3 (bawahan stasiun ancol)
        NodeStasiun stasiunPantaiAncol = new NodeStasiun("STN012", "Stasiun Pantai Ancol", "Jakarta Utara");
        NodeStasiun stasiunDufanAncol = new NodeStasiun("STN013", "Stasiun Dufan Ancol", "Jakarta Utara");

        // MEMBANGUN HIERARKI (Menentukan hubungan parent-child)
        System.out.println("\n>>> MEMBANGUN HIERARKI <<<");

        // Set stasiun pusat sebagai akar
        hierarki.setAkar(stasiunPusat);

        // Tambahkan stasiun tingkat 1 ke pusat
        hierarki.tambahStasiun("STN001", stasiunUtara);
        hierarki.tambahStasiun("STN001", stasiunSelatan);
        hierarki.tambahStasiun("STN001", stasiunTimur);
        hierarki.tambahStasiun("STN001", stasiunBarat);

        // Tambahkan stasiun tingkat 2 ke stasiun utara
        hierarki.tambahStasiun("STN002", stasiunAncol);
        hierarki.tambahStasiun("STN002", stasiunPluit);
        hierarki.tambahStasiun("STN002", stasiunKelapaGading);

        // Tambahkan stasiun tingkat 2 ke stasiun selatan
        hierarki.tambahStasiun("STN003", stasiunBlokM);
        hierarki.tambahStasiun("STN003", stasiunKemang);

        // Tambahkan stasiun tingkat 2 ke stasiun timur
        hierarki.tambahStasiun("STN004", stasiunCililitan);

        // Tambahkan stasiun tingkat 3 ke stasiun ancol
        hierarki.tambahStasiun("STN006", stasiunPantaiAncol);
        hierarki.tambahStasiun("STN006", stasiunDufanAncol);

        // MENAMPILKAN STRUKTUR
        hierarki.tampilkanStruktur();

        // STATISTIK POHON
        System.out.println("\n========== STATISTIK POHON ==========");
        System.out.println("Total jumlah stasiun: " + hierarki.getTotalStasiun());
        System.out.println("Tinggi pohon: " + hierarki.getTinggiPohon());

        // TRAVERSAL
        System.out.println("\n========== TRAVERSAL POHON ==========");

        hierarki.preOrderTraversal();
        hierarki.postOrderTraversal();
        hierarki.levelOrderTraversal();

        // PENCARIAN STASIUN
        System.out.println("\n========== PENCARIAN STASIUN ==========");

        // Cari stasiun yang ada
        String kodeCari = "STN006";
        NodeStasiun hasilCari = hierarki.cariStasiun(kodeCari);
        if (hasilCari != null) {
            System.out.println("Ditemukan stasiun dengan kode '" + kodeCari + "': " + hasilCari);
        } else {
            System.out.println("Stasiun dengan kode '" + kodeCari + "' tidak ditemukan!");
        }

        // Cari stasiun yang tidak ada
        kodeCari = "STN999";
        hasilCari = hierarki.cariStasiun(kodeCari);
        if (hasilCari != null) {
            System.out.println("Ditemukan stasiun dengan kode '" + kodeCari + "': " + hasilCari);
        } else {
            System.out.println("Stasiun dengan kode '" + kodeCari + "' tidak ditemukan!");
        }

        // Cek apakah suatu stasiun adalah daun
        System.out.println("\nApakah 'Stasiun Ancol' adalah daun? " +
                (hierarki.cariStasiun("STN006").apakahDaun() ? "YA" : "TIDAK"));
        System.out.println("Apakah 'Stasiun Pantai Ancol' adalah daun? " +
                (hierarki.cariStasiun("STN012").apakahDaun() ? "YA" : "TIDAK"));

        // MENGHAPUS STASIUN
        System.out.println("\n========== MENGHAPUS STASIUN ==========");

        // Tampilkan sebelum hapus
        System.out.println("Sebelum penghapusan:");
        hierarki.tampilkanStruktur();

        // Hapus Stasiun Ancol (yang memiliki anak)
        System.out.println("\n>>> Menghapus 'Stasiun Ancol' (STN006) dengan anak-anaknya dipindahkan <<<");
        hierarki.hapusStasiun("STN006");

        // Tampilkan setelah hapus
        System.out.println("\nSetelah penghapusan:");
        hierarki.tampilkanStruktur();

        // Statistik terbaru
        System.out.println("\nStatistik terbaru:");
        System.out.println("Total jumlah stasiun: " + hierarki.getTotalStasiun());
        System.out.println("Tinggi pohon: " + hierarki.getTinggiPohon());

        // DEMONSTRASI ERROR HANDLING
        System.out.println("\n========== DEMONSTRASI PENANGANAN ERROR ==========");

        // Coba tambah stasiun di bawah induk yang tidak ada
        NodeStasiun stasiunPalsu = new NodeStasiun("STN100", "Stasiun Palsu", "Wilayah Palsu");
        hierarki.tambahStasiun("STN999", stasiunPalsu);

        // Coba hapus stasiun yang tidak ada
        hierarki.hapusStasiun("STN999");

        // Coba hapus stasiun pusat (root)
        hierarki.hapusStasiun("STN001");

        System.out.println("\n==========================================================");
        System.out.println("      PROGRAM SELESAI DENGAN SUKSES!");
        System.out.println("==========================================================");

        scanner.close();
    }
}