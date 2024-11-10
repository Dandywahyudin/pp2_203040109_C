package view.jenisMember;

import javax.swing.*;
import java.util.*;
import dao.JenisMemberDao;
import model.JenisMember;

public class JenisMemberFrame extends JFrame{
    private List<JenisMember> jenisMemberList;
    private JenisMemberTableModel tableModel;
    private JTextField textFieldNama;
    private JenisMemberDao jenisMemberDao;

    public JenisMemberFrame(JenisMemberDao jenisMemberDao) {
        this.jenisMemberDao = jenisMemberDao;
        this.jenisMemberList = jenisMemberDao.findAll();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JLabel labelInput = new JLabel("Nama:");
    labelInput.setBounds(15,40,350,20);

    textFieldNama = new JTextField();
    textFieldNama.setBounds(15, 60, 200, 30);

    JButton button = new JButton("Simpan");
    button.setBounds(15,100,100,40);

    javax.swing.JTable table = new JTable();
    JScrollPane scrollableTable = new JScrollPane(table);
    scrollableTable.setBounds(15,150,350,200);

    tableModel = new JenisMemberTableModel(jenisMemberList);
    table.setModel(tableModel);

    JenisMemberButtonSimpanActionListerner actionListerner = new JenisMemberButtonSimpanActionListerner(this, jenisMemberDao);

    button.addActionListener(actionListerner);

    this.add(button);
    this.add(textFieldNama);
    this.add(labelInput);
    this.add(scrollableTable);

    this.setLayout(null);
    this.setSize(400,500);

    }
    public String getNama(){
        return textFieldNama.getText();
    }

    public void addJenisMember(JenisMember jenisMember){
        tableModel.add(jenisMember);
        textFieldNama.setText("");
    }
}
