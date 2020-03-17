package com.apap.tugas.tugas_1806269801.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pustakawan")
public class PustakawanModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 13)
    @Column(name = "nip", nullable = false, unique = true)
    private String nip;

    @NotNull
    @Column(name = "tempat_lahir")
    private String tempatLahir;

    @NotNull
    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggalLahir;

    @NotNull
    @Column(name = "jenis_kelamin", nullable = false)
    private int jenisKelamin;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "spesialisasi_pustakawan",
        joinColumns = @JoinColumn(name = "pustakawan_id"),
        inverseJoinColumns = @JoinColumn(name = "spesialisasi_id")
    )
    private List<SpesialisasiModel> spesialisasiPustakawan;

    public void setSpesialisasiPustakawan(List<SpesialisasiModel> spesialisasiPustakawan){
        this.spesialisasiPustakawan = spesialisasiPustakawan;
    }

    public List<SpesialisasiModel> getSpesialisasiPustakawan(){
        return this.spesialisasiPustakawan;
    }

    @OneToMany(
        mappedBy = "pustakawan",
        fetch = FetchType.LAZY,
        cascade = CascadeType.PERSIST
    )

    private List<TempatPustakawanModel> tempatPustakawan;

    public void setTempatPustakawan(List<TempatPustakawanModel> tempatPustakawan){
        this.tempatPustakawan = tempatPustakawan;
    }

    public List<TempatPustakawanModel> getTempatPustakawan(){
        return tempatPustakawan;
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

    public void setNip(String nip){
        this.nip = nip;
    }

    public String getNip(){
        return nip;
    }

    public void setTempatLahir(String tempatLahir){
        this.tempatLahir = tempatLahir;
    }

    public String getTempatLahir(){
        return tempatLahir;
    }

    public void setTanggalLahir(Date tanggalLahir){
        this.tanggalLahir = tanggalLahir;
    }

    public Date getTanggalLahir(){
        return tanggalLahir;
    }

    public void setJenisKelamin(int jenisKelamin){
        this.jenisKelamin = jenisKelamin;
    }

    public int getJenisKelamin(){
        return jenisKelamin;
    }
}