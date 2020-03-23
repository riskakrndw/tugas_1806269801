package com.apap.tugas.tugas_1806269801.controller;

import java.util.List;
import java.util.Optional;

import com.apap.tugas.tugas_1806269801.model.PerpustakaanModel;
import com.apap.tugas.tugas_1806269801.model.PustakawanModel;
import com.apap.tugas.tugas_1806269801.model.SpesialisasiModel;
import com.apap.tugas.tugas_1806269801.service.PerpustakaanService;
import com.apap.tugas.tugas_1806269801.service.PustakawanService;
import com.apap.tugas.tugas_1806269801.service.SpesialisasiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * PustakawanController
*/

@Controller
public class PustakawanController{
    @Autowired
    private PustakawanService pustakawanService;

    @Autowired
    private SpesialisasiService spesialisasiService;

    @Autowired
    private PerpustakaanService perpustakaanService;

    @RequestMapping(value="/pustakawan", method = RequestMethod.GET)
    public String view(@RequestParam(value = "nip") String nip, Model model){
        PustakawanModel dataPustakawan = pustakawanService.getPustakawanByNip(nip);
        model.addAttribute("data", dataPustakawan);
        String activeNav = "beranda";
        model.addAttribute("activeNav", activeNav);
        return "pustakawan/detail";
    }

    @RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.GET)
    private String add(Model model){
        List<SpesialisasiModel> spesialisasi = spesialisasiService.getAllSpesialisasi();
        PustakawanModel pustakawan = new PustakawanModel();
        model.addAttribute("dataSpesialisasi", spesialisasi);
        model.addAttribute("dataPustakawan", pustakawan);
        String activeNav = "beranda";
        model.addAttribute("activeNav", activeNav);
        String type = "success";
        model.addAttribute("type", type);
        String typeMsg = "add";
        model.addAttribute("typeMsg", typeMsg);
        String msg = "Data Pustakawan Berhasil Ditambahkan!";
        model.addAttribute("msg", msg);
        return "pustakawan/formAdd";
    }

    @RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST, params={"submit"})
    private String addSubmit(@RequestParam(value = "spesialisasi", required = false) SpesialisasiModel spesialisasi, @ModelAttribute PustakawanModel pustakawan, Model model){
        pustakawanService.addPustakawan(pustakawan);
        if(!(spesialisasi == null)){
            Optional<SpesialisasiModel> dataSpesialisasi = spesialisasiService.getSpesialisasiById(spesialisasi.getId());
            pustakawan.getListPustakawan().add(dataSpesialisasi.get());
        }
        String activeNav = "beranda";
        model.addAttribute("activeNav", activeNav);
        String type = "success";
        model.addAttribute("type", type);
        String typeMsg = "add";
        model.addAttribute("typeMsg", typeMsg);
        String msg = "Data Pustakawan Berhasil Ditambahkan!";
        model.addAttribute("msg", msg);
        return "pustakawan/notif";
    }

    @RequestMapping(value = "/pustakawan/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable(value = "id") long id, Model model){
        PustakawanModel pustakawan = pustakawanService.getPustakawanById(id);
        List<SpesialisasiModel> spesialisasi = spesialisasiService.getAllSpesialisasi();
        model.addAttribute("dataPustakawan", pustakawan);
        model.addAttribute("dataSpesialisasi", spesialisasi);
        String activeNav = "beranda";
        model.addAttribute("activeNav", activeNav);
        return "pustakawan/formEdit";
    }

    @RequestMapping(value = "/pustakawan/update/{id}", method = RequestMethod.POST)
    private String updateSubmit(@ModelAttribute PustakawanModel pustakawan, @PathVariable(value = "id") long id, Model model){
        pustakawanService.updatePustakawan(id, pustakawan);
        String activeNav = "beranda";
        model.addAttribute("activeNav", activeNav);
        String type = "success";
        model.addAttribute("type", type);
        String typeMsg = "edit";
        model.addAttribute("typeMsg", typeMsg);
        String msg = "Data Pustakawan Berhasil Diubah!";
        model.addAttribute("msg", msg);
        return "pustakawan/notif";
    }

    @RequestMapping(value = "/pustakawan/delete/{id}")
    public String delete(@PathVariable(value = "id") long id, Model model){
        pustakawanService.deleteById(id);
        String activeNav = "beranda";
        model.addAttribute("activeNav", activeNav);
        String type = "success";
        model.addAttribute("type", type);
        String typeMsg = "delete";
        model.addAttribute("typeMsg", typeMsg);
        String msg = "Data Pustakawan Berhasil Dihapus!";
        model.addAttribute("msg", msg);
        return "pustakawan/notif";
    }   

    @RequestMapping(value = "/cari", method = RequestMethod.GET)
    private String search(Model model){
        List<SpesialisasiModel> spesialisasi = spesialisasiService.getAllSpesialisasi();
        List<PerpustakaanModel> perpustakaan = perpustakaanService.getAllPerpustakaan();
        model.addAttribute("dataSpesialisasi", spesialisasi);
        model.addAttribute("dataPerpustakaan", perpustakaan);
        String activeNav = "pencarian";
        model.addAttribute("activeNav", activeNav);
        return "pencarian/index";
    }

    
}