package cl.malapractica.model.dao;

import cl.malapractica.connection.Conexion;
import cl.malapractica.model.entidades.Libro;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jazocar
 */
public class LibroDAO {

    public LibroDAO() {
    }
    
    /**
     * Guarda un libro en la base de datos.
     * @param libro
     * @return boolean
     */
    public boolean save(Libro libro){
        Conexion conexion = new Conexion(); 
        boolean estado    = false;
        try 
        {
            String query = "INSERT INTO libro (isbn, nombre, descripcion, precio, fecha_publicacion) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement(query);

            preparedStmt.setString(1, libro.getIsbn());
            preparedStmt.setString(2, libro.getNombre());
            preparedStmt.setString(3, libro.getDescripcion());
            preparedStmt.setInt(4, libro.getPrecio());
            preparedStmt.setDate(5, new java.sql.Date(libro.getFechaPublicacion().getTime()));
            estado = preparedStmt.execute();
            System.out.println("Registro ingresado");
        } catch (SQLException ex) {
            System.out.println(String.format("Error al ingresar el libro, mensaje: %s", ex.getMessage()));
        } finally {
            conexion.cerrarConexion();
        } 
        return estado;
    }
    
    /**
     * Actualiza un libro en la base de datos.
     * @param libro
     * @return 
     */
    public int update(Libro libro){
        Conexion conexion          = new Conexion(); 
        int registrosActualizados  = 0;
        try 
        {
            String query = "UPDATE libro SET isbn = ?, nombre = ?, descripcion = ?, precio = ?, fecha_publicacion = ? WHERE id = ?";
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement(query);

            preparedStmt.setString(1, libro.getIsbn());
            preparedStmt.setString(2, libro.getNombre());
            preparedStmt.setString(3, libro.getDescripcion());
            preparedStmt.setInt(4, libro.getPrecio());
            preparedStmt.setDate(5, new java.sql.Date(libro.getFechaPublicacion().getTime()));
            preparedStmt.setInt(6, libro.getId());
            registrosActualizados = preparedStmt.executeUpdate();
            
            System.out.println("Registro actualizado");
        } catch (SQLException ex) {
            System.out.println(String.format("Error al actualizar el libro, mensaje: %s", ex.getMessage()));
        } finally {
            conexion.cerrarConexion();
        } 
        return registrosActualizados;
    }
    
    /**
     * Elimina un registro de la base de datos.
     * @param libro
     * @return 
     */
    public int delete(Libro libro){
        Conexion conexion          = new Conexion(); 
        int registrosActualizados  = 0;
        try 
        {
            String query = "DELETE FROM libro WHERE id = ?";
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement(query);

            preparedStmt.setInt(1, libro.getId());
            registrosActualizados = preparedStmt.executeUpdate();
            
            System.out.println(String.format("Libro con ISBN: %s, eliminado.", libro.getIsbn()));
        } catch (SQLException ex) {
            System.out.println(String.format("Error al eliminar el libro, mensaje: %s", ex.getMessage()));
        } finally {
            conexion.cerrarConexion();
        } 
        return registrosActualizados;
    }
    
    /**
     * Busca un libro por su ISBN
     * @param isbn
     * @return 
     */
    public Libro selectByIsbn(String isbn){
        Conexion conexion = new Conexion(); 
        Libro    libro    = null;
        try 
        {
            String    query     = String.format("SELECT id, isbn, nombre, descripcion, precio, fecha_publicacion FROM libro WHERE isbn = '%s'", isbn);
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next()) {
                libro = new Libro(resultSet.getInt("id"), 
                                  resultSet.getString("isbn"), 
                                  resultSet.getString("nombre"), 
                                  resultSet.getString("descripcion"), 
                                  resultSet.getInt("precio"), 
                                  resultSet.getDate("fecha_publicacion"));
                System.out.println("Registro encontrado");
            } 
            else 
            {
                System.out.println("Registro no encontrado");
            }                        
        } catch (SQLException ex) {
            System.out.println(String.format("Error al buscar el libro, mensaje: %s", ex.getMessage()));
        } finally {
            conexion.cerrarConexion();
        } 
        return libro;
    }
    
    /**
     * Lista todos los libros
     * @return List<Libro>
     */
    public List<Libro> select(){
        Conexion conexion = new Conexion(); 
        List<Libro> listaLibros = new ArrayList<>();
        try 
        {
            String    query     = String.format("SELECT id, isbn, nombre, descripcion, precio, fecha_publicacion FROM libro");
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                Libro libro = new Libro(resultSet.getInt("id"), 
                                        resultSet.getString("isbn"), 
                                        resultSet.getString("nombre"), 
                                        resultSet.getString("descripcion"), 
                                        resultSet.getInt("precio"), 
                                        resultSet.getDate("fecha_publicacion"));
                listaLibros.add(libro);
            } 
                                
        } catch (SQLException ex) {
            System.out.println(String.format("Error al buscar el libro, mensaje: %s", ex.getMessage()));
        } finally {
            conexion.cerrarConexion();
        } 
        return listaLibros;
    }

}
