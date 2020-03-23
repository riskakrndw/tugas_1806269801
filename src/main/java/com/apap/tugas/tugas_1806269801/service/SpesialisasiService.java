package com.apap.tugas.tugas_1806269801.service;

import java.util.List;
import java.util.Optional;

import com.apap.tugas.tugas_1806269801.model.SpesialisasiModel;

/**
 * SpesialisasiService
 */

public interface SpesialisasiService{
	Optional<SpesialisasiModel> getSpesialisasiById(long id);
    List<SpesialisasiModel> getAllSpesialisasi();

    void addSpesialisasi(SpesialisasiModel spesialisasi);
}