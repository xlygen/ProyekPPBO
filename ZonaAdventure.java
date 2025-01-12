class ZonaAdventure extends zonaWisata implements Fasilitas {

    public ZonaAdventure(String nama, String deskripsi, boolean opeasional, int jumlahKapasitas) {
        super(nama, deskripsi, opeasional, jumlahKapasitas);
    }

    @Override
    public String getLayanan() {
        return "Gear Adventure atau Perlengkapan Outdor";
    }
}