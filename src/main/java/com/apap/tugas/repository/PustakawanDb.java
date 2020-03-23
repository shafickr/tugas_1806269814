package com.apap.tugas.repository;

import com.apap.tugas.model.PustakawanModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PustakawanDb extends JpaRepository<PustakawanModel, Integer> {
	PustakawanModel findById(int id);

	PustakawanModel findByNip(String nip);
}