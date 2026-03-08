package model;

public class Pelicula {
    private int id;
    private String titulo;
    private int anio;

    public Pelicula(int id,String titulo,int anio){
        this.id=id;
        this.titulo=titulo;
        this.anio=anio;
    }

    public int getId(){return id;}
    public String getTitulo(){return titulo;}
    public int getAnio(){return anio;}
}