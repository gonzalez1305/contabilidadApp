package com.bling.contabilidadApp.Services.imp;

import com.bling.contabilidadApp.Entity.Rol;
import com.bling.contabilidadApp.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class

RolService {

        @Autowired
        private RolRepository rolRepository;

        public List<Rol> obtenerTodosLosRoles() {


            List<Rol> entidades = rolRepository.findAll();
            return entidades;


        }
    }

