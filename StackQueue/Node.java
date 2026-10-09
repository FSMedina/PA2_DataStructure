// Nama  : Faiza Shifa Medina
// NIM   : 2902826034
// Tugas : Personal Assignment 2 - Data Structures and Algorithm Analysis [COSC6025036: TACA-LEC]

/*
Node untuk menyimpan data pelanggan/transaksi.
Dipakai bersama oleh Queue (antrian) dan Stack (riwayat).
*/

public class Node {
    private String nomorAntrian;
    private String namaPelanggan;
    private long totalBelanja;   // rupiah, long agar tidak bermasalah locale/desimal
    private Node next;

    public Node(String nomorAntrian, String namaPelanggan, long totalBelanja) {
        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
        this.next = null;
    }

    public String getNomorAntrian()  { return nomorAntrian; }
    public String getNamaPelanggan() { return namaPelanggan; }
    public long getTotalBelanja()    { return totalBelanja; }
    public Node getNext()            { return next; }
    public void setNext(Node next)   { this.next = next; }

    @Override
    public String toString() {
        return "No: " + nomorAntrian + " | Nama: " + namaPelanggan
                + " | Total: Rp" + String.format("%,d", totalBelanja).replace(',', '.');
    }
}