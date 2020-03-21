package com.apap.tugas.tugas_1806269801.controller;

import java.util.List;

import com.apap.tugas.tugas_1806269801.model.PustakawanModel;
import com.apap.tugas.tugas_1806269801.model.SpesialisasiModel;
import com.apap.tugas.tugas_1806269801.service.PustakawanService;
import com.apap.tugas.tugas_1806269801.service.SpesialisasiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.util.StringUtils;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * PustakawanController
*/

@Controller
public class PustakawanController{
    @Autowired
    private PustakawanService pustakawanService;

    @Autowired
    private SpesialisasiService spesialisasiService;

    @RequestMapping(value="/pustakawan", method = RequestMethod.GET)
    public String view(@RequestParam(value = "nip") String nip, Model model){
        PustakawanModel dataPustakawan = pustakawanService.getPustakawanByNip(nip);
        model.addAttribute("data", dataPustakawan);
        return "pustakawan/detail";
    }

    @RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.GET)
    private String add(Model model){
        List<SpesialisasiModel> spesialisasi = spesialisasiService.getAllSpesialisasi();
        PustakawanModel pustakawan = new PustakawanModel();
        model.addAttribute("dataSpesialisasi", spesialisasi);
        model.addAttribute("dataPustakawan", pustakawan);
        return "pustakawan/formAdd";
    }

    @RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST, params={"submit"})
    private String addSubmit(@RequestParam("spesialisasi") int spesialisasi, @ModelAttribute PustakawanModel pustakawan, Model model){
        pustakawanService.addPustakawan(pustakawan);

        if(!(spesialisasi == 0)){
            PustakawanModel dataPustakawan = pustakawanService.getPustakawanById(pustakawan.getId());

            SpesialisasiModel dataSpesialisasi = spesialisasiService.getSpesialisasiById(spesialisasi);
            dataSpesialisasi.getSpesialisasiPustakawan().add(dataPustakawan);
            spesialisasiService.addSpesialisasi(dataSpesialisasi);
        }
        return "pustakawan/notif";
    }
    
}