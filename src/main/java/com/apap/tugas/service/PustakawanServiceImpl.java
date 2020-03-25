package com.apap.tugas.service;

import java.util.List;

import javax.transaction.Transactional;

import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.model.SpesialisasiModel;
import com.apap.tugas.repository.PustakawanDb;
import com.apap.tugas.repository.SpesialisasiDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@Transactional
public class PustakawanServiceImpl implements PustakawanService {
	@Autowired
	private PustakawanDb pustakawanDb;

	@Override
	public PustakawanModel getPustakawanById(int id) {
		return pustakawanDb.findById(id);
	}

	@Override
	public List<PustakawanModel> getAllPustakawan() {
		return pustakawanDb.findAll();
	}

	@Override
	public PustakawanModel getPustakawanByNip(String nip) {
		return pustakawanDb.findByNip(nip);
	}

	@Override
	public void addPustakawan(PustakawanModel pustakawan) {
		pustakawanDb.save(pustakawan);
	}

	@Override
	public void updatePustakawan(int id, PustakawanModel pustakawan) {
		PustakawanModel oldPustakawan = getPustakawanById(id);
		oldPustakawan.setNama(pustakawan.getNama());
		oldPustakawan.setNip(pustakawan.getNip());
		oldPustakawan.setTempat_lahir(pustakawan.getTempat_lahir());
		oldPustakawan.setTanggal_lahir(pustakawan.getTanggal_lahir());
		oldPustakawan.setJenis_kelamin(pustakawan.getJenis_kelamin());
		oldPustakawan.setDaftarSpesialisasi(pustakawan.getDaftarSpesialisasi());
	}

	@Override
	public void deletePustakawan(int id) {
		pustakawanDb.delete(this.getPustakawanById(id));

	}

	@Override
	public void addJadwal(int id, PustakawanModel updatedPustakawan) {
		PustakawanModel pustakawan = this.getPustakawanById(id);
		pustakawan.setPustakawanPlacement(updatedPustakawan.getPustakawanPlacement());
	}
}