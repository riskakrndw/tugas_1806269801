package com.apap.tugas.tugas_1806269801.repository;

import com.apap.tugas.tugas_1806269801.model.SpesialisasiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spesialisasi Db
*/

@Repository
public interface SpesialisasiDb extends JpaRepository<SpesialisasiModel, Long>{
   SpesialisasiModel findById(long id);
}