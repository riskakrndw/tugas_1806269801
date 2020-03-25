package com.apap.tugas.tugas_1806269801.controller;

import java.util.List;

import com.apap.tugas.tugas_1806269801.model.JadwalPustakawanModel;
import com.apap.tugas.tugas_1806269801.model.PerpustakaanModel;
import com.apap.tugas.tugas_1806269801.model.PustakawanModel;
import com.apap.tugas.tugas_1806269801.service.PerpustakaanService;
import com.apap.tugas.tugas_1806269801.service.PustakawanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * SpesialisasiController
*/

@Controller
public class JadwalPustakawanController{
    
	@Autowired
    private PerpustakaanService perpustakaanService;
    
	@Autowired
	private PustakawanService pustakawanService;
   

    @RequestMapping(value = "/jadwal/tambah/{nip}", method = RequestMethod.GET)
    private String add(@PathVariable(value = "nip") String nip, @ModelAttribute JadwalPustakawanModel jadwal, Model model){
        JadwalPustakawanModel newJadwal = new JadwalPustakawanModel();
        List<PerpustakaanModel> perpustakaan = perpustakaanService.getAllPerpustakaan();
        PustakawanModel pustakawan = pustakawanService.getPustakawanByNip(nip);
        newJadwal.setPustakawan(pustakawan);
        model.addAttribute("dataJadwal", newJadwal);
        model.addAttribute("dataPerpustakaan", perpustakaan);
        model.addAttribute("dataPustakawan", pustakawan);
        model.addAttribute("pustakawanID", pustakawan.getId());
        model.addAttribute("listJadwal", pustakawan.getJadwalPustakawan());
        String activeNav = "beranda";
        model.addAttribute("activeNav", activeNav);
        String nav = "Jadwal Pustakawan";
        model.addAttribute("nav", nav);
        return "pustakawan/formAddJadwal";
    }

    @RequestMapping(value = "/jadwal/tambah/{nip}", method = RequestMethod.POST)
    private String addSubmit(@ModelAttribute JadwalPustakawanModel jadwal, @RequestParam(value = "perpustakaan", required = true) PerpustakaanModel perpustakaan, @RequestParam(value = "hari") String hari, @RequestParam(value = "pustakawan", required = true) PustakawanModel pustakawan, Model model){
        jadwal.setPustakawan(pustakawanService.getPustakawanById(pustakawan.getId()));
        jadwal.setPerpustakaan(perpustakaanService.getPerpustakaanById(perpustakaan.getId()));
        jadwal.setHari(hari);
        pustakawan.getJadwalPustakawan().add(jadwal);
        pustakawanService.addJadwal(pustakawan.getId(), pustakawan);
        String activeNav = "beranda";
        model.addAttribute("activeNav", activeNav);
        String nav = "Notification";
        model.addAttribute("nav", nav);
        String type = "success";
        model.addAttribute("type", type);
        String typeMsg = "add";
        model.addAttribute("typeMsg", typeMsg);
        String msg = "Jadwal Berhasil Ditambahkan!";
        model.addAttribute("msg", msg);
        return "pustakawan/notif";
    }

    @RequestMapping(value = "/jadwal/delete/{pustakawan_id}")
    private String delete(@PathVariable(value = "pustakawan_id") long pustakawan_id, Model model){
        pustakawanService.deleteJadwal(pustakawan_id);
        String activeNav = "beranda";
        model.addAttribute("activeNav", activeNav);
        String nav = "Notification";
        model.addAttribute("nav", nav);
        String type = "success";
        model.addAttribute("type", type);
        String typeMsg = "delete";
        model.addAttribute("typeMsg", typeMsg);
        String msg = "Data Pustakawan Berhasil Dihapus!";
        model.addAttribute("msg", msg);
        return "pustakawan/notif";
    }
}