package com.tutorial.crud.controller;

import java.util.List;

import com.tutorial.crud.dto.CategoriaDto;
import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.entity.Categoria;
import com.tutorial.crud.service.CategoriaService;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {
    
    @Autowired
    CategoriaService categoriaService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Categoria>> list(){
        List<Categoria> list = categoriaService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CategoriaDto categoriaDto){
        if(StringUtils.isBlank(categoriaDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        if(categoriaService.existsByNombre(categoriaDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Categoria categoria = new Categoria(categoriaDto.getNombre());
        categoriaService.save(categoria);
        return new ResponseEntity<>(new Mensaje("categoria creada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody CategoriaDto categoriaDto){
        if(!categoriaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(categoriaService.existsByNombre(categoriaDto.getNombre()) && categoriaService.getByNombre(categoriaDto.getNombre()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(categoriaDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Categoria categoria = categoriaService.getOne(id).get();
        categoria.setNombre(categoriaDto.getNombre());
        return new ResponseEntity<>(new Mensaje("producto actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!categoriaService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        categoriaService.delete(id);
        return new ResponseEntity<>(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

}
