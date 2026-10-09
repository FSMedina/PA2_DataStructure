// Nama  : Faiza Shifa Medina
// NIM   : 2902826034
// Tugas : Personal Assignment 2 - Data Structures and Algorithm Analysis [COSC6025036: TACA-LEC]

/*
Node untuk Single Linked List.
Menyimpan data satu buku + referensi (pointer) ke node berikutnya.
*/

public class Node {
    private String kodeBuku;
    private String judul;
    private String penulis;
    private Node next; // pointer ke node berikutnya (null jika node terakhir)

    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }
    public String getJudul()    {
        return judul;
    }
    public String getPenulis()  {
        return penulis;
    }
    public Node getNext()       {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Kode: " + kodeBuku + " | Judul: " + judul + " | Penulis: " + penulis;
    }
}