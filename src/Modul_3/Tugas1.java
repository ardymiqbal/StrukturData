package Modul_3;
import java.util.Scanner;

public class Tugas1 {
    private String[] history;
    private int currentIndex;

    public Tugas1(int capacity) {
        history = new String[capacity];
        currentIndex = -1;
    }

    public void visitURL(String url) {
        if (currentIndex == history.length - 1) {
            // Jika stack penuh, hapus elemen pertama untuk memberikan ruang
            System.arraycopy(history, 1, history, 0, history.length - 1);
            history[currentIndex] = url;
        } else {
            currentIndex++;
            history[currentIndex] = url;
        }
    }

    public String back() {
        if (currentIndex > 0) {
            currentIndex--;
            return history[currentIndex];
        } else {
            return "Tidak ada halaman sebelumnya";
        }
    }

    public String forward() {
        if (currentIndex < history.length - 1 && history[currentIndex + 1] != null) {
            currentIndex++;
            return history[currentIndex];
        } else {
            return "Tidak ada halaman berikutnya";
        }
    }

    public String getCurrentURL() {
        if (currentIndex >= 0) {
            return history[currentIndex];
        } else {
            return "Belum ada riwayat navigasi";
        }
    }

    public void printHistory() {
        System.out.println("History Navigasi:");
        for (int i = 0; i <= currentIndex; i++) {
            System.out.println((i + 1) + ". " + history[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tugas1 browser = new Tugas1(5); // Maksimum 5 URL dalam riwayat navigasi

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Visit URL");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Current URL");
            System.out.println("5. Print History");
            System.out.println("0. Keluar");

            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membuang newline setelah input angka

            switch (choice) {
                case 0:
                    System.out.println("Terima kasih, keluar dari program.");
                    return;
                case 1:
                    System.out.print("Masukkan URL: ");
                    String url = scanner.nextLine();
                    browser.visitURL(url);
                    break;
                case 2:
                    System.out.println("Back: " + browser.back());
                    break;
                case 3:
                    System.out.println("Forward: " + browser.forward());
                    break;
                case 4:
                    System.out.println("Current URL: " + browser.getCurrentURL());
                    break;
                case 5:
                    browser.printHistory();
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}
