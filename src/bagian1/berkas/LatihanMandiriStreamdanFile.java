package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiriStreamdanFile {
    public static void main(String[] args) {
        
        // 1. Membuat objek File yang menunjuk laporan.txt
        File laporan = new File("laporan.txt");

        System.out.println("=== Cek Berkas laporan.txt ===");
        if (laporan.exists()) {
            System.out.println("Berkas laporan.txt ada.");
            System.out.println("Ukuran berkas: " + laporan.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak ada.");
        }


        // 2. Membuat folder baru bernama arsip
        File folder = new File("arsip");

        System.out.println("\n=== Membuat Folder arsip ===");
        if (folder.mkdir()) {
            System.out.println("Folder arsip berhasil dibuat.");
        } else {
            System.out.println("Folder arsip gagal dibuat atau sudah ada.");
        }


        // 3. Membuat file sementara.txt lalu menghapusnya
        File sementara = new File("sementara.txt");

        System.out.println("\n=== Membuat dan Menghapus sementara.txt ===");

        try {
            if (sementara.createNewFile()) {
                System.out.println("Berkas sementara.txt berhasil dibuat.");
            } else {
                System.out.println("Berkas sementara.txt sudah ada.");
            }

            System.out.println("Sebelum dihapus, apakah ada? " + sementara.exists());

            if (sementara.delete()) {
                System.out.println("Berkas sementara.txt berhasil dihapus.");
            } else {
                System.out.println("Berkas sementara.txt gagal dihapus.");
            }

            System.out.println("Sesudah dihapus, apakah ada? " + sementara.exists());

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membuat berkas.");
            e.printStackTrace();
        }
    }
}