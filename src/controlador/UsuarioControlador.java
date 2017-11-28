package controlador;

import modelo.*;

import daw.com.Teclado;

//CONTROLADOR ES TODO LO QUE INTERACIONA DIRECTAMENTE CON EL USUARIO

public class UsuarioControlador {

	private UsuarioModelo usuario;
	
	public UsuarioControlador() {
		this.usuario = null;
	}
	
	public UsuarioControlador(UsuarioModelo usuario) {
		this.usuario = usuario;
	}

	public UsuarioModelo getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioModelo usuario) {
		this.usuario = usuario;
	}
	public void restarSaldo(float sustraendo){
		
		usuario.setSaldo(usuario.getSaldo() - sustraendo);
	}
	
	public void subirSaldo(){
		
		float cantidad = Teclado.leerFloat("\nCantidad a recargar:\n");
		usuario.setSaldo(usuario.getSaldo() + cantidad);
	}

	public void leerDatos() {
		
		leerPK(); 
		leerResto();
	}
	
	public void leerPK() {
		usuario.setNif(Teclado.leerString("Nif:"));
	}
	
	public void leerResto(){
		usuario.setNombre(Teclado.leerString("Nombre:"));
		usuario.setSaldo(Teclado.leerFloat("Saldo:")); 
		usuario.setLogin(Teclado.leerString("Login:"));
		usuario.setPassword(Teclado.leerString("Password:"));
	}
}
