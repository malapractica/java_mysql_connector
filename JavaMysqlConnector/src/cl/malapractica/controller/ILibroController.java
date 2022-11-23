package cl.malapractica.controller;

import cl.malapractica.model.entidades.Libro;
import java.util.List;

/**
 *
 * @author Mala Práctica
 * @date   2022-11-23
 * @verion 1.0.0
 */
public interface ILibroController {
    
    public boolean save(Libro libro);
    public int update(Libro libro);
    public int delete(Libro libro);
    public Libro selectByIsbn(String isbn);
    public List<Libro> select();
}
