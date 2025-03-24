class KarakterGame {
    private String nama;
    private int kesehatan;

    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama() {
        return nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public void serang(KarakterGame target) {
        System.out.println(nama + " menyerang " + target.getNama() + "!");
    }
}
class Pahlawan extends KarakterGame {
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Vandal!");
        target.setKesehatan(target.getKesehatan() - 85);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
    }
}

class Musuh extends KarakterGame {
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Operator!");
        target.setKesehatan(target.getKesehatan() - 110);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
    }
}

public class Main {
    public static void main(String[] args) {
        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
        Pahlawan Sage = new Pahlawan("Sage", 150);
        Musuh Tejo = new Musuh("Tejo", 200);

        System.out.println("=== Pertarungan Dimulai ===");
        Sage.serang(Tejo);
        Tejo.serang(Sage);
    }
}
