import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Pencatatan Peminjaman Kamera");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(900, 700);

    // MenuBar untuk navigasi
    JMenuBar menuBar = new JMenuBar();

    // Menu Utama
    JMenu menu = new JMenu("Menu");
    JMenuItem reportItem = new JMenuItem("Laporan Peminjaman");
    reportItem.addActionListener(e -> {
      JOptionPane.showMessageDialog(frame, "Menampilkan laporan peminjaman...");
      // Di sini Anda bisa menampilkan laporan dalam bentuk dialog atau panel baru
    });
    menu.add(reportItem);

    // Menu Bantuan
    JMenu helpMenu = new JMenu("Bantuan");
    JMenuItem helpItem = new JMenuItem("Cara Penggunaan");
    helpItem.addActionListener(e -> {
      JOptionPane.showMessageDialog(frame,
          "Cara Penggunaan:\n1. Isi semua kolom pada formulir.\n" +
              "2. Pilih aksesori tambahan jika diperlukan.\n" +
              "3. Setujui syarat & ketentuan sebelum menambahkan data ke tabel.\n" +
              "4. Gunakan opsi Menu untuk melihat laporan peminjaman.");
    });
    helpMenu.add(helpItem);

    // Menu Pengaturan
    JMenu settingsMenu = new JMenu("Pengaturan");
    JMenuItem preferencesItem = new JMenuItem("Preferensi");
    preferencesItem.addActionListener(e -> {
      JOptionPane.showMessageDialog(frame, "Pengaturan preferensi pengguna...");
      // Anda bisa membuat dialog pengaturan lebih lanjut di sini
    });
    settingsMenu.add(preferencesItem);

    // Menambahkan semua menu ke menu bar
    menuBar.add(menu);
    menuBar.add(helpMenu);
    menuBar.add(settingsMenu);
    frame.setJMenuBar(menuBar);

    // Menambahkan form ke frame utama
    frame.setContentPane(new CameraLoanForm());

    frame.setVisible(true);
  }
}
