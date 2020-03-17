package com.apap.tugas.tugas_1806269801.controller;

import com.apap.tugas.tugas_1806269801.service.SpesialisasiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * SpesialisasiController
*/

@Controller
public class SpesialisasiController{
    @Autowired
    private SpesialisasiService spesialisasiService;
}