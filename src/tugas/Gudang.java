package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gudang {
    private ArrayList<Barang> daftarBarang;

    public Gudang() {
        daftarBarang = new ArrayList<>();
    }

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    public void tampilkanSemua() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada data barang.");
        } else {
            for (Barang barang : daftarBarang) {
                System.out.println(barang.info());
            }
        }
    }

    public void simpanKeBerkas(String namaBerkas) {
        try {
            FileWriter tulis = new FileWriter(namaBerkas);

            for (Barang barang : daftarBarang) {
                tulis.write(barang.keBaris() + "\n");
            }

            tulis.close();
            System.out.println("Data barang berhasil disimpan ke berkas " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data.");
        }
    }

    public void muatDariBerkas(String namaBerkas) {
        try {
            BufferedReader baca = new BufferedReader(new FileReader(namaBerkas));
            String baris;

            while ((baris = baca.readLine()) != null) {
                String[] data = baris.split(";");

                if (data.length == 3) {
                    String nama = data[0];
                    double harga = Double.parseDouble(data[1]);
                    int stok = Integer.parseInt(data[2]);

                    Barang barang = new Barang(nama, harga, stok);
                    daftarBarang.add(barang);
                }
            }

            baca.close();
            System.out.println("Data barang berhasil dimuat dari berkas " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca berkas.");
        }
    }

    public double totalNilai() {
        double total = 0;

        for (Barang barang : daftarBarang) {
            total += barang.getHarga() * barang.getStok();
        }

        return total;
    }
}