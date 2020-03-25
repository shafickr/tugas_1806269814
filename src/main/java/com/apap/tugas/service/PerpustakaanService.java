package com.apap.tugas.service;

import java.util.List;
import java.util.Optional;

import com.apap.tugas.model.PerpustakaanModel;

public interface PerpustakaanService {
	List<PerpustakaanModel> getAllPerpustakaan();

	Optional<PerpustakaanModel> getPerpustakaanById(int id);

	void addPerpustakaan(PerpustakaanModel perpustakaan);

	void deletePerpustakaan(int id);
}