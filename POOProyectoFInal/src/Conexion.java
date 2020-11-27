import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class Conexion {

	private Connection conn;
	String servidor = "127.0.0.1:3306";
	String baseDatos = "iglesia?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //Tiene esta parte de mas porque me daba un error sobre la zona horaria
	String usuario = "root";
	String clave = "hola1234";
	String url = "jdbc:mysql://" + servidor + "/" + baseDatos;
	
	public Conexion()
	{
		conn = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = java.sql.DriverManager.getConnection(url, usuario, clave);
			//Como saber si ya estoy conectado a la bbdd
			if(conn != null)
			{
				//System.out.println("Conexion establecida");
			}
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			System.out.println("Error al concetar " + e);
		}
	}
	
	public Connection getConn()
	{
		return this.conn;
	}
	
	public void desconectar()
	{
		conn = null;
		
		if(conn == null)
		{
			System.out.println("Conexion terminada");
		}
	}
	
	
	//Metodos para la autenticacion de usuarios
	public void registrar(String nombre, String contraseña)
	{	
		try
		{
			java.sql.Statement stmt =  conn.createStatement();
			String sql = "INSERT INTO acceso_usuarios (`nombre-usuario`, `contraseña-usuario`) VALUES (\" "+ nombre + "\", \""+ contraseña +"\")";
			stmt.execute(sql);
			stmt.close();
			System.out.println("Registro realizado con exito");
		}
		catch (java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla en el registro");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
	}
	
	public boolean ingresar(String nombre, String contraseña)
	{
		ArrayList<String> comp = new ArrayList<String>();
		int contN = 0;
		int contP = 0;
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM acceso_usuarios";
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String nombreAut = rs.getString("nombre-usuario");
				String contraAut = rs.getString("contraseña-usuario");
				String nom = nombreAut.replace(" ", "");
				String cont = contraAut.replace(" ", "");
				comp.add(nom);
				comp.add(cont);
			}
			
			for(int i=0; i<comp.size(); i++)
			{
				if(comp.get(i).equals(nombre))
				{
					contN = 1;
				}
				
				if(comp.get(i).equals(contraseña)) {
					contP = 1;
				}
			}
			
			stmt.close();
			rs.close();
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al iniciar sesion");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
		
		if(contN == 1 && contP == 1)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	//Metodos para las ofrendas regulares
	public void ingresarRegular(String fecha, double monto, String servicio)
	{
		try
		{
			java.sql.Statement stmt =  conn.createStatement();
			String sql = "INSERT INTO ofrendas_regulares (`fecha`, `monto-total`, `servicio`) VALUES (' "+ fecha + "', '" + monto +"', '" + servicio +"')";
			stmt.execute(sql);
			stmt.close();
			System.out.println("La ofrenda regular se registro exitosamente");
		}
		catch (java.sql.SQLException ex)
		{
			System.out.println("Hubo un problema al registrar la ofrenda regular");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
	}
	
	public void mostrarRegular()
	{
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM ofrendas_regulares";
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt("id-ofrendasRegulares");
				String fecha = rs.getString("fecha");
				double monto = rs.getDouble("monto-total");
				String servicio = rs.getString("servicio");
				
				System.out.print(id + "\t\t");
				System.out.print(fecha + "\t\t");
				System.out.print(monto+ "\t\t");
				System.out.print(servicio + "\t");
				System.out.println();
			}
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al mostrar los registros de las ofrendas regulares");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
		
	}
	
	public double obtenerTotalRegular()
	{
		double total = 0;
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM ofrendas_regulares";
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				double monto = rs.getDouble("monto-total");
				total += monto;
			}
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al mostrar el total de las ofrendas regulares");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
		
		return total;
	}
	
	public void borrarRegular(int numero)
	{
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "DELETE FROM ofrendas_regulares WHERE `id-ofrendasRegulares` = "+ numero +"";
			stmt.execute(sql);
			stmt.close();
			
			System.out.println("El registro fue borrado exitosamente");
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al intentar borrar el registro");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
		
	}
	
	public void actualizarRegular(int numero)
	{
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
	
		do
		{
			System.out.print("Que apartado quieres modificar?(fecha, monto o servicio): ");
			String apartado = scan.nextLine();
			
			System.out.print("Ingresa el nuevo dato: ");
			String nDato = scan.nextLine();
			try
			{
				java.sql.Statement stmt = conn.createStatement();
				String sql = "";
				
				switch(apartado)
				{
				case "fecha":
					sql = "UPDATE ofrendas_regulares SET fecha = '" + nDato +"' WHERE `id-ofrendasRegulares` = "+ numero +"";
					break;
					
				case "monto":
					sql = "UPDATE ofrendas_regulares SET `monto-total` = '" + nDato +"' WHERE `id-ofrendasRegulares` = "+ numero +"";
					break;
					
				case "servicio":
					sql = "UPDATE ofrendas_regulares SET servicio = '" + nDato +"' WHERE `id-ofrendasRegulares` = "+ numero +"";
					break;
					
				default:
					System.out.println("Esa opcion no esta disponible, por favor intentelo de nuevo");
					break;
				}
				
				if(sql.equals(""))
				{
					exit = false;
				}
				else
				{
					stmt.execute(sql);
					stmt.close();
					System.out.println("Registro actualizado exitosamente");
					exit = true;
				}
				
			}
			catch(java.sql.SQLException ex)
			{
				System.out.println("Hubo una falla al intentar modificar el registro");
				System.out.println("Mensaje: " + ex.getMessage());
				System.out.println("Codigo: " + ex.getErrorCode());
				System.out.println("SQLState: " + ex.getSQLState());
			}
		}while(exit == false);
	}
	
	//Metodos para las ofrendas de amor
	public void ingresarAmor(String fecha, double monto, String destino)
	{
		try
		{
			java.sql.Statement stmt =  conn.createStatement();
			String sql = "INSERT INTO ofrendas_amor (`fecha`, `monto-total`, `destino`) VALUES (' "+ fecha + "', '" + monto +"', '" + destino +"')";
			stmt.execute(sql);
			stmt.close();
			System.out.println("La ofrenda de amor se registro exitosamente");
		}
		catch (java.sql.SQLException ex)
		{
			System.out.println("Hubo un problema al registrar la ofrenda de amor");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
	}
	
	public void mostrarAmor()
	{
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM ofrendas_amor";
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt("id-ofrendasAmor");
				String fecha = rs.getString("fecha");
				double monto = rs.getDouble("monto-total");
				String destino = rs.getString("destino");
				
				System.out.print(id + "\t\t");
				System.out.print(fecha + "\t\t");
				System.out.print(monto+ "\t\t");
				System.out.print(destino + "\t");
				System.out.println();
			}
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al mostrar los registros de las ofrendas de amor");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
	}
	
	public double obtenerTotalAmor()
	{
		double total = 0;
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM ofrendas_amor";
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				double monto = rs.getDouble("monto-total");
				total += monto;
			}
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al mostrar el total de las ofrendas de amor");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
		
		return total;
	}
	
	public void borrarAmor(int numero)
	{
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "DELETE FROM ofrendas_amor WHERE `id-ofrendasAmor` = "+ numero +"";
			stmt.execute(sql);
			stmt.close();
			
			System.out.println("El registro fue borrado exitosamente");
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al intentar borrar el registro");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
		
	}
	
	public void actualizarAmor(int numero)
	{
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
	
		do
		{
			System.out.print("Que apartado quieres modificar?(fecha, monto o destino): ");
			String apartado = scan.nextLine();
			
			System.out.print("Ingresa el nuevo dato: ");
			String nDato = scan.nextLine();
			try
			{
				java.sql.Statement stmt = conn.createStatement();
				String sql = "";
				
				switch(apartado)
				{
				case "fecha":
					sql = "UPDATE ofrendas_amor SET fecha = '" + nDato +"' WHERE `id-ofrendasAmor` = "+ numero +"";
					break;
					
				case "monto":
					sql = "UPDATE ofrendas_amor SET `monto-total` = '" + nDato +"' WHERE `id-ofrendasAmor` = "+ numero +"";
					break;
					
				case "destino":
					sql = "UPDATE ofrendas_amor SET destino = '" + nDato +"' WHERE `id-ofrendasAmor` = "+ numero +"";
					break;
					
				default:
					System.out.println("Esa opcion no esta disponible, por favor intentelo de nuevo");
					break;
				}
				
				if(sql.equals(""))
				{
					exit = false;
				}
				else
				{
					stmt.execute(sql);
					stmt.close();
					System.out.println("Registro actualizado exitosamente");
					exit = true;
				}
				
			}
			catch(java.sql.SQLException ex)
			{
				System.out.println("Hubo una falla al intentar modificar el registro");
				System.out.println("Mensaje: " + ex.getMessage());
				System.out.println("Codigo: " + ex.getErrorCode());
				System.out.println("SQLState: " + ex.getSQLState());
			}
		}while(exit == false);
	}
	
	//Metodos para ofrendas de construccion
	public void ingresarCsontruccion(String fecha, double monto, String destino)
	{
		try
		{
			java.sql.Statement stmt =  conn.createStatement();
			String sql = "INSERT INTO ofrendas_construccion (`fecha`, `monto-total`, `destino`) VALUES (' "+ fecha + "', '" + monto +"', '" + destino +"')";
			stmt.execute(sql);
			stmt.close();
			System.out.println("La ofrenda de construccion se registro exitosamente");
		}
		catch (java.sql.SQLException ex)
		{
			System.out.println("Hubo un problema al registrar la ofrenda de construccion");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
	}
	
	public void mostrarConstruccion()
	{
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM ofrendas_construccion";
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt("id-ofrendasConstruccion");
				String fecha = rs.getString("fecha");
				double monto = rs.getDouble("monto-total");
				String destino = rs.getString("destino");
				
				System.out.print(id + "\t\t");
				System.out.print(fecha + "\t\t");
				System.out.print(monto+ "\t\t");
				System.out.print(destino + "\t");
				System.out.println();
			}
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al mostrar los registros de las ofrendas de construccion");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
	}
	
	public double obtenerTotalConstruccion()
	{
		double total = 0;
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM ofrendas_construccion";
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				double monto = rs.getDouble("monto-total");
				total += monto;
			}
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al mostrar el total de las ofrendas de construccion");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
		
		return total;
	}
	
	public void borrarConstruccion(int numero)
	{
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "DELETE FROM ofrendas_construccion WHERE `id-ofrendasConstruccion` = "+ numero +"";
			stmt.execute(sql);
			stmt.close();
			
			System.out.println("El registro fue borrado exitosamente");
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al intentar borrar el registro");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
		
	}
	
	public void actualizarConstruccion(int numero)
	{
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
	
		do
		{
			System.out.print("Que apartado quieres modificar?(fecha, monto o destino): ");
			String apartado = scan.nextLine();
			
			System.out.print("Ingresa el nuevo dato: ");
			String nDato = scan.nextLine();
			try
			{
				java.sql.Statement stmt = conn.createStatement();
				String sql = "";
				
				switch(apartado)
				{
				case "fecha":
					sql = "UPDATE ofrendas_construccion SET fecha = '" + nDato +"' WHERE `id-ofrendasConstruccion` = "+ numero +"";
					break;
					
				case "monto":
					sql = "UPDATE ofrendas_construccion SET `monto-total` = '" + nDato +"' WHERE `id-ofrendasConstruccion` = "+ numero +"";
					break;
					
				case "destino":
					sql = "UPDATE ofrendas_construccion SET destino = '" + nDato +"' WHERE `id-ofrendasConstruccion` = "+ numero +"";
					break;
					
				default:
					System.out.println("Esa opcion no esta disponible, por favor intentelo de nuevo");
					break;
				}
				
				if(sql.equals(""))
				{
					exit = false;
				}
				else
				{
					stmt.execute(sql);
					stmt.close();
					System.out.println("Registro actualizado exitosamente");
					exit = true;
				}
				
			}
			catch(java.sql.SQLException ex)
			{
				System.out.println("Hubo una falla al intentar modificar el registro");
				System.out.println("Mensaje: " + ex.getMessage());
				System.out.println("Codigo: " + ex.getErrorCode());
				System.out.println("SQLState: " + ex.getSQLState());
			}
		}while(exit == false);
	}
	
	//Metodos para talento
	public void ingresarTalento(String familia, String fecha, String platillo, double monto)
	{
		try
		{
			java.sql.Statement stmt =  conn.createStatement();
			String sql = "INSERT INTO talentos (`familia`, `fecha`, `platillo`, `monto`) VALUES (' "+ familia + "', '" + fecha +"', '" + platillo +"' , '" + monto +"')";
			stmt.execute(sql);
			stmt.close();
			System.out.println("El talento se registro exitosamente");
		}
		catch (java.sql.SQLException ex)
		{
			System.out.println("Hubo un problema al registrar el talento");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
	}
	
	public void mostrarTalento()
	{
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM talentos";
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt("id-talentos");
				String familia = rs.getString("familia");
				String fecha = rs.getString("fecha");
				String platillo = rs.getString("platillo");
				double monto = rs.getDouble("monto");
				
				System.out.print(id + "\t\t");
				System.out.print(familia + "\t\t");
				System.out.print(fecha + "\t\t");
				System.out.print(platillo + "\t\t");
				System.out.print(monto + "\t");
				System.out.println();
			}
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al mostrar los registros de los talentos");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
	}
	
	public double obtenerTotalTalento()
	{
		double total = 0;
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM talentos";
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				double monto = rs.getDouble("monto");
				total += monto;
			}
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al mostrar el total de los talentos");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
		
		return total;
	}
	
	public void borrarTalento(int numero)
	{
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "DELETE FROM talentos WHERE `id-talentos` = "+ numero +"";
			stmt.execute(sql);
			stmt.close();
			
			System.out.println("El registro fue borrado exitosamente");
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al intentar borrar el registro");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
		
	}
	
	public void actualizarTalento(int numero)
	{
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
	
		do
		{
			System.out.print("Que apartado quieres modificar?(familia, fecha, platillo o monto): ");
			String apartado = scan.nextLine();
			
			System.out.print("Ingresa el nuevo dato: ");
			String nDato = scan.nextLine();
			try
			{
				java.sql.Statement stmt = conn.createStatement();
				String sql = "";
				
				switch(apartado)
				{
				case "familia":
					sql = "UPDATE talentos SET familia = '" + nDato +"' WHERE `id-talentos` = "+ numero +"";
					break;
					
				case "fecha":
					sql = "UPDATE talentos SET fecha = '" + nDato +"' WHERE `id-talentos` = "+ numero +"";
					break;
					
				case "platillo":
					sql = "UPDATE talentos SET platillo = '" + nDato +"' WHERE `id-talentos` = "+ numero +"";
					break;
					
				case "monto":
					sql = "UPDATE talentos SET monto = '" + nDato +"' WHERE `id-talentos` = "+ numero +"";
					break;
					
				default:
					System.out.println("Esa opcion no esta disponible, por favor intentelo de nuevo");
					break;
				}
				
				if(sql.equals(""))
				{
					exit = false;
				}
				else
				{
					stmt.execute(sql);
					stmt.close();
					System.out.println("Registro actualizado exitosamente");
					exit = true;
				}
				
			}
			catch(java.sql.SQLException ex)
			{
				System.out.println("Hubo una falla al intentar modificar el registro");
				System.out.println("Mensaje: " + ex.getMessage());
				System.out.println("Codigo: " + ex.getErrorCode());
				System.out.println("SQLState: " + ex.getSQLState());
			}
		}while(exit == false);
	}
	
	//Metodos para aseo
	
	public void ingresarAporte(String aportador, double monto, String fecha)
	{
		try
		{
			java.sql.Statement stmt =  conn.createStatement();
			String sql = "INSERT INTO aseos (`aportador`, `monto`, `fecha`) VALUES (' "+ aportador + "', '" + monto +"', '" + fecha +"')";
			stmt.execute(sql);
			stmt.close();
			System.out.println("La aportacion para aseos se registro exitosamente");
		}
		catch (java.sql.SQLException ex)
		{
			System.out.println("Hubo un problema al registrar la aportacion para el aseo");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
	}
	
	public void mostrarAseos()
	{
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM aseos";
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt("id-aseos");
				String aportador = rs.getString("aportador");
				double monto = rs.getDouble("monto");
				String fecha = rs.getString("fecha");
				
				System.out.print(id + "\t\t");
				System.out.print(aportador + "\t\t");
				System.out.print(monto + "\t\t");
				System.out.print(fecha + "\t");
				System.out.println();
			}
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al mostrar los registros de las aportaciones de los aseos");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
	}
	
	public double obtenerTotalAseo()
	{
		double total = 0;
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM aseos";
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				double monto = rs.getDouble("monto");
				total += monto;
			}
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al mostrar el total de las aportaciones para aseos");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
		
		return total;
	}
	
	public void borrarAseo(int numero)
	{
		try
		{
			java.sql.Statement stmt = conn.createStatement();
			String sql = "DELETE FROM aseos WHERE `id-aseos` = "+ numero +"";
			stmt.execute(sql);
			stmt.close();
			
			System.out.println("El registro fue borrado exitosamente");
		}
		catch(java.sql.SQLException ex)
		{
			System.out.println("Hubo una falla al intentar borrar el registro");
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("Codigo: " + ex.getErrorCode());
			System.out.println("SQLState: " + ex.getSQLState());
		}
		
	}
	
	public void actualizarAseo(int numero)
	{
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
	
		do
		{
			System.out.print("Que apartado quieres modificar?(aportador, monto o fecha): ");
			String apartado = scan.nextLine();
			
			System.out.print("Ingresa el nuevo dato: ");
			String nDato = scan.nextLine();
			try
			{
				java.sql.Statement stmt = conn.createStatement();
				String sql = "";
				
				switch(apartado)
				{
				case "aportador":
					sql = "UPDATE aseos SET aportador = '" + nDato +"' WHERE `id-aseos` = "+ numero +"";
					break;
					
				case "monto":
					sql = "UPDATE aseos SET monto = '" + nDato +"' WHERE `id-aseos` = "+ numero +"";
					break;
					
				case "fecha":
					sql = "UPDATE aseos SET fecha = '" + nDato +"' WHERE `id-aseos` = "+ numero +"";
					break;
					
				default:
					System.out.println("Esa opcion no esta disponible, por favor intentelo de nuevo");
					break;
				}
				
				if(sql.equals(""))
				{
					exit = false;
				}
				else
				{
					stmt.execute(sql);
					stmt.close();
					System.out.println("Registro actualizado exitosamente");
					exit = true;
				}
				
			}
			catch(java.sql.SQLException ex)
			{
				System.out.println("Hubo una falla al intentar modificar el registro");
				System.out.println("Mensaje: " + ex.getMessage());
				System.out.println("Codigo: " + ex.getErrorCode());
				System.out.println("SQLState: " + ex.getSQLState());
			}
		}while(exit == false);
	}
}
