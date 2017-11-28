package menu;

import dao.*;
import controlador.*;
import vista.*;
import modelo.*;

public class RecargarSaldo implements MenuAction {

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		
		UsuarioModelo usuario = new UsuarioModelo ();
		UsuarioControlador controlador = new UsuarioControlador (usuario);
		UsuarioVista vista = new UsuarioVista(usuario);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		controlador.leerPK();

		usuario = usuarioDAO.findByKey(usuario.getNif());
				
		if(usuario != null) { //CONDICION DE EXISTENCIA
			
			//SETEAMOS CON EL NUEVO USUARIO, YA RELLENO DE TODOS SUS DATOS
			controlador.setUsuario(usuario);
			vista.setUsuario(usuario);
			
			vista.saldoActual();
			controlador.subirSaldo();
			
			if(usuarioDAO.update(usuario)){
				vista.saldoRecargado();
				//usuarioDAO.update(usuario);
			}
			else
				vista.noExito();
			
		}
		else
			vista.noExiste();
		
		
	}

}
