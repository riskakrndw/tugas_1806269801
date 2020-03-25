package com.apap.tugas.tugas_1806269801.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "spesialisasi")
public class SpesialisasiModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 500)
    @Column(name = "deskripsi")
    private String deskripsi;

    @ManyToMany(mappedBy = "listPustakawan")
    private List<PustakawanModel> daftarPustakawan;

    public void setDaftarPustakawan(List<PustakawanModel> daftarPustakawan){
        this.daftarPustakawan = daftarPustakawan;
    }

    public List<PustakawanModel> getDaftarPustakawan(){
        return daftarPustakawan;
    }
    
    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }

    public String getDeskripsi(){
        return deskripsi;
    }
}