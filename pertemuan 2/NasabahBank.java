import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class NasabahBank extends JFrame {
  public NasabahBank() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // MODIFIKASI LAT 7
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel labelInput = new JLabel("Nama");
    labelInput.setBounds(15, 10, 350, 10);

    JTextField textField = new JTextField();
    textField.setBounds(15, 30, 350, 30);

    JLabel labelInput2 = new JLabel("Nomor HP: ");
    labelInput2.setBounds(15, 80, 350, 10);

    JTextField textField2 = new JTextField();
    textField2.setBounds(15, 100, 350, 30);

    JLabel labelRadio = new JLabel("Jenis Kelamin");
    labelRadio.setBounds(15, 150, 350, 10);

    JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
    radioButton1.setBounds(15, 165, 350, 30);

    JRadioButton radioButton2 = new JRadioButton("Perempuan");
    radioButton2.setBounds(15, 185, 350, 30);

    ButtonGroup bg = new ButtonGroup();
    bg.add(radioButton1);
    bg.add(radioButton2);

    JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
    checkBox.setBounds(15, 220, 350, 30);

    checkBox.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
      }
    });

    JLabel labelTabungan = new JLabel("Jenis Tabungan");
    labelTabungan.setBounds(15, 260, 350, 10);

    // TIPE JENIS REKENING MENGGUNAKAN SINGLE VALUE JLIST
    String[] tabungan = { "Junior", "Silver GPN", "Gold GPN", "Platinum GPN" };
    JList<String> tipeTabungan = new JList<>(tabungan);
    tipeTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tipeTabungan.setLayoutOrientation(JList.VERTICAL_WRAP);
    tipeTabungan.setVisibleRowCount(-1);
    tipeTabungan.setBounds(15, 280, 350, 70);
    this.add(tipeTabungan);

    // BUATLAH MENU!!
    JMenuBar menuBar = new JMenuBar();

    // MENU UTAMA
    JMenu menu = new JMenu("Menu");
    menu.getAccessibleContext().setAccessibleDescription(
        "Menu Aplikasi");
    menuBar.add(menu);

    // SUB MENU RESET
    JMenuItem menuItemReset = new JMenuItem("Reset", KeyEvent.VK_R);
    menuItemReset.getAccessibleContext().setAccessibleDescription("Reset semua form");
    menu.add(menuItemReset);

    // SUB MENU EXIT
    JMenuItem menuItemExit = new JMenuItem("Exit", KeyEvent.VK_E);
    menuItemExit.getAccessibleContext().setAccessibleDescription("Exit aplikasi");
    menu.add(menuItemExit);

    // JSLIDER FREKUENSI TRANSAKSI
    JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi");
    labelFrekuensi.setBounds(15, 320, 350, 100);

    JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 100, 1);
    slider.setBounds(15, 390, 350, 50);
    slider.setMajorTickSpacing(10);
    slider.setMinorTickSpacing(1);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);

    JLabel valueFrekuensi = new JLabel("Frekuensi");
    valueFrekuensi.setBounds(15, 400, 350, 100);

    slider.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        valueFrekuensi.setText(slider.getValue() + " transaksi");
      }
    });

    // BUATKAN PASSWORD
    JLabel labelPassword = new JLabel("Password");
    labelPassword.setBounds(15, 470, 350, 30);

    JPasswordField passwordField = new JPasswordField();
    passwordField.setBounds(15, 500, 350, 30);

    // KONFIRMASI PASSWORD
    JLabel labelConfirmPassword = new JLabel("Confirm Password");
    labelConfirmPassword.setBounds(15, 530, 350, 30);

    JPasswordField confirmPasswordField = new JPasswordField();
    confirmPasswordField.setBounds(15, 560, 350, 30);

    // TANGGAL LAHIR MENGGUNAKAN JSPINNER
    JLabel labelTanggalLahir = new JLabel("Tanggal Lahir");
    labelTanggalLahir.setBounds(15, 600, 350, 30);
    this.add(labelTanggalLahir);

    // LABEL Tanggal
    JLabel labelTanggal = new JLabel("Tanggal:");
    labelTanggal.setBounds(15, 620, 50, 30);
    this.add(labelTanggal);

    // SPINNER TANGGAL
    JSpinner spinnerTanggal = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
    spinnerTanggal.setBounds(150, 620, 200, 30);
    this.add(spinnerTanggal);

    // LABEL BULAN
    JLabel labelBulan = new JLabel("Bulan:");
    labelBulan.setBounds(15, 660, 50, 30);
    this.add(labelBulan);

    // SPINNER BULAN
    JSpinner spinnerBulan = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
    spinnerBulan.setBounds(150, 660, 200, 30);
    this.add(spinnerBulan);

    // LABEL TAHUN
    JLabel labelTahun = new JLabel("Tahun:");
    labelTahun.setBounds(15, 700, 50, 30);
    this.add(labelTahun);

    // SPINNER TAHUN
    JSpinner spinnerTahun = new JSpinner(new SpinnerNumberModel(1900, 1900, 2100, 1));
    spinnerTahun.setBounds(150, 700, 200, 30);
    this.add(spinnerTahun);

    // BUTTON SIMPAN
    JButton buttonSimpan = new JButton("Simpan");
    buttonSimpan.setBounds(15, 740, 100, 30);
    this.add(buttonSimpan);

    // TAMPILAN TEXTAREA
    JLabel labelNasabah = new JLabel("Tabungan Nasabah");
    labelNasabah.setBounds(15, 780, 350, 30);
    this.add(labelNasabah);

    JTextArea textarea = new JTextArea();
    textarea.setBounds(15, 810, 350, 160);
    this.add(textarea);

    // EVENTLISTERNER KETIKA BUTTON SIMPAN DIGUNAKAN, MAKA AKAN TAMPILKAN INPUTAN
    // DIATAS
    buttonSimpan.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        textarea.setText("");
        if (password.equals(confirmPassword)) {
          JOptionPane.showMessageDialog(null, "Data berhasil disimpan!", "Simpan", JOptionPane.INFORMATION_MESSAGE);
          String jenisKelamin = "";
          String WNA = "";
          if (radioButton1.isSelected()) {
            jenisKelamin = radioButton1.getText();
          }
          if (radioButton2.isSelected()) {
            jenisKelamin = radioButton2.getText();
          }

          if (checkBox.isSelected()) {
            WNA = "Ya";
          } else {
            WNA = "Tidak";
          }

          String nama = textField.getText();
          String nohp = textField2.getText();
          textarea.append("Nama: " + nama + "\n");
          textarea.append("Nomor HP: " + nohp + "\n");
          textarea.append("Jenis Kelamin: " + jenisKelamin + "\n");
          textarea.append("WNA: " + WNA + "\n");
          textarea.append("Jenis Tabungan: " + tipeTabungan.getSelectedValue() + "\n");
          textarea.append("Frekuensi Transaksi: " + slider.getValue() + "\n");
          textarea.append("Tanggal Lahir: " + spinnerTanggal.getValue() + "/" + spinnerBulan.getValue() + "/"
              + spinnerTahun.getValue() + "\n");
          textarea.append("Password: BENAR/SAMA\n");
        } else {
          JOptionPane.showMessageDialog(null, "Password yang anda masukkan salah!", "Error", JOptionPane.ERROR_MESSAGE);
          textarea.setText("Password Salah!");
        }
      }
    });

    // MENU LISTENER
    menuItemReset.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // reset semua form
        tipeTabungan.clearSelection();
        slider.setValue(0);

        passwordField.setText("");
        confirmPasswordField.setText("");

        spinnerTanggal.setValue(1);
        spinnerBulan.setValue(1);
        spinnerTahun.setValue(1900);

        textField.setText("");
        textField2.setText("");
        bg.clearSelection();
        checkBox.setSelected(false);

        textarea.setText("");
        JOptionPane.showMessageDialog(null, "Form telah direset!", "Reset", JOptionPane.INFORMATION_MESSAGE);

      }
    });

    menuItemExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    // INISIASI
    this.add(labelTabungan);
    this.add(labelPassword);
    this.add(passwordField);
    this.add(labelConfirmPassword);
    this.add(confirmPasswordField);
    this.add(labelFrekuensi);
    this.add(slider);
    // this.add(tipeTabungan);
    this.add(valueFrekuensi);
    this.setJMenuBar(menuBar);

    this.add(textField);
    this.add(textField2);
    this.add(labelRadio);
    this.add(radioButton1);
    this.add(radioButton2);
    this.add(labelInput2);
    this.add(labelInput);
    this.add(checkBox);

    this.setSize(400, 1000);
    this.setLayout(null);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        NasabahBank h = new NasabahBank();
        h.setVisible(true);
      }
    });
  }
}