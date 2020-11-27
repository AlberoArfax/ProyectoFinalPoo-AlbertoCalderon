import java.util.Scanner;


public class OfrendaAmor extends Ofrendas{

	Scanner scan = new Scanner(System.in);
	Conexion con = new Conexion();
	
	public void recogerOfrenda() {
		System.out.println("Se recogio una ofrenda de amor, se guardara en el registro");
		
		System.out.print("Ingresa la fecha en la que se recogió la ofrenda (YYYY-MM-DD): ");
		String fecha = scan.nextLine();
		super.setFecha(fecha);
		
		System.out.print("Ingrese el total del dinero que se recogio con decimales: ");
		double montoTotal = scan.nextDouble();
		scan.nextLine();
		super.setMontoTotal(montoTotal);
		
		System.out.print("Para quien es esta ofrenda de amor? ");
		String destino = scan.nextLine();
		super.setDestino(destino);
		
		con.ingresarAmor(super.getFecha(), super.getMontoTotal(), super.getDestino());
	}


	public void verRegistro() {
		System.out.println("Este es el registro de las ofrendas de amor");
		
		System.out.println();
		System.out.print("Numero\t\t");
		System.out.print("Fecha\t\t\t");
		System.out.print("Monto\t\t");
		System.out.print("Destino\t");
		System.out.println();
		
		con.mostrarAmor();
	}

	
	public double obtenerTotal() {
		System.out.println("El total de las ofrendas de amor es: " + con.obtenerTotalAmor());
		return con.obtenerTotalAmor();
	}


	public void borrarRegistro() {
		this.verRegistro();
		
		System.out.println();
		System.out.print("Que registro quieres borrar?(Ingresa el numero): ");
		int numero = scan.nextInt();
		scan.hasNextLine();
		
		con.borrarAmor(numero);
	}


	public void actualizarRegistro() {
		this.verRegistro();
		
		System.out.println();
		System.out.print("Que registro quieres modificar?(Ingresa el numero): ");
		int numero = scan.nextInt();
		scan.hasNextLine();
		
		con.actualizarAmor(numero);
	}

}
