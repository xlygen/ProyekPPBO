class ZonaKebunBinatang extends zonaWisata implements Fasilitas {


    public ZonaKebunBinatang(String nama, String deskripsi, boolean opeasional, int jumlahKapasitas) {
        super(nama, deskripsi, opeasional, jumlahKapasitas);
    }

    @Override
    public String getLayanan() {
        return "Mobil Ragunan";
    }
}