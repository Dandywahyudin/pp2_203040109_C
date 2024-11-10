package view.jenisMember;

import java.awt.event.*;
import java.util.UUID;
import model.*;
import dao.JenisMemberDao;


public class JenisMemberButtonSimpanActionListerner implements ActionListener {
    private JenisMemberFrame jenisMemberFrame;
    private JenisMemberDao jenisMemberDao; 

    public JenisMemberButtonSimpanActionListerner(JenisMemberFrame jenisMemberFrame, JenisMemberDao jenisMemberDao) {
        this.jenisMemberFrame = jenisMemberFrame;
        this.jenisMemberDao = jenisMemberDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = jenisMemberFrame.getNama();
        JenisMember jenisMember = new JenisMember();

        jenisMember.setId(UUID.randomUUID().toString());    
        jenisMember.setNama(nama);

        this.jenisMemberDao.insert(jenisMember);
        this.jenisMemberFrame.addJenisMember(jenisMember);
    }
}
