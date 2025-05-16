package ManajementStockProject;

import java.util.ArrayList;
import java.util.Scanner;

class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean jalan = true;
        while (jalan) {
            System.out.println("===== Menu Manajemen Stok =====");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    // Opsi 1: Tambah Barang
                    try {
                        System.out.print("Masukkan nama barang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan stok awal: ");
                        int stok = Integer.parseInt(scanner.nextLine());
                        Barang barangBaru = new Barang(nama, stok);
                        daftarBarang.add(barangBaru);
                        System.out.println("Barang '" + nama + "' berhasil ditambahkan.");
                    } catch (NumberFormatException e) {
                        System.out.println("Input stok harus berupa angka!");
                    }
                    break;

                case "2":
                    // Opsi 2: Tampilkan Semua Barang
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("--- Daftar Barang ---");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". Nama: " + b.getNama() + ", Stok: " + b.getStok());
                        }
                        System.out.println("------------------------");
                    }
                    break;

                case "3":
                    // Opsi 3: Kurangi Stok Barang
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang untuk dikurangi stok.");
                        break;
                    }

                    System.out.println("--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang b = daftarBarang.get(i);
                        System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                    }

                    try {
                        System.out.print("Masukkan nomor indeks barang: ");
                        int indeks = Integer.parseInt(scanner.nextLine());

                        Barang barang = daftarBarang.get(indeks);

                        System.out.print("Masukkan jumlah stok yang akan diambil: ");
                        int jumlahDiambil = Integer.parseInt(scanner.nextLine());

                        if (jumlahDiambil > barang.getStok()) {
                            throw new StokTidakCukupException(
                                    "Stok untuk '" + barang.getNama() + "' hanya tersisa " + barang.getStok());
                        }

                        barang.setStok(barang.getStok() - jumlahDiambil);
                        System.out.println("Stok barang '" + barang.getNama() + "' berhasil dikurangi. Sisa stok: " + barang.getStok());

                    } catch (NumberFormatException e) {
                        System.out.println("Input harus berupa angka.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks barang tidak valid.");
                    } catch (StokTidakCukupException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "0":
                    // Opsi 0: Keluar
                    System.out.println("Terima kasih! Program berakhir.");
                    jalan = false;
                    break;

                default:
                    System.out.println("Opsi tidak valid. Coba lagi.");
            }
        }

        scanner.close();
    }
}