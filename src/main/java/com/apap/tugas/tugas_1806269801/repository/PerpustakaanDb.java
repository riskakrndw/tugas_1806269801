package com.apap.tugas.tugas_1806269801.repository;

import com.apap.tugas.tugas_1806269801.model.PerpustakaanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spesialisasi Db
 */

@Repository
public interface PerpustakaanDb extends JpaRepository<PerpustakaanModel, Long>{
    PerpustakaanModel findById(long id);
}