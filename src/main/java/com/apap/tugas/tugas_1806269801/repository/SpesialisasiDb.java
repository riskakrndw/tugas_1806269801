package com.apap.tugas.tugas_1806269801.repository;

import java.util.List;
import java.util.Optional;

import com.apap.tugas.tugas_1806269801.model.SpesialisasiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

/**
 * Spesialisasi Db
*/

@Repository
public interface SpesialisasiDb extends JpaRepository<SpesialisasiModel, Long>{
	Optional<SpesialisasiModel> findById(long id);
}