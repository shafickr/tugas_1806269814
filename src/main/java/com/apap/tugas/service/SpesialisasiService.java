package com.apap.tugas.service;

import com.apap.tugas.model.SpesialisasiModel;

import java.util.List;

public interface SpesialisasiService {
	SpesialisasiModel getSpesialisasiById(long Id);

	List<SpesialisasiModel> getAllSpesialisasi();

	void addSpesialisasi(SpesialisasiModel spesialisasi);
}