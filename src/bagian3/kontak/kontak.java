package bagian3.kontak;

public class kontak {
    // Atribut
    private String nama;
    private String nomor;
    private String email;

    // Constructor
    public kontak(String nama, String nomor, String email) {
        this.nama = nama;
        this.nomor = nomor;
        this.email = email;
    }

    // Getter
    public String getNama() {
        return nama;
    }

    public String getNomor() {
        return nomor;
    }

    public String getEmail() {
        return email;
    }

    // Mengubah objek menjadi satu baris teks untuk disimpan ke berkas
    public String keBaris() {
        return nama + ";" + nomor + ";" + email;
    }

    // Menampilkan informasi kontak
    public String info() {
        return nama + " - " + nomor + " - " + email;
    }
}