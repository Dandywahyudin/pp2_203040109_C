package view.Main;

import model.Biodata;
import view.OperasiData.BiodataOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class biodata extends JFrame {

    private JPanel panel;
    private JTextField namaField, hpField;
    private JRadioButton lakiRadioButton, perempuanRadioButton;
    private JCheckBox checkBox;
    private JButton simpanButton, updateButton, deleteButton;

    public biodata() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Form Biodata");
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);

        JLabel headerLabel = new JLabel("Form Biodata");
        JLabel namaLabel = new JLabel("Nama:");
        JLabel hpLabel = new JLabel("Nomor HP:");
        JLabel jenisKelaminLabel = new JLabel("Jenis Kelamin:");

        namaField = new JTextField(15);
        hpField = new JTextField(15);

        lakiRadioButton = new JRadioButton("Laki-Laki");
        perempuanRadioButton = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(lakiRadioButton);
        genderGroup.add(perempuanRadioButton);

        checkBox = new JCheckBox("Warga Negara Asing");

        simpanButton = new JButton("Simpan");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(headerLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(namaLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(namaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(hpLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(hpField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(jenisKelaminLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(lakiRadioButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(perempuanRadioButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(checkBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        add(simpanButton, gbc);
        add(updateButton, gbc);
        add(deleteButton, gbc);

        this.setSize(800, 800);

        // Aksi tombol Simpan
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        // Aksi tombol Update
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateData();
            }
        });

        // Aksi tombol Delete
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteData();
            }
        });
    }

    private void saveData() {
        String nama = namaField.getText();
        String nomorHp = hpField.getText();
        String jenisKelamin = lakiRadioButton.isSelected() ? "Laki-Laki" : "Perempuan";
        boolean wargaNegaraAsing = checkBox.isSelected();

        Biodata biodata = new Biodata(nama, nomorHp, jenisKelamin, wargaNegaraAsing);
        BiodataOperation.saveData(biodata);
    }

    private void updateData() {
        String nama = namaField.getText();
        String nomorHp = hpField.getText();
        String jenisKelamin = lakiRadioButton.isSelected() ? "Laki-Laki" : "Perempuan";
        boolean wargaNegaraAsing = checkBox.isSelected();

        Biodata biodata = new Biodata(nama, nomorHp, jenisKelamin, wargaNegaraAsing);
        BiodataOperation.updateData(biodata);
    }

    private void deleteData() {
        String nama = namaField.getText();
        BiodataOperation.deleteData(nama);
    }

    public static void main(String[] args) {
        biodata form = new biodata();
        form.setVisible(true);
    }
}

