package com.bling.contabilidadApp.service;

import com.bling.contabilidadApp.Entity.Usuario;
import java.util.List;

public interface UsuarioService {
    public List<Usuario> findAll() throws Exception;
    public Usuario findById(int id_usuario);
    public void create(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(Usuario usuario);
}
