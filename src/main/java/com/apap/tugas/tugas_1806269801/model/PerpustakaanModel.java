package com.apap.tugas.tugas_1806269801.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "perpustakaan")
public class PerpustakaanModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 500)
    @Column(name = "lokasi")
    private String lokasi;

    @OneToMany(
        mappedBy = "perpustakaan"
    )

    private List<JadwalPustakawanModel> jadwalPustakawan;

    public void setJadwalPustakawan(List<JadwalPustakawanModel> jadwalPustakawan){
        this.jadwalPustakawan = jadwalPustakawan;
    }

    public List<JadwalPustakawanModel> getJadwalPustakawan(){
        return jadwalPustakawan;
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

    public void setLokasi(String lokasi){
        this.lokasi = lokasi;
    }

    public String getLokasi(){
        return lokasi;
    }
}