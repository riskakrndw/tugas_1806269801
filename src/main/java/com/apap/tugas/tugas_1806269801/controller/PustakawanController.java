package com.apap.tugas.tugas_1806269801.controller;

import com.apap.tugas.tugas_1806269801.model.PustakawanModel;
import com.apap.tugas.tugas_1806269801.service.PustakawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value="/pustakawan", method = RequestMethod.GET)
    public String view(@RequestParam(value = "nip") String nip, Model model){
        PustakawanModel dataPustakawan = pustakawanService.getPustakawanByNip(nip);
        model.addAttribute("data", dataPustakawan);
        return "pustakawan/detailPustakawan";
    }

}