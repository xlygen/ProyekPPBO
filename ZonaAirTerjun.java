class ZonaAirTerjun extends zonaWisata implements Fasilitas {


    public ZonaAirTerjun(String nama, String deskripsi, boolean opeasional, int jumlahKapasitas) {
        super(nama, deskripsi, opeasional, jumlahKapasitas);
    }

    @Override
    public String getLayanan() {
        return "Pelampung";

    }
}