package menu;


public class AppTienda extends AppMenu{
	
	public AppTienda(){
		
		addOpcion (new MenuItem ("Alta Usuario", 1, new AltaUsuario()));
		addOpcion (new MenuItem ("Alta Producto", 2, new AltaProducto()));
		addOpcion (new MenuItem ("Comprar", 3, new Comprar()));
		addOpcion (new MenuItem ("Recargar Saldo", 4, new RecargarSaldo()));
		addOpcion (new Salir());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppTienda app = new AppTienda();
		
		app.run();
	}

}
