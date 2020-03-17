package com.apap.tugas.controller;

import com.apap.tugas.service.SpesialisasiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpesialisasiController {
	@Autowired
	private SpesialisasiService spesialisasiService;
}