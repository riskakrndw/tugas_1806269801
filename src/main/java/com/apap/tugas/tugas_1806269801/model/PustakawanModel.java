package com.apap.tugas.tugas_1806269801.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.text.RandomStringGenerator;

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

    @Size(max = 100)
    @Column(name = "tempat_lahir", nullable = true)
    private String tempatLahir;

    @NotNull
    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggalLahir;

    @NotNull
    @Column(name = "jenis_kelamin", nullable = false)
    private int jenisKelamin;

    @ManyToMany(
        mappedBy = "spesialisasiPustakawan", 
        fetch = FetchType.LAZY
    )

    private List<SpesialisasiModel> listPustakawan;

    public void setListPustakawan(List<SpesialisasiModel> listPustakawan){
        this.listPustakawan = listPustakawan;
    }

    public List<SpesialisasiModel> getListPustakawan(){
        return listPustakawan;
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

    public String generateNip(){
        return LocalDate.now().getYear() + new SimpleDateFormat("ddMMyy").format(getTanggalLahir()) + getJenisKelamin() + new RandomStringGenerator.Builder().withinRange('A', 'Z').build().generate(2);
    }
}