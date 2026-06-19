//Nama : Saidilah
//NPM : 2510010501
package tugas;

public class MainTugas {
    public static void main(String[] args) {
        String[] kategori = {"Makanan", "Minuman", "Alat Tulis"};

        System.out.println("Daftar Kategori Barang:");
        for (String k : kategori) {
            System.out.println("- " + k);
        }

        System.out.println();

        Gudang gudang = new Gudang();

        gudang.tambahBarang(new Barang("Beras", 15000, 10));
        gudang.tambahBarang(new Barang("Gula", 14000, 8));
        gudang.tambahBarang(new Barang("Minyak Goreng", 18000, 6));
        gudang.tambahBarang(new Barang("Teh Kotak", 5000, 20));
        gudang.tambahBarang(new Barang("Buku Tulis", 7000, 15));

        System.out.println("Data Barang di Gudang:");
        gudang.tampilkanSemua();

        System.out.println();

        gudang.simpanKeBerkas("barang.txt");

        System.out.println();

        Gudang gudangBaru = new Gudang();
        gudangBaru.muatDariBerkas("barang.txt");

        System.out.println();

        System.out.println("Data Barang Setelah Dimuat dari Berkas:");
        gudangBaru.tampilkanSemua();

        System.out.println();

        System.out.println("Total Nilai Persediaan: Rp " + gudangBaru.totalNilai());
    }
}