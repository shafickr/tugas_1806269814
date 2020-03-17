package com.apap.tugas.service;

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
	public SpesialisasiModel getSpesialisasiById(long id) {
		return spesialisasiDb.findById(id);
	}
}