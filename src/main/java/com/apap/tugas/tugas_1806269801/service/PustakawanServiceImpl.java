package com.apap.tugas.tugas_1806269801.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.apap.tugas.tugas_1806269801.model.PustakawanModel;
import com.apap.tugas.tugas_1806269801.model.SpesialisasiModel;
import com.apap.tugas.tugas_1806269801.repository.PustakawanDb;
import com.apap.tugas.tugas_1806269801.repository.SpesialisasiDb;

/**
 * PustakawanServiceImpl
 */

@Service
@Transactional
public class PustakawanServiceImpl implements PustakawanService{
    @Autowired
    private PustakawanDb pustakawanDb;

    @Autowired
    private SpesialisasiDb spesialisasiDb;

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
    public List<SpesialisasiModel> getAllSpesialisasi(){
        return spesialisasiDb.findAll();
    }

}