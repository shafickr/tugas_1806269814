package com.apap.tugas.service;

import java.util.List;
import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.model.SpesialisasiModel;

public interface PustakawanService {
	PustakawanModel getPustakawanById(long Id);

	List<PustakawanModel> getAllPustakawan();

	List<SpesialisasiModel> getAllSpesialisasi();
}