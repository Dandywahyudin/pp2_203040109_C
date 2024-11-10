package model;

public class Biodata {
    private String nama;
    private String nomorHp;
    private String jenisKelamin;
    private boolean wargaNegaraAsing;

    public Biodata(String nama, String nomorHp, String jenisKelamin, boolean wargaNegaraAsing) {
        this.nama = nama;
        this.nomorHp = nomorHp;
        this.jenisKelamin = jenisKelamin;
        this.wargaNegaraAsing = wargaNegaraAsing;
    }

    // Getter and Setter methods
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public boolean isWargaNegaraAsing() {
        return wargaNegaraAsing;
    }

    public void setWargaNegaraAsing(boolean wargaNegaraAsing) {
        this.wargaNegaraAsing = wargaNegaraAsing;
    }
}
