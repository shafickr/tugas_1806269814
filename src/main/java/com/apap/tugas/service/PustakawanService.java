package com.apap.tugas.service;

import java.util.List;
import com.apap.tugas.model.PustakawanModel;

public interface PustakawanService {
	PustakawanModel getPustakawanById(int id);

	PustakawanModel getPustakawanByNip(String nip);

	List<PustakawanModel> getAllPustakawan();

	void addPustakawan(PustakawanModel pustakawan);

	void updatePustakawan(int id, PustakawanModel pustakawan);

	void deletePustakawan(int id);

	void addJadwal(int id, PustakawanModel pustakawan);
}