import java.awt.event.*;
import javax.swing.*;

public class Latihan4 extends JFrame {
  public Latihan4() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel labelInput = new JLabel("Input Nama");
    labelInput.setBounds(130, 40, 100, 10);

    JTextField textField = new JTextField();
    textField.setBounds(130, 60, 100, 30);

    JLabel labelInput2 = new JLabel("Input No. HP");
    labelInput2.setBounds(130, 100, 100, 10);

    JTextField textField2 = new JTextField();
    textField2.setBounds(130, 120, 100, 30);

    JButton button = new JButton("Klik");
    button.setBounds(130, 160, 100, 40);

    JLabel labelInput3 = new JLabel("Daftar Kontak");
    labelInput3.setBounds(130, 210, 100, 10);

    JTextArea txtOutput = new JTextArea("");
    txtOutput.setBounds(130, 230, 100, 100);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String nama = textField.getText();
        String nohp = textField2.getText();
        txtOutput.append(nama + " | " + nohp + "\n");
        txtOutput.append("==============\n");
        textField.setText("");
        textField2.setText("");
      }
    });

    this.add(button);
    this.add(labelInput);
    this.add(textField);
    this.add(labelInput2);
    this.add(textField2);
    this.add(labelInput3);
    this.add(txtOutput);

    this.setSize(400, 500);
    this.setLayout(null);

  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        Latihan4 h = new Latihan4();
        h.setVisible(true);
      }
    });
  }
}