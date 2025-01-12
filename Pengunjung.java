public class Pengunjung {
    private int id;
    private String nama;
    private  Tiket tiket;
    private int umur;

    public Pengunjung(int id, String nama, Tiket tiket, int umur) {
        this.id = id;
        this.nama = nama;
        this.tiket = tiket;
        this.umur = umur;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public Tiket getTiket() {
        return tiket;
    }

    public int getUmur() {
        return umur;
    }
    
}
