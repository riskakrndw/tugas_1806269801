package com.apap.tugas.tugas_1806269801.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas.tugas_1806269801.model.PerpustakaanModel;
import com.apap.tugas.tugas_1806269801.repository.PerpustakaanDb;

/**
 * PerpustakaanServiceImpl
 */

@Service
@Transactional
public class PerpustakaanServiceImpl implements PerpustakaanService{
    @Autowired
    private PerpustakaanDb perpustakaanDb;

    @Override
    public PerpustakaanModel getPerpustakaanById(long id){
        return perpustakaanDb.findById(id);
    }
}