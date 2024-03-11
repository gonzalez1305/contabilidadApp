package com.bling.contabilidadApp.controllers;

import com.bling.contabilidadApp.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/vendedor", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,})
@CrossOrigin("*")
public class VendedorController {
    @Autowired
    VendedorService vendedorService;



}

