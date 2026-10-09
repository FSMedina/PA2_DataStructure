// Nama  : Faiza Shifa Medina
// NIM   : 2902826034
// Tugas : Personal Assignment 2 - Data Structures and Algorithm Analysis [COSC6025036: TACA-LEC]

/*
Stack (Last In, First OUt [LIFO]) berbasis linked node untuk riwayat transaksi.
Semua operasi di top -> push/pop O(1).
*/

public class Stack {
    private Node top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() { return top == null; }
    public int size()        { return size; }

    // Simpan transaksi di puncak stack. O(1).
    public void push(String nomor, String nama, long total) {
        Node baru = new Node(nomor, nama, total);
        baru.setNext(top);   // node baru menunjuk ke top lama
        top = baru;          // top bergeser ke node baru
        size++;
    }

    // Ambil transaksi teratas. O(1). @return node atau null jika kosong
    public Node pop() {
        if (isEmpty()) return null;
        Node atas = top;
        top = top.getNext();
        atas.setNext(null);
        size--;
        return atas;
    }

    // Tampilkan riwayat dari terbaru ke terlama TANPA pop. O(n).
    public void display() {
        if (isEmpty()) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        System.out.println("Riwayat Transaksi (terbaru -> terlama):");
        int i = 1;
        for (Node c = top; c != null; c = c.getNext()) {
            System.out.println(i++ + ". " + c);
        }
        System.out.println("Total transaksi: " + size);
    }
}