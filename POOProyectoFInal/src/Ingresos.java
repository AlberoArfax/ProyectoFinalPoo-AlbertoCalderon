
public class Ingresos {
	
	private double totalDinero;
	OfrendaRegular or;
	OfrendaAmor oa;
	OfrendaConstruccion oc;
	Talentos t;
	Aseos a;

	public Ingresos()
	{
		or = new OfrendaRegular();
		oa = new OfrendaAmor();
		oc = new OfrendaConstruccion();
		t = new Talentos();
		a = new Aseos();
	}
	
	public double getTotalDinero() {
		return this.totalDinero;
	}

	public void setTotalDinero(double atotalDinero) {
		this.totalDinero = atotalDinero;
	}
	
	public void calcularTotal()
	{
		double total = 0;
		
		total = or.obtenerTotal() + oa.obtenerTotal() + oc.obtenerTotal() + t.obtenerTotal() + a.obtenerTotal();
		
		System.out.println("El total de dinero que se tiene en cajas es: " + total);
	}
}
