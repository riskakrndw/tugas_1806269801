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

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = CascadeType.PERSIST
    )
    @JoinTable(
        name = "spesialisasi_pustakawan",
        joinColumns = @JoinColumn(name = "spesialisasi_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "pustakawan_id", referencedColumnName = "id")
    )
    private List<PustakawanModel> spesialisasiPustakawan;

    public void setSpesialisasiPustakawan(List<PustakawanModel> spesialisasiPustakawan){
        this.spesialisasiPustakawan = spesialisasiPustakawan;
    }

    public List<PustakawanModel> getSpesialisasiPustakawan(){
        return spesialisasiPustakawan;
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