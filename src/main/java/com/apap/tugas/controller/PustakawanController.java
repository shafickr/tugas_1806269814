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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PustakawanController {
	@Autowired
	private PustakawanService pustakawanService;

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
}