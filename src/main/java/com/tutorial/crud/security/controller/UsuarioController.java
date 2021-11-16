package com.tutorial.crud.security.controller;

import java.util.List;

import com.tutorial.crud.security.entity.Usuario;
import com.tutorial.crud.security.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @ApiOperation("Muestra una lista de usuarios")
    @GetMapping
    public ResponseEntity<List<Usuario>> list(){
        List<Usuario> list = usuarioService.listar();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation("Muestra un usuario")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> get(@PathVariable("id")int id){
        Usuario usuario = usuarioService.getById(id).get();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @ApiOperation("Boora un usuario por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")int id){
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
