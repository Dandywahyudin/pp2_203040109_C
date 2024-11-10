package view.member;

import java.awt.event.*;
import java.util.*;

import dao.MemberDao;
import model.JenisMember;
import model.Member;

public class MemberButtonSimpanActionLIstener implements ActionListener {
    private MemberFrame memberFrame;
    private MemberDao memberDao;

    public MemberButtonSimpanActionLIstener(MemberFrame memberFrame, MemberDao memberDao) {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = memberFrame.getNama();  // Ambil nama member
        JenisMember jenisMember = memberFrame.getJenisMember();  // Ambil jenis member yang dipilih

        if (nama.isEmpty() || jenisMember == null) {
            memberFrame.showAlert("Nama dan jenis member harus diisi!");
            return;
        }

        // Membuat objek Member
        Member member = new Member();
        member.setId(UUID.randomUUID().toString());  // Set ID baru menggunakan UUID
        member.setNama(nama);
        member.setJenisMember(jenisMember);

        // Menyimpan ke database
        int result = memberDao.insert(member);
        if (result > 0) {
            memberFrame.showAlert("Member berhasil disimpan!");
            memberFrame.addMember(member);  // Tambahkan member ke daftar dan update tabel
            memberFrame.populateComboJenis();  // Refresh combo jenis member jika perlu
        } else {
            memberFrame.showAlert("Gagal menyimpan member.");
        }
    }
}
