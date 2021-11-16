package com.tutorial.crud.dto;

import javax.validation.constraints.NotBlank;

public class CategoriaDto {
    @NotBlank
    private String nombre;

    public CategoriaDto(){

    }

    public CategoriaDto (@NotBlank String nombre) {
        this.nombre = nombre;
    }

      public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ProductoDto{" +
                "nombre='" + nombre + '}';
    }
}
