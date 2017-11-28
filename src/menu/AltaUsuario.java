package menu;

import dao.*;
import controlador.*;
import vista.*;
import modelo.*;

public class AltaUsuario implements MenuAction{
	
	@Override
	public void doMenuAction() { 
		
		UsuarioModelo usuario = new UsuarioModelo ();
		UsuarioControlador controlador = new UsuarioControlador (usuario);
		UsuarioVista vista = new UsuarioVista(usuario);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		
		controlador.leerPK();
		
		//CON SOLO LA PK PODEMOS SABER SI SE ENCUENTRA EN LA BD
		if(usuarioDAO.findByKey(usuario.getNif()) == null){
			
			controlador.leerResto();
		
			if (!usuarioDAO.insert(usuario))
				vista.noExito();	
		}
		else
			vista.yaExiste();
	}


}
