package TASK1_STATION;

import java.util.*;


public class HierarkiStasiun {

    // ATRIBUT
    private NodeStasiun akar;  // Stasiun pusat/sentral

    // KONSTRUKTOR
    public HierarkiStasiun() {
        this.akar = null;
    }

    // METHOD DASAR
    public void setAkar(NodeStasiun stasiunPusat) {
        this.akar = stasiunPusat;
        System.out.println("Stasiun pusat ditetapkan: " + stasiunPusat);
    }


    public boolean tambahStasiun(String kodeInduk, NodeStasiun stasiunBaru) {
        NodeStasiun induk = cariStasiun(kodeInduk);
        if (induk == null) {
            System.out.println("Error: Stasiun induk dengan kode '" + kodeInduk + "' tidak ditemukan!");
            return false;
        }

        induk.tambahAnak(stasiunBaru);
        System.out.println("Berhasil menambahkan '" + stasiunBaru + "' di bawah '" + induk.getNamaStasiun() + "'");
        return true;
    }


    public NodeStasiun cariStasiun(String kodeStasiun) {
        if (akar == null) return null;
        return cariStasiunRekursif(akar, kodeStasiun);
    }

    private NodeStasiun cariStasiunRekursif(NodeStasiun current, String kodeStasiun) {
        if (current == null) return null;

        // Cek node saat ini
        if (current.getKodeStasiun().equals(kodeStasiun)) {
            return current;
        }

        // Cari secara rekursif ke semua anak
        for (NodeStasiun anak : current.getDaftarAnak()) {
            NodeStasiun ditemukan = cariStasiunRekursif(anak, kodeStasiun);
            if (ditemukan != null) {
                return ditemukan;
            }
        }
        return null;
    }


    public boolean hapusStasiun(String kodeStasiun) {
        NodeStasiun yangDihapus = cariStasiun(kodeStasiun);
        if (yangDihapus == null) {
            System.out.println("Error: Stasiun dengan kode '" + kodeStasiun + "' tidak ditemukan!");
            return false;
        }

        // Tidak boleh menghapus stasiun pusat (root)
        if (yangDihapus == akar) {
            System.out.println("Error: Tidak dapat menghapus stasiun pusat!");
            return false;
        }

        NodeStasiun induk = yangDihapus.getInduk();

        // Pindahkan semua anak ke kakek (induk dari stasiun yang dihapus)
        for (NodeStasiun anak : yangDihapus.getDaftarAnak()) {
            induk.tambahAnak(anak);
            System.out.println("  - Memindahkan '" + anak + "' ke bawah '" + induk.getNamaStasiun() + "'");
        }

        // Hapus stasiun dari daftar anak induknya
        boolean berhasil = induk.hapusAnak(yangDihapus);
        if (berhasil) {
            System.out.println("Berhasil menghapus stasiun: " + yangDihapus);
        }
        return berhasil;
    }

    // TRAVERSAL (CARA KUNJUNGI NODE)


    public void preOrderTraversal() {
        System.out.println("\n=== PreOrder Traversal (Induk → Anak) ===");
        preOrderRekursif(akar, 0);
    }

    private void preOrderRekursif(NodeStasiun current, int level) {
        if (current == null) return;

        // Cetak dengan indentasi sesuai level
        cetakIndentasi(level);
        System.out.println(current);

        // Kunjungi semua anak secara rekursif
        for (NodeStasiun anak : current.getDaftarAnak()) {
            preOrderRekursif(anak, level + 1);
        }
    }

    public void postOrderTraversal() {
        System.out.println("\n=== PostOrder Traversal (Anak → Induk) ===");
        postOrderRekursif(akar, 0);
    }

    private void postOrderRekursif(NodeStasiun current, int level) {
        if (current == null) return;

        // Kunjungi semua anak terlebih dahulu
        for (NodeStasiun anak : current.getDaftarAnak()) {
            postOrderRekursif(anak, level + 1);
        }

        // Setelah semua anak selesai, baru cetak node saat ini
        cetakIndentasi(level);
        System.out.println(current);
    }

    /**
     * LevelOrder Traversal (BFS): Traversal level per level
     */
    public void levelOrderTraversal() {
        System.out.println("\n=== LevelOrder Traversal (BFS - Level per Level) ===");
        if (akar == null) return;

        Queue<NodeStasiun> antrian = new LinkedList<>();
        antrian.add(akar);

        while (!antrian.isEmpty()) {
            int jumlahDiLevelIni = antrian.size();
            System.out.print("Level: ");

            for (int i = 0; i < jumlahDiLevelIni; i++) {
                NodeStasiun current = antrian.poll();
                System.out.print(current.getNamaStasiun() + " ");

                // Tambahkan semua anak ke antrian
                antrian.addAll(current.getDaftarAnak());
            }
            System.out.println();
        }
    }

    // STATISTIK POHON


    public int getTotalStasiun() {
        return hitungStasiunRekursif(akar);
    }

    private int hitungStasiunRekursif(NodeStasiun current) {
        if (current == null) return 0;

        int jumlah = 1;  // Hitung node saat ini
        for (NodeStasiun anak : current.getDaftarAnak()) {
            jumlah += hitungStasiunRekursif(anak);
        }
        return jumlah;
    }


    public int getTinggiPohon() {
        return hitungTinggiRekursif(akar);
    }

    private int hitungTinggiRekursif(NodeStasiun current) {
        if (current == null) return -1;  // Pohon kosong memiliki tinggi -1
        if (current.apakahDaun()) return 0;  // Daun memiliki tinggi 0

        int tinggiMaksAnak = 0;
        for (NodeStasiun anak : current.getDaftarAnak()) {
            int tinggiAnak = hitungTinggiRekursif(anak);
            tinggiMaksAnak = Math.max(tinggiMaksAnak, tinggiAnak);
        }
        return tinggiMaksAnak + 1;
    }

    public void tampilkanStruktur() {
        System.out.println("\n========== STRUKTUR HIERARKI STASIUN ==========");
        if (akar == null) {
            System.out.println("Pohon masih kosong!");
            return;
        }
        tampilkanStrukturRekursif(akar, 0);
    }

    private void tampilkanStrukturRekursif(NodeStasiun current, int level) {
        if (current == null) return;

        cetakIndentasi(level);
        System.out.println("├─ " + current);

        for (NodeStasiun anak : current.getDaftarAnak()) {
            tampilkanStrukturRekursif(anak, level + 1);
        }
    }

    // METHOD BANTUAN

    private void cetakIndentasi(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
    }
}