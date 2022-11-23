package cl.malapractica.main;

import cl.malapractica.model.entidades.Libro;
import cl.malapractica.controller.impl.LibroControllerImpl;
import java.util.Date;
import java.util.List;
import cl.malapractica.controller.ILibroController;

/**
 * @author Mala Práctica
 * @date   2022-11-23
 * @verion 1.0.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ILibroController libroService = new LibroControllerImpl();
        
        Libro libro = new Libro("CODE01", "NUEVO LIBRO", "DESCRIPCIÓN DEL LIBRO", 29990, new Date());
        libroService.save(libro);
        
        Libro libro2 = new Libro("CODE02", "NUEVO LIBRO 2", "DESCRIPCIÓN DEL LIBRO 2", 30990, new Date());
        libroService.save(libro2);
        
        Libro libro3 = new Libro("CODE03", "NUEVO LIBRO 3", "DESCRIPCIÓN DEL LIBRO 3", 40990, new Date());
        libroService.save(libro3);
        
        Libro libro4 = new Libro("CODE04", "NUEVO LIBRO 4", "DESCRIPCIÓN DEL LIBRO 4", 10990, new Date());
        libroService.save(libro4);
        
        System.out.println("Buscando registro...");
        Libro libroBusqueda = libroService.selectByIsbn(libro.getIsbn());
        libroBusqueda.imprimirInformacion();
        
        System.out.println("Actualizando registro de libro");
        
        libroBusqueda.setNombre("NOMBRE ACTUALIZADO");
        libroBusqueda.setDescripcion("NUEVA DESCRIPCION");
        
        libroService.update(libroBusqueda);
        libroBusqueda = libroService.selectByIsbn(libro.getIsbn());
        libroBusqueda.imprimirInformacion();
        
        System.out.println("Eliminando libro...");
        libroService.delete(libroBusqueda);
        
        System.out.println("Listando todos los libros...");
        List<Libro> listaLibros = libroService.select();
        
        for(Libro libroIteracion : listaLibros){
            libroIteracion.imprimirInformacion();
        }   
        
        
        System.out.println("Eliminando todos los libros");
        for(Libro libroIteracion : listaLibros){
           libroService.delete(libroIteracion);
        } 
    }
    
}
