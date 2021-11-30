package hiber;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:4306/springboot?useSSL=false";
		String usurio = "root";
		String contra = "";
		try {
			
			System.out.println("Intentando conectar a la DB");
			
			Connection miConexion = DriverManager.getConnection(url, usurio, contra);
			
			System.out.println("Conexion Exitosa!!!!!");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
