import java.io.*;
import java.util.*;

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

    public static void saveVisitorData(Pengunjung pengunjung) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dataPengunjung.txt", true))) {
            writer.write("ID: " + pengunjung.getId() + ", Name: " + pengunjung.getNama() +
                    ", Umur: " + pengunjung.getUmur() + ", Ticket: " + pengunjung.getTiket().getTipe());
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error saving visitor data: " + e.getMessage());
        }
    }
}