package view.OperasiData;

import model.Biodata;
import java.sql.*;

import javax.swing.JOptionPane;

import db.MySqlConnection;


public class BiodataOperation {

    public static void saveData(Biodata biodata) {
        try (Connection conn = MySqlConnection.getConnection()) {
            String query = "INSERT INTO biodata (nama, nomor_hp, jenis_kelamin, warga_negara_asing) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, biodata.getNama());
                stmt.setString(2, biodata.getNomorHp());
                stmt.setString(3, biodata.getJenisKelamin());
                stmt.setBoolean(4, biodata.isWargaNegaraAsing());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error menyimpan data: " + e.getMessage());
        }
    }

    public static void updateData(Biodata biodata) {
        try (Connection conn = MySqlConnection.getConnection()) {
            String query = "UPDATE biodata SET nomor_hp = ?, jenis_kelamin = ?, warga_negara_asing = ? WHERE nama = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, biodata.getNomorHp());
                stmt.setString(2, biodata.getJenisKelamin());
                stmt.setBoolean(3, biodata.isWargaNegaraAsing());
                stmt.setString(4, biodata.getNama());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error mengupdate data: " + e.getMessage());
        }
    }

    public static void deleteData(String nama) {
        try (Connection conn = MySqlConnection.getConnection()) {
            String query = "DELETE FROM biodata WHERE nama = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, nama);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error menghapus data: " + e.getMessage());
        }
    }
}
