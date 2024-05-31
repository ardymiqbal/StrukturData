package Modul_5_Tugas;

import java.util.Scanner;

class Buku {
    int isbn;
    String judul;
    Buku left, right;

    public Buku(int isbn, String judul) {
        this.isbn = isbn;
        this.judul = judul;
        left = right = null;
    }
}

class InventarisBuku {
    Buku root;

    public InventarisBuku() {
        root = null;
    }

    void tambahBuku(int isbn, String judul) {
        root = tambahRekursif(root, isbn, judul);
    }

    Buku tambahRekursif(Buku root, int isbn, String judul) {
        if (root == null) {
            root = new Buku(isbn, judul);
            return root;
        }
        if (isbn < root.isbn) {
            root.left = tambahRekursif(root.left, isbn, judul);
        } else if (isbn > root.isbn) {
            root.right = tambahRekursif(root.right, isbn, judul);
        }
        return root;
    }

    Buku cariBuku(int isbn) {
        return cariRekursif(root, isbn);
    }

    Buku cariRekursif(Buku root, int isbn) {
        if (root == null || root.isbn == isbn) {
            return root;
        }
        if (isbn < root.isbn) {
            return cariRekursif(root.left, isbn);
        }
        return cariRekursif(root.right, isbn);
    }

    void tampilkanPreOrder(Buku root) {
        if (root != null) {
            System.out.println(root.isbn + " " + root.judul);
            tampilkanPreOrder(root.left);
            tampilkanPreOrder(root.right);
        }
    }

    void tampilkanInOrder(Buku root) {
        if (root != null) {
            tampilkanInOrder(root.left);
            System.out.println(root.isbn + " " + root.judul);
            tampilkanInOrder(root.right);
        }
    }

    void tampilkanPostOrder(Buku root) {
        if (root != null) {
            tampilkanPostOrder(root.left);
            tampilkanPostOrder(root.right);
            System.out.println(root.isbn + " " + root.judul);
        }
    }

    public static void main(String[] args) {
        InventarisBuku inventaris = new InventarisBuku();
        Scanner scanner = new Scanner(System.in);

        // Menambahkan buku awal ke dalam inventaris
        inventaris.tambahBuku(123, "Java Programming");
        inventaris.tambahBuku(21, "Phyton Programming");
        inventaris.tambahBuku(456, "Data Structures and Algorithms");
        inventaris.tambahBuku(143, "Statistics");
        inventaris.tambahBuku(789, "Computer Networks");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Menambahkan buku baru beserta ISBN ke inventaris");
            System.out.println("2. Mencari buku berdasarkan ISBN");
            System.out.println("3. Menampilkan semua buku dalam inventaris secara terurut berdasarkan ISBN");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi (1-4): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ISBN buku: ");
                    int isbnBaru = scanner.nextInt();
                    scanner.nextLine(); // Konsumsi newline
                    System.out.print("Masukkan judul buku: ");
                    String judulBaru = scanner.nextLine();
                    inventaris.tambahBuku(isbnBaru, judulBaru);
                    System.out.println("Buku berhasil ditambahkan.");
                    break;
                case 2:
                    System.out.print("Masukkan ISBN buku yang ingin dicari: ");
                    int isbnCari = scanner.nextInt();
                    Buku hasilCari = inventaris.cariBuku(isbnCari);
                    if (hasilCari != null) {
                        System.out.println("Buku ditemukan: ISBN = " + hasilCari.isbn + ", Judul = " + hasilCari.judul);
                    } else {
                        System.out.println("Buku dengan ISBN " + isbnCari + " tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.println("\nInventaris Buku (terurut berdasarkan ISBN - InOrder):");
                    inventaris.tampilkanInOrder(inventaris.root);

                    System.out.println("\nInventaris Buku (PreOrder):");
                    inventaris.tampilkanPreOrder(inventaris.root);

                    System.out.println("\nInventaris Buku (PostOrder):");
                    inventaris.tampilkanPostOrder(inventaris.root);
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
                    break;
            }
        }
    }
}