package view.OperasiData;

import db.MySqlConnection;
import model.Biodata;

import java.sql.*;

public class BiodataOperation {

    public static void saveData(Biodata biodata) {
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            String query = "INSERT INTO biodata (nama, nomor_hp, jenis_kelamin, warga_negara_asing) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, biodata.getNama());
            statement.setString(2, biodata.getNomorHp());
            statement.setString(3, biodata.getJenisKelamin());
            statement.setBoolean(4, biodata.isWargaNegaraAsing());
            statement.executeUpdate();
            System.out.println("Data berhasil disimpan!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void updateData(Biodata biodata) {
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            String query = "UPDATE biodata SET nomor_hp = ?, jenis_kelamin = ?, warga_negara_asing = ? WHERE nama = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, biodata.getNomorHp());
            statement.setString(2, biodata.getJenisKelamin());
            statement.setBoolean(3, biodata.isWargaNegaraAsing());
            statement.setString(4, biodata.getNama());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Data berhasil diupdate!");
            } else {
                System.out.println("Nama tidak ditemukan!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void deleteData(String nama) {
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            String query = "DELETE FROM biodata WHERE nama = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nama);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Data berhasil dihapus!");
            } else {
                System.out.println("Nama tidak ditemukan!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
