package cl.malapractica.model.entidades;

import java.util.Date;

/**
 *
 * @author Mala Práctica
 * @date   2022-11-23
 * @verion 1.0.0
 */
public class Libro {
    
    private int id;
    private String isbn;
    private String nombre;
    private String descripcion;
    private int    precio;
    private Date   fechaPublicacion;

    /**
     * Constructor sin parámetros.
     */
    public Libro() {
    }

    /**
     * Constructor con parámetros. 
     * @param isbn
     * @param nombre
     * @param descripcion
     * @param precio
     * @param fechaPublicacion 
     */
    public Libro(String isbn, String nombre, String descripcion, int precio, Date fechaPublicacion) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * 
     * @param id
     * @param isbn
     * @param nombre
     * @param descripcion
     * @param precio
     * @param fechaPublicacion 
     */
    public Libro(int id, String isbn, String nombre, String descripcion, int precio, Date fechaPublicacion) {
        this.id = id;
        this.isbn = isbn;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    public void imprimirInformacion(){
        System.out.println("\nImprimiento información del libro");
        System.out.println("Id: "+getId());
        System.out.println("ISBN: "+getIsbn());
        System.out.println("Nombre: "+getNombre());
        System.out.println("Descripción: "+getDescripcion());
        System.out.println("Precio: "+getPrecio());
        System.out.println("Fecha de publicación: "+getFechaPublicacion());
        System.out.println("******************************** \n");
    }
    
}
