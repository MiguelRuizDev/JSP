package vista;

import modelo.*;
import daw.com.*;

public class UsuarioVista {

		private UsuarioModelo usuario;

		public UsuarioVista() {
			this.usuario = null;
		}
		
		public UsuarioVista(UsuarioModelo usuario) {
			this.usuario = usuario;
		}

		public UsuarioModelo getUsuario() {
			return usuario;
		}
		public void setUsuario(UsuarioModelo usuario) {
			this.usuario = usuario;
		}
		
		public void mostrarDatos () {
			Pantalla.escribirString(usuario.toString());		
		}
		
		public void exito (){
			Pantalla.escribirString("\nOperación realizada con éxito\n");
		}
		
		public void noExito(){
			Pantalla.escribirString("\nError al realizar la operación\n");
		}
		
		public void yaExiste (){
			Pantalla.escribirString("\nUsuario ya existente\n");
		}
		
		public void noExiste(){
			Pantalla.escribirString("\nUsuario no existente\n");
		}
		
		public void exitoUpdate(){
			Pantalla.escribirString("\nUsuario actualizado\n");
		}
		
		public void noExitoUpdate(){
			Pantalla.escribirString("\nError al actualizar, usuario no existente\n");

		}
		
		public void exitoBorrado(){
			Pantalla.escribirString("\nUsuario borrado con éxito\n");

		}
		
		public void noExitoBorrado(){
			Pantalla.escribirString("\nError al borrar usuario\n");

		}
		
		public void saldoActual(){
			System.out.println("\nSaldo actual:" + usuario.getSaldo());
		}
		
		public void saldoRecargado(){
			System.out.println("\nSaldo tras recargar:" + usuario.getSaldo());
		}
		
		public void noSaldo (){
			System.out.println("\nSaldo insuficiente");
		}
		
}
