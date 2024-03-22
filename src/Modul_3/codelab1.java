package Modul_3;

import java.util.Stack;

public class codelab1 {

    public static void main(String[] args) {
        // Membuat Object Stack bernama s
        Stack s = new Stack<>();
        //Mengecek apakah s kosong atau tidak. jika kosong akan mengembalikan true dan sebaliknya
        System.out.println(s.empty());

        // Menambahkan Element ke Stack s
        s.push("Bebek");
        s.push("Angsa");
        s.push("Kuda");
        s.push("Buaya");
        s.push("Tikus");

        System.out.println(s.empty());
        // Menampilkan Element teratas yaitu yang paling terakhir masuk dalam Stack
        System.out.println("Peek : " + s.peek());
        // Menampilkan Isi Stack s
        System.out.println("Animals: " + s);

        // Menghapus element teratas dari Stack s
        s.pop();
        s.pop();
        System.out.println("Animals : " + s);
        // Mencari posisi element kuda dalam stack dan mengembalikan nilai sesuai dengan urutannya dari stack teratas. jika element tidak ditemukan maka akan mengembalikan nilai -1
        System.out.println("Posision of Kuda: "+ s.search("Kuda"));
    }
}