import java.util.ArrayList;
import java.util.List;

public class Pengunjung extends User {
    private Tiket tiket;
    private int umur;
    private Pemandu pemandu; // Menyimpan pemandu yang dipilih oleh pengunjung

    public Pengunjung(int id, String nama, Tiket tiket, int umur) {
        super(id, nama);
        this.tiket = tiket;
        this.umur = umur;
    }

    public Tiket getTiket() {
        return tiket;
    }

    public int getUmur() {
        return umur;
    }

    public Pemandu getPemandu() {
        return pemandu;
    }

    public void pilihPemandu(Pemandu pemandu) {
        this.pemandu = pemandu;
        pemandu.tambahPengunjung(this); // Menambahkan asosiasi balik
    }
}
