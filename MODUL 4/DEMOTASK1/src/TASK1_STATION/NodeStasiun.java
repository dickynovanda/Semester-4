package TASK1_STATION;

import java.util.ArrayList;
import java.util.List;

public class NodeStasiun {

    // ATRIBUT
    private String kodeStasiun;
    private String namaStasiun;
    private String wilayah;
    private List<NodeStasiun> daftarAnak;
    private NodeStasiun induk;

    // ========== KONSTRUKTOR ==========
    public NodeStasiun(String kodeStasiun, String namaStasiun, String wilayah) {
        this.kodeStasiun = kodeStasiun;
        this.namaStasiun = namaStasiun;
        this.wilayah = wilayah;
        this.daftarAnak = new ArrayList<>();  // Inisialisasi daftar anak kosong
        this.induk = null;                     // Awalnya belum punya induk
    }

    // METHOD MANAJEMEN ANAK


    public void tambahAnak(NodeStasiun anak) {
        anak.setInduk(this);           // Set stasiun ini sebagai induk dari anak
        this.daftarAnak.add(anak);     // Tambahkan ke daftar anak
    }


    public boolean hapusAnak(NodeStasiun anak) {
        anak.setInduk(null);            // Hapus referensi induk
        return this.daftarAnak.remove(anak);  // Hapus dari daftar
    }


    public boolean apakahDaun() {
        return this.daftarAnak.isEmpty();
    }

    // GETTER DAN SETTER

    public String getKodeStasiun() {
        return kodeStasiun;
    }

    public void setKodeStasiun(String kodeStasiun) {
        this.kodeStasiun = kodeStasiun;
    }

    public String getNamaStasiun() {
        return namaStasiun;
    }

    public void setNamaStasiun(String namaStasiun) {
        this.namaStasiun = namaStasiun;
    }

    public String getWilayah() {
        return wilayah;
    }

    public void setWilayah(String wilayah) {
        this.wilayah = wilayah;
    }

    public List<NodeStasiun> getDaftarAnak() {
        return daftarAnak;
    }

    public NodeStasiun getInduk() {
        return induk;
    }

    public void setInduk(NodeStasiun induk) {
        this.induk = induk;
    }

    //  METHOD BANTUAN

    @Override
    public String toString() {
        return "[" + kodeStasiun + "] " + namaStasiun + " (" + wilayah + ")";
    }
}