import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Biodata extends JFrame {

    public Biodata() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout()); // Menggunakan GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Memberikan jarak antar komponen
        
        // Judul Form
        JLabel titleLabel = new JLabel("Form Biodata");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Mengatur font judul
        gbc.gridx = 0; // Kolom
        gbc.gridy = 0; // Baris
        gbc.gridwidth = 2; // Memperlebar ke dua kolom
        gbc.anchor = GridBagConstraints.CENTER; // Menyelaraskan judul ke tengah
        this.add(titleLabel, gbc);

        // Nama input
        JLabel labelInput = new JLabel("Nama:");
        gbc.gridwidth = 1; // Kembali ke satu kolom
        gbc.gridx = 0; // Kolom
        gbc.gridy = 1; // Baris
        gbc.anchor = GridBagConstraints.EAST; // Menyelaraskan label ke sebelah kanan
        this.add(labelInput, gbc);

        JTextField textField = new JTextField(20); // Ukuran teks
        gbc.gridx = 1; // Kolom berikutnya
        gbc.anchor = GridBagConstraints.WEST; // Menyelaraskan field teks ke sebelah kiri
        this.add(textField, gbc);

        // Nomor HP input
        JLabel labelHP = new JLabel("Nomor HP:");
        gbc.gridx = 0; // Kembali ke kolom pertama
        gbc.gridy = 2; // Baris berikutnya
        this.add(labelHP, gbc);

        JTextField textHP = new JTextField(20); // Ukuran teks
        gbc.gridx = 1; // Kolom berikutnya
        this.add(textHP, gbc);

        // Jenis Kelamin radio buttons
        JLabel labelGender = new JLabel("Jenis Kelamin:");
        gbc.gridx = 0;
        gbc.gridy = 3; // Baris berikutnya
        this.add(labelGender, gbc);

        JRadioButton radioMale = new JRadioButton("Laki-Laki");
        JRadioButton radioFemale = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioMale);
        genderGroup.add(radioFemale);

        JPanel radioPanel = new JPanel(); // Menggunakan panel untuk radio buttons
        radioPanel.add(radioMale);
        radioPanel.add(radioFemale);
        gbc.gridx = 1; // Kolom berikutnya
        this.add(radioPanel, gbc);

        // Warga Negara Asing checkbox
        JCheckBox checkBoxWNA = new JCheckBox("Warga Negara Asing");
        gbc.gridx = 0;
        gbc.gridy = 4; // Baris berikutnya
        gbc.gridwidth = 2; // Memperlebar checkbox ke dua kolom
        this.add(checkBoxWNA, gbc);

        // Simpan button
        JButton button = new JButton("SIMPAN");
        gbc.gridwidth = 1; // Kembali ke satu kolom
        gbc.gridy = 5; // Baris berikutnya
        gbc.gridx = 1; // Kolom kedua
        this.add(button, gbc);

        // Output area
        JTextArea txtOutput = new JTextArea(5, 20);
        txtOutput.setEditable(false);
        gbc.gridy = 30; // Baris berikutnya
        gbc.gridwidth = 2; // Memperlebar output area ke dua kolom
        this.add(new JScrollPane(txtOutput), gbc); // Menambahkan scroll pane

        // ActionListener for the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textField.getText();
                String nomorHP = textHP.getText();
                String jenisKelamin = radioMale.isSelected() ? "Laki-Laki" : "Perempuan";
                String wnaStatus = checkBoxWNA.isSelected() ? "Ya" : "Bukan";

                txtOutput.append("Nama   : " + nama + "\n");
                txtOutput.append("Nomor HP : " + nomorHP + "\n");
                txtOutput.append("Jenis Kelamin : " + jenisKelamin + "\n");
                txtOutput.append("WNA : " + wnaStatus + "\n");
                txtOutput.append("===========================================\n");

                textField.setText("");
                textHP.setText("");
                genderGroup.clearSelection();
                checkBoxWNA.setSelected(false);
            }
        });

        // Frame settings
        this.setSize(700, 800);
        this.setLocationRelativeTo(null); // Menempatkan frame di tengah layar
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Biodata h = new Biodata();
                h.setVisible(true);
            }
        });
    }
}
