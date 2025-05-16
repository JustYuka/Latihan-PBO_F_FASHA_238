package app;
public class Main {
    public static void main(String[] args) {
        perpustakaan.Fiksi buku1 = new perpustakaan.Fiksi("Semangkuk Mie Ayam", "(Mr.Azril)");
        perpustakaan.NonFiksi buku2 = new perpustakaan.NonFiksi("Indomie Harga Mati", "(Mr.Rusdi)");
        perpustakaan.Fiksi buku3 = new perpustakaan.Fiksi("Ambarawa", "(Mr.Andriana)");
        perpustakaan.NonFiksi buku4 = new perpustakaan.NonFiksi("Ambatukam", "(Mr.Ironi)");

        buku1.displayInfo();
        buku2.displayInfo();
        buku3.displayInfo();
        buku4.displayInfo();

        System.out.println();

        perpustakaan.Anggota anggota1 = new perpustakaan.Anggota("Vero", "Vero121");
        anggota1.displayInfo();
        anggota1.pinjamBuku("Semangkuk Mie Ayam");
        anggota1.pinjamBuku("Indomie Harga Mati", 7);
        anggota1.kembalikanBuku("Semangkuk Mie Ayam");

        System.out.println();

        perpustakaan.Anggota anggota2 = new perpustakaan.Anggota("Yuka", "Yuka2211");
        anggota2.displayInfo();
        anggota2.pinjamBuku("Ambarawa");
        anggota2.pinjamBuku("Ambatukam", 7);
        anggota2.kembalikanBuku("Ambarawa");
    }
}
