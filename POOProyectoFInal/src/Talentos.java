import java.util.Scanner;

public class Talentos {

	
	Scanner scan = new Scanner(System.in);
	Conexion con = new Conexion();
	
	private String familia;
	private String fecha;
	private String platillo;
	private double monto;
	
	
	public String getFamilia() {
		return this.familia;
	}
	
	public void setFamilia(String afamilia) {
		this.familia = afamilia;
	}
	
	public String getFecha() {
		return this.fecha;
	}
	
	public void setFecha(String afecha) {
		this.fecha = afecha;
	}
	
	public String getPlatillo() {
		return this.platillo;
	}
	public void setPlatillo(String aplatillo) {
		this.platillo = aplatillo;
	}
	
	public double getMonto() {
		return this.monto;
	}
	
	public void setMonto(double amonto) {
		this.monto = amonto;
	}
	
	public void hacerTalento()
	{
		System.out.println("Se ha hecho un talento, se guardara en el registro");
		
		System.out.print("Ingresa los apellidos de la familia que realizo el talento: ");
		String familia = scan.nextLine();
		this.setFamilia(familia);
		
		System.out.print("Ingresa la fecha en la que se realizo el talento (YYYY-MM-DD): ");
		String fecha = scan.nextLine();
		this.setFecha(fecha);
		
		System.out.print("Ingresa el platillo que se preparo: ");
		String platillo = scan.nextLine();
		this.setPlatillo(platillo);
		
		System.out.print("Ingresa el total de dinero que se junto con el talento usando decimales: ");
		double monto = scan.nextDouble();
		scan.nextLine();
		this.setMonto(monto);
		
		con.ingresarTalento(this.getFamilia(), this.getFecha(), this.getPlatillo(), this.getMonto());
		
	}
	
	public void verRegistro()
	{
		System.out.println("Este es el registro de los talentos");
		
		System.out.println();
		System.out.print("Numero\t\t");
		System.out.print("Familia\t\t\t");
		System.out.print("Fecha\t\t\t");
		System.out.print("Platillo\t\t");
		System.out.print("Monto\t");
		System.out.println();

		con.mostrarTalento();
	}
	
	public double obtenerTotal()
	{
		System.out.println("El total de los talentos es: " + con.obtenerTotalTalento());
		return con.obtenerTotalTalento();
	}
	
	public void borrarRegistro()
	{
		this.verRegistro();
		
		System.out.println();
		System.out.print("Que registro quieres borrar?(Ingresa el numero): ");
		int numero = scan.nextInt();
		scan.hasNextLine();
		
		con.borrarTalento(numero);
	}
	
	public void actualizarRegistro()
	{
		this.verRegistro();
		
		System.out.println();
		System.out.print("Que registro quieres modificar?(Ingresa el numero): ");
		int numero = scan.nextInt();
		scan.hasNextLine();
		
		con.actualizarTalento(numero);
	}
}
