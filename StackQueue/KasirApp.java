// Nama  : Faiza Shifa Medina
// NIM   : 2902826034
// Tugas : Personal Assignment 2 - Data Structures and Algorithm Analysis [COSC6025036: TACA-LEC]

import java.util.Scanner;

/*
Sistem kasir toko: Queue (antrian pelanggan) + Stack (riwayat transaksi).
Menu:
1 Tambah Antrian
2 Layani
3 Tampilkan Antrian
4 Riwayat
5 Keluar
*/

public class KasirApp {
    private static final int MAX_ANTRIAN = 5;   // validasi jumlah data <= 5
    private static final int MIN_ANTRIAN = 5;   // target minimal 5 pelanggan

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue antrian = new Queue(MAX_ANTRIAN);
        Stack riwayat = new Stack();
        boolean jalan = true;

        while (jalan) {
            tampilMenu();
            int pilihan = bacaInt(sc, "Pilih menu: ");
            System.out.println();

            switch (pilihan) {
                case 1: tambahAntrian(sc, antrian);     break;
                case 2: layani(antrian, riwayat);       break;
                case 3: antrian.display();              break;
                case 4: riwayat.display();              break;
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
        System.out.println("[SISTEM KASIR TOKO]");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Layani Pelanggan");
        System.out.println("3. Tampilkan Antrian");
        System.out.println("4. Lihat Riwayat Transaksi");
        System.out.println("5. Keluar");
    }

    // Menu 1: enqueue dengan validasi kapasitas, duplikat, dan input.
    private static void tambahAntrian(Scanner sc, Queue antrian) {
        if (antrian.isFull()) {
            System.out.println("Antrian penuh (maksimal " + MAX_ANTRIAN + " pelanggan). Layani pelanggan dulu.");
            return;
        }
        String nomor = bacaString(sc, "Masukkan Nomor Antrian: ");
        if (nomor.isEmpty()) {
            System.out.println("Gagal: nomor antrian tidak boleh kosong.");
            return;
        }
        if (antrian.contains(nomor)) {
            System.out.println("Gagal: nomor antrian '" + nomor + "' sudah ada di antrian.");
            return;
        }
        String nama = bacaString(sc, "Masukkan Nama Pelanggan: ");
        if (nama.isEmpty()) {
            System.out.println("Gagal: nama tidak boleh kosong.");
            return;
        }
        System.out.print("Masukkan Total Belanja: ");
        long total;
        try {
            total = Long.parseLong(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Gagal: total belanja harus berupa angka bulat.");
            return;
        }
        if (total < 0) {
            System.out.println("Gagal: total belanja tidak boleh negatif.");
            return;
        }
        antrian.enqueue(nomor, nama, total);
        System.out.println("Data pelanggan ditambahkan ke antrian!");
        if (antrian.size() < MIN_ANTRIAN) {
            System.out.println("(Info: baru " + antrian.size() + " pelanggan, target minimal " + MIN_ANTRIAN + ".)");
        }
    }

    // Menu 2: dequeue pelanggan terdepan, lalu push transaksinya ke stack.
    private static void layani(Queue antrian, Stack riwayat) {
        Node pelanggan = antrian.dequeue();
        if (pelanggan == null) {
            System.out.println("Tidak ada pelanggan dalam antrian.");
            return;
        }
        System.out.println("Melayani pelanggan " + pelanggan.getNomorAntrian()
                + " (" + pelanggan.getNamaPelanggan() + ")");
        riwayat.push(pelanggan.getNomorAntrian(), pelanggan.getNamaPelanggan(), pelanggan.getTotalBelanja());
        System.out.println("Transaksi disimpan ke riwayat.");
    }

    // helper input
    private static String bacaString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    private static int bacaInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}