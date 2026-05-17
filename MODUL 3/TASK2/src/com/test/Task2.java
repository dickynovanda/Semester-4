package com.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Task2 {

    // QUEUE untuk antrian penumpang (FIFO)
    private static Queue<String> passengerQueue = new LinkedList<>();

    // STACK untuk riwayat transaksi (LIFO)
    private static Stack<String> transactionHistory = new Stack<>();

    // Counter untuk nomor transaksi
    private static int transactionCounter = 1;

    //  METHOD 1: TAMBAH PENUMPANG
    private static void addPassenger(Scanner scanner) {
        System.out.print("Masukkan nama penumpang: ");
        String name = scanner.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println(" Nama tidak boleh kosong!");
            return;
        }

        passengerQueue.add(name);
        System.out.println(" Penumpang \"" + name + "\" ditambahkan ke antrian.");
        System.out.println("   Total antrian: " + passengerQueue.size() + " orang");
    }

    //  METHOD 2: TAMPILKAN ANTRIAN
    private static void displayQueue() {
        System.out.println("\n=== CURRENT QUEUE (FIFO) ===");
        if (passengerQueue.isEmpty()) {
            System.out.println(" Antrian kosong.");
        } else {
            int position = 1;
            for (String passenger : passengerQueue) {
                System.out.println("   " + position + ". " + passenger);
                position++;
            }
            System.out.println("   Total: " + passengerQueue.size() + " orang");
            System.out.println("   Next: " + passengerQueue.peek());
        }
        System.out.println("=============================\n");
    }

    //  METHOD 3: LAYANI PENUMPANG (FIFO)
    private static void servePassenger() {
        System.out.println("\n=== SERVE PASSENGER (FIFO) ===");

        if (passengerQueue.isEmpty()) {
            System.out.println(" Tidak ada penumpang dalam antrian!");
            System.out.println("==============================\n");
            return;
        }

        // Ambil penumpang dari depan antrian (FIFO)
        String servedPassenger = passengerQueue.poll();

        // Buat ID transaksi
        String transactionId = "TXN-" + String.format("%04d", transactionCounter++);
        String transactionRecord = transactionId + " | " + servedPassenger;

        // Simpan ke stack riwayat transaksi (LIFO)
        transactionHistory.push(transactionRecord);

        System.out.println(" Melayani: " + servedPassenger);
        System.out.println(" Transaksi: " + transactionId);
        System.out.println("   Sisa antrian: " + passengerQueue.size() + " orang");
        System.out.println("==============================\n");
    }

    //  METHOD 4: TAMPILKAN RIWAYAT TRANSAKSI
    private static void displayTransactionHistory() {
        System.out.println("\n=== TRANSACTION HISTORY (LIFO) ===");

        if (transactionHistory.isEmpty()) {
            System.out.println(" Belum ada transaksi.");
        } else {
            System.out.println("(dari yang terbaru ke terlama):");
            // Tampilkan dari atas stack (terbaru) ke bawah (terlama)
            for (int i = transactionHistory.size() - 1; i >= 0; i--) {
                System.out.println("   " + (transactionHistory.size() - i) + ". " + transactionHistory.get(i));
            }
            System.out.println("   Total transaksi: " + transactionHistory.size());
        }
        System.out.println("=================================\n");
    }

    //  METHOD 5: UNDO TRANSAKSI TERAKHIR (LIFO)
    private static void undoLastTransaction() {
        System.out.println("\n=== UNDO LAST TRANSACTION (LIFO) ===");

        if (transactionHistory.isEmpty()) {
            System.out.println(" Tidak ada transaksi yang bisa di-undo!");
            System.out.println("=====================================\n");
            return;
        }

        // Pop transaksi terakhir dari stack (LIFO)
        String undoneTransaction = transactionHistory.pop();

        System.out.println(" Mengundo transaksi:");
        System.out.println("   " + undoneTransaction);
        System.out.println(" Undo berhasil!");
        System.out.println("   Sisa transaksi: " + transactionHistory.size());
        System.out.println("=====================================\n");
    }

    //  METHOD 6: TAMPILKAN MENU
    private static void showMenu() {
        System.out.println("=".repeat(40));
        System.out.println("     TICKET SERVICE SIMULATION");
        System.out.println("=".repeat(40));
        System.out.println("1. Tambah Penumpang (Create)");
        System.out.println("2. Tampilkan Antrian (Read)");
        System.out.println("3. Layani Penumpang (Serve - FIFO)");
        System.out.println("4. Tampilkan Riwayat Transaksi");
        System.out.println("5. Undo Transaksi Terakhir (LIFO)");
        System.out.println("6. Keluar");
        System.out.println("-".repeat(40));
        System.out.print("Pilih menu (1-6): ");
    }

    //  METHOD 7: MAIN
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("\n SELAMAT DATANG DI SISTEM LAYANAN TIKET KERETA ");
        System.out.println(" Queue (FIFO) untuk antrian penumpang");
        System.out.println(" Stack (LIFO) untuk riwayat transaksi\n");

        do {
            showMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addPassenger(scanner);
                        break;
                    case 2:
                        displayQueue();
                        break;
                    case 3:
                        servePassenger();
                        break;
                    case 4:
                        displayTransactionHistory();
                        break;
                    case 5:
                        undoLastTransaction();
                        break;
                    case 6:
                        System.out.println("\n Terima kasih! Statistik akhir:");
                        System.out.println("   Sisa antrian: " + passengerQueue.size() + " orang");
                        System.out.println("   Total transaksi tersimpan: " + transactionHistory.size());
                        break;
                    default:
                        System.out.println(" Pilihan tidak valid! (1-6)");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Input harus berupa angka!");
                choice = 0;
            }
        } while (choice != 6);

        scanner.close();
    }
}