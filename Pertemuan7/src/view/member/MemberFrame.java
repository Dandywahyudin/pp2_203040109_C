package view.member;

import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;
import dao.JenisMemberDao;
import dao.MemberDao;
import model.*;

public class MemberFrame extends JFrame {
    private List<JenisMember> jenisMemberList;
    private List<Member> memberList;
    private JTextField textFieldNama;
    private MemberTableModel tableModel;
    private JComboBox<JenisMember> comboJenis;
    private MemberDao memberDao;
    private JenisMemberDao jenisMemberDao;

    public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.memberDao = memberDao;
        this.jenisMemberDao = jenisMemberDao;

        this.memberList = this.memberDao.findAll();
        this.jenisMemberList = this.jenisMemberDao.findAll();

        JLabel labelInput = new JLabel("Nama: ");
        labelInput.setBounds(15, 50, 350, 10);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 70, 350, 30);

        JLabel labelJenis = new JLabel("Jenis: ");
        labelJenis.setBounds(15, 100, 350, 10);

        comboJenis = new JComboBox<>();
        comboJenis.setBounds(15, 120, 150, 30);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 160, 100, 40);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 220, 350, 200);

        tableModel = new MemberTableModel(memberList);
        table.setModel(tableModel);

        MemberButtonSimpanActionLIstener actionListener = new MemberButtonSimpanActionLIstener(this, memberDao);
        button.addActionListener(actionListener);

        this.add(button);
        this.add(labelInput);
        this.add(textFieldNama);
        this.add(labelJenis);
        this.add(comboJenis);
        this.add(scrollableTable);
        this.setLayout(null);
        this.setSize(400, 500);

    }

    @SuppressWarnings("unchecked")
    public void populateComboJenis() {
        this.jenisMemberList = this.jenisMemberDao.findAll();
        comboJenis.removeAllItems();
        for (JenisMember jenisMember : this.jenisMemberList) {
            comboJenis.addItem(jenisMember);
        }
    }

    public String getNama() {
        return textFieldNama.getText();
    }

    public JenisMember getJenisMember() {
        return (JenisMember) comboJenis.getSelectedItem();
    }

    public void addMember(Member member) {
        memberList.add(member);
        tableModel.fireTableDataChanged();  
        textFieldNama.setText("");
    }

    public void showAlert(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
