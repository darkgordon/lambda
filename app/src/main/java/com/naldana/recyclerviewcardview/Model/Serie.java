package com.naldana.recyclerviewcardview.Model;

/**
 * Created by Nestor on 15/5/2017.
 */

public class Serie {
    //PONIENDOLE EL ID A LA SERIE
    int ID;
    private String titulo;
    private int imgId;
    private String genero;
    private String subGenero;
    private int cantCapitulos;
    private int cantTemporadas;
    private String descripcion;

    public Serie(String string){
        this.titulo=titulo;
    }


    public Serie(int ID,String titulo){
        this.ID=ID;
        this.titulo=titulo;
    }

    public Serie(String titulo, int imgId) {
        this.titulo = titulo;
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSubGenero() {
        return subGenero;
    }

    public void setSubGenero(String subGenero) {
        this.subGenero = subGenero;
    }

    public int getCantCapitulos() {
        return cantCapitulos;
    }

    public void setCantCapitulos(int cantCapitulos) {
        this.cantCapitulos = cantCapitulos;
    }

    public int getCantTemporadas() {
        return cantTemporadas;
    }

    public void setCantTemporadas(int cantTemporadas) {
        this.cantTemporadas = cantTemporadas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



}
