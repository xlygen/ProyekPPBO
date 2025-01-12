public abstract class zonaWisata {
    private String nama;
    private String Deskripsi;
    private boolean Opeasional;
    private int jumlahKapasitas;

    public zonaWisata(String nama, String deskripsi, boolean opeasional, int jumlahKapasitas) {
        this.nama = nama;
        Deskripsi = deskripsi;
        Opeasional = opeasional;
        this.jumlahKapasitas = jumlahKapasitas;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public boolean isOpeasional() {
        return Opeasional;
    }

    public int getJumlahKapasitas() {
        return jumlahKapasitas;
    }

}
