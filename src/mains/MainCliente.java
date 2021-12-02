package mains;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;

import models.Cliente;

public class MainCliente {

	public static void main(String[] args) {
		
		Cliente ClienteUno = new Cliente("Luz","Bejarano","Calle 8");
		
		//guardarCliente(ClienteUno);
		//consultarClientes();
		
		
		//Consultar por direccio
		String dir = "'Calle 7'";
		consultarClienesEnDireccion(dir);
		
		
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

	
	/**
	 * Consulta de tipo SELECT sencillo
	 */
	
	public static void consultarClientes() {
		
		org.hibernate.SessionFactory sf = conexion(); 
		Session session = (((org.hibernate.SessionFactory) sf).openSession());
		
		try {
			session.beginTransaction();
			
			//Consulta de todos los clientes
			List<Cliente> clientes = session.createQuery("FROM Cliente").getResultList();
			
			recorrerClientes(clientes);
			
			
			session.close();
		}finally {
			session.close();
		}
		
	}
	
	
	public static void consultarClienesEnDireccion(String direccion) {
		org.hibernate.SessionFactory sf = conexion(); 
		Session session = (((org.hibernate.SessionFactory) sf).openSession());
		
		try {
			session.beginTransaction();
			
			//Consulta de todos los clientes que se encuentren en determinada direccion (parametro)
			List<Cliente> clientes = 
					session.createQuery("FROM Cliente cl WHERE cl.direccion="+direccion).getResultList();
			
			//Mostrar los clientes
			recorrerClientes(clientes);
			
			System.out.println("Total de clientes en direccion: " + clientes.size()); 
			
			//commit
			session.getTransaction().commit();
			
			session.close();
		}finally {
			session.close();
		}
	}

	private static void recorrerClientes(List<Cliente> clientes) {
		for(Cliente c : clientes) {
			System.out.println(c.toString());
		}
	}
	
	
}
