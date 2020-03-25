package com.apap.tugas.tugas_1806269801.service;

import java.util.List;

import com.apap.tugas.tugas_1806269801.model.PustakawanModel;

/**
 * PustakawanService
 */

public interface PustakawanService{
    PustakawanModel getPustakawanById(long id);
    PustakawanModel getPustakawanByNip(String nip);
    List<PustakawanModel> getAllPustakawan();
    
    void generateNip(PustakawanModel pustakawan);
    void addPustakawan(PustakawanModel pustakawan);
    void updatePustakawan(long id, PustakawanModel pustakawan);
    
    void addJadwal(long id, PustakawanModel pustakawan);

    void deleteById(long id);
    void deleteJadwal(long id);
}