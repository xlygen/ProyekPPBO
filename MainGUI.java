import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainGUI {
    private static List<Pengunjung> pengunjungList = new ArrayList<>();
    private static List<Pemandu> pemanduList = new ArrayList<>();
    private static LaporanPendapatan lpd = new LaporanPendapatan();
    private static List<zonaWisata> zonaList = new ArrayList<>();
    private static Fasilitas fasilitas = new Fasilitas() {
        @Override
        public String getLayanan() {
            return "";
        }
    };
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
        panel.add(laporanPendapatan);
        panel.add(pemanduTersedia);
        panel.add(Fasilitas);
        panel.add(zonaWisata);

        frame.add(label, "North");
        frame.add(panel, "Center");

        // Menambahkan beberapa pemandu untuk contoh
        pemanduList.add(new Pemandu(330, "Faishal", "Zona Adventure", "Senin - kamis"));
        pemanduList.add(new Pemandu(333, "Rindra", "Zona Taman Angrek", "Selasa - Sabtu"));
        pemanduList.add(new Pemandu(335, "Rofiq", "Zona Kebun Binatang", "senin - Minggu"));
        pemanduList.add(new Pemandu(342, "Dimas", "Zona Air Terjun", "Sabtu - Minggu"));

        // Menambahkan Zona List    
        zonaList.add(new ZonaAdventure("Zona Adventure", "Tempat petualangan seru", true, 100));
        zonaList.add(new ZonaTamanAnggrek("Zona Taman Anggrek", "Koleksi bunga anggrek indah", true, 50));
        zonaList.add(new ZonaKebunBinatang("Zona Kebun Binatang", "Melihat hewan eksotis", true, 75));
        zonaList.add(new ZonaAirTerjun("Zona Air Terjun", "Bermain Air", false, 30));

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
                    
                    // Periksa apakah ID sudah ada
                    if (fileManager.isIdExists(id)) {
                        JOptionPane.showMessageDialog(frame, "ID sudah ada di sistem! Penambahan gagal.");
                        return;
                    }

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
                     //menyimpan file
                     fileManager.saveVisitorData(pengunjung);
                     // laporan pendapatan
                     lpd.tambahPenjualan(tiket);

                    JOptionPane.showMessageDialog(frame, "Pengunjung berhasil ditambahkan.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Input tidak valid!");
                }
            }
        });
        
        //Laporan Pendapatan
        laporanPendapatan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String laporan = lpd.tampilkanLaporan();
                    JOptionPane.showMessageDialog(frame, laporan);
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

        //Fasilitas
        Fasilitas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder fasilitasInfo = new StringBuilder("Fasilitas:\n\n");

                for (zonaWisata zona : zonaList) {
                    fasilitasInfo.append("Nama Zona: ").append(zona.getNama()).append("\n")
                            .append("Fasilitas: ").append(zona instanceof Fasilitas ? ((Fasilitas) zona).getLayanan() : "Tidak tersedia")
                            .append("\n\n");
                }

                JOptionPane.showMessageDialog(frame, fasilitasInfo.toString());
            }
        });

        zonaWisata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder zonaInfo = new StringBuilder("Informasi Zona Wisata:\n\n");

                for (zonaWisata zona : zonaList) {
                    zonaInfo.append("Nama Zona: ").append(zona.getNama()).append("\n")
                            .append("Deskripsi: ").append(zona.getDeskripsi()).append("\n")
                            .append("Operasional: ").append(zona.isOpeasional() ? "Buka" : "Tutup").append("\n")
                            .append("Kapasitas Maksimal: ").append(zona.getJumlahKapasitas()).append("\n\n");
                }

                JOptionPane.showMessageDialog(frame, zonaInfo.toString());
            }
        });
        
        frame.setVisible(true);
    }
}
