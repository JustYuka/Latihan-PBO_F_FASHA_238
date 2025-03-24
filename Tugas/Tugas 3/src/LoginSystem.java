import java.util.Scanner;

class User {
    private String nama;
    private String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public void login() {
        System.out.println("Silakan login sebagai Admin atau Mahasiswa.");
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama + ", NIM: " + nim);
    }
}

class Admin extends User {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan username: ");
        String userInput = input.next();
        System.out.print("Masukkan password: ");
        String passInput = input.next();

        if (userInput.equals(username) && passInput.equals(password)) {
            System.out.println("Login berhasil sebagai Admin!");
            displayInfo();
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin " + getNama() + " berhasil login.");
    }
}

class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama: ");
        String namaInput = input.next();
        System.out.print("Masukkan NIM: ");
        String nimInput = input.next();

        if (namaInput.equals(getNama()) && nimInput.equals(getNim())) {
            System.out.println("Login berhasil sebagai Mahasiswa!");
            displayInfo();
        } else {
            System.out.println("Login gagal. Nama atau NIM salah.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Mahasiswa " + getNama() + " berhasil login.");
    }
}

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Admin UMM", "0001", "Yuka12", "1234");
        Mahasiswa mahasiswa = new Mahasiswa("Yuka", "180320");

        System.out.println("Pilih login sebagai:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();

        if (pilihan == 1) {
            admin.login();
        } else if (pilihan == 2) {
            mahasiswa.login();
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
}
