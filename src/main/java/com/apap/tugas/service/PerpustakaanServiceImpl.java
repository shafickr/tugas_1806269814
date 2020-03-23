package com.apap.tugas.service;

import java.util.List;

import javax.transaction.Transactional;

import com.apap.tugas.model.PerpustakaanModel;
import com.apap.tugas.repository.PerpustakaanDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PerpustakaanServiceImpl implements PerpustakaanService {
	@Autowired
	private PerpustakaanDb perpustakaanDb;

	@Override
	public PerpustakaanModel getPerpustakaanById(int id) {
		return perpustakaanDb.findById(id);
	}

	@Override
	public List<PerpustakaanModel> getAllPerpustakaan() {
		return perpustakaanDb.findAll();
	}

	@Override
	public void addPerpustakaan(PerpustakaanModel perpustakaan) {
		perpustakaanDb.save(perpustakaan);
	}

	@Override
	public void deletePerpustakaan(int id) {
		perpustakaanDb.delete(this.getPerpustakaanById(id));
	}
}