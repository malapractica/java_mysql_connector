package cl.malapractica.service;

import cl.malapractica.model.entidades.Libro;
import java.util.List;

/**
 *
 * @author jazocar
 */
public interface ILibroService {
    
    public boolean save(Libro libro);
    public int update(Libro libro);
    public int delete(Libro libro);
    public Libro selectByIsbn(String isbn);
    public List<Libro> select();
}
