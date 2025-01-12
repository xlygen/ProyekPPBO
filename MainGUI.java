import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainGUI {
    private static List<Pengunjung> pengunjungList = new ArrayList<>();
    private static List<Pemandu> pemanduList = new ArrayList<>();
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistem Manajemen Taman Wisata");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Selamat Datang di Sistem Manajemen Taman Wisata");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton tambahPengunjung = new JButton("Tambah Pengunjung");
        JButton laporanPendapatan = new JButton("Lihat Laporan Pendapatan");
        JButton pemanduTersedia = new JButton("Lihat Pemandu Tersedia");
        JButton Fasilitas = new JButton("Lihat Fasilitas");
        JButton zonaWisata = new JButton("Lihat Zona Wisata");

        JPanel panel = new JPanel();
        panel.add(tambahPengunjung);
        panel.add(pemanduTersedia);

        frame.add(label, "North");
        frame.add(panel, "Center");

        // Menambahkan beberapa pemandu untuk contoh
        pemanduList.add(new Pemandu(330, "Faishal", "Zona Adventure", "Senin - kamis"));
        pemanduList.add(new Pemandu(333, "Rindra", "Zona Taman Angrek", "Selasa - Sabtu"));
        pemanduList.add(new Pemandu(335, "Rofiq", "Zona Kebun Binatang", "senin - Minggu"));
        pemanduList.add(new Pemandu(342, "Dimas", "Zona Air Terjun", "Sabtu - Minggu"));

        tambahPengunjung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Input Data Pengunjung
                    String idStr = JOptionPane.showInputDialog(frame, "Masukkan ID Pengunjung:");
                    String nama = JOptionPane.showInputDialog(frame, "Masukkan Nama Pengunjung:");
                    String umurStr = JOptionPane.showInputDialog(frame, "Masukkan Umur Pengunjung:");

                    if (idStr == null || nama == null || umurStr == null || idStr.isEmpty() || nama.isEmpty() || umurStr.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Data tidak lengkap!");
                        return;
                    }

                    int id = Integer.parseInt(idStr);
                    int umur = Integer.parseInt(umurStr);
                    
                    // Pilihan tiket
                    String[] ticketOptions = {"Reguler", "Premium"};
                    String tipeTiket = (String) JOptionPane.showInputDialog(frame, "Pilih Tipe Tiket:",
                            "Tipe Tiket", JOptionPane.QUESTION_MESSAGE, null, ticketOptions, ticketOptions[0]);

                    Tiket tiket;
                    if ("Reguler".equalsIgnoreCase(tipeTiket)) {
                        tiket = new tiketReguler();
                    } else {
                        tiket = new tiketPremium();
                    }
                    
                    Pengunjung pengunjung = new Pengunjung(id, nama, tiket, umur);
                    pengunjungList.add(pengunjung);

                    JOptionPane.showMessageDialog(frame, "Pengunjung berhasil ditambahkan.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Input tidak valid!");
                }
            }
        });

        pemanduTersedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder pemanduInfo = new StringBuilder();
                for (Pemandu pemandu : pemanduList) {
                    pemanduInfo.append("ID: ").append(pemandu.getId())
                            .append(", Nama: ").append(pemandu.getNama())
                            .append(", Zona: ").append(pemandu.getZonaBekerja())
                            .append(", Jadwal: ").append(pemandu.getJadwal())
                            .append("\n");
                }
                JOptionPane.showMessageDialog(frame, pemanduInfo.toString());
            }
        });
        
        frame.setVisible(true);
    }
}
