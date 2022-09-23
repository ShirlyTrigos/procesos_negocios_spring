package com.procesos.negocio.shirly.controllers;

import com.procesos.negocio.shirly.models.Usuario;
import com.procesos.negocio.shirly.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.util.Date;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping(value = "/usuario/{id}")
    public Optional<Usuario> getUsuario(@PathVariable Long id){

        Optional<Usuario> usuario= usuarioRepository.findById(id);
        return usuario;




        // Usuario usuario = new Usuario();
        //usuario.setId(id);
        //usuario.setNombre("Shirly");
        //usuario.setApellidos("Trigos");
        //usuario.setDocumento("1193557572");
        //usuario.setDireccion("Juan 23");
        //usuario.setFechaNacimiento(new Date(2002,9,21));
        //usuario.setTelefono("3042047497");

    }
    @PostMapping("/usuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
        return usuario;
    }
    @GetMapping("/usuarios")
    public List<Usuario> listarUsuario(){
        return  usuarioRepository.findAll();
    }
    @GetMapping("/usuario/{nombre}/{apellidos}")
    public List<Usuario> listarPorNombreApellidos(@PathVariable String nombre,@PathVariable String apellidos){
        return usuarioRepository.findAllByNombreAndApellidos(nombre, apellidos);
    } @GetMapping("/usuario/apellidos/{apellidos}")
    public List<Usuario> listarPorApellidos(@PathVariable String apellidos){
        return usuarioRepository.findAllByApellidos(apellidos);
}
    @PutMapping("/usuario/{id}")
    public Usuario editarUsuario(@PathVariable Long id,
                                          @RequestBody Usuario usuario){
        Usuario usuarioBD= usuarioRepository.findById(id).get();
        try{
          usuarioBD.setNombre(usuario.getNombre());
          usuarioBD.setApellidos(usuario.getApellidos());
          usuarioBD.setDireccion(usuario.getDireccion());
          usuarioBD.setDocumento(usuario.getDocumento());
          usuarioBD.setFechaNacimiento(usuario.getFechaNacimiento());
          usuarioBD.setTelefono(usuario.getTelefono());
          usuarioRepository.save(usuarioBD);
          return usuarioBD;
        }catch (Exception e){
            return null;
        }
    }
    @DeleteMapping("/usuario/{id}")
    public Usuario eliminarUsuario(@PathVariable Long id){
        Usuario usuarioBD= usuarioRepository.findById(id).get();
        try{
            usuarioRepository.delete(usuarioBD);
            return usuarioBD;
        }catch (Exception e){
            return null;
        }
    }
}
