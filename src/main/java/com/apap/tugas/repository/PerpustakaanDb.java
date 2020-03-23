package com.apap.tugas.repository;

import com.apap.tugas.model.PerpustakaanModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerpustakaanDb extends JpaRepository<PerpustakaanModel, Integer> {
	PerpustakaanModel findById(int id);
}