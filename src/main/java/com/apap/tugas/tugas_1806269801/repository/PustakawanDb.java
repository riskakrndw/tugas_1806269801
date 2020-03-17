package com.apap.tugas.tugas_1806269801.repository;

import com.apap.tugas.tugas_1806269801.model.PustakawanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spesialisasi Db
 */

@Repository
    public interface PustakawanDb extends JpaRepository<PustakawanModel, Long>{
    PustakawanModel findById(long id);
    PustakawanModel findByNip(String nip);

}