import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		//Realiza la conexion con la base de datos
		Conexion con = new Conexion();
		//Connection reg = con.getConn();
		Scanner scan = new Scanner(System.in);
		
		//Objetos que nos ayudaran a utilizar sus metodos
		OfrendaRegular or = new OfrendaRegular();
		OfrendaAmor oa = new OfrendaAmor();
		OfrendaConstruccion oc = new OfrendaConstruccion();
		Talentos t = new Talentos();
		Aseos a = new Aseos();
		Ingresos i = new Ingresos();
		
		String ansF;
		
		System.out.println();
		System.out.println("Bienvenido " + inicioSesion(con) + ", a que ingresos quieres acceder?"); 
		System.out.println();
		
		do
		{
		System.out.println("a) Ofrendas regulares");
		System.out.println("b) Ofrendas de amor");
		System.out.println("c) Ofrendas de construccion");
		System.out.println("d) Talentos");
		System.out.println("e) Aseos");
		System.out.println("f) Ver total en cajas");
		
		System.out.println();
		System.out.print("Seleccione una opcion (a, b, c, d ,e o f): ");
		String ses1 = scan.nextLine();
		ses1.toLowerCase();
		
		switch(ses1)
		{
		case "a":
			System.out.println();
			System.out.println("Elegiste ofrendas regulares, que desesas hacer?");
			System.out.println("1) Recoger ofrenda regular");
			System.out.println("2) Ver registros");
			System.out.println("3) Obtener el total de las ofrendas regulares");
			System.out.println("4) Borrar un registro");
			System.out.println("5) Actualizar un registro");
			
			System.out.println();
			System.out.print("Seleccione una opcion (1, 2, 3, 4 o 5): ");
			String des1 = scan.nextLine();
			
			des1.toLowerCase();
			
			switch(des1)
			{
			case "1":
				or.recogerOfrenda();
				break;
				
			case "2":
				or.verRegistro();
				break;
				
			case "3":
				or.obtenerTotal();
				break;
				
			case "4":
				or.borrarRegistro();
				break;
				
			case "5":
				or.actualizarRegistro();
				break;
				
			default:
				System.out.println("Lo siento, esa opcion no existe");
				break;
			}
			break;
			
		case "b":
			System.out.println();
			System.out.println("Elegiste ofrendas de amor, que desesas hacer?");
			System.out.println("1) Recoger ofrenda de amor");
			System.out.println("2) Ver registros");
			System.out.println("3) Obtener el total de las ofrendas de amor");
			System.out.println("4) Borrar un registro");
			System.out.println("5) Actualizar un registro");
			
			System.out.println();
			System.out.print("Seleccione una opcion (1, 2, 3, 4 o 5): ");
			String des2 = scan.nextLine();
			
			des2.toLowerCase();
			
			switch(des2)
			{
			case "1":
				oa.recogerOfrenda();
				break;
				
			case "2":
				oa.verRegistro();
				break;
				
			case "3":
				oa.obtenerTotal();
				break;
				
			case "4":
				oa.borrarRegistro();
				break;
				
			case "5":
				oa.actualizarRegistro();
				break;
				
			default:
				System.out.println("Lo siento, esa opcion no existe");
				break;
			}
			break;
			
		case "c":
			System.out.println();
			System.out.println("Elegiste ofrendas de construccion, que desesas hacer?");
			System.out.println("1) Recoger ofrenda de construccion");
			System.out.println("2) Ver registros");
			System.out.println("3) Obtener el total de las ofrendas de construccion");
			System.out.println("4) Borrar registro");
			System.out.println("5) Actualizar un registro");
			
			System.out.println();
			System.out.print("Seleccione una opcion (1, 2, 3, 4 o 5): ");
			String des3 = scan.nextLine();
			
			des3.toLowerCase();
			
			switch(des3)
			{
			case "1":
				oc.recogerOfrenda();
				break;
				
			case "2":
				oc.verRegistro();
				break;
				
			case "3":
				oc.obtenerTotal();
				break;
				
			case "4":
				oc.borrarRegistro();
				break;
				
			case "5":
				oc.actualizarRegistro();
				break;
				
			default:
				System.out.println("Lo siento, esa opcion no existe");
				break;
			}
			break;
			
		case "d":
			System.out.println();
			System.out.println("Elegiste talentos, que desesas hacer?");
			System.out.println("1) Hacer talento");
			System.out.println("2) Ver registros");
			System.out.println("3) Obtener el total de los talentos");
			System.out.println("4) Borrar registro");
			System.out.println("5) Actualizar un registro");
			
			System.out.println();
			System.out.print("Seleccione una opcion (1, 2, 3, 4 o 5): ");
			String des4 = scan.nextLine();
			
			des4.toLowerCase();
			
			switch(des4)
			{
			case "1":
				t.hacerTalento();
				break;
				
			case "2":
				t.verRegistro();
				break;
				
			case "3":
				t.obtenerTotal();
				break;
				
			case "4":
				t.borrarRegistro();
				break;
				
			case "5":
				t.actualizarRegistro();
				break;
			
			default:
				System.out.println("Lo siento, esa opcion no existe");
				break;
			}
			break;
			
		case "e":
			System.out.println();
			System.out.println("Elegiste aseos, que desesas hacer?");
			System.out.println("1) Hacer aportacion");
			System.out.println("2) Ver registros");
			System.out.println("3) Obtener el total de los aseos");
			System.out.println("4) Borrar registro");
			System.out.println("5) Actualizar un registro");
			
			System.out.println();
			System.out.print("Seleccione una opcion (1, 2, 3, 4 o 5): ");
			String des5 = scan.nextLine();
			
			des5.toLowerCase();
			
			switch(des5)
			{
			case "1":
				a.hacerCoperacion();
				break;
				
			case "2":
				a.verRegistro();
				break;
				
			case "3":
				a.obtenerTotal();
				break;
				
			case "4":
				a.borrarRegistro();
				break;
				
			case "5":
				a.actualizarRegistro();
				break;
				
			default:
				System.out.println("Lo siento, esa opcion no existe");
				break;
			}
			break;
			
		case "f":
			System.out.println();
			i.calcularTotal();
			break;
			
		default:
			System.out.println("Esa opcion no existe, por favor intentelo de nuevo");
			break;
		}
		
		System.out.println();
		System.out.print("Quieres realizar otra accion? (y/n)");
		ansF = scan.nextLine();
		ansF.toLowerCase();
		System.out.println();
		
		}while(ansF.equals("y"));
		
		con.desconectar();
		System.out.println("Que tenga un excelente dia :)");
	}

	
	public static String inicioSesion(Conexion conne)
	{
		boolean exit = false;
		String nombreIn = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("Hola!!! Ingresa tu nombre y contraseña para iniciar sesión, si no tienes una cuenta registrada crea una.");
		do 
		{
			
			System.out.print("Que desesas hacer ahora? (ingresar / registrar): ");
			
			String des =  scan.nextLine();
			des.toLowerCase();
			
			switch(des)
			{
			case "ingresar":
				System.out.print("Ingresa el nombre: ");
				nombreIn = scan.nextLine();

				System.out.print("Ingresa la contreseña: ");
				String contraIn = scan.nextLine();
				
				if(conne.ingresar(nombreIn, contraIn))
				{
					exit = true;
					System.out.println("Ingresaste correctamente");
				}
				else
				{
					exit = false;
					System.out.println("El nombre o contraseña son incorrectos o no estan registrados");
					System.out.println("Intentanlo nuevamente.");
				}
				break;
			
			case "registrar":
				System.out.print("Ingresa el nombre que quieres registrar: ");
				String nombre = scan.nextLine();
				System.out.print("Ingresa la contraseña que quieres registrar: ");
				String contra = scan.nextLine();
				conne.registrar(nombre, contra);
				break;
				
			default:
				System.out.println("Lo siento, pero esa opcion no esta disponible");
				System.out.println("Intentanlo nuevamente.");
				exit = false;
				break;
			}
			
			System.out.println();
			
		}
		while(exit == false);
		
		return nombreIn;
	}
}