package TASK2_EMPLOYEE;

public class Karyawan implements Comparable<Karyawan> {
    int id;
    String nama;
    String departemen;

    public Karyawan(int id, String nama, String departemen) {
        this.id = id;
        this.nama = nama;
        this.departemen = departemen;
    }

    @Override
    public int compareTo(Karyawan o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return id + " - " + nama + " (" + departemen + ")";
    }
}