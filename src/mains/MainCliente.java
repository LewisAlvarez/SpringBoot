package mains;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;

import models.Cliente;

public class MainCliente {

	public static void main(String[] args) {
		
		Cliente ClienteUno = new Cliente("Lucas","Torreira","Call 123");
		
		guardarCliente(ClienteUno);
	}
	
	public static org.hibernate.SessionFactory conexion() {
		org.hibernate.SessionFactory sessionFactory = 
				 new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Cliente.class).buildSessionFactory();
		
		return sessionFactory;
	}
	
	/**
	 * Guardar cliente en db con mapeo ORM
	 * @param cliente
	 */
	
	public static void guardarCliente(Cliente cliente) {
		
		org.hibernate.SessionFactory sf = conexion(); 
		Session session = (((org.hibernate.SessionFactory) sf).openSession());
		
		try {
			
			session.beginTransaction();
			
			//Para guardar en DB
			session.save(cliente);
			
			session.getTransaction().commit();
			
			System.out.println("El registro se ha guardado exitosamente " + 
					cliente.toString());
			
			session.close();
			
		}finally {
			session.close();
		}
	}

	
	
	
}
