package cl.malapractica.service.impl;

import cl.malapractica.model.dao.LibroDAO;
import cl.malapractica.model.entidades.Libro;
import cl.malapractica.service.ILibroService;
import java.util.List;

/**
 *
 * @author jazocar
 */
public class LibroServiceImpl implements ILibroService {
    
    LibroDAO libroDao;
    
    public LibroServiceImpl(){
        libroDao = new LibroDAO();
    }

    @Override
    public boolean save(Libro libro) {
        return libroDao.save(libro);
    }

    @Override
    public int update(Libro libro) {
        return libroDao.update(libro);
    }
    
    @Override
    public int delete(Libro libro) {
       return libroDao.delete(libro);
    }
    
    @Override
    public List<Libro> select() {
        return libroDao.select();
    }

    @Override
    public Libro selectByIsbn(String isbn) {
        return libroDao.selectByIsbn(isbn);
    }

    


    
}
