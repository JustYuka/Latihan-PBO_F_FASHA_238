package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.models.Item;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    public Mahasiswa(String nama, String nim) {
        this.username = nama;
        this.password = nim;
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n[Mahasiswa Menu]");
            System.out.println("1. Laporkan Barang");
            System.out.println("2. Lihat Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> reportItem();
                case 2 -> viewReportedItems();
            }
        } while (pilihan != 0);
    }

    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Deskripsi: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi: ");
        String lokasi = scanner.nextLine();

        LoginSystem.reportedItems.add(new Item(nama, deskripsi, lokasi));
        System.out.println("Barang berhasil dilaporkan.");
    }

    @Override
    public void viewReportedItems() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan.");
        } else {
            for (Item i : LoginSystem.reportedItems) {
                if (i.getStatus().equals("Reported")) {
                    System.out.println(i);
                }
            }
        }
    }
}
