package cl.malapractica.controller.impl;

import cl.malapractica.model.dao.LibroDAO;
import cl.malapractica.model.entidades.Libro;
import java.util.List;
import cl.malapractica.controller.ILibroController;

/**
 * @author Mala Práctica
 * @date   2022-11-23
 * @verion 1.0.0
 */
public class LibroControllerImpl implements ILibroController {
    
    LibroDAO libroDao;
    
    public LibroControllerImpl(){
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
