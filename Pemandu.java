public class Pemandu extends User {
    private String zonaBekerja;
    private String Jadwal;

    public Pemandu(int id, String nama, String zonaBekerja, String jadwal) {
        super(id, nama);
        this.zonaBekerja = zonaBekerja;
        Jadwal = jadwal;
    }

    public String getZonaBekerja() {
        return zonaBekerja;
    }

    public String getJadwal() {
        return Jadwal;
    }
}
