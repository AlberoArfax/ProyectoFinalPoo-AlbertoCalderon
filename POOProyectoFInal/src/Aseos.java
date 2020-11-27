import java.util.Scanner;

public class Aseos {

	Scanner scan = new Scanner(System.in);
	Conexion con = new Conexion();
	
	private String aportador;
	private double monto;
	private String fecha;
	
	
	public String getAportador() {
		return this.aportador;
	}
	
	public void setAportador(String aaportador) {
		this.aportador = aaportador;
	}

	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double amonto) {
		this.monto = amonto;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String afecha) {
		this.fecha = afecha;
	}
	
	public void hacerCoperacion()
	{
		System.out.println("Se ha hecho una cooperacion para aseo, se guardara en el registro");
		
		System.out.print("Ingresa el nombre del aportador : ");
		String aportador = scan.nextLine();
		this.setAportador(aportador);
		
		System.out.print("Ingresa el total de dinero que se junto con el aporte usando decimales: ");
		double monto = scan.nextDouble();
		scan.nextLine();
		this.setMonto(monto);
		
		System.out.print("Ingresa la fecha en la que se realizo el aporte (YYYY-MM-DD): ");
		String fecha = scan.nextLine();
		this.setFecha(fecha);
		
		con.ingresarAporte(this.getAportador(), this.getMonto(), this.getFecha());
	}
	
	public void verRegistro()
	{
		System.out.println("Este es el registro de las cooperaciones para los aseos");
		
		System.out.println();
		System.out.print("Numero\t\t");
		System.out.print("Aportador\t\t");
		System.out.print("Monto\t\t");
		System.out.print("Fecha\t");
		System.out.println();
		
		con.mostrarAseos();
	}
	
	public double obtenerTotal()
	{
		System.out.println("El total de las aportaciones para aseos es: " + con.obtenerTotalAseo());
		return con.obtenerTotalAseo();
	}
	
	public void borrarRegistro()
	{
		this.verRegistro();
		
		System.out.println();
		System.out.print("Que registro quieres borrar?(Ingresa el numero): ");
		int numero = scan.nextInt();
		scan.hasNextLine();
		
		con.borrarAseo(numero);
	}
	
	public void actualizarRegistro()
	{
		this.verRegistro();
		
		System.out.println();
		System.out.print("Que registro quieres modificar?(Ingresa el numero): ");
		int numero = scan.nextInt();
		scan.hasNextLine();
		
		con.actualizarAseo(numero);
	}
}
