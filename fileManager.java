import java.io.*;

public class fileManager {

    public static boolean isIdExists(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("dataPengunjung.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID: " + id + ",")) {
                    return true; // ID ditemukan
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading visitor data: " + e.getMessage());
        }
        return false; // ID tidak ditemukan
    }

    // Metode untuk menyimpan data pengunjung ke file, termasuk pemandu yang dipilih
    public static void saveVisitorData(Pengunjung pengunjung, String namaPemandu) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dataPengunjung.txt", true))) {
            // Format penyimpanan data pengunjung
            writer.write("ID: " + pengunjung.getId());
            writer.write(", Nama: " + pengunjung.getNama());
            writer.write(", Umur: " + pengunjung.getUmur());
            writer.write(", Tiket: " + pengunjung.getTiket().getTipe());
            writer.write(", Pemandu: " + namaPemandu);
            writer.newLine(); // Tambahkan baris baru
            writer.write("====================================");
            writer.newLine(); // Baris kosong untuk memisahkan entri
            System.out.println("Data pengunjung berhasil disimpan ke file!");
        } catch (IOException e) {
            System.out.println("Error saving visitor data: " + e.getMessage());
        }
    }
}
