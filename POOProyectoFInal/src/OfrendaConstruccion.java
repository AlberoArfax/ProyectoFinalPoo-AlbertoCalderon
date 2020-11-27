import java.util.Scanner;

public class OfrendaConstruccion extends Ofrendas{
	
	Scanner scan = new Scanner(System.in);
	Conexion con = new Conexion();
	
	public void recogerOfrenda() {
		System.out.println("Se recogio una ofrenda de construccion, se guardara en el registro");
		
		System.out.print("Ingresa la fecha en la que se recogió la ofrenda (YYYY-MM-DD): ");
		String fecha = scan.nextLine();
		super.setFecha(fecha);
		
		System.out.print("Ingrese el total del dinero que se recogio con decimales: ");
		double montoTotal = scan.nextDouble();
		scan.nextLine();
		super.setMontoTotal(montoTotal);
		
		System.out.print("En donde se utilizara esta ofrenda de construccion? ");
		String destino = scan.nextLine();
		super.setDestino(destino);
		
		con.ingresarCsontruccion(super.getFecha(), super.getMontoTotal(), super.getDestino());
	}


	public void verRegistro() {
		System.out.println("Este es el registro de las ofrendas de construccion");
		
		System.out.println();
		System.out.print("Numero\t\t");
		System.out.print("Fecha\t\t\t");
		System.out.print("Monto\t\t");
		System.out.print("Destino\t");
		System.out.println();
		
		con.mostrarConstruccion();
	}

	
	public double obtenerTotal() {
		System.out.println("El total de las ofrendas de construccion es: " + con.obtenerTotalConstruccion());
		return con.obtenerTotalConstruccion();
	}


	public void borrarRegistro() {
		this.verRegistro();
		
		System.out.println();
		System.out.print("Que registro quieres borrar?(Ingresa el numero): ");
		int numero = scan.nextInt();
		scan.hasNextLine();
		
		con.borrarConstruccion(numero);
	}


	public void actualizarRegistro() {
		this.verRegistro();
		
		System.out.println();
		System.out.print("Que registro quieres modificar?(Ingresa el numero): ");
		int numero = scan.nextInt();
		scan.hasNextLine();
		
		con.actualizarConstruccion(numero);
	}
	
}
