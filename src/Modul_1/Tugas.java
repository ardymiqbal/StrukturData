package Modul_1;

import java.util.Scanner;

enum JenisBarang {
    SANDANG, PANGAN, PAPAN
}

class Barang<Harga, Nama> {
    private Harga harga;
    private Nama nama;
    private JenisBarang jenisBarang;

    public Barang(Harga harga, Nama nama, JenisBarang jenisBarang) {
        this.harga = harga;
        this.nama = nama;
        this.jenisBarang = jenisBarang;
    }

    public Harga getHarga() {
        return harga;
    }

    public Nama getNama() {
        return nama;
    }

    public JenisBarang getJenisBarang() {
        return jenisBarang;
    }
}

public class Tugas { // Main
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ulang;
        do {
            System.out.print("Masukkan Nama barang: ");
            String namaBarang = input.nextLine();
            System.out.print("Masukkan Harga barang: ");
            int hargaBarang = input.nextInt();
            System.out.println("Pilih jenis barang: ");
            System.out.println("0. SANDANG");
            System.out.println("1. PANGAN");
            System.out.println("2. PAPAN");
            System.out.print("Masukkan Pilihan: ");
            int jenisInput = input.nextInt();
            JenisBarang jenisBarang;
            switch (jenisInput) {
                case 0:
                    jenisBarang = JenisBarang.SANDANG;
                    break;
                case 1:
                    jenisBarang = JenisBarang.PANGAN;
                    break;
                case 2:
                    jenisBarang = JenisBarang.PAPAN;
                    break;
                default:
                    jenisBarang = null;
                    break;
            }
            if (jenisBarang != null) {
                Barang<Integer, String> barang = new Barang<>(hargaBarang, namaBarang, jenisBarang);
                System.out.println("Informasi Barang: ");
                System.out.println("Nama Barang  : " + barang.getNama());
                System.out.println("Harga Barang : " + barang.getHarga());
                System.out.println("Jenis Barang : " + barang.getJenisBarang());

            } else {
                System.out.println("Tidak dapat memuat barang karena jenis barang tidak valid");
            }
            System.out.print("Ingin memasukkan barang lagi? (1/0): ");
            ulang = input.nextInt();
            input.nextLine();
        } while (ulang == 1);
        input.close();
    }
}