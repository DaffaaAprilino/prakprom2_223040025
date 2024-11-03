import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CameraLoanForm extends JPanel {
  private JTextField nameField;
  private JTextField idField;
  private JTextArea addressField;
  private JComboBox<String> cameraTypeBox;
  private JRadioButton studentButton;
  private JRadioButton generalButton;
  private JCheckBox termsCheckBox;
  private JTextField loanDateField;
  private JTextField returnDateField;
  private DefaultTableModel tableModel;
  private JList<String> accessoriesList;
  private JSlider loanDurationSlider;
  private JSpinner cameraCountSpinner;
  private JTable table;

  public CameraLoanForm() {
    setLayout(new GridLayout(1, 2, 10, 10));
    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // Panel Form Input
    JPanel inputPanel = new JPanel(new GridBagLayout());
    inputPanel.setBorder(BorderFactory.createTitledBorder("Form Peminjaman Kamera"));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    // Nama Peminjam
    gbc.gridx = 0;
    gbc.gridy = 0;
    inputPanel.add(new JLabel("Nama Peminjam:"), gbc);
    gbc.gridx = 1;
    nameField = new JTextField(20);
    inputPanel.add(nameField, gbc);

    // ID Peminjam
    gbc.gridx = 0;
    gbc.gridy = 1;
    inputPanel.add(new JLabel("ID Peminjam:"), gbc);
    gbc.gridx = 1;
    idField = new JTextField(20);
    inputPanel.add(idField, gbc);

    // Alamat Peminjam
    gbc.gridx = 0;
    gbc.gridy = 2;
    inputPanel.add(new JLabel("Alamat Peminjam:"), gbc);
    gbc.gridx = 1;
    addressField = new JTextArea(3, 20);
    JScrollPane addressScrollPane = new JScrollPane(addressField);
    inputPanel.add(addressScrollPane, gbc);

    // Jenis Peminjam
    gbc.gridx = 0;
    gbc.gridy = 3;
    inputPanel.add(new JLabel("Jenis Peminjam:"), gbc);
    gbc.gridx = 1;
    JPanel userTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    studentButton = new JRadioButton("Mahasiswa");
    generalButton = new JRadioButton("Umum");
    ButtonGroup userTypeGroup = new ButtonGroup();
    userTypeGroup.add(studentButton);
    userTypeGroup.add(generalButton);
    userTypePanel.add(studentButton);
    userTypePanel.add(generalButton);
    inputPanel.add(userTypePanel, gbc);

    // Jenis Kamera
    gbc.gridx = 0;
    gbc.gridy = 4;
    inputPanel.add(new JLabel("Jenis Kamera:"), gbc);
    gbc.gridx = 1;
    cameraTypeBox = new JComboBox<>(new String[] { "Canon EOS", "Nikon D850", "Sony A7 III" });
    inputPanel.add(cameraTypeBox, gbc);

    // Aksesori Tambahan (JList)
    gbc.gridx = 0;
    gbc.gridy = 5;
    inputPanel.add(new JLabel("Aksesori Tambahan:"), gbc);
    gbc.gridx = 1;
    accessoriesList = new JList<>(new String[] { "Tripod", "Lensa Tambahan", "Baterai Cadangan" });
    accessoriesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    JScrollPane accessoriesScrollPane = new JScrollPane(accessoriesList);
    inputPanel.add(accessoriesScrollPane, gbc);

    // Panel untuk Durasi Peminjaman dan Jumlah Kamera
    JPanel loanInfoPanel = new JPanel(new GridLayout(2, 2, 5, 5));

    // Durasi Peminjaman (JSlider)
    loanInfoPanel.add(new JLabel("Durasi Peminjaman (hari):"));
    loanDurationSlider = new JSlider(1, 30, 7);
    loanDurationSlider.setMajorTickSpacing(5);
    loanDurationSlider.setPaintTicks(true);
    loanDurationSlider.setPaintLabels(true);
    loanInfoPanel.add(loanDurationSlider);

    // Jumlah Kamera (JSpinner)
    loanInfoPanel.add(new JLabel("Jumlah Kamera:"));
    cameraCountSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
    loanInfoPanel.add(cameraCountSpinner);

    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 2; // Mengatur lebar panel untuk memasukkan info pinjaman
    inputPanel.add(loanInfoPanel, gbc);

    // Tanggal Peminjaman
    gbc.gridwidth = 1; // Reset lebar panel
    gbc.gridx = 0;
    gbc.gridy = 7;
    inputPanel.add(new JLabel("Tanggal Peminjaman:"), gbc);
    gbc.gridx = 1;
    loanDateField = new JTextField("YYYY-MM-DD", 20);
    inputPanel.add(loanDateField, gbc);

    // Tanggal Pengembalian
    gbc.gridx = 0;
    gbc.gridy = 8;
    inputPanel.add(new JLabel("Tanggal Pengembalian:"), gbc);
    gbc.gridx = 1;
    returnDateField = new JTextField("YYYY-MM-DD", 20);
    inputPanel.add(returnDateField, gbc);

    // Setuju Syarat & Ketentuan
    gbc.gridx = 0;
    gbc.gridy = 9;
    gbc.gridwidth = 2;
    termsCheckBox = new JCheckBox("Setuju Syarat & Ketentuan");
    inputPanel.add(termsCheckBox, gbc);

    // Tombol Tambah Data dan Hapus Data
    gbc.gridx = 0;
    gbc.gridy = 10;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.CENTER;
    JPanel buttonPanel = new JPanel();
    JButton addButton = new JButton("Tambah");
    JButton deleteButton = new JButton("Hapus");
    buttonPanel.add(addButton);
    buttonPanel.add(deleteButton);
    inputPanel.add(buttonPanel, gbc);

    // Tabel Riwayat Peminjaman
    String[] columns = { "Nama", "ID", "Alamat", "Jenis Peminjam", "Jenis Kamera", "Aksesori", "Durasi (hari)",
        "Jumlah", "Tgl Peminjaman", "Tgl Pengembalian" };
    tableModel = new DefaultTableModel(columns, 0);
    table = new JTable(tableModel);
    JScrollPane tableScrollPane = new JScrollPane(table);
    tableScrollPane.setBorder(BorderFactory.createTitledBorder("Riwayat Peminjaman"));

    // Action untuk menambah data ke tabel
    addButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (!termsCheckBox.isSelected()) {
          JOptionPane.showMessageDialog(null, "Harap menyetujui syarat dan ketentuan!");
          return;
        }

        String name = nameField.getText();
        String id = idField.getText();
        String address = addressField.getText();
        String userType = studentButton.isSelected() ? "Mahasiswa" : "Umum";
        String cameraType = (String) cameraTypeBox.getSelectedItem();
        String accessories = String.join(", ", accessoriesList.getSelectedValuesList());
        int duration = loanDurationSlider.getValue();
        int cameraCount = (int) cameraCountSpinner.getValue();
        String loanDate = loanDateField.getText();
        String returnDate = returnDateField.getText();

        // Tambahkan data ke tabel
        tableModel.addRow(new Object[] { name, id, address, userType, cameraType, accessories, duration, cameraCount,
            loanDate, returnDate });

        // Tampilkan dialog pop-up dengan laporan peminjaman
        String report = "Laporan Peminjaman:\n" +
            "Nama: " + name + "\n" +
            "ID: " + id + "\n" +
            "Alamat: " + address + "\n" +
            "Jenis Peminjam: " + userType + "\n" +
            "Jenis Kamera: " + cameraType + "\n" +
            "Aksesori: " + accessories + "\n" +
            "Durasi: " + duration + " hari\n" +
            "Jumlah: " + cameraCount + "\n" +
            "Tanggal Peminjaman: " + loanDate + "\n" +
            "Tanggal Pengembalian: " + returnDate;
        JOptionPane.showMessageDialog(null, report, "Laporan Peminjaman", JOptionPane.INFORMATION_MESSAGE);

        // Clear input fields after adding to table
        nameField.setText("");
        idField.setText("");
        addressField.setText("");
        loanDateField.setText("YYYY-MM-DD");
        returnDateField.setText("YYYY-MM-DD");
        userTypeGroup.clearSelection();
        accessoriesList.clearSelection();
        loanDurationSlider.setValue(7);
        cameraCountSpinner.setValue(1);
        termsCheckBox.setSelected(false);
      }
    });

    // Action untuk menghapus data dari tabel
    deleteButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
          tableModel.removeRow(selectedRow);
          JOptionPane.showMessageDialog(null, "Data berhasil dihapus.");
        } else {
          JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus.");
        }
      }
    });

    // Menambahkan panel input dan tabel ke dalam layout utama
    add(inputPanel);
    add(tableScrollPane);
  }
}
