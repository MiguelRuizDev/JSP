package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import modelo.*;
import vista.*;


public class CategoriaDAO implements DAO <CategoriaModelo, String>{
	
	@Override
	public boolean insert(CategoriaModelo co) {
		// TODO Auto-generated method stub
		boolean exito = false;
		int cuantos = 0;
		CategoriaVista vista = new CategoriaVista();
		
	    try {
			      
	            Connection connection = ConexionManager.getConnection();
	            
	           	            
	            String query = "INSERT INTO categoria VALUES (?,?)";
	            PreparedStatement s = connection.prepareStatement(query);
	            
	            s.setString(1, co.getNombre());
	            s.setString(2, co.getDescripcion());
	            
	            
	            cuantos = s.executeUpdate();
	 
	            if (cuantos !=0)
	            	vista.exito();

	    		}
        		catch (SQLException e) {
        			vista.yaExiste();
        		}
	    		catch (Exception e) {
	    			vista.noExito();
	    		}
	            
		
		return exito;
	}

	@Override
	public boolean delete(String key)  {
		// TODO Auto-generated method stub
		int cuantos=0;
		CategoriaVista vista = new CategoriaVista();

		try {
		      
            Connection connection = ConexionManager.getConnection();
            
            // Se crea un Statement, para realizar la consulta
            
            String query = "DELETE FROM categoria WHERE nombre =?";
            PreparedStatement s = connection.prepareStatement(query);
            
            s.setString(1, key);
            
            
            cuantos = s.executeUpdate();
 
            if (cuantos != 0)
            	vista.exitoBorrado();
            else
            	vista.noExiste();
            
        	}
	        catch (Exception e) {
				vista.noExitoBorrado();
			}
            
	
		return (cuantos ==1) ? true : false;
        
	}

	@Override
	public boolean update(CategoriaModelo co) {
		// TODO Auto-generated method stub
		boolean exito = false;
		int cuantos;
		CategoriaVista vista = new CategoriaVista();

		try {
		      
            Connection connection = ConexionManager.getConnection();
            
            // Se crea un Statement, para realizar la consulta
            
            String query = "UPDATE  categoria SET descripcion=?  WHERE nombre =?";
            PreparedStatement s = connection.prepareStatement(query);       
           
            s.setString(1, co.getDescripcion());
            s.setString(2, co.getNombre());
          
            cuantos = s.executeUpdate();
            
    		if (cuantos != 0){
    			exito = true;
    			vista.exitoUpdate();}
    		else
    			vista.noExitoUpdate();
    		
        	}
            catch (Exception e)
    		{
            	System.out.println("Error al actualizar");			
    		}
    		return exito;
		
	}
    
    
	@Override
	public CategoriaModelo findByKey(String key) {
		// TODO Auto-generated method stub
		int cuantos=0;
		CategoriaVista vista = new CategoriaVista();

		
		CategoriaModelo categoria = null;
		
		try {
		      
            Connection connection = ConexionManager.getConnection();
            
            // Se crea un Statement, para realizar la consulta
            
            String query = "SELECT * FROM categoria WHERE nombre=?";
            PreparedStatement s = connection.prepareStatement(query);
            
            s.setString(1, key);         
            
            ResultSet result = s.executeQuery();
                        
            if(result.next()) 
            	categoria = new CategoriaModelo(result.getString(1), result.getString(2));
		    
			}
    		catch (Exception e) {
    			vista.noExiste();
    				
    		}
         
		return categoria;
		
	}

	@Override
	public Iterator<CategoriaModelo> findAll() {
		// TODO Auto-generated method stub

		CategoriaModelo categoria;
		CategoriaVista vista = new CategoriaVista();
		ArrayList <CategoriaModelo> categorias = new ArrayList <CategoriaModelo>();
		try {
		      
            Connection connection = ConexionManager.getConnection();
            
            // Se crea un Statement, para realizar la consulta
            
            String query = "SELECT * FROM categoria";
            PreparedStatement s = connection.prepareStatement(query);
                        
            ResultSet result = s.executeQuery();
                                    
            while(result.next()) {
            	categoria = new CategoriaModelo(result.getString(1), result.getString(2));             
            	categorias.add(categoria);            
            }       
                        
            }
    		catch (Exception e) {
    			vista.noExito();    				
    		}
		return categorias.iterator();
	}

}
