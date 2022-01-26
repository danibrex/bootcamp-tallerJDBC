package com.nttdata.tallerJDBC.bdDAOController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.nttdata.tallerJDBC.interfaces.BdInterface;

/**
 * Clase que contiene todos los metodos necesarios para una conexion JDBC contra una base de datos MySQL
 * que viene integrada en el propio proyecto. 
 * 
 * La practica consiste en hacer un CRUD sencillo contra una base de datos que integra el propio proyecto.
 * 
 * @author Daniel
 * @version 0.1 26/01/22
 */

public class BdDaoController implements BdInterface {
	
	/** esta es ruta de la base de datos */
    private final String URL = "jdbc:mysql:/testjpa";
    
    /** usuario de la BD */
    private final String USUARIO = "root";
    
    /** password vacio en la BD*/
    private final String PASS = "";
   
    /** Para instanciar un objeto del tipo Connection*/
    private Connection conexion;
    
    /** Para instanciar un objeto del tipo PreparedStatement*/    
    private PreparedStatement ps; 
    
    /** Para instanciar un objeto del tipo ResultSet*/      
    private ResultSet rs;
    
    /** Para instanciar un objeto deñ tipo Statement*/    
    private Statement st;
	
	
    /**
     * Metodo que establece la conexion con la base de datos usando el Driver JDBC de MySQL
     * y ejecuta la sentencia pasada por parametro
     * 
     * @param String que contiene unsa sentencia SQL
     */
    
	@Override
	public void connect(String sql) {
		// TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");    
            conexion = DriverManager.getConnection(URL, USUARIO, PASS);
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();          
        } catch (SQLException ex) {
            Logger.getLogger(BdDaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception e){
        
        }

	}
	
	/**
	 * Metodo que cierra las conexiones abiertas con la BD si las hubiera.
	 * 
	 */

	@Override
	public void desconnect() {
		// TODO Auto-generated method stub
        try {
            rs.close();
            ps.close();
            conexion.close();
        } catch (SQLException e) {
        }
	}
	
	/**
	 * Igual que el metodo anterior de conexion pero adaptado a insert, delete y update
	 * 
	 * @param Un String que contiene una sentencia SQL para su ejecucion.
	 */
	
	@Override
	public void connectIDU(String sql) {
		// TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");    
            conexion = DriverManager.getConnection(URL, USUARIO, PASS);
            st = conexion.createStatement();
            st.executeUpdate(sql); //para insert, delete o update         
        } catch (SQLException ex) {
            Logger.getLogger(BdDaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception e){
        
        }
		
	}
	
	/**
	 * Igual que el metodo anterior de desconexion pero adaptado a insert, delete y update
	 * 
	 */

	@Override
	public void desconnectIDU() {
		// TODO Auto-generated method stub
		/** se verifica que no sean nulos antes de cerrar */
        try {
	        if (rs != null)
	                rs.close();
	        if (st != null)
	                st.close();
	        if (conexion != null)
	                conexion.close();
	        } catch (SQLException e) {
	    }
		
	}
	
	/**
	 * Metodo que vuelca todos los registros de la BD ordenados por id de manera descendente
	 */
		
	@Override
	public String show() {
		// TODO Auto-generated method stub
		final String SQL = "SELECT * FROM persona ORDER BY idPersona DESC";
		StringBuilder personInfo = null;
		
		try {
			
			//creamos la conexion y se ejecutara la sentencia
			connect(SQL);
					
			//Agregará los datos que se vayan obteniendo de esos campos
			personInfo = new StringBuilder();
			
			//cabecera de lo que imprime
			System.out.println("ID      Nombre     Apellidos");				
			
			//iteración de la consulta
			while(rs.next()) {
				
				//se van añadiendo cadenas y un salto de linea
				personInfo.append(rs.getString("idPersona") + "        ");							
				personInfo.append(rs.getString("nombre") + "     ");
				personInfo.append(rs.getString("apellidos"));
				personInfo.append(".\n");
					
			}
			
			//se imprime en pantalla
			System.out.println(personInfo.toString());
			
			//cierra la conexion
			desconnect();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		//devuelve la cadena de texto
		return personInfo.toString();
	}
	
	/**
	 * Metodo que crea la sentencia e inserta un nuevo registro en la BD mediante el metodo connectIDU 
	 * y luego cierra la conexion.
	 * 
	 * @param nombre que se añadira al campo nombre de la tabla persona
	 * @param apellidos para completar el registro
	 */

	@Override
	public void create(String nombre, String apellidos) {
		// TODO Auto-generated method stub
        String sql = "INSERT INTO PERSONA VALUES (0," + "'" +nombre+"'" + "," + "'" + apellidos + "'" +")";
        connectIDU(sql);
        desconnectIDU(); 

	}
	
	/**
	 * Metodo que elimina un regtistro de la BD. Abre, ejecuta la sentencia y cierra la conexion.
	 * 
	 * @param id como clave unica para eliminar el registro
	 */

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
	       String sql = "DELETE FROM PERSONA WHERE idPersona = " + id;    
	       connectIDU(sql);
	       desconnect();   
		
	}
	
	/**
	 * Metodo que actualiza un regtistro de la BD cambiando el valor del campo nombre. 
	 * Abre, ejecuta la sentencia y cierra la conexion.
	 * 
	 * @param int id como clave unica para eliminar el registro
	 * @param String nombre: el nuevo valor para el campo nombre del registro con ese id.
	 */


	@Override
	public void updateName(int id, String name) {
		// TODO Auto-generated method stub
       String sql = "UPDATE PERSONA set nombre = (" + "'" + name + "'" + ") WHERE idPersona = " +id+ "";
       connectIDU(sql);
       desconnect();   
		
	}
	
	/**
	 * Metodo que actualiza un regtistro de la BD cambiando el valor del campo apellidos. 
	 * Abre, ejecuta la sentencia y cierra la conexion.
	 * 
	 * @param int id como clave unica para eliminar el registro
	 * @param String apellidos: el nuevo valor para el campo apellidos del registro con ese id.
	 */

	@Override
	public void updateSurname(int id, String surname) {
		// TODO Auto-generated method stub
       String sql = "UPDATE PERSONA set apellidos = (" + "'" + surname + "'" + ") WHERE idPersona = " +id+ "";
       connectIDU(sql);
       desconnect();   			
		
	}

	
}
