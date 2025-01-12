public class Tiket {
    private String Tipe;
    private int harga;

    public Tiket(String tipe, int harga) {
        Tipe = tipe;
        this.harga = harga;
    }

    public String getTipe() {
        return Tipe;
    }

    public int getHarga() {
        return harga;
    }
}