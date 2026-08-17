package com.mycompany;


public class Material {
    private String codigo;
    private String titulo;
    private String anioPublicacion;

    public Material() {
    }

    public Material(String codigo, String titulo, String anioPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + " | Titulo: " + titulo + " | Año: " + anioPublicacion;
    }
}