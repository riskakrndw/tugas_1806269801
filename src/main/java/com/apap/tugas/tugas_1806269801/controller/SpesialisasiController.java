package com.apap.tugas.tugas_1806269801.controller;

import java.util.List;

import com.apap.tugas.tugas_1806269801.model.SpesialisasiModel;
import com.apap.tugas.tugas_1806269801.service.SpesialisasiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * SpesialisasiController
*/

@Controller
public class SpesialisasiController{
    @Autowired
    private SpesialisasiService spesialisasiService;

    @RequestMapping(value = "/statistik", method = RequestMethod.GET)
    private String index(Model model){
        List<SpesialisasiModel> spesialisasi = spesialisasiService.getAllSpesialisasi();
        model.addAttribute("spesialisasi", spesialisasi);
        String activeNav = "statistik";
        model.addAttribute("activeNav", activeNav);
        String nav = "Statistik";
        model.addAttribute("nav", nav);
        return "statistik/index";
    }
}