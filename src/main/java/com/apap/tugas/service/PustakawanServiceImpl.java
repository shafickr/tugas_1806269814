package com.apap.tugas.service;

import java.util.List;

import javax.transaction.Transactional;

import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.model.SpesialisasiModel;
import com.apap.tugas.repository.PustakawanDb;
import com.apap.tugas.repository.SpesialisasiDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PustakawanServiceImpl implements PustakawanService {
	@Autowired
	private PustakawanDb pustakawanDb;
	private SpesialisasiDb spesialisasiDb;

	@Override
	public PustakawanModel getPustakawanById(long id) {
		return pustakawanDb.findById(id);
	}

	@Override
	public List<PustakawanModel> getAllPustakawan() {
		return pustakawanDb.findAll();
	}

	@Override
	public List<SpesialisasiModel> getAllSpesialisasi() {
		return spesialisasiDb.findAll();
	}
}