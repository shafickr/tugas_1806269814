package com.apap.tugas.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas.model.PustakawanPlacementModel;
import com.apap.tugas.model.PerpustakaanModel;
import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.service.PerpustakaanService;
import com.apap.tugas.service.PustakawanService;

@Controller
public class PustakawanPlacementController {
	@Autowired
	private PustakawanService pustakawanService;

	@Autowired
	private PerpustakaanService perpustakaanService;

	@RequestMapping(value = "/jadwal/tambah/{nip}", method = RequestMethod.GET)
	private String addJadwal(@PathVariable(value = "nip") String nip, @ModelAttribute PustakawanPlacementModel jadwal,
			Model model) {
		PustakawanPlacementModel newJadwal = new PustakawanPlacementModel();
		List<PerpustakaanModel> perpustakaan = perpustakaanService.getAllPerpustakaan();
		PustakawanModel pustakawan = pustakawanService.getPustakawanByNip(nip);
		Set<PustakawanPlacementModel> pustakawanJadwal = pustakawan.getPustakawanPlacement();
		newJadwal.setPustakawan(pustakawan);
		model.addAttribute("jadwal", newJadwal);
		model.addAttribute("pustakawan", pustakawan);
		model.addAttribute("perpustakaan", perpustakaan);
		model.addAttribute("pustakawanJadwal", pustakawanJadwal);
		return "add-jadwal";
	}

	@RequestMapping(value = "/jadwal/tambah/{nip}", method = RequestMethod.POST)
	private String addJadwalSubmit(@PathVariable(value = "nip") String nip,
			@ModelAttribute PustakawanPlacementModel jadwal,
			@RequestParam(value = "perpustakaan", required = true) PerpustakaanModel perpustakaan,
			@RequestParam(value = "hari") String hari,
			@RequestParam(value = "pustakawan", required = true) PustakawanModel pustakawan, Model model) {
		jadwal.setPustakawan(pustakawanService.getPustakawanById(pustakawan.getId()));
		jadwal.setPerpustakaan(perpustakaanService.getPerpustakaanById(perpustakaan.getId()).get());
		jadwal.setHari(hari);
		pustakawan.getPustakawanPlacement().add(jadwal);
		pustakawanService.addJadwal(pustakawan.getId(), pustakawan);
		model.addAttribute("pustakawan", pustakawan);
		return "add-success";
	}

}