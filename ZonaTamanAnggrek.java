class ZonaTamanAnggrek extends zonaWisata implements Fasilitas {


    public ZonaTamanAnggrek(String nama, String deskripsi, boolean opeasional, int jumlahKapasitas) {
        super(nama, deskripsi, opeasional, jumlahKapasitas);
    }

    @Override
    public String getLayanan() {
        return "Mobil Taman";
    }
}

    