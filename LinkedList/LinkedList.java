// Nama  : Faiza Shifa Medina
// NIM   : 2902826034
// Tugas : Personal Assignment 2 - Data Structures and Algorithm Analysis [COSC6025036: TACA-LEC]

/*
Single Linked List untuk daftar buku perpustakaan.
*/

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() { return head == null; }
    public int size()        { return size; }

    // Tambah buku di AKHIR daftar. Kompleksitas O(1) karena ada pointer tail.
    public void push(String kodeBuku, String judul, String penulis) {
        Node baru = new Node(kodeBuku, judul, penulis);
        if (isEmpty()) {
            head = baru;          // list kosong: node baru jadi head sekaligus tail
        } else {
            tail.setNext(baru);   // menyambung tail lama ke node baru
        }
        tail = baru;              // geser tail ke node baru
        size++;
    }

    /*
    Menghapus buku TERAKHIR. Kompleksitas O(n): harus berjalan dari head untuk menemukan node tepat sebelum tail.
    @return node yang dihapus, atau null jika list kosong
    */

    public Node pop() {
        if (isEmpty()) return null;

        Node dihapus = tail;
        if (head == tail) {       // kasus 1 elemen: list menjadi kosong
            head = null;
            tail = null;
        } else {
            Node prev = head;
            while (prev.getNext() != tail) { // cari node sebelum tail
                prev = prev.getNext();
            }
            prev.setNext(null);   // memutus tail lama
            tail = prev;          // prev menjadi tail baru
        }
        size--;
        return dihapus;
    }

    //Mencari buku berdasarkan kode dengan case-insensitive. O(n). @return node atau null
    public Node search(String kodeBuku) {
        Node curr = head;
        while (curr != null) {
            if (curr.getKodeBuku().equalsIgnoreCase(kodeBuku)) return curr;
            curr = curr.getNext();
        }
        return null;
    }

    // Menampilkan semua buku sesuai urutan input (head -> tail) + total. O(n).
    public void display() {
        if (isEmpty()) {
            System.out.println("Daftar buku masih kosong.");
            System.out.println("Total Buku: 0");
            return;
        }
        System.out.println("Daftar Buku:");
        Node curr = head;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.getNext();
        }
        System.out.println("Total Buku: " + size);
    }
}