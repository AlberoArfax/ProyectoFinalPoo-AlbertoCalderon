import java.util.Scanner;

public class OfrendaRegular extends Ofrendas{

	Scanner scan = new Scanner(System.in);
	Conexion con = new Conexion();
	
	public void recogerOfrenda() {
		
		System.out.println("Se recogio una ofrenda, se guardara en el registro");
		
		System.out.print("Ingresa la fecha en la que se recogió la ofrenda (YYYY-MM-DD): ");
		String fecha = scan.nextLine();
		super.setFecha(fecha);
		
		System.out.print("Ingrese el total del dinero que se recogio con decimales: ");
		double montoTotal = scan.nextDouble();
		scan.nextLine();
		super.setMontoTotal(montoTotal);
		
		System.out.print("En que servicio se recogio la ofrenda? (mañana, medio dia o tarde): ");
		String servicio = scan.nextLine();
		super.setServicio(servicio);
		
		con.ingresarRegular(super.getFecha(), super.getMontoTotal(), super.getServicio());
	}

	public void verRegistro() {
		
		System.out.println("Este es el registro de las ofrendas regulares");
		
		System.out.println();
		System.out.print("Numero\t\t");
		System.out.print("Fecha\t\t\t");
		System.out.print("Monto\t\t");
		System.out.print("Servicio\t");
		System.out.println();
		
		con.mostrarRegular();
	}

	public double obtenerTotal() {
		
		System.out.println("El total de las ofrendas regulares es: " + con.obtenerTotalRegular());
		return con.obtenerTotalRegular();
	}


	public void borrarRegistro() {
		this.verRegistro();
		
		System.out.println();
		System.out.print("Que registro quieres borrar?(Ingresa el numero): ");
		int numero = scan.nextInt();
		scan.hasNextLine();
		
		con.borrarRegular(numero);
		
	}

	public void actualizarRegistro() {
		this.verRegistro();
		
		System.out.println();
		System.out.print("Que registro quieres modificar?(Ingresa el numero): ");
		int numero = scan.nextInt();
		scan.hasNextLine();
		
		con.actualizarRegular(numero);
		
	}
	
}
