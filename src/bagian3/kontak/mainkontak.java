package bagian3.kontak;

public class mainkontak {
    public static void main(String[] args) {
        bukukontak buku = new bukukontak("kontak.txt");

        buku.tambahKontak(new kontak("Andi", "081111", "andi@gmail.com"));
        buku.tambahKontak(new kontak("Budi", "082222", "budi@gmail.com"));
        buku.tambahKontak(new kontak("Citra", "083333", "citra@gmail.com"));

        buku.tampilkanSemua();
        buku.simpanKeBerkas();

        System.out.println();

        // Uji cari kontak
        buku.cariKontak("Budi");
        buku.cariKontak("Dewi");

        System.out.println();

        // Uji hapus kontak
        buku.hapusKontak("Andi");

        System.out.println();

        // Tampilkan data setelah dihapus
        buku.tampilkanSemua();

        System.out.println();

        // Muat ulang dari berkas
        bukukontak bukuLain = new bukukontak("kontak.txt");
        bukuLain.muatDariBerkas();
        bukuLain.tampilkanSemua();

        System.out.println("Jumlah kontak: " + bukuLain.jumlahKontak());
    }
}