package Tugas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class SewaBuku extends JFrame {
    public SewaBuku() {
        setTitle("Perpustakaan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Membuat menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuForm = new JMenu("Menu");
        
        JMenuItem menuBuku = new JMenuItem("Data Buku");
        JMenuItem menuPeminjaman = new JMenuItem("Peminjaman");
        
        menuForm.add(menuBuku);
        menuForm.add(menuPeminjaman);
        menuBar.add(menuForm);
        setJMenuBar(menuBar);

        // Event handlers untuk menu items
        menuBuku.addActionListener(e -> showForm(new BukuForm()));
        menuPeminjaman.addActionListener(e -> showForm(new PeminjamanForm()));

        // Tampilkan form buku sebagai default
        showForm(new BukuForm());
    }

    private void showForm(JPanel form) {
        getContentPane().removeAll();
        getContentPane().add(form);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SewaBuku().setVisible(true));
    }
}

class BukuForm extends JPanel {
    private JTextField txtKode, txtJudul, txtPenulis;
    private JComboBox<String> cbKategori;
    private JCheckBox cbTersedia;
    private JTextField txtRak;
    private JTable table;
    private DefaultTableModel tableModel;

    public BukuForm() {
        setLayout(new BorderLayout());
        
        // Panel untuk input
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Kode Buku
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Kode Buku:"), gbc);
        txtKode = new JTextField(20);
        gbc.gridx = 1;
        inputPanel.add(txtKode, gbc);

        // Judul Buku
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Judul:"), gbc);
        txtJudul = new JTextField(20);
        gbc.gridx = 1;
        inputPanel.add(txtJudul, gbc);

        // Penulis
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Penulis:"), gbc);
        txtPenulis = new JTextField(20);
        gbc.gridx = 1;
        inputPanel.add(txtPenulis, gbc);

        // Kategori
        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Kategori:"), gbc);
        String[] kategori = {"Novel", "Komik", "Pendidikan", "Sejarah", "Teknologi"};
        cbKategori = new JComboBox<>(kategori);
        gbc.gridx = 1;
        inputPanel.add(cbKategori, gbc);

        // Status
        gbc.gridx = 0; gbc.gridy = 4;
        inputPanel.add(new JLabel("Status:"), gbc);
        cbTersedia = new JCheckBox("Tersedia");
        gbc.gridx = 1;
        inputPanel.add(cbTersedia, gbc);

        // Lokasi Rak
        gbc.gridx = 0; gbc.gridy = 5;
        inputPanel.add(new JLabel("Lokasi Rak:"), gbc);
        txtRak = new JTextField(20);
        gbc.gridx = 1;
        inputPanel.add(txtRak, gbc);

        // Button
        JButton btnSimpan = new JButton("Simpan");
        gbc.gridx = 1; gbc.gridy = 6;
        inputPanel.add(btnSimpan, gbc);

        // Table
        String[] columns = {"Kode", "Judul", "Penulis", "Kategori", "Status", "Lokasi Rak"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        
        // Layout
        add(new JScrollPane(inputPanel), BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Action listener untuk button simpan
        btnSimpan.addActionListener(e -> {
            Vector<String> row = new Vector<>();
            row.add(txtKode.getText());
            row.add(txtJudul.getText());
            row.add(txtPenulis.getText());
            row.add(cbKategori.getSelectedItem().toString());
            row.add(cbTersedia.isSelected() ? "Tersedia" : "Tidak Tersedia");
            row.add(txtRak.getText());
            
            tableModel.addRow(row);
            clearForm();
        });
    }

    private void clearForm() {
        txtKode.setText("");
        txtJudul.setText("");
        txtPenulis.setText("");
        cbKategori.setSelectedIndex(0);
        cbTersedia.setSelected(false);
        txtRak.setText("");
    }
}

class PeminjamanForm extends JPanel {
    private JTextField txtKodePinjam, txtNamaPeminjam, txtKodeBuku;
    private JComboBox<String> cbJenisPeminjam;
    private JSpinner spinnerDurasi;
    private JTextArea txtKeterangan;
    private JTable table;
    private DefaultTableModel tableModel;

    public PeminjamanForm() {
        setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Kode Peminjaman
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Kode Peminjaman:"), gbc);
        txtKodePinjam = new JTextField(20);
        gbc.gridx = 1;
        inputPanel.add(txtKodePinjam, gbc);

        // Nama Peminjam
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Nama Peminjam:"), gbc);
        txtNamaPeminjam = new JTextField(20);
        gbc.gridx = 1;
        inputPanel.add(txtNamaPeminjam, gbc);

        // Kode Buku
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Kode Buku:"), gbc);
        txtKodeBuku = new JTextField(20);
        gbc.gridx = 1;
        inputPanel.add(txtKodeBuku, gbc);

        // Jenis Peminjam
        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Jenis Peminjam:"), gbc);
        String[] jenisPeminjam = {"Mahasiswa", "Dosen", "Umum"};
        cbJenisPeminjam = new JComboBox<>(jenisPeminjam);
        gbc.gridx = 1;
        inputPanel.add(cbJenisPeminjam, gbc);

        // Durasi Peminjaman
        gbc.gridx = 0; gbc.gridy = 4;
        inputPanel.add(new JLabel("Durasi (hari):"), gbc);
        spinnerDurasi = new JSpinner(new SpinnerNumberModel(7, 1, 14, 1));
        gbc.gridx = 1;
        inputPanel.add(spinnerDurasi, gbc);

        // Keterangan
        gbc.gridx = 0; gbc.gridy = 5;
        inputPanel.add(new JLabel("Keterangan:"), gbc);
        txtKeterangan = new JTextArea(3, 20);
        gbc.gridx = 1;
        inputPanel.add(new JScrollPane(txtKeterangan), gbc);

        // Button
        JButton btnSimpan = new JButton("Simpan");
        gbc.gridx = 1; gbc.gridy = 6;
        inputPanel.add(btnSimpan, gbc);

        // Table
        String[] columns = {"Kode Pinjam", "Nama Peminjam", "Kode Buku", "Jenis Peminjam", "Durasi", "Keterangan"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        // Layout
        add(new JScrollPane(inputPanel), BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Action listener
        btnSimpan.addActionListener(e -> {
            Vector<String> row = new Vector<>();
            row.add(txtKodePinjam.getText());
            row.add(txtNamaPeminjam.getText());
            row.add(txtKodeBuku.getText());
            row.add(cbJenisPeminjam.getSelectedItem().toString());
            row.add(spinnerDurasi.getValue().toString());
            row.add(txtKeterangan.getText());
            
            tableModel.addRow(row);
            clearForm();
        });
    }

    private void clearForm() {
        txtKodePinjam.setText("");
        txtNamaPeminjam.setText("");
        txtKodeBuku.setText("");
        cbJenisPeminjam.setSelectedIndex(0);
        spinnerDurasi.setValue(7);
        txtKeterangan.setText("");
    }
}
