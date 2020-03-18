package com.apap.tugas.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.model.SpesialisasiModel;
import com.apap.tugas.service.PustakawanService;
import com.apap.tugas.service.SpesialisasiService;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PustakawanController {
	@Autowired
	private PustakawanService pustakawanService;
	@Autowired
	private SpesialisasiService spesialisasiService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String home(Model model) {
		List<PustakawanModel> daftarPustakawan = pustakawanService.getAllPustakawan();
		model.addAttribute("daftarPustakawan", daftarPustakawan);
		return "home";
	}

	@RequestMapping(value = "/pustakawan", method = RequestMethod.GET)
	public String viewPustakawan(@RequestParam(value = "nip") String nip, Model model) {
		PustakawanModel pustakawan = pustakawanService.getPustakawanByNip(nip);
		model.addAttribute("pustakawan", pustakawan);
		return "view-pustakawan";
	}

	@RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.GET)
	private String addPustakawan(Model model) {
		List<SpesialisasiModel> spesialisasi = spesialisasiService.getAllSpesialisasi();
		model.addAttribute("pustakawan", new PustakawanModel());
		model.addAttribute("spesialisasi", spesialisasi);
		return "add-pustakawan";
	}

	@RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST)
	private String addPustakawanSubmit(@RequestParam("spesialisasi_id") int spesialisasi_id,
			@ModelAttribute PustakawanModel pustakawan) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy");
		StringBuilder newNip = new StringBuilder();
		newNip.append(LocalDateTime.now().getYear());
		newNip.append(dateFormat.format(pustakawan.getTanggal_lahir()));
		newNip.append(pustakawan.getJenis_kelamin());
		newNip.append(new RandomStringGenerator.Builder().withinRange('A', 'Z').build().generate(2));
		String nip = newNip.toString();
		pustakawan.setNip(nip);
		pustakawanService.addPustakawan(pustakawan);
		if ((spesialisasi_id != 0)) {
			PustakawanModel pustakawanId = pustakawanService.getPustakawanById(pustakawan.getId());
			SpesialisasiModel spesialisasiId = spesialisasiService.getSpesialisasiById(spesialisasi_id);
			spesialisasiId.getDaftarPustakawan().add(pustakawanId);
			spesialisasiService.addSpesialisasi(spesialisasiId);
		}
		;
		return "add-success";
	}
}