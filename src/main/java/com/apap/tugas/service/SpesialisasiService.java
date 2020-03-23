package com.apap.tugas.service;

import com.apap.tugas.model.SpesialisasiModel;

import java.util.List;
import java.util.Optional;

public interface SpesialisasiService {
	Optional<SpesialisasiModel> getSpesialisasiById(int id);

	List<SpesialisasiModel> getAllSpesialisasi();

	void addSpesialisasi(SpesialisasiModel spesialisasi);
}