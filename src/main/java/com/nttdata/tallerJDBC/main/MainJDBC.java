package com.nttdata.tallerJDBC.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nttdata.tallerJDBC.bdDAOController.BdDaoController;

/**
 * Clase que contiene el metodo MAIN para hacer pruebas con JDBC contra una BD MySQL QUE ESTA INCLUIDA EN EL PROYECTO.
 * Gracias al ejemplo del ejercicio price-config he descubierto que la base de datos puede estar
 * como recurso intregado en el mismo paquete. Es la primera vez que lo veo y que lo pruebo.
 * 
 * Son practicas con CRUD
 * 
 * La clase DAO proporciona los metodos:
 * 
 * - show()
 * - create(String nombre, String apellidos)
 * - delete(int id)
 * - updateName(int id, String nombre);
 * - updateSurname(int id, String apellidos);	
 * 
 * @author Daniel
 * @version 0.1 26/01/22
 */

public class MainJDBC {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//instancia que contiene todos los metodos que necesita la conexion implementados del interface
		BdDaoController dao = new BdDaoController();
		
		//muestra todos los registros de la BD.
		dao.show();
		
		//inserta un registro en la BD
		dao.create("JDBC", "prueba insert");
		
     	System.out.println("SE HA INSERTADO UN REGISTRO EN LA BASE DE DATOS");
     	System.out.println("");	
     	
		dao.show();
		
		//elimina el registro 107
		//dao.delete(107);
		
//     	System.out.println("SE HA ELIMINADO UN REGISTRO EN LA BASE DE DATOS");
//     	System.out.println("");	
//		dao.show();
		
		//actualiza el registro con id 45
		dao.updateName(1, "Lola");
		dao.updateSurname(1, "La cantaora");		
     	System.out.println("SE HA ACTUALIZADO UN REGISTRO EN LA BASE DE DATOS");
     	System.out.println("");	
		dao.show();
	}
	
}
