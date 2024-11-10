package model;

public class JenisMember {
    private String id;
    private String nama;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
