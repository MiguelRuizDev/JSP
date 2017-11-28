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



public class UsuarioDAO implements DAO <UsuarioModelo, String> {

	public UsuarioModelo login (String login, String password){
		
		UsuarioModelo user = null;
		
		try {
		
		Connection connection = ConexionManager.getConnection();
		
		String query = "SELECT nif FROM usuario WHERE login = ? AND password = ?";
		
        PreparedStatement s = connection.prepareStatement(query);
        
        s.setString(1, login);
        s.setString(2, password);
        
        ResultSet result = s.executeQuery();
        
        if (result.next())
    		user = findByKey(result.getString(1));

		}
		catch ( Exception e) {
			e.printStackTrace();
			
		}
        return user;
	}
	@Override
	public boolean insert(UsuarioModelo vo) {
		// TODO Auto-generated method stub
		int cuantos = 0;
		UsuarioVista vista = new UsuarioVista();
		
	    try {
	    		//Connection connection = ConexionManager.getConnection();
    			// ANTES CON "ConexionManager"; AHORA CON "PoolConexiones"
	            Connection connection = ConexionManager.getConnection(); 
	            
	            //SE CREA UN STATEMENT PARA REALIZAR LA CONSULTA
	            
	            String query = "INSERT INTO usuario VALUES (?,?,?,?,?)";
	            PreparedStatement s = connection.prepareStatement(query);
	            
	            s.setString(1, vo.getNif());
	            s.setString(2, vo.getNombre());
	            s.setFloat(3, vo.getSaldo());
	            s.setString(4, vo.getLogin());
	            s.setString(5, vo.getPassword());

	            cuantos = s.executeUpdate(); //LA FUNCIÓN DEVUELVE EL NÚMERO DE FILAS INSERTADAS
	            
	            if (cuantos !=0)
	            	vista.exito();

	    		}
        		catch (SQLException e) {
        			vista.yaExiste();
        		}
	    		catch (Exception e) {
	    			vista.noExito();
	    		}
	            
		return (cuantos == 1) ? true : false; //TRUCO PARA DEVOLVER BOOLEAN
	}

	@Override
	public boolean delete(String key) {
		
		int cuantos = 0;
		UsuarioVista vista = new UsuarioVista();
		
        Connection connection = ConexionManager.getConnection();
        
        try{
        	
        	String query = "DELETE FROM usuario WHERE nif = ?";
            PreparedStatement s = connection.prepareStatement(query);
        	
            s.setString(1, key);
            
            cuantos = s.executeUpdate(); //LA FUNCIÓN DEVUELVE EL NÚMERO DE FILAS ELIMINADAS
                     
            if (cuantos != 0)
            	vista.exitoBorrado();
            else
            	vista.noExiste();
            
        	}
	        catch (Exception e) {
				vista.noExitoBorrado();
			}
	        
        return (cuantos == 1) ? true : false; //TRUCO PARA DEVOLVER BOOLEAN
	}

	@Override
	public boolean update(UsuarioModelo vo) {
		// TODO Auto-generated method stub
		boolean exito = false;
		int cuantos;
		UsuarioVista vista = new UsuarioVista();
		
        Connection connection = ConexionManager.getConnection(); 

        try{
        	
		String query = "UPDATE usuario SET nombre = ?, saldo = ?, login  =?,  password = ?  WHERE nif = ?";
		 
		PreparedStatement s = connection.prepareStatement(query);
		 		
		s.setString (1, vo.getNombre());
		s.setFloat (2, vo.getSaldo());
		s.setString (3, vo.getLogin());
		s.setString (4, vo.getPassword());
		s.setString(5, vo.getNif());
		
		
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
	public UsuarioModelo findByKey(String key) {
		// TODO Auto-generated method stub
		
		UsuarioModelo user = null;
		UsuarioVista vista = new UsuarioVista();
		
		Connection connection = ConexionManager.getConnection();

        try{
        	
		String query = "SELECT * FROM usuario WHERE nif = ?";
		 
		PreparedStatement s = connection.prepareStatement(query);
		
		s.setString(1, key);
		
		ResultSet result = s.executeQuery();
		 
		if (result.next())
		user = new UsuarioModelo(result.getString(1), result.getString(2), result.getFloat(3), result.getString(4),result.getString(5));
		
    	}
        catch (Exception e){
			vista.noExito();
		}
        
		return user;
	}

	@Override
	public Iterator <UsuarioModelo> findAll() {
		// TODO Auto-generated method stub
		
		UsuarioModelo user = null;
		UsuarioVista vista = new UsuarioVista();
		
		ArrayList <UsuarioModelo> usuarios = new ArrayList <UsuarioModelo>();
		
		Connection connection = ConexionManager.getConnection();
		
		try{
		
		String query = "SELECT * FROM usuario";
		
		PreparedStatement s = connection.prepareStatement(query);
				
		ResultSet result = s.executeQuery(query);
		 
		
		while (result.next()){ //HACEMOS USO DEL MÉTODO ".next()" DE RESULTSET
			
		user = new UsuarioModelo(result.getString(1), result.getString(2), result.getFloat(3), result.getString(4),result.getString(5));
		usuarios.add(user);
		}
		
    	}
        catch (Exception e) {
			vista.noExito();
		}
		
		//NO HACEMOS UN ".values()", PUES ESTAMOS TRABAJANDO CON UN ARRAYLIST, Y NO CON UN TREEMAP
		return usuarios.iterator(); 
	}
}
