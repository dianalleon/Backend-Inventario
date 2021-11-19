package com.tutorial.crud.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductoDto {

    @NotBlank
    private String nombre;
    @Min(0)
    private Float precio;
    private int cantidad;
    private Double iva;
    private Double retencion;
    private int cantidad_minima;
    private int idCategoria;

    public ProductoDto() {
    }

    public ProductoDto(@NotBlank String nombre,  Float precio, int cantidad, Double iva, Double retencion, int cantidadMinima, int idCategoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.iva = iva;
        this.retencion = retencion;
        this.cantidad_minima = cantidadMinima;
        this.idCategoria = idCategoria;
    
    }

    public ProductoDto(@NotBlank String nombre, @Min(0) Float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public ProductoDto(@NotBlank String nombre, @Min(0) Float precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

      public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getRetencion() {
        return retencion;
    }

    public void setRetencion(Double retencion) {
        this.retencion = retencion;
    }

    public int getCantidad_minima() {
        return cantidad_minima;
    }

    public void setCantidad_minima(int cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

  

    @Override
    public String toString() {
        return "ProductoDto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", iva=" + iva +
                ", retencion=" + retencion +
                ", cantidad minima='" + cantidad_minima + '\'' +
                ", idCategoria=" + idCategoria +
                '}';
    }

}
