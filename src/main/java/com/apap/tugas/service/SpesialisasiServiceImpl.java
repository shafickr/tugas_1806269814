package com.apap.tugas.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.apap.tugas.model.SpesialisasiModel;
import com.apap.tugas.repository.SpesialisasiDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SpesialisasiServiceImpl implements SpesialisasiService {
	@Autowired
	private SpesialisasiDb spesialisasiDb;

	@Override
	public Optional<SpesialisasiModel> getSpesialisasiById(int id) {
		return spesialisasiDb.findById(id);
	}

	@Override
	public List<SpesialisasiModel> getAllSpesialisasi() {
		return spesialisasiDb.findAll();
	}

	@Override
	public void addSpesialisasi(SpesialisasiModel spesialisasi) {
		spesialisasiDb.save(spesialisasi);

	}
}