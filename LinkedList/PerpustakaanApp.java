// Nama  : Faiza Shifa Medina
// NIM   : 2902826034
// Tugas : Personal Assignment 2 - Data Structures and Algorithm Analysis [COSC6025036: TACA-LEC]

import java.util.Scanner;

/*
Program pengelolaan daftar buku perpustakaan (Single Linked List).
Menu:
1 Tambah (push)
2 Hapus (pop)
3 Cari
4 Lihat Semua
5 Keluar
*/

public class PerpustakaanApp {
    private static final int MAX_KODE = 5;   // kodeBuku maksimal 5 karakter
    private static final int MIN_BUKU = 5;   // target minimal 5 buku

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList daftar = new LinkedList();
        boolean jalan = true;

        while (jalan) {
            tampilMenu();
            int pilihan = bacaInt(sc, "Pilih menu: ");
            System.out.println();

            switch (pilihan) {
                case 1: tambahBuku(sc, daftar); break;
                case 2: hapusBuku(daftar);      break;
                case 3: cariBuku(sc, daftar);   break;
                case 4: lihatSemua(daftar);     break;
                case 5:
                    System.out.println("Terima kasih. Program selesai.");
                    jalan = false;
                    break;
                default:
                    System.out.println("Menu tidak valid. Pilih 1-5.");
            }
            System.out.println();
        }
        sc.close();
    }

    private static void tampilMenu() {
        System.out.println("[SISTEM DATA BUKU]");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Hapus Buku");
        System.out.println("3. Cari Buku");
        System.out.println("4. Lihat Semua Buku");
        System.out.println("5. Keluar");
    }

    // Menu 1: input + validasi, lalu push ke akhir list.
    private static void tambahBuku(Scanner sc, LinkedList daftar) {
        String kode = bacaString(sc, "Masukkan Kode Buku: ");
        if (kode.isEmpty() || kode.length() > MAX_KODE) {
            System.out.println("Gagal: kode buku harus 1-" + MAX_KODE + " karakter.");
            return;
        }
        if (daftar.search(kode) != null) {
            System.out.println("Gagal: kode buku '" + kode + "' sudah ada.");
            return;
        }
        String judul = bacaString(sc, "Masukkan Judul: ");
        String penulis = bacaString(sc, "Masukkan Penulis: ");
        if (judul.isEmpty() || penulis.isEmpty()) {
            System.out.println("Gagal: judul dan penulis tidak boleh kosong.");
            return;
        }
        daftar.push(kode, judul, penulis);
        System.out.println("Data berhasil ditambahkan!");
        if (daftar.size() < MIN_BUKU) {
            System.out.println("(Info: baru " + daftar.size() + " buku, minimal " + MIN_BUKU + " buku.)");
        }
    }

    // Menu 2: pop buku terakhir.
    private static void hapusBuku(LinkedList daftar) {
        Node dihapus = daftar.pop();
        if (dihapus == null) {
            System.out.println("Tidak ada data untuk dihapus.");
        } else {
            System.out.println("Buku terakhir berhasil dihapus:");
            System.out.println(dihapus);
        }
    }

    // Menu 3: cari berdasarkan kode.
    private static void cariBuku(Scanner sc, LinkedList daftar) {
        String kode = bacaString(sc, "Masukkan Kode Buku yang dicari: ");
        Node hasil = daftar.search(kode);
        if (hasil == null) {
            System.out.println("Buku tidak ditemukan.");
        } else {
            System.out.println("Buku ditemukan:");
            System.out.println(hasil);
        }
    }

    // Menu 4: tampilkan semua.
    private static void lihatSemua(LinkedList daftar) {
        daftar.display();
        if (daftar.size() < MIN_BUKU) {
            System.out.println("(Info: jumlah buku belum mencapai minimal " + MIN_BUKU + ".)");
        }
    }

    // helper input
    private static String bacaString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    // Baca angka lewat nextLine() agar tidak kena bug newline Scanner & tidak crash.
    private static int bacaInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}