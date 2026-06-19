package bagian1.berkas;

import java.io.File;

public class LatihanMandiriStreamdanFile1 {
    public static void main(String[] args) {
        File file = new File("laporan.txt");

        if (file.exists()) {
            System.out.println("Berkas laporan.txt ada.");
            System.out.println("Ukuran berkas: " + file.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak ada.");
        }
    }
}