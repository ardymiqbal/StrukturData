package Modul_2;
import java.util.Scanner;

class Kontak {
    private String nama;
    private String nomorTelepon;
    private Kontak next;
    public Kontak(String nama, String nomorTelepon) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.next = null;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public Kontak getNext() {
        return next;
    }

    public void setNext(Kontak next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Nomor Telepon: " + nomorTelepon;
    }
}

class PengelolaKontak {
    private Kontak head;

    public PengelolaKontak() {
        head = null;
    }

    public void tambahKontak(String nama, String nomorTelepon) {
        Kontak newKontak = new Kontak(nama, nomorTelepon);
        if (head == null) {
            head = newKontak;
        } else {
            Kontak current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newKontak);
        }
    }

    public void tampilkanKontak() {
        System.out.println("Daftar Kontak:");
        Kontak current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    public void cariKontak(String nama) {
        boolean ditemukan = false;
        Kontak current = head;
        while (current != null) {
            if (current.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Kontak ditemukan:");
                System.out.println(current);
                ditemukan = true;
                break;
            }
            current = current.getNext();
        }
        if (!ditemukan) {
            System.out.println("Kontak tidak ditemukan.");
        }
    }
}

public class Tugas2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PengelolaKontak pengelolaKontak = new PengelolaKontak();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Tampilkan Kontak");
            System.out.println("3. Cari Kontak");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Buang karakter newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nomor telepon: ");
                    String nomorTelepon = scanner.nextLine();
                    pengelolaKontak.tambahKontak(nama, nomorTelepon);
                    System.out.println("Kontak berhasil ditambahkan.");
                    break;
                case 2:
                    pengelolaKontak.tampilkanKontak();
                    break;
                case 3:
                    System.out.print("Masukkan nama untuk dicari: ");
                    String namaCari = scanner.nextLine();
                    pengelolaKontak.cariKontak(namaCari);
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }
}