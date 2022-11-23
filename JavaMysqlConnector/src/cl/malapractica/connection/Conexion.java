package cl.malapractica.connection;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;

/**
 * Clase que permite gestionar la conexión hacia las clases DAO.
 * @author Mala Práctica
 * @date   2022-11-23
 * @verion 1.0.0
 */
public final class Conexion {
    
    //Atributos de la clase Conexión.
    private Connection connection;
    private String     host;
    private String     port;
    private String     user;
    private String     pass;
    private String     database;

    /**
     * Constructor sin parámetros de la clase Conexión.
     */
    public Conexion() {
        this.host     = "localhost";
        this.port     = "3306";
        this.user     = "root";
        this.pass     = "root";
        this.database = "libreria";
        crearConexion();
    }
    
    /**
     * Constructor con parámetros de la clase Conexión.
     * 
     * @param String host
     * @param String port
     * @param String user
     * @param String pass
     * @param String database 
     */
    public Conexion(String host, String port, String user, String pass, String database) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.database = database;       
        crearConexion();
    }
    
    /**
     * Permite crear la conexión.
     */
    public void crearConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); //nombre del controlador de JDBC          
            //establece la conexion a la base de datos
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s?useSSL=false", getHost(), getPort(), getDatabase()), getUser(), getPass()); //URL de la base de datos
            System.out.println("Conexion establecida");
          } catch (ClassNotFoundException ex) {
              ex.printStackTrace();
          }catch(SQLException ex){
              ex.printStackTrace();
            }
    }
    
    /**
     * Permite cerrar la conexión.
     */
    public void cerrarConexion(){
        try 
        {
            connection.close();
            System.out.println("Conexion cerrada");
        }   catch(SQLException ex){
                ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
    
}
