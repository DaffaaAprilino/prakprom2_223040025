import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Pencatatan Peminjaman Kamera");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(900, 700);

    // MenuBar untuk navigasi
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem reportItem = new JMenuItem("Laporan Peminjaman");
    menu.add(reportItem);
    menuBar.add(menu);
    frame.setJMenuBar(menuBar);

    // Menambahkan form ke frame utama
    frame.setContentPane(new CameraLoanForm());

    frame.setVisible(true);
  }
}
