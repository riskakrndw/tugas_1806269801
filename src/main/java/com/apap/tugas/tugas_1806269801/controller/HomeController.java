package com.apap.tugas.tugas_1806269801.controller;

import java.util.List;

import com.apap.tugas.tugas_1806269801.model.PustakawanModel;
import com.apap.tugas.tugas_1806269801.service.PustakawanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * HomeController
*/

@Controller
public class HomeController{
    @Autowired
    private PustakawanService pustakawanService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String index(Model model){
        List<PustakawanModel> dataPustakawan = pustakawanService.getAllPustakawan();
        model.addAttribute("data", dataPustakawan);
        return "index";
    }
}