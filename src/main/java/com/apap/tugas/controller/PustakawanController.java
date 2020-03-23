package com.apap.tugas.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.model.SpesialisasiModel;
import com.apap.tugas.service.PustakawanService;
import com.apap.tugas.service.SpesialisasiService;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		PustakawanModel pustakawan = new PustakawanModel();
		pustakawan.setId(pustakawan.getId());
		model.addAttribute("pustakawan", pustakawan);
		model.addAttribute("spesialisasi", spesialisasi);
		return "add-pustakawan";
	}

	// @RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST,
	// params = { "addRow" })
	// public String addRow(@ModelAttribute PustakawanModel pustakawan,
	// BindingResult bindingResult, Model model) {
	// SpesialisasiModel spesialisasiBaru = new SpesialisasiModel();
	// pustakawan.getDaftarSpesialisasi().add(spesialisasiBaru);
	// model.addAttribute("pustakawan", pustakawan);
	// return "add-pustakawan";
	// }

	@RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST)
	private String addPustakawanSubmit(
			@RequestParam(value = "spesialisasi", required = false) SpesialisasiModel spesialisasi,
			@ModelAttribute PustakawanModel pustakawan, Model model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy");
		StringBuilder newNip = new StringBuilder();
		newNip.append(LocalDateTime.now().getYear());
		newNip.append(dateFormat.format(pustakawan.getTanggal_lahir()));
		newNip.append(pustakawan.getJenis_kelamin());
		newNip.append(new RandomStringGenerator.Builder().withinRange('A', 'Z').build().generate(2));
		String nip = newNip.toString();
		pustakawan.setNip(nip);
		pustakawanService.addPustakawan(pustakawan);
		if (!(spesialisasi == null)) {
			Optional<SpesialisasiModel> spesialisasiId = spesialisasiService.getSpesialisasiById(spesialisasi.getId());
			pustakawan.getDaftarSpesialisasi().add(spesialisasiId.get());
		}
		return "add-success";
	}

	@RequestMapping(value = "/pustakawan/update/{id}", method = RequestMethod.GET)
	private String updatePustakawan(@PathVariable(value = "id") int id, Model model) {
		PustakawanModel pustakawan = pustakawanService.getPustakawanById(id);
		List<SpesialisasiModel> spesialisasi = spesialisasiService.getAllSpesialisasi();
		model.addAttribute("spesialisasi", spesialisasi);
		model.addAttribute("pustakawan", pustakawan);
		model.addAttribute("updatedPustakawan", new PustakawanModel());
		return "update-pustakawan";
	}

	@RequestMapping(value = "/pustakawan/update/{id}", method = RequestMethod.POST)
	private String updatePustakawanSubmit(@ModelAttribute PustakawanModel updatedPustakawan,
			@PathVariable(value = "id") int id, Model model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy");
		StringBuilder newNip = new StringBuilder();
		newNip.append(LocalDateTime.now().getYear());
		newNip.append(dateFormat.format(updatedPustakawan.getTanggal_lahir()));
		newNip.append(updatedPustakawan.getJenis_kelamin());
		newNip.append(new RandomStringGenerator.Builder().withinRange('A', 'Z').build().generate(2));
		String nip = newNip.toString();
		updatedPustakawan.setNip(nip);
		pustakawanService.updatePustakawan(id, updatedPustakawan);
		return "update-success";
	}

	@RequestMapping(value = "/pustakawan/delete/{id}")
	private String deletePustakawan(@PathVariable(value = "id") int id, Model model) {
		pustakawanService.deletePustakawan(id);
		model.addAttribute("nav", "Hapus Pustakawan");
		return "delete-success";
	}
}