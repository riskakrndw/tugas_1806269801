package com.apap.tugas.tugas_1806269801.service;

import java.util.List;

import com.apap.tugas.tugas_1806269801.model.PustakawanModel;
import com.apap.tugas.tugas_1806269801.model.SpesialisasiModel;

/**
 * PustakawanService
 */

public interface PustakawanService{
    PustakawanModel getPustakawanById(long id);
    PustakawanModel getPustakawanByNip(String nip);

    List<PustakawanModel> getAllPustakawan();
    List<SpesialisasiModel> getAllSpesialisasi();
}