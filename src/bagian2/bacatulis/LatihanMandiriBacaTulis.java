package bagian2.bacatulis;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LatihanMandiriBacaTulis {
    public static void main(String[] args) {

        // 1. Tulis 5 nama hari ke dalam berkas hari.txt
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt"))) {
            penulis.println("Senin");
            penulis.println("Selasa");
            penulis.println("Rabu");
            penulis.println("Kamis");
            penulis.println("Jumat");

            System.out.println("5 nama hari berhasil ditulis ke hari.txt");
        } catch (IOException e) {
            System.out.println("Gagal menulis data: " + e.getMessage());
        }

        // Baca kembali isi hari.txt
        System.out.println("\nIsi awal hari.txt:");
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;

            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca data: " + e.getMessage());
        }

        // 2. Tambahkan 2 nama hari lagi tanpa menghapus isi sebelumnya
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt", true))) {
            penulis.println("Sabtu");
            penulis.println("Minggu");

            System.out.println("\n2 nama hari berhasil ditambahkan.");
        } catch (IOException e) {
            System.out.println("Gagal menambahkan data: " + e.getMessage());
        }

        // Tampilkan seluruh isi hari.txt setelah ditambahkan
        System.out.println("\nIsi hari.txt setelah ditambahkan:");
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;

            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca data: " + e.getMessage());
        }

        // 3. Hitung jumlah baris dalam hari.txt
        int jumlahBaris = 0;

        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;

            while ((baris = pembaca.readLine()) != null) {
                jumlahBaris++;
            }

            System.out.println("\nJumlah baris dalam hari.txt: " + jumlahBaris);
        } catch (IOException e) {
            System.out.println("Gagal menghitung baris: " + e.getMessage());
        }
    }
}