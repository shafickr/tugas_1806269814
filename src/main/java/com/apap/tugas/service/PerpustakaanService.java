package com.apap.tugas.service;

import java.util.List;

import com.apap.tugas.model.PerpustakaanModel;

public interface PerpustakaanService {
	List<PerpustakaanModel> getAllPerpustakaan();

	PerpustakaanModel getPerpustakaanById(int id);

	void addPerpustakaan(PerpustakaanModel perpustakaan);

	void deletePerpustakaan(int id);
}