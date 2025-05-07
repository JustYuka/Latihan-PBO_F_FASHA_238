package com.praktikum.main;

import com.praktikum.users.*;

import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user;

        System.out.println("=== Sistem Login ===");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        if (username.equals("admin")) {
            user = new Admin("admin", "admin123");
        } else {
            user = new Mahasiswa("mahasiswa", "pass123");
        }

        if (user.login(username, password)) {
            System.out.println("Login berhasil!");
            user.displayAppMenu();
        } else {
            System.out.println("Login gagal!");
        }
    }
}
