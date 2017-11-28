package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


import modelo.*;
import vista.*;


public class CompraDAO implements DAO <CompraModelo, String> {

	@Override
	public boolean insert(CompraModelo vo) {
		// TODO Auto-generated method stub
		int cuantos = 0;
		CompraVista vista = new CompraVista();
		
	    try 	{
			      
	            Connection connection = ConexionManager.getConnection();
	            
	            // Se crea un Statement, para realizar la consulta
	            
	            String query = "INSERT INTO compra VALUES (?,?,?,?)";
	            PreparedStatement s = connection.prepareStatement(query);
	            
	            
	            s.setString(1, vo.getUsuario());
	            s.setString(2, vo.getProducto().getRef());
	            s.setTimestamp(3, new Timestamp(vo.getFecha().getTime()));
	            s.setInt(4, vo.getCantidad());
	            
	            
	            cuantos = s.executeUpdate();
	 
	            if (cuantos !=0)
	            	vista.exito();

	    		}
        		catch (SQLException e) {
        			vista.claveNoExistente();
        		}
	    		catch (Exception e) {
	    			vista.noExito();
	    		}
	            
		
		return (cuantos ==1) ? true : false;
	}

	@Override
	public boolean delete(String key) {
		
		int cuantos = 0;
		CompraVista vista = new CompraVista();

        Connection connection = ConexionManager.getConnection();
        
        try{
        	
        	String newKey[]=key.split("$$$");
        	
        	String query = "DELETE FROM compra WHERE nif = ? AND ref = ? AND fecha = ?";
            PreparedStatement s = connection.prepareStatement(query);
        	
            s.setString(1, newKey[0]);
            s.setString(2, newKey[1]);
            s.setString(3, newKey[2]);
            
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
	public boolean update(CompraModelo vo) {
		// TODO Auto-generated method stub
		boolean exito = false;
		int cuantos;
		CompraVista vista = new CompraVista();
		
        Connection connection = ConexionManager.getConnection();

        try{
        	
        
		String query = "UPDATE compra SET cantidad = ?  WHERE nif=? AND ref = ? AND fecha=?";
		 
		PreparedStatement s = connection.prepareStatement(query);
		 

		s.setInt (1, vo.getCantidad());
		
		s.setString(2, vo.getUsuario());
		s.setString (3, vo.getProducto().getRef());
		s.setTimestamp (4, new Timestamp(vo.getFecha().getTime()));
		
		cuantos = s.executeUpdate();
		
		if (cuantos != 0){
			exito = true;
			vista.exitoUpdate();}
		else
			vista.noExitoUpdate();
		
    	}
        catch (Exception e){
        	System.out.println("Error al actualizar");			
		}
        
		return exito;
	}

	@Override
	public CompraModelo findByKey(String key) {
		// TODO Auto-generated method stub
		
		CompraModelo comp = null;
		CompraVista vista = new CompraVista();
		UsuarioDAO daoUser = new UsuarioDAO ();
		ProductoDAO daoProd = new ProductoDAO();
		
		Connection connection = ConexionManager.getConnection();

        try{
        	
        String newKey[]=key.split("$$$");
        
        
		String query = "SELECT * FROM compra WHERE nif=? AND ref=? AND fecha=?";
		 
		PreparedStatement s = connection.prepareStatement(query);
		
		s.setString(1, newKey[0]);
        s.setString(2, newKey[1]);
        s.setString(3, newKey[2]);
		
		ResultSet result = s.executeQuery();
		 
		
		if(result.next())
		comp = new CompraModelo (result.getString(1),daoProd.findByKey(result.getString(2)), new Date (result.getTimestamp(3).getTime()), result.getInt(4));
		
    	}
        catch (Exception e){
			vista.noExiste();
		}
        
		return comp;
	}

	@Override
	public Iterator <CompraModelo> findAll() {
		// TODO Auto-generated method stub
		
		CompraModelo comp = null;
		CompraVista vista = new CompraVista();
		UsuarioDAO daoUser = new UsuarioDAO ();
		ProductoDAO daoProd = new ProductoDAO();
		
		ArrayList <CompraModelo> compras = new ArrayList<CompraModelo> ();
		
		Connection connection = ConexionManager.getConnection();
		
		try{
		
		String query = "SELECT * FROM compra";
		
		PreparedStatement s = connection.prepareStatement(query);
		
		//Statement st = connection.createStatement();
		
		ResultSet result = s.executeQuery(query);
		 
		
		while (result.next()){
			
		comp = new CompraModelo (result.getString(1),daoProd.findByKey(result.getString(2)), new Date (result.getTimestamp(3).getTime()), result.getInt(4));
		compras.add(comp);
		}
		
    	}
        catch (Exception e)
		{
			vista.noExito();
			
		}
		
		return compras.iterator();
	}
}
