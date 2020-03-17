package com.apap.tugas.controller;

import java.util.List;
import java.util.StringJoiner;

import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.model.SpesialisasiModel;
import com.apap.tugas.service.PustakawanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PustakawanController {
	@Autowired
	private PustakawanService pustakawanService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String home(Model model) {
		List<PustakawanModel> daftarPustakawan = pustakawanService.getAllPustakawan();
		// for (int i = 0; i < daftarPustakawan.size(); i++) {
		// if (daftarPustakawan.get(i).getSpesialisasiPustakawan().size() == 0) {
		// daftarPustakawan.get(i).setSpesialisasiPustakawan('-');
		// } else if (daftarPustakawan.get(i).getSpesialisasiPustakawan().size() > 1) {
		// StringJoiner joiner = new StringJoiner(",\n");
		// daftarPustakawan.get(i).getSpesialisasiPustakawan().forEach(spesialisasi -> {
		// joiner.add(spesialisasi.getNama().toString());
		// });
		// daftarPustakawan.get(i).setSpesialisasiPustakawan(joiner);
		// }
		// }
		model.addAttribute("daftarPustakawan", daftarPustakawan);
		return "home";
	}
}