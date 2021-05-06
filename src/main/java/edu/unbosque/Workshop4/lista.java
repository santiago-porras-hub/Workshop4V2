package edu.unbosque.Workshop4;

import java.util.ArrayList;

public  class lista {

    String name = "";
    String comentario ="";
    String date ="";
    String imagename="";

    public lista(String name, String comentario, String date, String imagename) {
        this.name = name;
        this.comentario = comentario;
        this.date = date;
        this.imagename = imagename;
    }

    public lista() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }
}