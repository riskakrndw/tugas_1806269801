package com.apap.tugas.tugas_1806269801.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;


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
    public SpesialisasiModel getSpesialisasiById(long id){
        return spesialisasiDb.findById(id);
    }
}