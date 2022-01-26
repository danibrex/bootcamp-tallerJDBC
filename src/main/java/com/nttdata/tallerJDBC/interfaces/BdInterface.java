package com.nttdata.tallerJDBC.interfaces;

/**
 * Interfaz que implementara el DAO y que lo dota de un sencillo CRUD
 * 
 * @author Daniel
 *
 */

public interface BdInterface {
	
	//contara con la base de datos y ejecutara la sentencia
	public void connect(String sql);
	
	//lo mismo pero adaptado a insert, delete y update.
	public void connectIDU(String sql);
	
	//cierra todas las conexiones si estan abiertas
	public void desconnect();
	
	//lo mismo pero adaptado a insert, delete y update.	
	public void desconnectIDU();
	
	//metodo para crear un nuevo registro en la BD con esos valores
	public void create(String nombre, String apellidos);
	
	//muestra la tabla persona
	public String show();
	
	//acutaliza nombre
	public void updateName(int id, String name);
	
	//actualiza apellidos
	public void updateSurname(int id, String surname);
	
	//elimina el registro con ese id
	public void delete(int id);

	
}
