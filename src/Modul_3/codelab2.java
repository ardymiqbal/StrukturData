package Modul_3;

import java.util.LinkedList;
import java.util.Queue;


public class codelab2 {
    public static void main(String[] args) {
        // Membuat object queue benama q dengan menggunakan Linkedlist
        Queue q = new LinkedList<>();

        // Menambahkan element ke queue q
        q.add("Bebek");
        q.add("Angsa");
        q.add("Kuda");
        q.add("Buaya");
        q.add("Tikus");
        // Menampilkan element teratas dari queue q yaitu yang paling pertama masuk dalam queue
        System.out.println("Peek: " + q.peek());
        // Menampilkan semua element q
        System.out.println("Animals: " + q);

        // Menghapus element teratas dari queue
        q.poll();
        q.poll();

        System.out.println("Animals : " + q);
    }
}