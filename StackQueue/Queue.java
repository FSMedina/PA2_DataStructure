// Nama  : Faiza Shifa Medina
// NIM   : 2902826034
// Tugas : Personal Assignment 2 - Data Structures and Algorithm Analysis [COSC6025036: TACA-LEC]

/*
Queue (First In, First Out [FIFO]) berbasis linked node dengan kapasitas maksimum.
front = tempat dequeue, rear = tempat enqueue -> keduanya O(1).
*/

public class Queue {
    private Node front;
    private Node rear;
    private int size;
    private final int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }
    public boolean isFull()  {
        return size >= capacity;
    }
    public int size()        {
        return size;
    }
    public int capacity()    {
        return capacity;
    }

    // Tambah pelanggan di belakang antrian. O(1). @return false jika penuh
    public boolean enqueue(String nomor, String nama, long total) {
        if (isFull()) return false;
        Node baru = new Node(nomor, nama, total);
        if (isEmpty()) {
            front = baru;            // antrian kosong: front = rear = node baru
        } else {
            rear.setNext(baru);
        }
        rear = baru;
        size++;
        return true;
    }

    // Ambil pelanggan terdepan. O(1). @return node, atau null jika kosong
    public Node dequeue() {
        if (isEmpty()) return null;
        Node keluar = front;
        front = front.getNext();
        if (front == null) rear = null;  // antrian jadi kosong: rear ikut direset
        keluar.setNext(null);            // lepas dari antrian
        size--;
        return keluar;
    }

    // Cek apakah nomor antrian sudah ada. O(n).
    public boolean contains(String nomor) {
        for (Node c = front; c != null; c = c.getNext()) {
            if (c.getNomorAntrian().equalsIgnoreCase(nomor)) return true;
        }
        return false;
    }

    // Tampilkan antrian dari depan ke belakang. O(n).
    public void display() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Antrian saat ini (depan -> belakang):");
        int i = 1;
        for (Node c = front; c != null; c = c.getNext()) {
            System.out.println(i++ + ". " + c);
        }
        System.out.println("Jumlah antrian: " + size + "/" + capacity);
    }
}