/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/**
 *
 * @author Admin
 */
import javax.swing.*;
import java.awt.event.ActionEvent;

public class exfour {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chuyen đoi nhiet do");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        JLabel labelC = new JLabel("Nhap do C:");
        labelC.setBounds(20, 20, 100, 25);
        frame.add(labelC);

        JTextField txtC = new JTextField();
        txtC.setBounds(120, 20, 150, 25);
        frame.add(txtC);
        JButton btnConvert = new JButton("Chuyen sang do F");
        btnConvert.setBounds(20, 60, 250, 30);
        frame.add(btnConvert);

        JLabel lblResult = new JLabel("Ket qua: ");
        lblResult.setBounds(20, 100, 250, 25);
        frame.add(lblResult);

        btnConvert.addActionListener((ActionEvent e) -> {
            try {
                double celsius = Double.parseDouble(txtC.getText());

                double fahrenheit = (celsius * 9 / 5) + 32;
                lblResult.setText("Ket qua: " + String.format("%.2f", fahrenheit) + " °F");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Vui long nhap so hop le!");
            }
        });

        frame.setVisible(true);
    }
}