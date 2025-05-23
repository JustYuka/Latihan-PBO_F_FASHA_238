package com.praktikum.main;

import com.praktikum.models.Item;
import com.praktikum.users.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        userList.add(new Admin("admin", "admin123"));
        userList.add(new Mahasiswa("Mahasiswa", "Mahasiswa123"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Username/Nama: ");
            String user = scanner.nextLine();
            System.out.print("Password/NIM: ");
            String pass = scanner.nextLine();

            User loggedIn = null;
            for (User u : userList) {
                if (u.getUsername().equals(user) && u.getPassword().equals(pass)) {
                    loggedIn = u;
                    break;
                }
            }

            if (loggedIn != null) {
                loggedIn.displayAppMenu();
            } else {
                System.out.println("Login gagal.");
            }
        }
    }
}
