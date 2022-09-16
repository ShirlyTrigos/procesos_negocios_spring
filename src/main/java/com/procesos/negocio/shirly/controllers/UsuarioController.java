package com.procesos.negocio.shirly.controllers;

import com.procesos.negocio.shirly.models.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UsuarioController {
    @GetMapping(value = "/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Shirly");
        usuario.setApellidos("Trigos");
        usuario.setDocumento("1193557572");
        usuario.setDireccion("Juan 23");
        usuario.setFechaNacimiento(new Date(2002,9,21));
        usuario.setTelefono("3042047497");
        return usuario;
    }
}
