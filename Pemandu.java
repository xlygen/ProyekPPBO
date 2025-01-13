import java.util.ArrayList;
import java.util.List;

public class Pemandu extends User {
    private String zonaBekerja;
    private String Jadwal;
    private List<Pengunjung> pengunjungList; // Menyimpan daftar pengunjung yang dipandu

    public Pemandu(int id, String nama, String zonaBekerja, String jadwal) {
        super(id, nama);
        this.zonaBekerja = zonaBekerja;
        Jadwal = jadwal;
        pengunjungList = new ArrayList<>();
    }

    public String getZonaBekerja() {
        return zonaBekerja;
    }

    public String getJadwal() {
        return Jadwal;
    }

    public List<Pengunjung> getPengunjungList() {
        return pengunjungList;
    }

    public void tambahPengunjung(Pengunjung pengunjung) {
        if (!pengunjungList.contains(pengunjung)) {
            pengunjungList.add(pengunjung);
        }
    }
}
