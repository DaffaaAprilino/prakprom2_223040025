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

  public CameraLoanForm() {
    setLayout(new BorderLayout(10, 10));
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

    // Tanggal Peminjaman
    gbc.gridx = 0;
    gbc.gridy = 5;
    inputPanel.add(new JLabel("Tanggal Peminjaman:"), gbc);
    gbc.gridx = 1;
    loanDateField = new JTextField("YYYY-MM-DD", 20);
    inputPanel.add(loanDateField, gbc);

    // Tanggal Pengembalian
    gbc.gridx = 0;
    gbc.gridy = 6;
    inputPanel.add(new JLabel("Tanggal Pengembalian:"), gbc);
    gbc.gridx = 1;
    returnDateField = new JTextField("YYYY-MM-DD", 20);
    inputPanel.add(returnDateField, gbc);

    // Setuju Syarat & Ketentuan
    gbc.gridx = 0;
    gbc.gridy = 7;
    gbc.gridwidth = 2;
    termsCheckBox = new JCheckBox("Setuju Syarat & Ketentuan");
    inputPanel.add(termsCheckBox, gbc);

    // Tombol Tambah Data
    gbc.gridx = 0;
    gbc.gridy = 8;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.CENTER;
    JButton addButton = new JButton("Tambah");
    inputPanel.add(addButton, gbc);

    // Tabel Riwayat Peminjaman
    String[] columns = { "Nama", "ID", "Alamat", "Jenis Peminjam", "Jenis Kamera", "Tgl Peminjaman",
        "Tgl Pengembalian" };
    tableModel = new DefaultTableModel(columns, 0);
    JTable table = new JTable(tableModel);
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
        String loanDate = loanDateField.getText();
        String returnDate = returnDateField.getText();

        tableModel.addRow(new Object[] { name, id, address, userType, cameraType, loanDate, returnDate });

        // Clear input fields after adding to table
        nameField.setText("");
        idField.setText("");
        addressField.setText("");
        loanDateField.setText("YYYY-MM-DD");
        returnDateField.setText("YYYY-MM-DD");
        userTypeGroup.clearSelection();
        termsCheckBox.setSelected(false);
      }
    });

    add(inputPanel, BorderLayout.NORTH);
    add(tableScrollPane, BorderLayout.CENTER);
  }
}
