package cl.malapractica.connection;

import java.sql.Connection; 
import java.sql.DriverManager; 
/**
 *
 * @author jazocar
 */
public class Conexion {
    
    private Connection connection;
    private String     host;
    private String     port;
    private String     user;
    private String     pass;
    private String     database;

    public Conexion() {
        this.host     = "localhost";
        this.port     = "3306";
        this.user     = "root";
        this.pass     = "root";
        this.database = "libreria";
        crearConexion();
    }
    
    public Conexion(String host, String port, String user, String pass, String database) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.database = database;       
        crearConexion();
    }
    
   
    public void crearConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); //nombre del controlador de JDBC          
            //establece la conexion a la base de datos
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s?useSSL=false", getHost(), getPort(), getDatabase()), getUser(), getPass()); //URL de la base de datos
            System.out.println("Conexion establecida");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void cerrarConexion(){
        try 
        {
            connection.close();
            System.out.println("Conexion cerrada");
        }   catch(Exception ex){
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
