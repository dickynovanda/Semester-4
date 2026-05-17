package com.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        // ************************************************************
        // BAGIAN 1: QUEUE DEMONSTRATION (FIFO)
        // ************************************************************
        // Queue digunakan untuk antrian pelayanan di stasiun
        // Penumpang yang datang pertama akan dilayani pertama

        // TODO 1: Inisialisasi Queue untuk antrian pelayanan
        // Clue: Queue adalah interface, implementasinya menggunakan LinkedList
        // Sintaks: Queue<TipeData> namaVariabel = new LinkedList<>();

        Queue<String> serviceQueue = new LinkedList<>(); // 1

        // Lengkapi inisialisasi Queue

        // TODO 2: Menambahkan penumpang ke antrian menggunakan add()
        // Clue: Gunakan method add(element) untuk menambahkan ke antrian
        // Sintaks: namaQueue.add("data");

        // Tambahkan 3 penumpang: Andi, Titan, Rapi
        serviceQueue.add("Andi"); //2
        serviceQueue.add("Titan");
        serviceQueue.add("Rapi");

        // Menampilkan antrian awal
        System.out.println("Initial Service Queue:");
        System.out.println(serviceQueue);

        // TODO 3: Melayani penumpang (mengambil dari depan antrian menggunakan poll())
        // Clue: Gunakan method poll() untuk mengambil dan menghapus elemen pertama
        // Sintaks: String hasil = namaQueue.poll();

        String servedPassenger = serviceQueue.poll(); // 3

        // Lengkapi method untuk mengambil dari antrian
        System.out.println("Serving passenger: " + servedPassenger);

        // Menampilkan antrian setelah pelayanan
        System.out.println("Queue after serving:");
        System.out.println(serviceQueue);

        // TODO 4: Melihat penumpang di depan antrian tanpa menghapus menggunakan peek()
        // Clue: Gunakan method peek() untuk melihat elemen pertama tanpa menghapus
        // Sintaks: String hasil = namaQueue.peek();

        String nextPassenger = serviceQueue.peek(); // 4

        // Lengkapi method untuk melihat elemen pertama
        System.out.println("Next passenger to serve: " + nextPassenger);

        System.out.println();

        // ************************************************************
        // BAGIAN 2: STACK DEMONSTRATION (LIFO)
        // ************************************************************

        // TODO 5: Inisialisasi Stack untuk riwayat transaksi
        // Clue: Gunakan class Stack untuk membuat stack
        // Sintaks: Stack<TipeData> namaVariabel = new Stack<>();

        Stack<String> transactionHistory = new Stack<>(); // 5

        // Lengkapi inisialisasi Stack

        // TODO 6: Menambahkan transaksi ke stack menggunakan push()
        // Clue: Gunakan method push(element) untuk menambahkan ke stack
        // Tambahkan 3 transaksi: Transaction-1, Transaction-2, Transaction-3

        transactionHistory.push("Transaction-1"); // 6
        transactionHistory.push("Transaction-2");
        transactionHistory.push("Transaction-3");

        // Menampilkan riwayat transaksi
        System.out.println("Transaction History:");
        System.out.println(transactionHistory);

        // TODO 7: Membatalkan transaksi terakhir (undo) menggunakan pop()
        // Clue: Gunakan method pop() untuk mengambil dan menghapus elemen teratas
        // Sintaks: String hasil = namaStack.pop();

        String lastTransaction = transactionHistory.pop(); // 7

        // Lengkapi method untuk mengambil dari stack
        System.out.println("Undo last transaction: " + lastTransaction);

        // Menampilkan riwayat setelah undo
        System.out.println("Transaction History after undo:");
        System.out.println(transactionHistory);

        // TODO 8: Melihat transaksi terakhir tanpa menghapus menggunakan peek()
        // Clue: Gunakan method peek() untuk melihat elemen teratas

        String topTransaction = transactionHistory.peek(); // 8

        // Lengkapi method untuk melihat elemen teratas
        System.out.println("Current top transaction: " + topTransaction);

        // TODO 9: Mengecek apakah stack kosong menggunakan isEmpty()

        if (transactionHistory.isEmpty()) { // 9
            System.out.println("No transaction history.");
        } else {
            System.out.println("Transaction history is not empty. Size: "
                    + transactionHistory.size()); // 10
        }

    }
}