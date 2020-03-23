package com.apap.tugas.repository;

import java.util.Optional;

import com.apap.tugas.model.SpesialisasiModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpesialisasiDb extends JpaRepository<SpesialisasiModel, Integer> {
	Optional<SpesialisasiModel> findById(int id);
}