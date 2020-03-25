package com.apap.tugas.tugas_1806269801.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.apap.tugas.tugas_1806269801.model.PustakawanModel;
import com.apap.tugas.tugas_1806269801.repository.PustakawanDb;

/**
 * PustakawanServiceImpl
 */

@Service
@Transactional
public class PustakawanServiceImpl implements PustakawanService{
    @Autowired
    private PustakawanDb pustakawanDb;

    @Override
    public PustakawanModel getPustakawanById(long id){
        return pustakawanDb.findById(id);
    }

    @Override
    public PustakawanModel getPustakawanByNip(String nip){
        return pustakawanDb.findByNip(nip);
    }

    @Override
    public List<PustakawanModel> getAllPustakawan(){
        return pustakawanDb.findAll();
    }

    @Override
    public void generateNip(PustakawanModel pustakawan){
        pustakawan.setNip(pustakawan.generateNip());
    }

    @Override
    public void addPustakawan(PustakawanModel pustakawan){
        generateNip(pustakawan);
        pustakawanDb.save(pustakawan);
    }

    @Override
    public void updatePustakawan(long id, PustakawanModel pustakawan) {
        PustakawanModel newPustakawan = getPustakawanById(id);
        newPustakawan.setNama(pustakawan.getNama());
        newPustakawan.setTempatLahir(pustakawan.getTempatLahir());
        newPustakawan.setTanggalLahir(pustakawan.getTanggalLahir());
        newPustakawan.setJenisKelamin(pustakawan.getJenisKelamin());
        newPustakawan.setListPustakawan(pustakawan.getListPustakawan());
    }

    @Override
    public void addJadwal(long id, PustakawanModel pustakawan) {
        PustakawanModel newPustakawan = getPustakawanById(id);
        newPustakawan.setJadwalPustakawan(pustakawan.getJadwalPustakawan());
    }

    @Override
    public void deleteById(long id){
        pustakawanDb.delete(this.getPustakawanById(id));
    }
}