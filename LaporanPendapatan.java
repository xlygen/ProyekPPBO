import java.io.*;

public class LaporanPendapatan {
    private int totalTiketReguler;
    private int totalTiketPremium;
    private static final String FILE_NAME = "pendapatan.txt";

    public LaporanPendapatan() {
        // Muat data dari file saat objek dibuat
        loadPendapatan();
    }

    public void tambahPenjualan(Tiket tiket) {
        if (tiket.getTipe().equals("Reguler")) {
            totalTiketReguler++;
        } else if (tiket.getTipe().equals("Premium")) {
            totalTiketPremium++;
        }
        // Simpan data ke file setiap ada perubahan
        savePendapatan();
    }

    public String tampilkanLaporan() {
        double pendapatanReguler = totalTiketReguler * 50000;
        double pendapatanPremium = totalTiketPremium * 100000;
        double totalPendapatan = pendapatanReguler + pendapatanPremium;

        return "Laporan Pendapatan Harian:\n" +
                "Tiket Reguler terjual: " + totalTiketReguler + ", Pendapatan: Rp" + pendapatanReguler + "\n" +
                "Tiket Premium terjual: " + totalTiketPremium + ", Pendapatan: Rp" + pendapatanPremium + "\n" +
                "Total Pendapatan: Rp" + totalPendapatan;
    }

    private void savePendapatan() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(totalTiketReguler + "\n");
            writer.write(totalTiketPremium + "\n");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data pendapatan.");
        }
    }

    private void loadPendapatan() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            totalTiketReguler = Integer.parseInt(reader.readLine());
            totalTiketPremium = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {

        }
    }
}
