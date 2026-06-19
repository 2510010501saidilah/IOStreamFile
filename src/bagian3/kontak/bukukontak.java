package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class bukukontak {
    private ArrayList<kontak> daftar = new ArrayList<>();
    private String namaBerkas;

    public bukukontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    public void tambahKontak(kontak kontak) {
        daftar.add(kontak);
    }

    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");

        for (int i = 0; i < daftar.size(); i++) {
            kontak k = daftar.get(i);
            System.out.println((i + 1) + ". " + k.info());
        }
    }

    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (kontak k : daftar) {
                penulis.println(k.keBaris());
            }

            System.out.println("Kontak disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    public void muatDariBerkas() {
        daftar.clear();

        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;

            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");

                // Karena sekarang data terdiri dari nama, nomor, dan email
                if (bagian.length == 3) {
                    daftar.add(new kontak(bagian[0], bagian[1], bagian[2]));
                }
            }

            System.out.println("Kontak dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    public int jumlahKontak() {
        return daftar.size();
    }

    // 1. Method mencari kontak berdasarkan nama
    public void cariKontak(String nama) {
        boolean ditemukan = false;

        for (kontak k : daftar) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Kontak ditemukan: " + k.info());
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Kontak dengan nama " + nama + " tidak ditemukan.");
        }
    }

    // 3. Method menghapus kontak berdasarkan nama
    public void hapusKontak(String nama) {
        boolean berhasilDihapus = false;

        for (int i = 0; i < daftar.size(); i++) {
            kontak k = daftar.get(i);

            if (k.getNama().equalsIgnoreCase(nama)) {
                daftar.remove(i);
                berhasilDihapus = true;
                System.out.println("Kontak " + nama + " berhasil dihapus.");
                break;
            }
        }

        if (berhasilDihapus) {
            simpanKeBerkas();
        } else {
            System.out.println("Kontak dengan nama " + nama + " tidak ditemukan.");
        }
    }
}