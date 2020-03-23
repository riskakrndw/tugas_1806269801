package com.apap.tugas.tugas_1806269801.controller;

import java.util.List;

import com.apap.tugas.tugas_1806269801.model.PerpustakaanModel;
import com.apap.tugas.tugas_1806269801.service.PerpustakaanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * PustakawanController
*/

@Controller
public class PerpustakaanController{
    @Autowired
    private PerpustakaanService perpustakaanService;
    
    @RequestMapping(value = "/perpustakaan", method = RequestMethod.GET)
    private String index(Model model){
        List<PerpustakaanModel> dataPerpustakaan = perpustakaanService.getAllPerpustakaan();
        model.addAttribute("data", dataPerpustakaan);
        String activeNav = "perpustakaan";
        model.addAttribute("activeNav", activeNav);
        return "perpustakaan/index";
    }

    @RequestMapping(value = "/perpustakaan/tambah", method = RequestMethod.GET)
    private String add(Model model){
        model.addAttribute("dataPerpustakaan", new PerpustakaanModel());
        String activeNav = "perpustakaan";
        model.addAttribute("activeNav", activeNav);
        return "perpustakaan/formAdd";
    }

    @RequestMapping(value = "/perpustakaan/tambah", method = RequestMethod.POST)
    private String addSubmit(@ModelAttribute PerpustakaanModel perpustakaan, Model model){
        perpustakaanService.addPerpustakaan(perpustakaan);
        String activeNav = "perpustakaan";
        model.addAttribute("activeNav", activeNav);
        String typeMsg = "add";
        model.addAttribute("typeMsg", typeMsg);
        String msg = "Data Perpustakaan Berhasil Ditambahkan!";
        model.addAttribute("msg", msg);
        return "perpustakaan/notif";
    }

    @RequestMapping(value = "/perpustakaan/delete/{id}")
    public String delete(@PathVariable(value = "id") long id, Model model){
        perpustakaanService.deletePerpustakaan(id);
        String activeNav = "perpustakaan";
        model.addAttribute("activeNav", activeNav);
        String typeMsg = "delete";
        model.addAttribute("typeMsg", typeMsg);
        String msg = "Data Perpustakaan Berhasil Dihapus!";
        model.addAttribute("msg", msg);
        return "perpustakaan/notif";
    }
    
}