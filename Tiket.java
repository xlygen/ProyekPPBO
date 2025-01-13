public class Tiket {
    private String Tipe;
    private int harga;

    // Constructor utama
    public Tiket(String tipe, int harga) {
        Tipe = tipe;
        this.harga = harga;
    }

    // Constructor overload: default tipe tiket
    public Tiket(int harga) {
        this.Tipe = "Reguler"; // Default tipe tiket
        this.harga = harga;
    }

    // Constructor overload: default harga tiket
    public Tiket(String tipe) {
        this.Tipe = tipe;
        this.harga = 50000;
    }

    public String getTipe() {
        return Tipe;
    }

    public int getHarga() {
        return harga;
    }
}