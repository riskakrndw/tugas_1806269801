package com.apap.tugas.tugas_1806269801.service;

import java.util.List;

import com.apap.tugas.tugas_1806269801.model.PerpustakaanModel;

/**
 * SpesialisasiService
 */

public interface PerpustakaanService{
    PerpustakaanModel getPerpustakaanById(long id);

    List<PerpustakaanModel> getAllPerpustakaan();

    void addPerpustakaan(PerpustakaanModel perpustakaan);

    void deletePerpustakaan(long id);

}