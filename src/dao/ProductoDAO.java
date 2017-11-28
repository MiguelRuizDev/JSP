package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.*;
import vista.*;
import dao.*;


public class ProductoDAO implements DAO <ProductoModelo, String> {

	
	public ProductoModelo getByDescripcion (String descripcion){
		ProductoModelo prod = null;
		
		try {
			
			Connection connection = ConexionManager.getConnection();
			
			String query = "SELECT ref FROM producto WHERE descripcion = ?";
			
	        PreparedStatement s = connection.prepareStatement(query);
	        
	        s.setString(1, descripcion);
	        
	        
	        ResultSet result = s.executeQuery();
	        
	        if (result.next())
	    		prod = findByKey(result.getString(1));

			}
			catch ( Exception e) {
				e.printStackTrace();
				
			}
		
		return prod;
	}
	@Override
	public boolean insert(ProductoModelo vo) {
		// TODO Auto-generated method stub
		int cuantos = 0;
		//ProductoVista vista = new ProductoVista();
		
		
	    try 	{
			      
	            Connection connection = ConexionManager.getConnection();
	           	                   
	            String query = "INSERT INTO producto VALUES (?,?,?,?,?)";
	            
	            PreparedStatement s = connection.prepareStatement(query);
	            
	            
	            s.setString(1, vo.getRef());
	            s.setString(2, vo.getDescripcion());
	            s.setFloat(3, vo.getPvp());
	            s.setInt(4, vo.getStock());
	            s.setString(5, vo.getCategoria());
	            
	            cuantos = s.executeUpdate();
	 
	           /*if (cuantos !=0)
	            	vista.exito();*/

	    		}
	            
        		catch (SQLException e) {
        			//vista.yaExiste();
        		}
	    		catch (Exception e) {
	    			//vista.noExito();
	    		}
	            
	    
		
		return (cuantos == 1) ? true : false;
	}

	@Override
	public boolean delete(String key) {
		
		int cuantos = 0;
		ProductoVista vista = new ProductoVista();

		
        Connection connection = ConexionManager.getConnection();
        
        try{
        	
        	String query = "DELETE FROM producto WHERE ref = ?";
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
	public boolean update(ProductoModelo vo) {
		// TODO Auto-generated method stub
		boolean exito = false;
		int cuantos;
		ProductoVista vista = new ProductoVista();

		
        Connection connection = ConexionManager.getConnection();

        try{
        	
        
		String query = "UPDATE producto SET descripcion = ?, pvp = ?, stock = ?,  categoria = ?  WHERE ref = ?";
		 
		PreparedStatement s = connection.prepareStatement(query);
		 	
		s.setString (1, vo.getDescripcion());
		s.setFloat (2, vo.getPvp());
		s.setInt (3, vo.getStock());
		s.setString (4, vo.getCategoria());
		s.setString(5, vo.getRef());
		
		cuantos = s.executeUpdate();
		
		if (cuantos != 0){
			exito = true;
			vista.exitoUpdate();}
		else
			vista.noExitoUpdate();
		
        }
        catch (Exception e)
		{
        	e.printStackTrace();
        	System.out.println("Error al actualizar");
        }
		return exito;
	}

	@Override
	public ProductoModelo findByKey(String key) {
		// TODO Auto-generated method stub
		
		ProductoModelo prod = null;
		ProductoVista vista = new ProductoVista();
		CategoriaDAO daocat = new CategoriaDAO();

		
		Connection connection = ConexionManager.getConnection();

        try{
        	
        
		String query = "SELECT * FROM producto WHERE ref = ?";
		 
		PreparedStatement s = connection.prepareStatement(query);
		
		s.setString(1, key);
		
		ResultSet result = s.executeQuery();
		 	
		if(result.next())
		prod = new ProductoModelo (result.getString(1), result.getString(2), result.getFloat(3), result.getInt(4),result.getString(5));
		
		// MARAVILLA: daocat.findByKey(result.getString(5))
    	}
        catch (Exception e)
		{
        	vista.noExito();			
		}
        
		return prod;
	}

	@Override
	public Iterator <ProductoModelo> findAll() {
		// TODO Auto-generated method stub
		
		ProductoModelo prod = null;
		ProductoVista vista = new ProductoVista();
		CategoriaDAO daocat = new CategoriaDAO();

		
		ArrayList <ProductoModelo> productos = new ArrayList <ProductoModelo>();
		
		Connection connection = ConexionManager.getConnection();
		
		try{
		
		String query = "SELECT * FROM producto";
		
		PreparedStatement s = connection.prepareStatement(query);
				
		ResultSet result = s.executeQuery(query);
		 
		
		while (result.next()){
			
		prod = new ProductoModelo (result.getString(1), result.getString(2), result.getFloat(3), result.getInt(4), result.getString(5));
		productos.add(prod);
		}
		
    	}
        catch (Exception e){
			vista.noExito();
			
		}
		
		return productos.iterator(); 
	}
}
