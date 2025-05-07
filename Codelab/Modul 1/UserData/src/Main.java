import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        Fiksi buku1 = new Fiksi("Semangkuk Mie Ayam", "(Andrea Hirata)");
        NonFiksi buku2 = new NonFiksi("Indomie Harga Mati", "(James Clear)");
        Fiksi buku3 = new Fiksi("Ambarawa", "(Andriana)");
        NonFiksi buku4 = new NonFiksi("Ambatukam", "(Mr.Ironi)");

        buku1.displayInfo();
        buku2.displayInfo();
        buku3.displayInfo();
        buku4.displayInfo();

        System.out.println();

        Anggota anggota1 = new Anggota("Vero", "Vero121");
        anggota1.displayInfo();
        anggota1.pinjamBuku("Semangkuk Mie Ayam");
        anggota1.pinjamBuku("Indomie Harga Mati", 7);
        anggota1.kembalikanBuku("Semangkuk Mie Ayam");

        System.out.println();

        Anggota anggota2 = new Anggota("Yuka", "Yuka2211");
        anggota2.displayInfo();
        anggota2.pinjamBuku("Ambarawa");
        anggota2.pinjamBuku("Ambatukam", 7);
        anggota2.kembalikanBuku("Ambarawa");
    }
}
