package com.apap.tugas.tugas_1806269801.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import com.apap.tugas.tugas_1806269801.model.SpesialisasiModel;
import com.apap.tugas.tugas_1806269801.repository.SpesialisasiDb;

/**
 * SpesialisasiServiceImpl
 */

@Service
@Transactional
public class SpesialisasiServiceImpl implements SpesialisasiService{
    @Autowired
    private SpesialisasiDb spesialisasiDb;

    @Override
	public Optional<SpesialisasiModel> getSpesialisasiById(long id) {
		return spesialisasiDb.findById(id);
	}

    @Override
    public List<SpesialisasiModel> getAllSpesialisasi(){
        return spesialisasiDb.findAll();
    }

    @Override
    public void addSpesialisasi(SpesialisasiModel spesialisasi){
        spesialisasiDb.save(spesialisasi);
    }
}