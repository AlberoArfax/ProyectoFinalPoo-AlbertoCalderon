
public abstract class Ofrendas {

	private String fecha;
	private double montoTotal;
	private String servicio;
	private String destino;
	
	public Ofrendas()
	{
		this.setFecha("YYYY-MM-DD");
		this.setMontoTotal(0);
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String afecha) {
		this.fecha = afecha;
	}

	public double getMontoTotal() {
		return this.montoTotal;
	}

	public void setMontoTotal(double amontoTotal) {
		this.montoTotal = amontoTotal;
	}

	public String getServicio() {
		return this.servicio;
	}

	public void setServicio(String aservicio) {
		this.servicio = aservicio;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String adestino) {
		this.destino = adestino;
	}
	
	public abstract void recogerOfrenda();
	
	public abstract void verRegistro();
	
	public abstract void borrarRegistro();
	
	public abstract void actualizarRegistro();
	
	public abstract double obtenerTotal();
	
}
