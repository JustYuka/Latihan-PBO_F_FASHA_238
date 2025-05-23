package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.models.Item;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    public Admin(String user, String pass) {
        this.username = user;
        this.password = pass;
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n[Admin Menu]");
            System.out.println("1. Kelola Laporan");
            System.out.println("2. Kelola Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> manageItems();
                case 2 -> manageUsers();
            }
        } while (pilihan != 0);
    }

    @Override
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
            System.out.println(i + ". " + LoginSystem.reportedItems.get(i));
        }

        try {
            System.out.print("Pilih item (indeks): ");
            int index = scanner.nextInt();
            scanner.nextLine();
            Item item = LoginSystem.reportedItems.get(index);
            item.setStatus("Claimed");
            System.out.println("Item ditandai sebagai 'Claimed'.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indeks tidak valid.");
        } catch (InputMismatchException e) {
            System.out.println("Input harus angka.");
        }
    }

    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa");
        System.out.print("Pilih: ");
        int pilih = scanner.nextInt();
        scanner.nextLine();

        if (pilih == 1) {
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("NIM: ");
            String nim = scanner.nextLine();
            LoginSystem.userList.add(new Mahasiswa(nama, nim));
            System.out.println("Mahasiswa ditambahkan.");
        } else if (pilih == 2) {
            System.out.print("NIM Mahasiswa: ");
            String nim = scanner.nextLine();
            Iterator<User> it = LoginSystem.userList.iterator();
            while (it.hasNext()) {
                User u = it.next();
                if (u instanceof Mahasiswa && u.getPassword().equals(nim)) {
                    it.remove();
                    System.out.println("Mahasiswa dihapus.");
                    return;
                }
            }
            System.out.println("Mahasiswa tidak ditemukan.");
        }
    }
}
