package com.tutorial.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private float precio;
    private int cantidad;
    private Double iva;
    private Double retencion;
    private int cantidad_minima;
    private int idCategoria;
  

    public Producto() {
    }

    public Producto(String nombre, float precio, int cantidad,Double iva, Double retencion, int cantidad_minima, int categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.iva = iva;
        this.retencion = retencion;
        this.cantidad_minima = cantidad_minima;
        this.idCategoria = categoria;
    }

    public Producto(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String nombre, float precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
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

    // public int getIdProveedor() {
    //     return idProveedor;
    // }

    // public void setIdProveedor(int idProveedor) {
    //     this.idProveedor = idProveedor;
    // }

    
    
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad='" + cantidad + '\'' +
                ", iva=" + iva +
                ", retencion=" + retencion +
                ", cantidad minima=" + cantidad_minima +
                ", categoria=" + idCategoria +
                '}';
    }
  

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio, cantidad, iva, retencion, cantidad_minima, idCategoria);
    }


}
